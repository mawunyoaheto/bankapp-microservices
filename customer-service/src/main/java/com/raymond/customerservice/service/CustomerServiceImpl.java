package com.raymond.customerservice.service;

import com.raymond.customerservice.dto.AccountDTO;
import com.raymond.customerservice.dto.CustomerAccountDTO;
import com.raymond.customerservice.entity.Customer;
import com.raymond.customerservice.exceptions.CustomerNotFoundException;
import com.raymond.customerservice.feign.AccountFeignClient;
import com.raymond.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    @Transactional
    public CustomerAccountDTO createAccount(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        AccountDTO newAccount = new AccountDTO();
        newAccount.setAccountType("SAVINGS");
        newAccount.setCustomerId(newCustomer.getId());
        newAccount.setCurrentBalance(newAccount.getOpeningBalance());
        newAccount.setOpenDate(LocalDate.now());
        accountFeignClient.createAccount(newAccount);

        CustomerAccountDTO newAccountDTO = new CustomerAccountDTO();
        newAccountDTO.setCustomerDetails(newCustomer);
        newAccountDTO.getAccounts().add(newAccount);
        return newAccountDTO;
    }

    @Override
    public CustomerAccountDTO getCustomerAccount(long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()->new CustomerNotFoundException("Customer with given Id not found"));

        List<AccountDTO> accounts = accountFeignClient.getAllCustomerAccounts(customerId);
        CustomerAccountDTO customerAccountDTO = new CustomerAccountDTO();
        customerAccountDTO.setCustomerDetails(customer);
        customerAccountDTO.setAccounts(accounts);

        return customerAccountDTO;
    }
}
