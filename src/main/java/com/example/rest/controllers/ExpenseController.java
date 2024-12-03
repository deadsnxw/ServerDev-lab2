package com.example.rest.controllers;

import com.example.rest.models.Expense;
import com.example.rest.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable String id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/user/{userId}/category/{categoryId}")
    public List<Expense> getExpensesByUserAndCategory(@PathVariable String userId, @PathVariable String categoryId) {
        return expenseService.getExpensesByUserAndCategory(userId, categoryId);
    }
}
