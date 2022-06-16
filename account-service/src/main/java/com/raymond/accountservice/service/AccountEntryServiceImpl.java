package com.raymond.accountservice.service;

import com.raymond.accountservice.Subject;
import com.raymond.accountservice.entity.Account;
import com.raymond.accountservice.entity.AccountEntry;
import com.raymond.accountservice.entity.TransactionType;
import com.raymond.accountservice.repository.AccountEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Slf4j
public class AccountEntryServiceImpl implements AccountEntryService{
    @Autowired
    private AccountEntryRepository accountEntryRepository;

//    @Autowired
//    private AccountServiceImpl accountService;

    public AccountEntryServiceImpl(AccountServiceImpl accountService) {
        log.info("accountService "+accountService);
        accountService.registerObserver(this);
    }

    @Override
    public void updateAccountEntry(Object object) {
        if(object instanceof Account){
            Account account = (Account)object;
            addEntry(account);
        }
    }

    @Override
    public void addEntry(Account account) {
        AccountEntry accountEntry = new AccountEntry();
        accountEntry.setAccountId(account.getId());
        accountEntry.setOpeningBalance(account.getOpeningBalance());
        accountEntry.setTransactionAmount(account.getOpeningBalance());
        accountEntry.setTransactionDate(LocalDate.now());
        accountEntry.setTransactionType(TransactionType.DEPOSIT);
        accountEntryRepository.save(accountEntry);
        log.info("Account Entry: "+accountEntry);
    }
}
