//package com.eazybytes.springsecuritybasic.controller;
//
//import com.eazybytes.springsecuritybasic.Repository.AccountsRepository;
//import com.eazybytes.springsecuritybasic.modal.Accounts;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class BalanceController {
//    AccountsRepository accountsRepository;
//
//    @GetMapping("/myBalance")
//    public Accounts getAccountDetails(@RequestParam int id) {
//        List<Accounts> accountsList = accountsRepository.findByCustomer_id(id);
//
//        if (!accountsList.isEmpty()) {
//            // If there are multiple accounts with the same customer ID,
//            // you can return the first one.
//            return accountsList.get(0);
//        } else {
//            // Handle the case where no account is found.
//            // You can return null, throw an exception, or return an error message.
//            return null;
//        }
//    }
//}
