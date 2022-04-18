package io.ciaa.twitterUser.controller;

import io.ciaa.twitterUser.modelo.Account;
import io.ciaa.twitterUser.repository.AccountRespository;
import io.ciaa.twitterUser.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Component
@RequestMapping("/users")
public class UserController {


    @Autowired
    private final AccountService accountService;
    @Autowired
    private final AccountRespository accountRespository;

    @PostMapping
    public Account createUser(@RequestBody AccountMessage message){

        return accountService.createUser(message);
    }

    @GetMapping("/{userid}")
    public Account getUser(@PathVariable("userid") Long userid) { return accountRespository.getById(userid);
    }
    // criar um endpoint para retornar os usuarios @GettMapping("/id")

    @GetMapping()
    public List<Account> getUsers() {return accountRespository.findAll(); }
}
