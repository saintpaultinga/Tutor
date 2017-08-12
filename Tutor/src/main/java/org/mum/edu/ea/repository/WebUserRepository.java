package org.mum.edu.ea.repository;

import org.mum.edu.ea.domain.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
	
	
	WebUser findWebUserByEmail(String email);

}
