package com.fintrackpro.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionRequest {
    private Long userId;
    private Long categoryId;
    private String type;
    private Double amount;
    private String paymentMode;
    private LocalDate date;
    private String note;
}
