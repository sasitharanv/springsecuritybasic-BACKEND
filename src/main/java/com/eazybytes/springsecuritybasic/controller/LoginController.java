package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.Repository.CustomerRepository;
import com.eazybytes.springsecuritybasic.config.EazyBankUserDetails;
import com.eazybytes.springsecuritybasic.modal.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Indicates that this class is a REST controller.
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository; // Injects the CustomerRepository.

    @Autowired
    private PasswordEncoder passwordEncoder; // Injects a PasswordEncoder.

    @Autowired
    private EazyBankUserDetails userDetails;

    AuthenticationProvider authenticationProvider;
    AuthenticationManager authenticationManager;

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

    @Autowired
    private EazyBankUserDetails userDetailsService;


//    @PostMapping("/signIn")
//    public ResponseEntity<?> signIn(@RequestBody Customer customer) {
//        // Create a UsernamePasswordAuthenticationToken using the provided username and password.
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPassword());
//
//        try {
//            // Authenticate the user using the authenticationProvider.
//            Authentication authentication = authenticationProvider.authenticate(authenticationToken);
//
//            // Set the authenticated user in the SecurityContext
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            // Return a JSON response with user information, authorities, or a token
//            Map<String, Object> responseData = new HashMap<>();
//            responseData.put("username", authentication.getName());
//            responseData.put("authorities", authentication.getAuthorities());
//
//            return ResponseEntity.ok(responseData);
//        } catch (BadCredentialsException e) {
//            // Authentication failed due to invalid credentials
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        } catch (LockedException e) {
//            // Handle account lockout, if applicable
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Account locked. Please contact support.");
//        } catch (DisabledException e) {
//            // Handle disabled account, if applicable
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Account disabled. Please contact support.");
//        } catch (Exception e) {
//            // Handle other authentication exceptions
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed. Please try again.");
//        }
//    }


    @GetMapping ("/user")
    public  Customer getUserDetailsAfterLogin(Authentication authentication){
        List<Customer> customers=customerRepository.findByEmail(authentication.getName());

    if(customers.size()>0){
        return customers.get(0);
    }
    else {
    return  null;
    }


    }


}




