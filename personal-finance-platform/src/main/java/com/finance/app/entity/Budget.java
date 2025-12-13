package com.finance.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="Budget")
@Data
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month; // YYYY-MM

    private BigDecimal budgetAmount;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
