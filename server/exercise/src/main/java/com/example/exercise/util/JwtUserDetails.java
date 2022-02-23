package com.example.exercise.util;

import com.example.exercise.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {
     
     private final User user;
     
     public JwtUserDetails(User user) {
          super();
          this.user = user;
     }
     
     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
//          Role role = user.getRole();
          List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
          authorities.add(new SimpleGrantedAuthority(user.getUsername()));
          return authorities;
     }
     
     @Override
     public String getPassword() {
          return user.getPassword();
     }
     
     @Override
     public String getUsername() {
          return user.getUsername();
     }
     
     @Override
     public boolean isAccountNonExpired() {
          return true;
     }
     
     @Override
     public boolean isAccountNonLocked() {
          return true;
     }
     
     @Override
     public boolean isCredentialsNonExpired() {
          return true;
     }
     
     @Override
     public boolean isEnabled() {
          return true;
     }
}
