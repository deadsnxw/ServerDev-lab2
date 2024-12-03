package com.example.rest.repository;

import com.example.rest.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> { }
