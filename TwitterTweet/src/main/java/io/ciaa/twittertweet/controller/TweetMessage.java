package io.ciaa.twittertweet.controller;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class TweetMessage {
    private String tweet;
    private Long userId;
}
