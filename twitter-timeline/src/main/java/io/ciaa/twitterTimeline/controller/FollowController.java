package io.ciaa.twitterTimeline.controller;

import io.ciaa.twitterTimeline.model.Follow;
import io.ciaa.twitterTimeline.repository.FollowRepository;
import io.ciaa.twitterTimeline.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/follow")
public class FollowController {
    private final FollowRepository followRepository;
    private final FollowService followService;

    @Autowired
    public FollowController(FollowRepository followRepository, FollowService followService) {
        this.followRepository = followRepository;
        this.followService = followService;
    }

    @PostMapping
    public Follow followUser(@RequestBody FollowDto dto){
        return followService.followUser(dto);
    }

    @GetMapping("/{userid}")
    public Follow getFollows(@PathVariable("userid") Long userid) {
        return followRepository.getById(userid);
    }
    // criar um endpoint para retornar os usuarios @GettMapping("/id")
}
