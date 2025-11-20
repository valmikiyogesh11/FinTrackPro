package com.fintrackpro.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GoalRequest {
    private Long userId;
    private String name;
    private Double targetAmount;
    private LocalDate targetDate;
}
