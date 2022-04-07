package io.ciaa.twitterUser.controller;

import io.ciaa.twitterUser.modelo.Account;
import io.ciaa.twitterUser.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequestMapping("/user")
public class UserController {

    private final AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createUser(@RequestBody AccountMessage message){
        return accountService.createUser(message);
    }


}
