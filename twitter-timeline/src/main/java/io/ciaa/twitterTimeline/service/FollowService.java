package io.ciaa.twitterTimeline.service;

import io.ciaa.twitterTimeline.FollowDto;
import io.ciaa.twitterTimeline.model.Follow;
import io.ciaa.twitterTimeline.repository.FollowRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class FollowService {

    @Autowired
    FollowRepository followRepository;


    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;

    }

    @SneakyThrows
   public void followUser(Long followerId, Long followedId) {

        Follow follower = new Follow();
        follower.setFollower(followerId);
        follower.setFollowed(followedId);
        followRepository.save(follower);


    }
    @SneakyThrows
    public void unfollowUser(Long followerId, Long followedId)
    {
        Follow follower = followRepository.findByFollowedAndFollower(followerId, followedId).orElse(null);

        followRepository.delete(follower);



    }
}
