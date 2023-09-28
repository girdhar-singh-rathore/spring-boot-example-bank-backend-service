package com.example.bank.controller;

import com.example.bank.model.Customer;
import com.example.bank.model.Loans;
import com.example.bank.repository.LoanRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:36 AM
 */
@RestController
public class LoanController {

    private LoanRepository loanRepository;

    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping("/loans")
    public List<Loans> getLoanDetails(@RequestBody Customer customer) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }

}
