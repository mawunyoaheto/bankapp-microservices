package com.raymond.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private Long customerId;
    private String accountType;
    private double openingBalance;
    private double currentBalance;
    private String accountStatus;
    private LocalDate openDate;
}
