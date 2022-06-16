package com.raymond.accountservice.service;

import com.raymond.accountservice.AccountObserver;
import com.raymond.accountservice.entity.Account;

public interface AccountEntryService extends AccountObserver {
    void addEntry(Account account);
}
