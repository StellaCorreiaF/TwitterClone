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
public class ProfileController {
    private final ProfileService profileService;

    @Autowired

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping()
    public List<Profile> getProfiles(){
        return profileService.profiles();
    }

    @PutMapping("/{id]")
    public ProfileMessage update(@PathVariable Long id, @RequestBody ProfileMessage profileMessage){
        return this.profileService.updateProfile(id, profileMessage);
    }
}
