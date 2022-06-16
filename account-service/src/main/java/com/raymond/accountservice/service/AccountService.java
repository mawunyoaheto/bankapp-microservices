package com.raymond.accountservice.service;

import com.raymond.accountservice.Subject;
import com.raymond.accountservice.entity.Account;
import org.springframework.stereotype.Service;


public interface AccountService extends Subject {
    public Account addAccount(Account account);
}
