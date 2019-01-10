package com.djb.scout.contoller;

import com.djb.scout.NotFoundException;
import com.djb.scout.model.Content;
import com.djb.scout.model.User;
import com.djb.scout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // Get content
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value="id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User", "id", userId) );
    }
}
