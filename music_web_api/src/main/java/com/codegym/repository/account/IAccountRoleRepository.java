package com.codegym.repository.account;

import com.codegym.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRoleRepository extends JpaRepository<AccountRole,Integer> {
}
