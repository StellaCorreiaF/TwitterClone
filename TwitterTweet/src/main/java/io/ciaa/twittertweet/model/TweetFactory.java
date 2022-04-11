package io.ciaa.twittertweet.model;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class TweetFactory {

    @SneakyThrows
    public Tweet create(String tweet, String userName){
        final Tweet message = Tweet.builder()
                .userName(userName)
                .schedule(LocalDateTime.now())
                .tweet(tweet)
                .build();

        return message;
    }

}
