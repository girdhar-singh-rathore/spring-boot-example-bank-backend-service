/*package com.example.bank.user.service;

import com.example.bank.model.UsersDetails;
import com.example.bank.repository.UsersDetailsRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;*/

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 10:35 PM
 */
// NOTE: This class is not used in the project, since we are using BankUsernamePwdAuthenticationProvider.java

/*
@Service
public class BankUserDetails implements UserDetailsService {

    private UsersDetailsRepository usersDetailsRepository;

    public BankUserDetails(UsersDetailsRepository usersDetailsRepository) {
        this.usersDetailsRepository = usersDetailsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String userName, password = null;
        List<GrantedAuthority> authorities = null;
        List<UsersDetails> usersDetails = usersDetailsRepository.findByEmail(username);

        if (usersDetails.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the user: " + username + ".");
        } else {
            userName = usersDetails.get(0).getEmail();
            password = usersDetails.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(usersDetails.get(0).getRole()));
        }
        return new User(userName, password, authorities);
    }
}
*/
