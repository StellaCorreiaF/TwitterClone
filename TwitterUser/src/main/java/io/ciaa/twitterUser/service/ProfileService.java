package io.ciaa.twitterUser.service;

import io.ciaa.twitterUser.controller.ProfileMessage;
import io.ciaa.twitterUser.modelo.Profile;
import io.ciaa.twitterUser.repository.AccountRespository;
import io.ciaa.twitterUser.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;



    @Autowired

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }

    public ProfileMessage updateProfile(Long id, ProfileMessage profileMessage){
        if(profileRepository.findById(id).isPresent()){
            Profile existingProfile = profileRepository.findById(id).get();
            existingProfile.setName(profileMessage.getName());
            existingProfile.setBirthDate(profileMessage.getBirthDate());
            existingProfile.setDescription(profileMessage.getDescription());

            Profile updatedProfile = profileRepository.save(existingProfile);
            return new ProfileMessage(updatedProfile.getId(), updatedProfile.getName(), updatedProfile.getDescription(), updatedProfile.getBirthDate());
        }
        else {return null; }
    }
}
