package com.codegym.repository.account;

import com.codegym.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
}
