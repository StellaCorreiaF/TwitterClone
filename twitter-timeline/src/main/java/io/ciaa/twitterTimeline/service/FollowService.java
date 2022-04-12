package io.ciaa.twitterTimeline.service;

import io.ciaa.twitterTimeline.adapter.UserClient;
import io.ciaa.twitterTimeline.controller.FollowDto;
import io.ciaa.twitterTimeline.model.Follow;
import io.ciaa.twitterTimeline.model.FollowFactory;
import io.ciaa.twitterTimeline.repository.FollowRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final UserClient userClient;

    @Autowired
    public FollowService(FollowRepository followRepository, UserClient userClient) {
        this.followRepository = followRepository;
        this.userClient = userClient;
    }

    @SneakyThrows
    public Follow followUser(FollowDto followDto) {

       var follower = userClient.get(followDto.getUserFollowerId());
       var followed = userClient.get(followDto.getUserFollowedId());


        var newFollow = new FollowFactory().create(follower.getUserName(), followed.getUserName());
        followRepository.save(newFollow);

        return newFollow;
    }

    @SneakyThrows
    public void unfollowUser(Long followerId, Long followedId)
    {
        Follow follower = followRepository.findByFollowedAndFollower(followerId, followedId).orElse(null);

        followRepository.delete(follower);
    }
}
