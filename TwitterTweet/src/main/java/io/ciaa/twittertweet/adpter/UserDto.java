package io.ciaa.twittertweet.adpter;

import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {
    String email;
    String userName;

}