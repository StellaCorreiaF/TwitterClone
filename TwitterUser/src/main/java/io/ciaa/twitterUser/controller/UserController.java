package io.ciaa.twitterUser.controller;

import io.ciaa.twitterUser.modelo.Account;
import io.ciaa.twitterUser.repository.AccountRespository;
import io.ciaa.twitterUser.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/users")
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

    @GetMapping("/{userid}")
    public Account getUser(@PathVariable("userid") Long userid) {
        return accountRespository.getById(userid);
    }
    // criar um endpoint para retornar os usuarios @GettMapping("/id")

    @GetMapping()
    public List<Account> getUsers() {return accountRespository.findAll(); }
}
