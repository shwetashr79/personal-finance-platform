package com.finance.app.repository;

import com.finance.app.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
    Optional<Budget> findByUserEmailAndMonth(String email,String month);
}
