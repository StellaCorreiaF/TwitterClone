package io.ciaa.twitterTimeline.controller;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class TimelineDto {

    private Long userId;
    private String tweet;
}