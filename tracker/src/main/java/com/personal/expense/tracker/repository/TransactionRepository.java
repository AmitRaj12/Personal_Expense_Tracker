package com.personal.expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.expense.tracker.model.Transaction;
import com.personal.expense.tracker.model.ExpenseType;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    //Derived query => parsed by spring boot for query generation at run time
    //Long sumAmountByEType(ExpenseType e_type); //ignore underscores
    
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.e_type = :e_type")
    Long sumAmountByEType(@Param("e_type") ExpenseType e_type);
}
