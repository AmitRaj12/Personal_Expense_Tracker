package com.personal.expense.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.personal.expense.tracker.model.Transaction;
import com.personal.expense.tracker.model.Transaction.ExpenseType;
import com.personal.expense.tracker.service.TransactionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class TransactionController {
    @Autowired
    private TransactionService t_Service;
    
    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }
    
    @GetMapping("/add_transaction")
    public String getAddTransactionPage(Model model) {
        //add transaction to form
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("expense_types", ExpenseType.values());
        return "add_transaction";
    }

    @PostMapping("/add_transaction")
    public String addTransaction(@ModelAttribute("transaction") Transaction transaction) {
        t_Service.addTransaction(transaction);
        
        //redirect:/path => redirects to blank add_transaction path
        /*
         * This sends an HTTP redirect (302) to /add, triggering a new GET request. That means:

          *  A fresh, unbound @ModelAttribute Transaction is passed to the form.

           * The form is blank again (reset).
         */

         /*
          * /add_transaction
          * Does not redirect to a new request
          * form still bound to same transaction object
          */
        return "redirect:/add_transaction";
    }

    @GetMapping("/view_transaction")
    public String showAllTransactions(Model model) {
        List<Transaction> t_list = t_Service.showAllTransactions();

        model.addAttribute("transaction_list", t_list);

        return "view_transaction";
    }
    
    @GetMapping("/view_transaction/edit/{id}")
    public String findTransactionById(@PathVariable Long id, Model model) {
        Transaction transaction = t_Service.findTransactionById(id);
        model.addAttribute("transaction", transaction);

        return "edit_transaction";
    }
    
    @PostMapping("/view_transaction/edit/")
    public String updateTransaction(@ModelAttribute("transaction") Transaction transaction) {
        t_Service.updateTransactionById(transaction, transaction.getId());
        return "redirect:/view_transaction";
    }
    
    @GetMapping("/view_transaction/delete/{id}")
    public String deleteTransactionById(@PathVariable Long id) {
        t_Service.deleteTransactionById(id);

        return "redirect:/view_transaction";
    }
    
    
}
