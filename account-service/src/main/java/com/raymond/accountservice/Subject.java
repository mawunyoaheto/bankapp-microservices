package com.raymond.accountservice;

import com.raymond.accountservice.entity.Account;

public interface Subject {
    void registerObserver(AccountObserver accountObserver);
    void removeObserver(AccountObserver accountObserver);
    void notifyObserver(Account account);
}
