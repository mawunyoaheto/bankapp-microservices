package com.raymond.accountservice.controller;

import com.raymond.accountservice.entity.Account;
import com.raymond.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountservice;

    @PostMapping
    public ResponseEntity<Account> createAccount(Account account) {
        return new ResponseEntity<>(accountservice.addAccount(account), HttpStatus.CREATED);
    }
}
