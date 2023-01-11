package com.codegym.controller.security;

import com.codegym.model.account.Account;
import com.codegym.payload.reponse.JwtRespone;
import com.codegym.payload.reponse.MessageRespone;
import com.codegym.payload.request.LoginForm;
import com.codegym.security.jwt.JwtProvider;
import com.codegym.security.user_detail.MyUserDetail;
import com.codegym.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
public class SecurityController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {

        Account accountValidate = accountService.findByUsername(loginForm.getUsername()).get();

        if (accountValidate == null) {
            return new ResponseEntity<>(new MessageRespone("username not found"), HttpStatus.NOT_FOUND);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);

        return new ResponseEntity<>(new JwtRespone(token, myUserDetail.getAuthorities(), myUserDetail.getAccount().getUser(), myUserDetail.getAccount().getUsername()), HttpStatus.OK);

    }
}
