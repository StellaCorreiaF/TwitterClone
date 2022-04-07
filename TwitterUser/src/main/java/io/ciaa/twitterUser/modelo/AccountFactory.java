package io.ciaa.twitterUser.modelo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class AccountFactory {

    public Account create(String userName, String email, String password){
        final Account account = Account.builder()
                .userName(userName)
                .email(email)
                .password(password)
                .lastLog(LocalDateTime.now())
                .build();

        return account;
    }
}
