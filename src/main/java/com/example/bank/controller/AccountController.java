package com.example.bank.controller;

import com.example.bank.model.Accounts;
import com.example.bank.model.Customer;
import com.example.bank.repository.AccountsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:33 AM
 */
@RestController
public class AccountController {

    private AccountsRepository accountsRepository;

    public AccountController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @PostMapping("/accounts")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getId());
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

}
