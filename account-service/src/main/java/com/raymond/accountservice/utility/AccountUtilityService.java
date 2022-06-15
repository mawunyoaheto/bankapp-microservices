package com.raymond.accountservice.utility;

import com.raymond.accountservice.entity.Account;
import com.raymond.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

public class AccountUtilityService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean hasSufficientBalance(long accountNumber, double amount){
        Account acctDetails = accountRepository.findById(accountNumber)
                .orElseThrow(()->new EntityNotFoundException("Account does not exist"));

        return acctDetails.getCurrentBalance()>=amount;
    }
}
