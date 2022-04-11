package io.ciaa.twittertweet.repository;

import io.ciaa.twittertweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
