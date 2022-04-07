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
@RequestMapping("/user/account")
public class AccountController {

    private final AccountRespository accountRespository;
    private final AccountService accountService;

    public AccountController(AccountRespository accountRespository, AccountService accountService) {
        this.accountRespository = accountRespository;
        this.accountService = accountService;
    }

    @Autowired


    @GetMapping()
    public List<Account> getAccounts() {
        return this.accountService.getAccount();
    }

    @PutMapping("/{id}")
    public AccountMessage updateAccount(@PathVariable Long id, AccountMessage accountMessage){
        return accountService.updateAccount(id, accountMessage);
    }
}
