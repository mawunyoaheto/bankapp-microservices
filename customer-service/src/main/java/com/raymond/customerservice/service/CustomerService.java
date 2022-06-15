package com.raymond.customerservice.service;

import com.raymond.customerservice.dto.CustomerAccountDTO;
import com.raymond.customerservice.entity.Customer;

public interface CustomerService {
    public CustomerAccountDTO createAccount(Customer customer);
    public CustomerAccountDTO getCustomerAccount(long customerId);
}
