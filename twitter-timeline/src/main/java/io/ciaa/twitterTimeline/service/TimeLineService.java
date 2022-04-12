package io.ciaa.twitterTimeline.service;

import io.ciaa.twitterTimeline.adapter.TweetClient;
import io.ciaa.twitterTimeline.adapter.UserClient;
import io.ciaa.twitterTimeline.adapter.dto.TweetDto;
import io.ciaa.twitterTimeline.model.Timeline;
import io.ciaa.twitterTimeline.model.TimelineFactory;
import io.ciaa.twitterTimeline.repository.FollowRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class TimeLineService {
    @Autowired
    private final UserClient userClient;
    @Autowired
    private final TweetClient tweetClient;

    @Autowired
    private final FollowRepository followRepository;

    public Timeline timeline(String username){
        var follows=    followRepository.findByFollower(username);

        List<TweetDto> allTweets = new ArrayList<>();

        for (var f: follows){
           var tweets =  tweetClient.getByUserName(f.getFollowed());
           allTweets.addAll(tweets);
        }
        var timeline = new TimelineFactory().create(username, allTweets);

        return timeline;
    }
}
