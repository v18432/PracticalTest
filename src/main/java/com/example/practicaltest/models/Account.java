package com.example.practicaltest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int accountNumber;
    private String beneficiaryName;
    private String pinCode;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(String beneficiaryName, int accountNumber, String pinCode, BigDecimal balance) {
        this.beneficiaryName = beneficiaryName;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
        this.balance = balance;
    }
}
