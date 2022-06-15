package com.raymond.accountservice.service;

import com.raymond.accountservice.entity.Account;
import com.raymond.accountservice.entity.AccountEntry;
import com.raymond.accountservice.entity.TransactionType;
import com.raymond.accountservice.repository.AccountEntryRepository;
import com.raymond.accountservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountEntryRepository accountEntryRepository;

    @Override
    @Transactional
    public Account addAccount(Account account) {
        AccountEntry accountEntry = new AccountEntry();
        Account newAccount = accountRepository.save(account);
        accountEntry.setAccountId(newAccount.getId());
        accountEntry.setAccountBalance(newAccount.getOpeningBalance());
        accountEntry.setTransactionAmount(newAccount.getOpeningBalance());
        accountEntry.setTransactionDate(LocalDate.now());
        accountEntry.setTransactionType(TransactionType.DEPOSIT);
        accountEntryRepository.save(accountEntry);
        return newAccount;
    }
}
