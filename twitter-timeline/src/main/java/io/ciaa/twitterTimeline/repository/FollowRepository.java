package io.ciaa.twitterTimeline.repository;

import io.ciaa.twitterTimeline.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {

//    List<Follow> findTweetsThatsFollows(Follow user);

    Optional<Follow> findByFollowedAndFollower(Long follower, Long followed);

}
