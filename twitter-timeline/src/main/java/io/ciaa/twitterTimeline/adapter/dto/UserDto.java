package io.ciaa.twitterTimeline.adapter.dto;

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
