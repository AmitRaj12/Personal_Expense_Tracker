package com.personal.expense.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    
}
