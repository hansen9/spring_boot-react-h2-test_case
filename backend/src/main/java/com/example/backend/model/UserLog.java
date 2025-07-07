package com.example.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserLog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Long userId;

    private String actionType; // LOGIN, LOGOUT, etc.
    private String detail; // Optional: "Created customer with ID 5"
    private String targetType;

    private Long targetId;

    private LocalDateTime timestamp;

    public UserLog(String username, String action, LocalDateTime timestamp){
        this.username = username;
        this.actionType = action;
        this.timestamp = timestamp;
    }

    public UserLog(String username, String action, String detail, LocalDateTime timestamp){
        this.username = username;
        this.actionType = action;
        this.detail = detail;
        this.timestamp = timestamp;
    }

    
    public UserLog(
        String username, 
        Long userId, 
        String action, 
        String detail, 
        String targetType,
        Long targetId,
        LocalDateTime timestamp){
        this.username = username;
        this.userId = userId;
        this.actionType = action;
        this.detail = detail;
        this.targetType = targetType;
        this.targetId = targetId;
        this.timestamp = timestamp;
    }
}
