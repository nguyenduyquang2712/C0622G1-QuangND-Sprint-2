package com.codegym.service.account;

import com.codegym.model.account.Account;
import com.codegym.model.account.Role;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);
    Account save(Account account);
    List<Role> getListRoleByAccountId(Integer userId);
    void save(Integer accountId,Integer roleId);
}
