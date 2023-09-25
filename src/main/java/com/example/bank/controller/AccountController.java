package com.example.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:33 AM
 */
@RestController
public class AccountController {

    @GetMapping("/accounts")
    public String getAccountDetails() {
        return "Account Details";
    }

}
