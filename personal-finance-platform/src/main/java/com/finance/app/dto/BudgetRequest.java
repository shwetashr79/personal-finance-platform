package com.finance.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class BudgetRequest {

    @NotBlank
    private String month;

    @NonNull
    @Positive
    private BigDecimal budgetAmount;

}
