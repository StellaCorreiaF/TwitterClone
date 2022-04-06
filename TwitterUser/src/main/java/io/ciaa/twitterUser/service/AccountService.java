package io.ciaa.twitterUser.service;


import io.ciaa.twitterUser.controller.AccountMessage;
import io.ciaa.twitterUser.modelo.Account;
import io.ciaa.twitterUser.modelo.AccountFactory;
import io.ciaa.twitterUser.modelo.ProfileFactory;
import io.ciaa.twitterUser.repository.AccountRespository;
import io.ciaa.twitterUser.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRespository accountRespository;
    private final ProfileRepository profileRepository;
    private final AccountFactory accountFactory;

    @Autowired
    public AccountService(AccountRespository accountRespository,
                          ProfileRepository profileRepository,
                          AccountFactory accountFactory) {
        this.accountRespository = accountRespository;
        this.profileRepository = profileRepository;
        this.accountFactory = accountFactory;
    }

    public Account createUser(AccountMessage message){
        var newAccount = new AccountFactory().create(message.getUserName(), message.getEmail(), message.getPassword());
        var newProfile = new ProfileFactory().create(message.getName(), newAccount, message.getBirthDate(), message.getDescription());

        var createdAccount = accountRespository.save(newAccount);
        var createdProfile = profileRepository.save(newProfile);

        return createdAccount;
    }
}
