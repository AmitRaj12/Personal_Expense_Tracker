package com.personal.expense.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.expense.tracker.model.Transaction;
import com.personal.expense.tracker.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository t_repo;

    
    public void addTransaction(Transaction transaction)
    {
        t_repo.save(transaction);
    }
}
