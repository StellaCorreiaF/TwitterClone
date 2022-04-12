package io.ciaa.twitterTimeline.controller;

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
}
