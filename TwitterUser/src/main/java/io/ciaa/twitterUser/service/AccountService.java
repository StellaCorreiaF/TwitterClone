package io.ciaa.twitterUser.service;


import io.ciaa.twitterUser.controller.AccountMessage;
import io.ciaa.twitterUser.modelo.Account;
import io.ciaa.twitterUser.modelo.AccountFactory;
import io.ciaa.twitterUser.modelo.ProfileFactory;
import io.ciaa.twitterUser.repository.AccountRespository;
import io.ciaa.twitterUser.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRespository accountRespository;
    private final ProfileRepository profileRepository;



    @Autowired
    public AccountService(AccountRespository accountRespository, ProfileRepository profileRepository) {
        this.accountRespository = accountRespository;
        this.profileRepository = profileRepository;
    }

    public Account createUser(AccountMessage message){
        var newAccount = new AccountFactory().create(message.getUserName(), message.getEmail(), message.getPassword());
        var newProfile = new ProfileFactory().create(message.getName(), newAccount, message.getBirthDate(), message.getDescription());

        var createdAccount = accountRespository.save(newAccount);
        var createdProfile = profileRepository.save(newProfile);

        return createdAccount;
    }
    public AccountMessage updateAccount(Long id, AccountMessage accountMessage){
        if(accountRespository.findById(id).isPresent()){
            Account existingAccount = accountRespository.findById(id).get();
            existingAccount.setEmail(accountMessage.getEmail());
            existingAccount.setPassword(accountMessage.getPassword());
            existingAccount.setUserName(accountMessage.getUserName());

            Account updatedAccount = accountRespository.save(existingAccount);
            return new AccountMessage(updatedAccount.getId(),
                    updatedAccount.getUserName(),
                    updatedAccount.getEmail(),
                    updatedAccount.getPassword());
        }
        else {return null; }
    }

    public List<Account> getAccount() {
        return accountRespository.findAll();
    }


}
