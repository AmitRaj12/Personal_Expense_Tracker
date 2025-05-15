package com.personal.expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.expense.tracker.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    
}
