package com.finance.app.service;

import com.finance.app.dto.ExpenseRequest;
import com.finance.app.entity.Expense;

import java.util.List;

public interface ExpenseService {
    void addExpense(String email, ExpenseRequest request);
    List<Expense> getExpenses(Long userId);
}
