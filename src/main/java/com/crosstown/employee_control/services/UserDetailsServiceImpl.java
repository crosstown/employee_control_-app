package com.crosstown.employee_control.services;

import com.crosstown.employee_control.auth.User;
import com.crosstown.employee_control.auth.UserPrincipal;
import com.crosstown.employee_control.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author developer
 * @date 2019-05-16
 * @time 19:50
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("cannot find username: " + username);
        return new UserPrincipal(user);
    }
}
