package com.codegym.model.account;

import com.codegym.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;
    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRole> accountRoles;
    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private User user;

}
