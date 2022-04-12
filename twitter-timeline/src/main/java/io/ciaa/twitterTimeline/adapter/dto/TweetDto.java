package io.ciaa.twitterTimeline.adapter.dto;

import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class TweetDto {
    String userName;
    String tweet;
}
