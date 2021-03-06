package io.ciaa.twittertweet.repository;

import io.ciaa.twittertweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> getByUserName(String userName);
}
