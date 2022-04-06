package io.ciaa.twitterUser.model;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class ProfileFactory {

    @SneakyThrows
    public Profile create  (String name, Account account, LocalDateTime birthDate, String description){
        final Profile userProfile = Profile.builder()
                .name(name)
                .birthDate(birthDate)
                .description(description)
                .account(account)
                .build();

        return userProfile;
    }
}