package org.example.userapp.controller;

import org.example.userapp.entity.Country;
import org.example.userapp.entity.User;
import org.example.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/additional-info")
    public List<User> getUsersNotFromCountry(
            @RequestParam("country") Country country) {
        return userService.getUsersNotFromCountry(country);
    }
}