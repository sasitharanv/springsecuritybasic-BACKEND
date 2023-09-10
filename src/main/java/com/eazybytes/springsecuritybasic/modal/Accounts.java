package com.eazybytes.springsecuritybasic.modal;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_number;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    private String account_type;

    private String branch_address;

    private Date create_date;


    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public void setBranch_address(String branch_address) {
        this.branch_address = branch_address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
