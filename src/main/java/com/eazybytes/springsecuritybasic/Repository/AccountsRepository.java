package com.eazybytes.springsecuritybasic.Repository;

import com.eazybytes.springsecuritybasic.modal.Accounts;

import com.eazybytes.springsecuritybasic.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository  extends JpaRepository<Accounts,Long> {


    List<Accounts> findByCustomerCustomerId(long customerId);
}
