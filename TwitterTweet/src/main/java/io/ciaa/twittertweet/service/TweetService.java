package io.ciaa.twittertweet.service;

import io.ciaa.twittertweet.adpter.UserClient;
import io.ciaa.twittertweet.controller.TweetMessage;
import io.ciaa.twittertweet.model.Tweet;
import io.ciaa.twittertweet.model.TweetFactory;
import io.ciaa.twittertweet.repository.TweetRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserClient userClient;

    @Autowired
    public TweetService(TweetRepository tweetRepository, UserClient userClient) {
        this.tweetRepository = tweetRepository;
        this.userClient = userClient;
    }


    @SneakyThrows
    public Tweet createTweet(Long id, TweetMessage tweetMessage){
        var account = userClient.get(id);
        var newTweet = new TweetFactory().create(tweetMessage.getTweet(), account.getUserName());
        var createdTweet = tweetRepository.save(newTweet);

        return createdTweet;
    }


    public List<Tweet> getTweets(String userName) {
        return tweetRepository.getByUserName(userName);

    }
}
