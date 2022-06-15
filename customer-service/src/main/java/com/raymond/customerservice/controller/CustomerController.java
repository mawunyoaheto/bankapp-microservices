package com.raymond.customerservice.controller;

import com.raymond.customerservice.dto.CustomerAccountDTO;
import com.raymond.customerservice.entity.Customer;
import com.raymond.customerservice.feign.AccountFeignClient;
import com.raymond.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerservice;

    @GetMapping("customer/{customerId}")
    public ResponseEntity<CustomerAccountDTO> getCustomerAccount(@PathVariable long customerId){
        return new ResponseEntity<>(customerservice
                .getCustomerAccount(customerId), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerAccountDTO> createAccount(@RequestBody Customer customer){
        return new ResponseEntity<>(customerservice.createAccount(customer),HttpStatus.CREATED);
    }
}
