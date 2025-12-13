package com.finance.app.service.impl;

import com.finance.app.dto.ExpenseRequest;
import com.finance.app.entity.Category;
import com.finance.app.entity.Expense;
import com.finance.app.entity.User;
import com.finance.app.repository.CategoryRepository;
import com.finance.app.repository.ExpenseRepository;
import com.finance.app.repository.UserRepository;
import com.finance.app.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

   private final ExpenseRepository expenseRepo;
   private final UserRepository userRepo;
   private final CategoryRepository categoryRepo;

    @Override
    public void addExpense(String email, ExpenseRequest request) {
      User user = userRepo.findByEmail(email).orElseThrow();
        Category cat = categoryRepo.findById(request.getCategoryId()).orElseThrow();

        Expense e = new Expense();
        e.setUser(user);
        e.setCategory(cat);
        e.setAmount(request.getAmount());
        e.setDate(request.getDate());
        e.setDescription(request.getDescription());

        expenseRepo.save(e);

    }

    @Override
    public List<Expense> getExpenses(Long id) {
        //List.of() is a static method used to create an immutable list(fixed-size,unmodifiable)
        return expenseRepo.findByUserId(id);
    }
}
