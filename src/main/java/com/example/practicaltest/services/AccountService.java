package com.example.practicaltest.services;

import com.example.practicaltest.dto.AccountResponseDto;
import com.example.practicaltest.models.Account;
import com.example.practicaltest.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String beneficiaryName, String pinCode) {
        int accountNumber = Math.abs(new Random().nextInt());
        Account account = new Account(beneficiaryName, accountNumber, pinCode, BigDecimal.ZERO);
        return accountRepository.save(account);
    }

    public List<AccountResponseDto> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(account -> new AccountResponseDto(account.getBeneficiaryName(), account.getBalance()))
                .collect(Collectors.toList());
    }

    public Account findByAccountNumber(int accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}