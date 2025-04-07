package intern.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import intern.project.entity.Account;
import intern.project.repository.AccountRepository;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {
        Account us = userRepository.findByUsername(name);
        if (us == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(us);
    }

}