package com.personal.expense.tracker.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    enum ExpenseType {
        EXPENSE,
        INCOME
    }

    @Id
    private long id;
    private String description;
    private long amount;
    private Date date;
    private String category;
    private ExpenseType e_type;
}
