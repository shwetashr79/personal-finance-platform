package com.finance.app.controller;

import com.finance.app.config.CustomUserDetails;
import com.finance.app.dto.ExpenseRequest;
import com.finance.app.service.ExpenseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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

    //earlier reading from request
/*
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<?> all(HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        return expenseService.getExpenses(email);
    }*/

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<?> all(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.getId();
        return expenseService.getExpenses(userId);
    }


}
