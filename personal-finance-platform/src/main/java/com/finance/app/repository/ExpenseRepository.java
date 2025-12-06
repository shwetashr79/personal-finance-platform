package com.finance.app.repository;

import com.finance.app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    //for now we are able to load only the useremail not whole userdetails
    List<Expense> findByUserEmail(String email);
}
