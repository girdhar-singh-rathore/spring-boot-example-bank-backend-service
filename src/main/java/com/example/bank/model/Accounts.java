package com.example.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 27, 2023, 08:12 PM
 */

@Entity
@Getter
@Setter
public class Accounts {

    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "account_number")
    @Id
    private long accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_dt")
    private String createDt;

}
