package com.eazybytes.springsecuritybasic.modal;


import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.Date;
@Entity
@Table(name = "account_transactions")
public class Account_transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId")
    private long transactionId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "transaction_amount")
    private int transactionAmount;

    @Column(name = "closing_amount")
    private int closingAmount;

    @Column(name = "create_date")
    private ZonedDateTime createDate;

    @Column(name = "transaction_date")
    private ZonedDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Accounts accounts;


    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(int closingAmount) {
        this.closingAmount = closingAmount;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getTransactionDate() {
        return transactionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public void setTransactionDate(ZonedDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
