package com.example.practicaltest.controllers;

import com.example.practicaltest.dto.*;
import com.example.practicaltest.models.Transaction;
import com.example.practicaltest.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PutMapping("transactions/deposit")
    public ResponseEntity<Transaction> deposit(@RequestBody TransactionDepositRequestDto transaction) {
        return new ResponseEntity<>(transactionService
                .deposit(transaction.getToAccountNumber(), transaction.getAmount()), HttpStatus.OK);
    }

    @PutMapping("transactions/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestBody TransactionWithdrawRequestDto transaction) {
        return new ResponseEntity<>(transactionService
                .withdraw(transaction.getFromAccountNumber(), transaction.getAmount(), transaction.getPinCode()), HttpStatus.OK);
    }

    @PutMapping("transactions/transfer")
    public ResponseEntity<Transaction> transfer(@RequestBody TransactionTransferRequestDto transaction) {
        return new ResponseEntity<>(transactionService
                .transfer(transaction.getFromAccountNumber(), transaction.getToAccountNumber(), transaction.getAmount()), HttpStatus.OK);

    }

    @GetMapping("/transactions/{accountnumber}")
    public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable("accountnumber") int accountNumber) {
        return new ResponseEntity<>(transactionService.findByAccountNumber(accountNumber), HttpStatus.OK);
    }

}
