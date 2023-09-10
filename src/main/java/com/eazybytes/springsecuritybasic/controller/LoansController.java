package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.Repository.LoanRepository;
import com.eazybytes.springsecuritybasic.modal.Loans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    private LoanRepository loanRepository;



    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam long id) {
        List<Loans> loansList = loanRepository.findByCustomerCustomerIdOrderByStartDateDesc(id);

        return loansList;
    }
}
