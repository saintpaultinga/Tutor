package org.mum.edu.ea.repository;

import org.mum.edu.ea.domain.WebUserProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserProfileTypeRepository extends JpaRepository<WebUserProfileType, Long> {
	
	WebUserProfileType findByProfilename(String name);

}
