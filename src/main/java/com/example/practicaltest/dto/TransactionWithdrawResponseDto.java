package com.example.practicaltest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionWithdrawResponseDto {

    private BigDecimal amount;
    private int fromAccountNumber;
    private LocalDateTime timestamp;

    public TransactionWithdrawResponseDto(BigDecimal amount, int fromAccountNumber, LocalDateTime timestamp) {
        this.fromAccountNumber = fromAccountNumber;
        this.amount = amount;
        this.timestamp = timestamp;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
