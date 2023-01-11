package com.codegym.repository.account;

import com.codegym.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRoleRepository extends JpaRepository<AccountRole,Integer> {
    @Modifying
    @Query(value = " insert into account_role (account_id, role_id) " +
            " values" +
            " ( :accountId, :roleId ) ", nativeQuery = true)
    void createAccountRole(Integer accountId, Integer roleId);
}
