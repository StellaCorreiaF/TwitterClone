package io.ciaa.twitterUser.repository;

import io.ciaa.twitterUser.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
