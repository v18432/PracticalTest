package com.example.practicaltest.services;

import com.example.practicaltest.exeption.IncorrectPinException;
import com.example.practicaltest.exeption.InsufficientFundsException;
import com.example.practicaltest.exeption.ResourceNotFoundException;
import com.example.practicaltest.models.Account;
import com.example.practicaltest.models.Transaction;
import com.example.practicaltest.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Service
public class TransactionService {

    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Transaction deposit(int accountNumber, BigDecimal amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new ResourceNotFoundException("Номер счета не найден");
        }

        account.setBalance(account.getBalance().add(amount));

        Transaction transaction = new Transaction(LocalDateTime.now(), accountNumber, amount);
        account.getTransactions().add(transaction);
        accountRepository.save(account);
        return transaction;
    }

    public Transaction withdraw(int fromAccountNumber, BigDecimal amount, String pinCode) {
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);

        if (fromAccount == null) {
            throw new ResourceNotFoundException("Номер счета не найден");
        }

        if (!Objects.equals(fromAccount.getPinCode(), pinCode)) {
            throw new IncorrectPinException("Введен неверный пин код");
        }

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Недостаточно средств на счету для снятия");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));

        Transaction transaction = new Transaction(LocalDateTime.now(), fromAccountNumber, amount.negate());
        fromAccount.getTransactions().add(transaction);
        accountRepository.save(fromAccount);
        return transaction;
    }

    public Transaction transfer(int fromAccountNumber, int toAccountNumber, BigDecimal amount) throws InsufficientFundsException {
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);

        if (fromAccount == null) {
            throw new ResourceNotFoundException("Номер счета отправителя указан не верно");
        }

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);

        if (toAccount == null) {
            throw new ResourceNotFoundException("Номер счета получателя указан не верно");
        }

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Недостаточно средств на счету для перевода");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        Transaction fromTransaction = new Transaction(LocalDateTime.now(), fromAccountNumber, toAccountNumber, amount.negate());
        fromAccount.getTransactions().add(fromTransaction);
        Transaction toTransaction = new Transaction(LocalDateTime.now(), fromAccountNumber, toAccountNumber, amount);
        toAccount.getTransactions().add(toTransaction);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        return toTransaction;
    }

    public List<Transaction> findByAccountNumber(int accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new ResourceNotFoundException("Номер счета не найден");
        }

        return account.getTransactions();
    }
}
