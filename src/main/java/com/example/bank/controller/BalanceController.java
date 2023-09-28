package com.example.bank.controller;

import com.example.bank.model.AccountTransactions;
import com.example.bank.model.Customer;
import com.example.bank.repository.AccountTransactionsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:35 AM
 */
@RestController
public class BalanceController {

    private AccountTransactionsRepository accountTransactionsRepository;

    public BalanceController(AccountTransactionsRepository accountTransactionsRepository) {
        this.accountTransactionsRepository = accountTransactionsRepository;
    }

    @PostMapping("/balance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(customer.getId());
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
