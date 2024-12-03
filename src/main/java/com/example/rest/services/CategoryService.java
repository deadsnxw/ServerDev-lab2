package com.example.rest.services;

import com.example.rest.models.Category;
import com.example.rest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(String id) {
        Long categoryId = Long.parseLong(id);
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.orElse(null);
    }

    public void deleteCategory(String id) {
        Long categoryId = Long.parseLong(id);
        categoryRepository.deleteById(categoryId);
    }
}
