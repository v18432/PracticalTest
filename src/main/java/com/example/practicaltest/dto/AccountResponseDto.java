package com.example.practicaltest.dto;

import java.math.BigDecimal;

public class AccountResponseDto {

    private String name;
    private BigDecimal balance;

    public AccountResponseDto(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
