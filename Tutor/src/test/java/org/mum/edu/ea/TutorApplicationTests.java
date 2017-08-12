package org.mum.edu.ea;

import static org.junit.Assert.assertTrue;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mum.edu.ea.domain.WebUserProfileType;
import org.mum.edu.ea.repository.WebUserProfileTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorApplicationTests {
	
    @Autowired
	private WebUserProfileTypeRepository roleRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insertRole() {
	
		WebUserProfileType newrole = new WebUserProfileType();
		newrole.setProfilename("Admin");
		
		roleRepository.save(newrole);
		
		int number_of_role = roleRepository.findAll().size();
		
		assertTrue("---test role insertion----",number_of_role == 1);
		
		
	}

}
