package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.Repository.ContactRepository;
import com.eazybytes.springsecuritybasic.modal.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private  ContactRepository contactRepository;
    @GetMapping("/contact")
    public String saveContactInquiryDetails(){
        return "Here are the contact details fronm DB";
    }


    @PostMapping("/contactus")
    public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
       Contact savedcontact=null;
       ResponseEntity response=null;
        try {

            savedcontact=contactRepository.save(contact);
            if(savedcontact.getContactId()>0){
                response= ResponseEntity.ok("Contact Details Saved Successfully");
            }


        } catch (Exception e) {
            response=ResponseEntity.status(HttpStatus.CREATED).body("An exception occured due to"+e.getMessage());
        }
          return  response;
        }

}