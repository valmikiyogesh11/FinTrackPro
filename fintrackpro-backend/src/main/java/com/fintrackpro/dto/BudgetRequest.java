package com.fintrackpro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetRequest {
    private Long userId;
    private Long categoryId;
    private Integer month;
    private Integer year;
    private Double limitAmount;
}
