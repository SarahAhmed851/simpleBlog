package com.lab10sarahahmed.simpleBlog.service;

import com.lab10sarahahmed.simpleBlog.model.User;
import com.lab10sarahahmed.simpleBlog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // CREATE a new user
    public User createUser(String username, String email, String password) {
        // Check if email already exists
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists!");
        }

        // Create new user
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));  // Hash the password!
        user.setCreatedAt(LocalDateTime.now());

        // Save to database and return
        return userRepository.save(user);
    }

    // AUTHENTICATE (login) a user
    public User authenticate(String email, String password) {
        // Find user by email
        Optional<User> userOptional = userRepository.findByEmail(email);

        // Check if user exists
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        User user = userOptional.get();

        // Check if password matches
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        // Password correct - return the user
        return user;
    }
}