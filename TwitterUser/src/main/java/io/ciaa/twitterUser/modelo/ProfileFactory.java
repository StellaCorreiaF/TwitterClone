package io.ciaa.twitterUser.modelo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class ProfileFactory {

    public Profile create(String name, Account account, LocalDateTime birthDate, String description){
        final Profile profile = Profile.builder()
                .name(name)
                .account(account)
                .birthDate(birthDate)
                .description(description).build();

        return profile;
    }
}
