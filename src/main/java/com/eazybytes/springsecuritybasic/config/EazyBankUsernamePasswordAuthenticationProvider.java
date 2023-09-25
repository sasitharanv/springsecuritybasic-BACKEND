package com.eazybytes.springsecuritybasic.config;

import com.eazybytes.springsecuritybasic.Repository.CustomerRepository;
import com.eazybytes.springsecuritybasic.modal.Authority;
import com.eazybytes.springsecuritybasic.modal.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component // Indicates that this class is a Spring Component.
public class EazyBankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository; // Injects the CustomerRepository.

    @Autowired
    private PasswordEncoder passwordEncoder; // Injects a PasswordEncoder.

    // Implementation of the authenticate method from the AuthenticationProvider interface.
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String Password = authentication.getCredentials().toString();

        // Find a customer by their email (username).
        List<Customer> customer = customerRepository.findByEmail(username);

        if (customer.size() > 0) {
            // Check if the provided password matches the stored hashed password.
            if (passwordEncoder.matches(Password, customer.get(0).getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority((customer.get(0).getRole())));
                // Return a UsernamePasswordAuthenticationToken with the username, password, and authorities.
                return new UsernamePasswordAuthenticationToken(username, Password, getGrantedAutorities(customer.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid Password");
            }
        } else {
            throw new BadCredentialsException("No User registered with Details");
        }
    }
    // This is a method that converts a set of custom "Authority" objects into a list of Spring Security's "GrantedAuthority" objects.
    private List<GrantedAuthority> getGrantedAutorities(Set<Authority> authorities) {
        // Initialize an empty list to store the converted authorities.
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        // Loop through each "Authority" object in the provided set.
        for (Authority authority : authorities) {
            // Create a new "SimpleGrantedAuthority" object using the name of the "Authority."
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }

        // Return the list of converted "GrantedAuthority" objects.
        return grantedAuthorities;
    }




    // Implementation of the supports method from the AuthenticationProvider interface.
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "password";
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword); // Prints the hashed password to the console.
    }
}
