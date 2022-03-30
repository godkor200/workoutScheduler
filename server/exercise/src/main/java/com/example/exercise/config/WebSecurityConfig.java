package com.example.exercise.config;

import com.example.exercise.util.ExceptionHandlerFilter;
import com.example.exercise.util.JwtAuthenticationEntryPoint;
import com.example.exercise.util.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     
     @Autowired
     private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
     
     @Autowired
     private UserDetailsService jwtUserDetailsService;
     
     @Autowired
     private ExceptionHandlerFilter exceptionHandlerFilter;
     
     @Autowired
     private JwtRequestFilter jwtRequestFilter;
     
     
     @Autowired
     public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(jwtUserDetailsService)
              .passwordEncoder(passwordEncoder());
     }
     
     @Bean
     @Override
     public AuthenticationManager authenticationManagerBean() throws Exception {
          return super.authenticationManagerBean();
     }
     
     @Bean
     public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }
     
     @Override
     public void configure(HttpSecurity http) throws Exception {
          http.cors()
              .disable()
              .csrf()
              .disable().
              authorizeRequests()
              .antMatchers("/", "/v2/api-docs", "/swagger-resources/**",
                      "/swagger-ui.html", "/webjars/**", "/swagger/**", "/api/user/**", "/api/v1/authenticate")
              .permitAll()
              .anyRequest()
              .authenticated()
              .and()
              .exceptionHandling()
              .authenticationEntryPoint(jwtAuthenticationEntryPoint)
              .and()
              .formLogin()
              .disable()
              .headers()
              .frameOptions()
              .disable();
          
          http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
          http.addFilterBefore(exceptionHandlerFilter, JwtRequestFilter.class);
     }
}
