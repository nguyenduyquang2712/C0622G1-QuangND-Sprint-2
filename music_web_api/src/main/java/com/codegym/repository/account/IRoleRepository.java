package com.codegym.repository.account;

import com.codegym.model.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
    @Query(
            value = " select role.id, role.name from role " +
                    " join account_role on role.id = account_role.account_id " +
                    " where account_id = :accountId ", nativeQuery = true
    )
    List<Role> getListRoleByAccountId(@Param("accountId") Integer accountId);
    Optional<Role> findByName(String name);
}
