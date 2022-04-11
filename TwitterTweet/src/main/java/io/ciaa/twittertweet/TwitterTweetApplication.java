package io.ciaa.twittertweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TwitterTweetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterTweetApplication.class, args);
    }

}
