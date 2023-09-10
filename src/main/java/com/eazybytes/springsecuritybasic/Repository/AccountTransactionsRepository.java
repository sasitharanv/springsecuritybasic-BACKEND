package com.eazybytes.springsecuritybasic.Repository;

import com.eazybytes.springsecuritybasic.modal.Account_transactions;
import com.eazybytes.springsecuritybasic.modal.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionsRepository  extends JpaRepository<Account_transactions,Long> {


    List<Account_transactions> findByCustomerCustomerIdOrderByTransactionDateDesc(long customerId );
}
