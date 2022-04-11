package io.ciaa.twitterTimeline.model;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FollowFactory {

    @SneakyThrows
    public Follow create(String follower, String followed){

        final Follow follow = Follow.builder()
                .followed(followed)
                .follower(follower)
                .build();

        return follow;
    }


}
