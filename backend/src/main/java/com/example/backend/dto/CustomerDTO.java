package com.example.backend.dto;

import java.time.LocalDate;

import com.example.backend.model.Customer.Stages;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String address;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Stages Stage;
    private Long createdBy;
    private Long updatedBy;
}

