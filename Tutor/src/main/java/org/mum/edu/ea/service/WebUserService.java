package org.mum.edu.ea.service;

import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.repository.WebUserRepository;



public class WebUserService {

	private WebUserRepository webuserRepository;
	
	public void create(WebUser webuser){
		webuserRepository.save(webuser);
		
	}

}
