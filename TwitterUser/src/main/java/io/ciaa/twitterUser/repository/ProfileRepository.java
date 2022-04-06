package io.ciaa.twitterUser.repository;

import io.ciaa.twitterUser.modelo.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
