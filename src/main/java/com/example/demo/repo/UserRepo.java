package com.example.demo.repo;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserNameAndPassword(String userName, String password);
}
