package io.ciaa.twitterUser.model;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@AllArgsConstructor
public class AccountFactory {

    @SneakyThrows
    public Account create(String userName, String email, String password) {

        final Account account = Account.builder()
                .userName(userName)
                .email(email)
                .password(password)
                .lastLog(LocalDateTime.now())
                .build();

        return account;


    }



}