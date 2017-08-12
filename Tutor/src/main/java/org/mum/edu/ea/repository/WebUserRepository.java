package org.mum.edu.ea.repository;

import org.mum.edu.ea.domain.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
	
	
	WebUser findWebUserByEmail(String email);

}
