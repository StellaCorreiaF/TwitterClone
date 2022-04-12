package io.ciaa.twitterTimeline.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.ciaa.twitterTimeline.adapter.dto.TweetDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Getter
@Setter
@JsonSerialize

public class Timeline {

    String userName;
    List<TweetDto> tweet;
}
