package intern.project.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import intern.project.entity.Account;
import lombok.Data;


@Data
@Service
public class MyUserDetails implements UserDetails {
    private Account us;
    public MyUserDetails(){
    }
    public MyUserDetails(Account us) {
        this.us = us;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(us.getRole());
        return Arrays.asList(authority);
        
    }

    @Override
    public String getPassword() {
        return us.getPassword();
    }

    @Override
    public String getUsername() {
        return us.getUsername();
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