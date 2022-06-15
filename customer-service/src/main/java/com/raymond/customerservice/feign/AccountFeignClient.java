package com.raymond.customerservice.feign;

import com.raymond.customerservice.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "account-service")
@Service
public interface AccountFeignClient {
    @GetMapping("/accounts/{customerId}")
    public AccountDTO getAccount(@PathVariable long customerId);

    @PostMapping("/accounts")
    public AccountDTO createAccount(AccountDTO account);

    @GetMapping("/accounts")
    public List<AccountDTO>  getAllCustomerAccounts(@PathVariable long customerId);
}
