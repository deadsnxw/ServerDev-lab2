package com.example.rest.controllers;

import com.example.rest.models.Account;
import com.example.rest.repositories.AccountRepository;
import com.example.rest.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/deposit/{userId}")
    public ResponseEntity<String> deposit(@PathVariable Long userId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");

        // Проверка на валидность суммы
        if (amount == null || amount <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid deposit amount");
        }

        try {
            accountService.deposit(userId, amount);
            return ResponseEntity.ok("Account has been replenished with " + amount);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/expense")
    public ResponseEntity<String> createExpense(@RequestParam Long userId, @RequestParam Long categoryId, @RequestParam Double amount) {
        // Проверка на валидность суммы
        if (amount == null || amount <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid expense amount");
        }

        try {
            accountService.createExpense(userId, categoryId, amount);
            return ResponseEntity.ok("Expense was created with amount: " + amount);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Double> getBalance(@PathVariable Long userId) {
        Account account = accountRepository.findByUserId(userId);

        if (account != null) {
            return ResponseEntity.ok(account.getBalance());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
