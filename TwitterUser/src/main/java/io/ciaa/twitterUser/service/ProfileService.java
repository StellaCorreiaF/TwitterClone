package io.ciaa.twitterUser.service;

import io.ciaa.twitterUser.controller.ProfileMessage;
import io.ciaa.twitterUser.model.Profile;
import io.ciaa.twitterUser.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileMessage updateProfile(Long id, ProfileMessage message) {
        if(profileRepository.findById(id).isPresent()){
            Profile existingProfile = profileRepository.findById(id).get();

            existingProfile.setName(message.getName());
            existingProfile.setDescription(message.getDescription());

            Profile updatedProfile = profileRepository.save(existingProfile);

            return new ProfileMessage(updatedProfile.getName(), updatedProfile.getDescription());
        } else { return null; }
    }
}
