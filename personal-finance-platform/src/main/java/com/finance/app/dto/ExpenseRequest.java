package com.finance.app.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseRequest {
    private Long categoryId;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
}
