package com.andrewborchenko.spring.buycycle.repositories;

import com.andrewborchenko.spring.buycycle.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
