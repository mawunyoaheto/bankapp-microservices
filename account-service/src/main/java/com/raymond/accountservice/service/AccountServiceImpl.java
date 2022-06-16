package com.raymond.accountservice.service;

import com.raymond.accountservice.AccountObserver;
import com.raymond.accountservice.entity.Account;
import com.raymond.accountservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    List<AccountObserver> accountObservers;

    @Autowired
    private AccountRepository accountRepository;

//    @Autowired
//    private AccountEntryServiceImpl accountEntry;

    public AccountServiceImpl() {
        accountObservers = new ArrayList<>();
//        log.info("Account Entry Obj: "+accountEntry);
//        this.registerObserver(accountEntry);
    }

    @Override
    @Transactional
    public Account addAccount(Account account) {
        Account newAccount = accountRepository.save(account);
        log.info("Account information: " + newAccount);
        accountChanged(newAccount);
        return newAccount;
    }

    @Override
    public void registerObserver(AccountObserver accountObserver) {
        accountObservers.add(accountObserver);
    }

    @Override
    public void removeObserver(AccountObserver accountObserver) {
        accountObservers.remove(accountObserver);
    }

    @Override
    public void notifyObserver(Account account) {
        log.info("Observer List Has :"+ accountObservers.size());
        for (AccountObserver observer : accountObservers) {
            log.info("observer: "+observer);
            observer.updateAccountEntry(account);
        }
    }

    public void accountChanged(Account account) {
        notifyObserver(account);
    }
}
