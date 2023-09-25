package com.eazybytes.springsecuritybasic.controller;


import java.util.List;

import com.eazybytes.springsecuritybasic.Repository.AccountTransactionsRepository;
import com.eazybytes.springsecuritybasic.modal.Account_transactions;
import com.eazybytes.springsecuritybasic.modal.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @PostMapping("/myBalance")
    public List<Account_transactions> getBalanceDetails(@RequestBody Customer customer) {
        List<Account_transactions> accountTransactions = accountTransactionsRepository.
                findByCustomerCustomerIdOrderByTransactionDateDesc(customer.getCustomerId());
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }
}
