package com.personal.expense.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters.InstantToLocalDateTimeConverter;
import org.springframework.stereotype.Service;

import com.personal.expense.tracker.model.Transaction;
import com.personal.expense.tracker.model.ExpenseType;
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

    public void deleteTransactionById(Long id)
    {
        if(t_repo.existsById(id))
        {
            t_repo.deleteById(id);
        }
    }

    public Long getTotalIncome()
    {
        Long ret = t_repo.sumAmountByEType(ExpenseType.INCOME);

        if(ret == null) ret = new Long(0);
        
        return ret;
    }

    public Long getTotalExpense()
    {
        Long ret = t_repo.sumAmountByEType(ExpenseType.EXPENSE);

        if(ret == null) ret = new Long(0);
        
        return ret;
    }
}
