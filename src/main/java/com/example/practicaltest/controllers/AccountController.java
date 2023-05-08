package com.example.practicaltest.controllers;

import com.example.practicaltest.dto.AccountCreateRequestDto;
import com.example.practicaltest.dto.AccountResponseDto;
import com.example.practicaltest.models.Account;
import com.example.practicaltest.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody @Validated AccountCreateRequestDto accountCreateRequestDto) {
        Account createdAccount = accountService.createAccount(accountCreateRequestDto.getName(), accountCreateRequestDto.getPinCode());
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/accounts")
    public List<AccountResponseDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
