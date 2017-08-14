
package org.mum.edu.ea.serviceimpl;

import java.util.List;
import java.util.Set;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.domain.WebUserProfile;
import org.mum.edu.ea.repository.WebUserProfileTypeRepository;
import org.mum.edu.ea.repository.WebUserRepository;
import org.mum.edu.ea.service.WebUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WebUserServiceImpl implements WebUserService {
	// We must implement AOP for logging later
	private static final Logger LOG = LoggerFactory.getLogger(WebUser.class);
	@Autowired
	private WebUserRepository userRepository;
	@Autowired
	private WebUserProfileTypeRepository roleRepository;

	/**
	 * @param email
	 */
	@Override
	public WebUser findByEmail(String email) {
		WebUser user = userRepository.findWebUserByEmail(email);
		return user;
	}

	/**
	 * @param id
	 */

	@Override
	public WebUser findById(Long id) {
		WebUser user = userRepository.findOne(id);

		return user;
	}

	@Transactional
	@Override
	public WebUser createUser(WebUser user, Set<WebUserProfile> userRoles) throws Exception {
		//
		WebUser localUser = userRepository.findWebUserByEmail(user.getEmail());
		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getEmail());
		} else {
			for (WebUserProfile userRole : userRoles) {
				roleRepository.save(userRole.getRole());
			}

			user.getWebUserProfileCollection().addAll(userRoles);

			localUser = userRepository.save(user);
		}
		return localUser;
	}

	@Override
	public WebUser save(WebUser user) {

		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long Id) {

		userRepository.delete(Id);
		;
	}

	@Override
	public List<WebUser> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
