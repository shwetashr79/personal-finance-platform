package com.finance.app.service;

import com.finance.app.dto.BudgetRequest;

public interface BudgetService {

    void setBudget(String email, BudgetRequest budgetRequest);
}
