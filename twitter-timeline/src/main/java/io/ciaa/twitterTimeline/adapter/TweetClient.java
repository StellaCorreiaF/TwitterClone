package io.ciaa.twitterTimeline.adapter;

import io.ciaa.twitterTimeline.adapter.dto.TweetDto;
import io.ciaa.twitterTimeline.adapter.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "tweets", url = "http://localhost:8083")
public interface TweetClient {
    @RequestMapping(method = RequestMethod.GET, value = "/tweet/{tweetid}")
    UserDto get(@PathVariable("tweetid") Long tweetid);
    @RequestMapping(method = RequestMethod.GET, value = "/tweet/u/{username}/tweets")
    List<TweetDto> getByUserName(@PathVariable("username") String userName);
}
