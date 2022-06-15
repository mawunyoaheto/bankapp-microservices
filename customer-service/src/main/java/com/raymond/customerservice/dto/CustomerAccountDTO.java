package com.raymond.customerservice.dto;

import com.raymond.customerservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountDTO {
    private Customer customerDetails;
    private List<AccountDTO> accounts;
}
