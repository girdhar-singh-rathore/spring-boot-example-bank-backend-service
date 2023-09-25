package com.example.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:35 AM
 */
@RestController
public class BalanceController {

    @GetMapping("/balance")
    public String getBalanceDetails() {
        return "Balance Details";
    }
}
