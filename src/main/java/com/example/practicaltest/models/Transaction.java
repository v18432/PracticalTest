package com.example.practicaltest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private int fromAccountNumber;
    private int toAccountNumber;


    private LocalDateTime timestamp;

    public Transaction(LocalDateTime timestamp, int toAccountNumber, BigDecimal amount) {
        this.amount = amount;
        this.toAccountNumber = toAccountNumber;
        this.timestamp = timestamp;
    }

    public Transaction() {

    }

    public Transaction(LocalDateTime timestamp, int fromAccountNumber, int toAccountNumber, BigDecimal amount) {
        this.timestamp = timestamp;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
    }
}
