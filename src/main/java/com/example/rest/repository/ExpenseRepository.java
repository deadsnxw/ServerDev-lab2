package com.example.rest.repository;

import com.example.rest.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, Long> { }
