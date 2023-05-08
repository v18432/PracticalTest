package com.example.practicaltest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDepositResponseDto {

    private BigDecimal amount;
    private int toAccountNumber;
    private LocalDateTime timestamp;

    public TransactionDepositResponseDto(BigDecimal amount, int toAccountNumber, LocalDateTime timestamp) {
        this.amount = amount;
        this.toAccountNumber = toAccountNumber;
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(int toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
