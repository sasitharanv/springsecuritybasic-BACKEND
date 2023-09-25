package com.eazybytes.springsecuritybasic.config;

import com.eazybytes.springsecuritybasic.filter.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.naming.Context;

@EnableWebSecurity // Enables Spring Security for the application.
@Configuration // Indicates that this class is a configuration class.
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        // Create a CsrfTokenRequestAttributeHandler instance.
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        // Configure security settings using HttpSecurity.
        http.securityContext((context) -> context.requireExplicitSave(false))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/myAccount").hasAuthority("VIEWACCOUNT")
                        .requestMatchers("/myBalance").hasAnyAuthority("VIEWACCOUNT","VIEWBALANCE")
                        .requestMatchers("/myCards").hasAuthority("VIEWCARD")
                        .requestMatchers("/myLoans").hasAuthority("VIEWLOANS")


                        .requestMatchers("/myAccount").hasRole("USER")
                        .requestMatchers("/myBalance").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/myCards").hasRole("USER")
                        .requestMatchers("/myLoans").hasRole("USER")


                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards", "/user").authenticated()
                        .requestMatchers("/notices", "/contact", "/register", "/contactus","/signIn").permitAll()
                        .anyRequest().denyAll());
        http.csrf(csrf -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact", "/register", "/contactus")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
        http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);

        // Configure CORS settings.
        http.cors(Customizer.withDefaults());

        // Configure form login with defaults.
        http.formLogin(Customizer.withDefaults());

        // Configure HTTP Basic Authentication with defaults.
        http.httpBasic(Customizer.withDefaults());

        // Build and return the security filter chain.
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Create and return a BCryptPasswordEncoder instance for password encoding.
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        // Configure CORS settings for allowed origins, headers, methods, etc.
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000"); // Allowed origin
        configuration.addAllowedHeader("*"); // Allowed headers
        configuration.addAllowedMethod("*"); // Allowed methods
        configuration.setAllowCredentials(true); // Allow credentials
        configuration.setMaxAge(3600L); // Max age

        // Create a URL-based CorsConfigurationSource and apply CORS settings to all paths.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
