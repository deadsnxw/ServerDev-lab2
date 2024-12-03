package com.example.rest.services;

import com.example.rest.models.Expense;
import com.example.rest.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense getExpenseById(String id) {
        Long expenseId = Long.parseLong(id);
        return expenseRepository.findById(expenseId).orElse(null);
    }

    public void deleteExpense(String id) {
        Long expenseId = Long.parseLong(id);
        expenseRepository.deleteById(expenseId);
    }
}