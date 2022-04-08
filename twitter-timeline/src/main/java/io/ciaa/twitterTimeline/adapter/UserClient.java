package io.ciaa.twitterTimeline.adapter;

import io.ciaa.twitterTimeline.adapter.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "users", url = "http://localhost:8082")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users/{userid}")
    UserDto get(@PathVariable("userid") Long userId);
}
