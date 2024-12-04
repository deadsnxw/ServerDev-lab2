package com.example.rest.services;

import com.example.rest.models.Account;
import com.example.rest.models.Expense;
import com.example.rest.repositories.AccountRepository;
import com.example.rest.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public void deposit(Long userId, Double amount) {
        Account account = accountRepository.findByUserId(userId);

        if (account == null) {
            account = new Account(userId, 0.0);
        }

        account.deposit(amount);

        accountRepository.save(account);
    }

    public void createExpense(Long userId, Long categoryId, Double amount) {
        Account account = accountRepository.findByUserId(userId);

        if (account != null) {
            if (account.withdraw(amount)) {
                Expense expense = new Expense(userId, categoryId, LocalDateTime.now(), amount);
                expenseRepository.save(expense);
            } else {
                throw new RuntimeException("Not enough balance to make expense");
            }
        } else {
            throw new RuntimeException("Account not found for userId: " + userId);
        }
    }
}

