package com.personal.expense.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;


@Controller
public class TransactionController {
    
    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }
    
}
