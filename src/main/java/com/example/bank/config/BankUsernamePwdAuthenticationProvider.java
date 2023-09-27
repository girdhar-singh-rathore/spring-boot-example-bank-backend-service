package com.example.bank.config;

import com.example.bank.model.UsersDetails;
import com.example.bank.repository.UsersDetailsRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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

    private UsersDetailsRepository usersDetailsRepository;

    private PasswordEncoder passwordEncoder;

    public BankUsernamePwdAuthenticationProvider(UsersDetailsRepository usersDetailsRepository,
                                                 PasswordEncoder passwordEncoder) {
        this.usersDetailsRepository = usersDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<UsersDetails> usersDetails = usersDetailsRepository.findByEmail(userName);
        if (usersDetails.size() > 0) {
            if (passwordEncoder.matches(password, usersDetails.get(0).getPwd())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(usersDetails.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(userName, password, authorities);
            } else {
                throw new BadCredentialsException("Invalid password.");
            }
        } else {
            throw new BadCredentialsException("No user registered with the given details");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
