package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.UserLog;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}
