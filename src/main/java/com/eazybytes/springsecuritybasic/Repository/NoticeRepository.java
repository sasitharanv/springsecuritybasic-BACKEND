package com.eazybytes.springsecuritybasic.Repository;

import com.eazybytes.springsecuritybasic.modal.Customer;
import com.eazybytes.springsecuritybasic.modal.Notice_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice_details,Long> {


    List<Notice_details> findAll();

}
