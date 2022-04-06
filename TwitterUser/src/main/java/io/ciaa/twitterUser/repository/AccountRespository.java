package io.ciaa.twitterUser.repository;

import io.ciaa.twitterUser.modelo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRespository extends JpaRepository<Account, Long>{
}
