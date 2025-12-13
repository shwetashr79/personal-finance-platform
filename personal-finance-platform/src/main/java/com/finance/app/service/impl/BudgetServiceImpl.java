package com.finance.app.service.impl;

import com.finance.app.dto.BudgetRequest;
import com.finance.app.entity.Budget;
import com.finance.app.entity.User;
import com.finance.app.repository.BudgetRepository;
import com.finance.app.repository.UserRepository;
import com.finance.app.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

  private final BudgetRepository budgetRepository;
  private final UserRepository userRepository;

    @Override
    public void setBudget(String email, BudgetRequest budgetRequest) {
          User user = userRepository.findByEmail(email).orElseThrow();
          //if budget already exists then we will update it.
      Budget b = budgetRepository.findByUserEmailAndMonth(email,budgetRequest.getMonth())
              .orElse(new Budget());

      b.setUser(user);
      b.setMonth(budgetRequest.getMonth());
      b.setBudgetAmount(budgetRequest.getBudgetAmount());

      //the working of save if day already exists it will update
      //if not it will create a new record
      budgetRepository.save(b);
    }
}
