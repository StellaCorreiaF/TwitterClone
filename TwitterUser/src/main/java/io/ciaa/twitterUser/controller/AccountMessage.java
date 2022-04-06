package io.ciaa.twitterUser.controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AccountMessage {
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;
    @JsonProperty("birth_date")
    private LocalDateTime birthDate;
    @JsonProperty("description")
    private String description;

    public AccountMessage(Long id,
                          String userName,
                          String email,
                          String password) {

        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
