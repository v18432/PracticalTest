package com.example.practicaltest.dto;

import java.math.BigDecimal;

public class TransactionDepositRequestDto {

   private int toAccountNumber;
   private BigDecimal amount;

    public TransactionDepositRequestDto(int toAccountNumber, BigDecimal amount) {
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
    }

    public int getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(int toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
