package com.finance.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseRequest {
    private Long categoryId;

    @NotNull
    @Positive
    private BigDecimal amount;

    private LocalDate date;
    private String description;
}
