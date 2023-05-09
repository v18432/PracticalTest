package com.example.practicaltest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TransactionTransferRequestDto {

    private int fromAccountNumber;
    private int toAccountNumber;
    private BigDecimal amount;

}
