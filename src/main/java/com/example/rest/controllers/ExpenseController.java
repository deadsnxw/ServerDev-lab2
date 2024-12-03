package com.example.rest.controllers;

import com.example.rest.models.User;
import com.example.rest.models.Category;
import com.example.rest.models.Record;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    private Map<Long, User> users = new HashMap<>();
    private Map<Long, Category> categories = new HashMap<>();
    private Map<Long, Record> records = new HashMap<>();
    private Long userIdCounter = 1L;
    private Long categoryIdCounter = 1L;
    private Long recordIdCounter = 1L;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        user.setId(userIdCounter++);
        users.put(user.getId(), user);
        return user;
    }

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return users.values();
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        users.remove(userId);
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        } return user;
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) {
        category.setId(categoryIdCounter++);
        categories.put(category.getId(), category);
        return category;
    }

    @GetMapping("/category")
    public Collection<Category> getCategories() {
        return categories.values();
    }

    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categories.remove(categoryId);
    }

    @PostMapping("/record")
    public Record createRecord(@RequestBody Record record) {
        record.setId(recordIdCounter++);
        records.put(record.getId(), record);
        return record;
    }

    @GetMapping("/record/{recordId}")
    public Record getRecord(@PathVariable Long recordId) {
        return records.get(recordId);
    }

    @DeleteMapping("/record/{recordId}")
    public void deleteRecord(@PathVariable Long recordId) {
        records.remove(recordId);
    }

    @GetMapping("/record")
    public Collection<Record> getRecords(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long categoryId) {

        List<Record> filteredRecords = new ArrayList<>();
        for (Record record : records.values()) {
            if ((userId == null || record.getUserId().equals(userId)) &&
                    (categoryId == null || record.getCategoryId().equals(categoryId))) {
                filteredRecords.add(record);
            }
        }

        if (userId == null && categoryId == null) {
            throw new IllegalArgumentException("At least one filter parameter (userId or categoryId) must be provided.");
        }

        return filteredRecords;
    }
}

