package com.security.authserver.userdetails;

import com.security.authserver.entity.Account;
import com.security.authserver.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> account = accountRepo.findByUserName(username);
        if (!account.isPresent()) throw new UsernameNotFoundException("User Name not Found");
        return new AccountDetails(account.get());
    }
}
