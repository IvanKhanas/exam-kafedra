package org.example.userapp.repository;

import org.example.userapp.entity.Country;
import org.example.userapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCountryNotOrderByAgeAsc(Country country);
}