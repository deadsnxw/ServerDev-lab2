package com.example.rest.services;

import com.example.rest.models.User;
import com.example.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        Long userId = Long.parseLong(id);
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    public void deleteUser(String id) {
        Long userId = Long.parseLong(id);
        userRepository.deleteById(userId);
    }
}
