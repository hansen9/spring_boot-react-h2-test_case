package com.example.backend.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "customers")
public class Customer {

    public enum Stages{
        SEED,
        NURTURE,
        LEAD,
        OPPORTUNITY,
        ACTIVE,
        LOYAL
    };

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Stages stage;

    private Long createdBy;
    private Long updatedBy;
}
