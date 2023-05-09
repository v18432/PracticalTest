package com.example.practicaltest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TransactionWithdrawRequestDto {

    private int fromAccountNumber;
    private BigDecimal amount;
    private String pinCode;

}
