package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.Repository.CustomerRepository;
import com.eazybytes.springsecuritybasic.modal.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController // Indicates that this class is a REST controller.
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository; // Injects the CustomerRepository.

    @Autowired
    private PasswordEncoder passwordEncoder; // Injects a PasswordEncoder.

    // Endpoint to register a user.
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity response = null;
        try {
            // Hash the user's password before saving it.
            String hashPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashPassword);

            // Set the create date to the current date.
            Date createDate = new Date(System.currentTimeMillis());
            customer.setCreateDate(createDate);

            // Save the customer to the database.
            savedCustomer = customerRepository.save(customer);

            if (savedCustomer.getCustomerId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("Given Your Details are Successfully Registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.CREATED).body("An exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    // Endpoint to get user details after login.
    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        // Find the customer by their email (username) from the authentication object.
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }
}
