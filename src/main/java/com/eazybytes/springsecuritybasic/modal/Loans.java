
package com.eazybytes.springsecuritybasic.modal;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;



    @Column(name = "loan_number")
    private String loanNumber;

    @Column(name = "total_loan")
    private int totalLoan;

    @Column(name = "create_date")
    private ZonedDateTime createDate;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "start_date")
    private ZonedDateTime startDate;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "outstanding_amount")
    private int outstandingAmount;

    @Column(name = "account_type")
    private String accountType;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private  Customer customer;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }


    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public int getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(int totalLoan) {
        this.totalLoan = totalLoan;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }





    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(int outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
