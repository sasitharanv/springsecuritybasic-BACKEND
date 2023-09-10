package com.eazybytes.springsecuritybasic.Repository;

import com.eazybytes.springsecuritybasic.modal.Customer;
import com.eazybytes.springsecuritybasic.modal.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loans,Long> {
//    List<Loans> findByCustomerIdOrderByOrderByStartDateDesc(int customer_id);
    List<Loans> findByCustomerCustomerIdOrderByStartDateDesc(long customerId);
}
