package com.ypp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ypp.model.UserAccount;

@Repository
public interface UserAccountRepository  extends JpaRepository<UserAccount, Long> {
	
	Optional<UserAccount> findById(Long id);

}
