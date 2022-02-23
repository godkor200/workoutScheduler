package com.example.exercise.config;

import com.example.exercise.util.JwtAuthenticationEntryPoint;
import com.example.exercise.util.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     
     @Autowired
     private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
     
     @Autowired
     private JwtRequestFilter jwtRequestFilter;
     
     @Bean
     public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }
     
     @Bean
     @Override
     public AuthenticationManager authenticationManagerBean() throws Exception {
          return super.authenticationManagerBean();
     }
     
     @Override
     public void configure(HttpSecurity http) throws Exception {
          http.csrf()
              .disable();
          http.authorizeRequests()
              .antMatchers("/", "/v2/api-docs", "/swagger-resources/**",
                      "/swagger-ui.html", "/webjars/**", "/swagger/**", "/api/user/**")
              .permitAll()
              .anyRequest()
              .authenticated()
              .and()
              .exceptionHandling()
              .authenticationEntryPoint(jwtAuthenticationEntryPoint);
//              .and()
//              .formLogin()
//              .disable();
//          http.addFilterBefore(jwtRequestFilter);
     }
}
