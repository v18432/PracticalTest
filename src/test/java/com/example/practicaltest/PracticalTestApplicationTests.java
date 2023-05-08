package com.example.practicaltest;

import com.example.practicaltest.dto.AccountResponseDto;
import com.example.practicaltest.dto.TransactionDepositResponseDto;
import com.example.practicaltest.dto.TransactionTransferResponseDto;
import com.example.practicaltest.dto.TransactionWithdrawResponseDto;
import com.example.practicaltest.models.Account;;
import com.example.practicaltest.repositories.AccountRepository;
import com.example.practicaltest.services.AccountService;
import com.example.practicaltest.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PracticalTestApplicationTests {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @BeforeEach
    void clearDataBase() {
        accountRepository.deleteAll();
    }

    @Test
    void testCreateAccount() {
        String beneficiaryName = "Nikolay";
        String pinCode = "1234";

        Account createdAccount = accountService.createAccount(beneficiaryName, pinCode);

        assertNotNull(createdAccount);
        assertEquals(beneficiaryName, createdAccount.getBeneficiaryName());
        assertEquals(pinCode, createdAccount.getPinCode());
        assertEquals(BigDecimal.ZERO, createdAccount.getBalance());

    }

    @Test
    void testGetAllAccounts() {
        Account account1 = new Account("Ivan", 123456789, "1234", new BigDecimal("1000.00"));
        Account account2 = new Account("Vasiliy", 987654321, "5678", new BigDecimal("500.00"));

        accountRepository.save(account1);
        accountRepository.save(account2);

        List<AccountResponseDto> accountResponseDtos = accountService.getAllAccounts();
        assertNotNull(accountResponseDtos);
        assertEquals(2, accountResponseDtos.size());
        assertEquals("Ivan", accountResponseDtos.get(0).getName());
        assertEquals(new BigDecimal("1000.00"), accountResponseDtos.get(0).getBalance());
        assertEquals("Vasiliy", accountResponseDtos.get(1).getName());
        assertEquals(new BigDecimal("500.00"), accountResponseDtos.get(1).getBalance());

    }

    @Test
    void testDeposit() {
        Account account = accountService.createAccount("Oleg", "1234");

        TransactionDepositResponseDto response = transactionService.deposit(account.getAccountNumber(), new BigDecimal("1000"));

        assertNotNull(response);
        assertEquals(response.getAmount(), response.getAmount());
        assertEquals(response.getToAccountNumber(), account.getAccountNumber());

    }

    @Test
    void testWithdraw() {
        Account account = new Account("Ivan", 1234, "1234", new BigDecimal("100"));
        accountRepository.save(account);
        BigDecimal amount = new BigDecimal("50");

        TransactionWithdrawResponseDto transaction = transactionService.withdraw(account.getAccountNumber(), amount, account.getPinCode());

        assertNotNull(transaction);
        assertEquals(transaction.getFromAccountNumber(), account.getAccountNumber());
        assertEquals(transaction.getAmount(), amount.negate());

    }

    @Test
    void testTransfer() {
        Account account1 = new Account("Ivan", 1234, "1234", new BigDecimal("100"));
        Account account2 = new Account("Svetlana", 6583, "0937", new BigDecimal("100"));
        accountRepository.save(account1);
        accountRepository.save(account2);
        BigDecimal amount = new BigDecimal("50");

        TransactionTransferResponseDto transaction = transactionService.transfer(account1.getAccountNumber(), account2.getAccountNumber(), amount);

        assertNotNull(transaction);
        assertEquals(transaction.getFromAccountNumber(), account1.getAccountNumber());
        assertEquals(transaction.getToAccountNumber(), account2.getAccountNumber());
        assertEquals(transaction.getAmount(), amount.negate());

    }

    @Test
    void teatFindByAccountNumber() {
        Account createdAccount = new Account("Ivan", 1234, "1234", new BigDecimal("100"));

        accountRepository.save(createdAccount);
        Account findAccount = accountService.findByAccountNumber(createdAccount.getAccountNumber());

        assertNotNull(findAccount);
        assertEquals(createdAccount.getBeneficiaryName(), findAccount.getBeneficiaryName());
        assertEquals(createdAccount.getPinCode(), findAccount.getPinCode());
        assertEquals(createdAccount.getAccountNumber(), findAccount.getAccountNumber());

    }
}
