package com.finance.app.repository;

import com.finance.app.entity.Expense;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    //for now we are able to load only the useremail not whole userdetails
    List<Expense> findByUserId(Long id);

}
