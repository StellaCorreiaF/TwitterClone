package io.ciaa.twitterUser.controller;

import io.ciaa.twitterUser.modelo.Profile;
import io.ciaa.twitterUser.repository.ProfileRepository;
import io.ciaa.twitterUser.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/user/profile")

public class ProfileController {

    private final ProfileService profileService;
    private final ProfileRepository profileRepository;
    @Autowired


    public ProfileController(ProfileService profileService, ProfileRepository profileRepository) {
        this.profileService = profileService;
        this.profileRepository = profileRepository;
    }

    @GetMapping("/{userid}")
    public Profile getProfile(@PathVariable ("userid") Long userid){

        return profileRepository.getById(userid);
    }

    @PutMapping("/{userid}")
    public ProfileMessage updateProfile(@PathVariable Long id, @RequestBody ProfileMessage profileMessage){
        return profileService.updateProfile(id, profileMessage);
    }

}
