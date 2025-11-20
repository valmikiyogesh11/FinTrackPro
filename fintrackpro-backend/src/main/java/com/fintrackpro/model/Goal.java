package com.fintrackpro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "goals")
@Getter
@Setter
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private Double targetAmount;
    private Double currentAmount = 0.0;
    private LocalDate targetDate;
    private String status; // ACTIVE, COMPLETED, CANCELLED
}
