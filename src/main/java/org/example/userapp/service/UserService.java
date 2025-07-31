package org.example.userapp.service;

import org.example.userapp.entity.Country;
import org.example.userapp.entity.User;
import org. example.userapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getUsersNotFromCountry(Country country) {
        return userRepository.findByCountryNotOrderByAgeAsc(country);
    }
}