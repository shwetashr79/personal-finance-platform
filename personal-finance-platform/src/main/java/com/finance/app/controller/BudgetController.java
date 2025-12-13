package com.finance.app.controller;


import com.finance.app.dto.BudgetRequest;
import com.finance.app.service.BudgetService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/budget")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    public String set(@Valid @RequestBody BudgetRequest req, HttpServletRequest request){
        String email = (String) request.getAttribute("email");
        budgetService.setBudget(email,req);
        return "Budget set successfully";
    }

}
