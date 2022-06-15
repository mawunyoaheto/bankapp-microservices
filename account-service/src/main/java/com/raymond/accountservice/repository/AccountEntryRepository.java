package com.raymond.accountservice.repository;

import com.raymond.accountservice.entity.AccountEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntryRepository extends JpaRepository<AccountEntry,Long> {
}
