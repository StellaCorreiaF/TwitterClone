package io.ciaa.twitterTimeline;

import io.ciaa.twitterTimeline.model.Follow;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class FollowDto {

    private Long userFollowerId;
    private Long userFollowedId;

    private Follow follow;
}
