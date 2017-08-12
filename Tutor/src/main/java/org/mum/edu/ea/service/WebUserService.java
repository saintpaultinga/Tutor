package org.mum.edu.ea.service;

import java.util.List;
import java.util.Set;

import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.domain.WebUserProfile;


public interface WebUserService {
	
	WebUser findByEmail (String email);
	
	WebUser findById(Long id);
	
	WebUser createUser(WebUser user, Set<WebUserProfile> userRoles) throws Exception;
	
	WebUser save(WebUser user);
	
	void deleteUserById(Long Id);
	
	List<WebUser> findAll();
}
