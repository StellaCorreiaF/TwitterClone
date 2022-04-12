package io.ciaa.twitterTimeline.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.ciaa.twitterTimeline.adapter.UserClient;
import io.ciaa.twitterTimeline.model.Timeline;
import io.ciaa.twitterTimeline.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequestMapping("/timeline")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class TimelineController {
    @Autowired
    UserClient userClient;

    @Autowired
    TimeLineService timeLineService;

    @GetMapping("/{id}")
    public Timeline getTimeline(@PathVariable Long id) {
        var user = userClient.get(id);
        var timeline =  timeLineService.timeline(user.getUserName());

        return timeline;
    }
}
