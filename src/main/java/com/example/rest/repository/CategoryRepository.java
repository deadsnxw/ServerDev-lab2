package com.example.rest.repository;

import com.example.rest.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, Long> { }
