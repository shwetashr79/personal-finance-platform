package com.finance.app.controller;

import com.finance.app.dto.ExpenseRequest;
import com.finance.app.service.ExpenseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public String add(@RequestBody ExpenseRequest req, HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        expenseService.addExpense(email,req);
        return "Expense added";
    }

    @GetMapping
    public List<?> all(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        return expenseService.getExpenses(email);
    }

}
