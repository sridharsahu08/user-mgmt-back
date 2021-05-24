package com.user.management.repository;

import com.user.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("from User where email=?1")
    public List<User> findByEMAIL(String email);

    @Query("from User where email=?1 and password=?2")
    public User findByUsernamePassword(String username,String password);

}