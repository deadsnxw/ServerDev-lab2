package com.example.rest.repositories;

import com.example.rest.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, Long> {
    List<Expense> findByUserIdAndCategoryId(String userId, String categoryId);
}
