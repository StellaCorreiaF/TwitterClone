package io.ciaa.twitterUser.service;

import io.ciaa.twitterUser.controller.AccountMessage;
import io.ciaa.twitterUser.model.Account;
import io.ciaa.twitterUser.model.AccountFactory;
import io.ciaa.twitterUser.model.ProfileFactory;
import io.ciaa.twitterUser.repository.AccountRepository;
import io.ciaa.twitterUser.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, ProfileRepository profileRepository) {
        this.accountRepository = accountRepository;
        this.profileRepository = profileRepository;
    }

    public Account createUser(AccountMessage message) {
        var newUser = new AccountFactory().create(message.getUserName(), message.getEmail(), message.getPassword());
        var newProfile = new ProfileFactory().create(message.getName(),newUser, message.getBirthDate(), message.getDescription());

        var createdUser = accountRepository.save(newUser);
        var createdProfile= profileRepository.save(newProfile);
        return createdUser;
    }

    public AccountMessage updateUser(Long id, AccountMessage message){
        if(accountRepository.findById(id).isPresent()) {
            Account existingUser = accountRepository.findById(id).get();

            existingUser.setUserName(message.getUserName());
            existingUser.setEmail(message.getEmail());
            existingUser.setPassword(message.getPassword());

            Account updatedUser = accountRepository.save(existingUser);

            return new AccountMessage(updatedUser.getId(), updatedUser.getUserName(), updatedUser.getEmail(), updatedUser.getPassword());
        } else {return null; }

    }
}
