package com.example.practicaltest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionTransferResponseDto {

    private BigDecimal amount;
    private int fromAccountNumber;
    private int toAccountNumber;

    private LocalDateTime timestamp;

    public TransactionTransferResponseDto(BigDecimal amount, int fromAccountNumber, int toAccountNumber, LocalDateTime timestamp) {
        this.amount = amount;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(int fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
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
