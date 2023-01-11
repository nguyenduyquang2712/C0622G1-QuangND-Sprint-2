package com.codegym.service.account.impl;

import com.codegym.model.account.Account;
import com.codegym.model.account.Role;
import com.codegym.repository.account.IAccountRepository;
import com.codegym.repository.account.IAccountRoleRepository;
import com.codegym.repository.account.IRoleRepository;
import com.codegym.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IAccountRoleRepository accountRoleRepository;
    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Role> getListRoleByAccountId(Integer userId) {
        return roleRepository.getListRoleByAccountId(userId);
    }

    @Override
    public void save(Integer accountId, Integer roleId) {
        accountRoleRepository.createAccountRole(accountId,roleId);
    }
}
