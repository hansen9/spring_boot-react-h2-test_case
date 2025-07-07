package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.UserLog;
import com.example.backend.repository.UserLogRepository;

import java.time.LocalDateTime;

@Service
public class UserLogService {

    @Autowired
    private UserLogRepository repo;

    public void log(String username, String action) {
        UserLog log = new UserLog(username, action, LocalDateTime.now());
        repo.save(log);
    }
}
