package com.example.practicaltest.dto;

import java.math.BigDecimal;

public class TransactionWithdrawRequestDto {

    private int fromAccountNumber;
    private BigDecimal amount;
    private String pinCode;

    public TransactionWithdrawRequestDto(int fromAccountNumber, BigDecimal amount, String pinCode) {
        this.fromAccountNumber = fromAccountNumber;
        this.amount = amount;
        this.pinCode = pinCode;
    }

    public int getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(int fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
