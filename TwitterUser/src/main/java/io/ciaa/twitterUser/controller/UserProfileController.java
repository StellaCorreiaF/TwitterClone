package io.ciaa.twitterUser.controller;

import io.ciaa.twitterUser.modelo.Profile;
import io.ciaa.twitterUser.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/user/profile")
public class UserProfileController {

    private final ProfileService profileService;

    @Autowired
    public UserProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PutMapping("/{id}")
    public ProfileMessage updateUser(@PathVariable Long id, @RequestBody ProfileMessage profilemessage) {
        return profileService.updateProfile(id, profilemessage);
    }

    @GetMapping
    public List<Profile> getProfiles () {
        return profileService.profiles();
    }
}
