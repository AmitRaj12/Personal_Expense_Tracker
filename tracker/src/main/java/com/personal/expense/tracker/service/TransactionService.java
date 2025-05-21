package com.personal.expense.tracker.service;

import java.util.List;

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

    public List<Transaction> showAllTransactions()
    {
        return t_repo.findAll();
    }

    public Transaction findTransactionById(Long id)
    {
        return t_repo.getReferenceById(id);
    }

    public void updateTransactionById(Transaction transaction, Long id)
    {
        if(t_repo.existsById(id))
        {
            t_repo.save(transaction);
        }
    }
}
