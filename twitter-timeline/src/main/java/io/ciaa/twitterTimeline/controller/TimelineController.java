package io.ciaa.twitterTimeline.controller;

import io.ciaa.twitterTimeline.adapter.UserClient;
import io.ciaa.twitterTimeline.adapter.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/timeline")
public class TimelineController {
    @Autowired
    UserClient userClient;

    @GetMapping()

    //posso excluir o parametro e inserir diretamente na requisiçao
    public UserDto createUser(Long id) {
        return userClient.get(id);
    }
}
