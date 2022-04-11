package io.ciaa.twitterTimeline.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.ciaa.twitterTimeline.adapter.UserClient;
import io.ciaa.twitterTimeline.adapter.dto.UserDto;
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

    @GetMapping("/users/{id}")
    //posso excluir o parametro e inserir diretamente na requisiçao
    public UserDto createUser(@PathVariable Long id) {
        return userClient.get(id);
    }
}
