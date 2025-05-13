package com.personal.expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.personal.expense.tracker.model.Transaction;

public interface TrasactionRepository extends JpaRepository<Transaction, long>{

    
}
