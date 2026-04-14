package com.journalapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.journalapp.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // No code needed now
}
