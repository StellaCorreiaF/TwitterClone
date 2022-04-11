package io.ciaa.twittertweet.controller;


import io.ciaa.twittertweet.model.Tweet;
import io.ciaa.twittertweet.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("tweet")
public class TweetController {

    private final TweetService tweetService;
    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;}

    @PostMapping("/{userid}")
    public Tweet createTweet(@PathVariable ("userid") Long id,  @RequestBody TweetMessage tweetMessage) {
        return tweetService.createTweet(id, tweetMessage);
    }
}
