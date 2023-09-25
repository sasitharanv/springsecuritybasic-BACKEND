package com.eazybytes.springsecuritybasic.Repository;

import com.eazybytes.springsecuritybasic.modal.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long >{

}
