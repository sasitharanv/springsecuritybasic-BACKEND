package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.Repository.AuthorityRepository;
import com.eazybytes.springsecuritybasic.modal.Authority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorityController {

    AuthorityRepository authoritieRepository;

    @GetMapping("/authority")
    public Authority getAuthorityDetail(@RequestParam long id){
        List<Authority> authoritylist=authoritieRepository.findAll();
        return null;
    }




}
