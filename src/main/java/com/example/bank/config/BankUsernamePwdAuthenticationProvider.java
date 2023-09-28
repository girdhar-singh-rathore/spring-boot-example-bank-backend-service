package com.example.bank.config;

import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Girdhar Singh Rathore
 * @date Wednesday, September 27, 2023, 11:37 AM
 */
@Component
public class BankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private CustomerRepository customerRepository;

    private PasswordEncoder passwordEncoder;

    public BankUsernamePwdAuthenticationProvider(CustomerRepository customerRepository,
                                                 PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<Customer> customer = customerRepository.findByEmail(username);
        if (customer.size() > 0) {
            if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
