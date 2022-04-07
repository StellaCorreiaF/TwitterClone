package io.ciaa.twitterUser.controller;

import io.ciaa.twitterUser.modelo.Account;
import io.ciaa.twitterUser.repository.AccountRespository;
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
    private final AccountRespository accountRespository;


    @Autowired

    public UserController(AccountService accountService, AccountRespository accountRespository) {
        this.accountService = accountService;
        this.accountRespository = accountRespository;
    }

    @PostMapping
    public Account createUser(@RequestBody AccountMessage message){
        return accountService.createUser(message);
    }

    
}
