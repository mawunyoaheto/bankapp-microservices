package com.raymond.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private AccountType accountType;
    private double openingBalance;
    private double currentBalance;
    private AccountStatus accountStatus;
    private LocalDate openDate;


    public void deposit(double amount){
        currentBalance+=amount;
    }

    public void withdraw(double amount){

    }
}
