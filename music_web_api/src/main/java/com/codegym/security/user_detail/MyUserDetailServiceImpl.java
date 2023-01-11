package com.codegym.security.user_detail;

import com.codegym.model.account.Account;
import com.codegym.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IAccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username).get();
        if(account == null) {
            throw new UsernameNotFoundException("username not found!");
        }
        return new MyUserDetail(account);
    }
}
