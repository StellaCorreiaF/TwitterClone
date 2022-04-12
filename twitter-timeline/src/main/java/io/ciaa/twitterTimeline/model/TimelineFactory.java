package io.ciaa.twitterTimeline.model;

import io.ciaa.twitterTimeline.adapter.dto.TweetDto;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TimelineFactory {

    @SneakyThrows
    public Timeline create(String userName, List<TweetDto> tweet){

        final Timeline timeline = Timeline.builder()
                .userName(userName)
                .tweet(tweet)
                .build();

        return timeline;
    }

}
