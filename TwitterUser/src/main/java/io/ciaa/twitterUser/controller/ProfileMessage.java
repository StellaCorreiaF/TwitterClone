package io.ciaa.twitterUser.controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ProfileMessage {
    private String name;
    private Long userId;
    private String photo;
    @JsonProperty("birth_date")
    private LocalDateTime birthDate;
    private String description;


    public ProfileMessage(Long id, String name, String description, LocalDateTime birthDate) {

        this.name = name;
        this.description = description;
        this.birthDate = birthDate;
    }
}
