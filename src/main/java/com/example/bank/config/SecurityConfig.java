package com.example.bank.config;

import com.example.bank.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:49 AM
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler csrfTokenHandler = new CsrfTokenRequestAttributeHandler();
        csrfTokenHandler.setCsrfRequestAttributeName("_csrf");

        http.csrf(csrf -> csrf.csrfTokenRequestHandler(csrfTokenHandler).ignoringRequestMatchers("/contact","/register/**")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests) -> requests
                        /*.requestMatchers("/accounts").hasAuthority("VIEWACCOUNT")
                        .requestMatchers("/balance").hasAnyAuthority("VIEWACCOUNT", "VIEWBALANCE")
                        .requestMatchers("/loans").hasAuthority("VIEWLOAN")
                        .requestMatchers("/cards").hasAuthority("VIEWCARD")*/
                        .requestMatchers("/accounts").hasRole("USER")
                        .requestMatchers("/balance").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/loans").hasRole("USER")
                        .requestMatchers("/cards").hasRole("USER")
                        .requestMatchers("/user","/contact").authenticated()
                        .requestMatchers("/register/**", "/actuator/**","/notices").permitAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())

        ;
        return http.build();
    }

    /**
     * InMemoryUserDetailsManager, not recommended for production use.
     */
/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
    */

    // I have created custom UserDetailsRepository and UserDetails classes.
/*    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/
/*    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
