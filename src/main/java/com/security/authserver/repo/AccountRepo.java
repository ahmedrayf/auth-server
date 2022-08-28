package com.security.authserver.repo;

import com.security.authserver.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account,Long> {

    Optional<Account> findByUserName(String username);
}
