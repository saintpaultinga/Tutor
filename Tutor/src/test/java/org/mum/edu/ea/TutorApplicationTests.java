package org.mum.edu.ea;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mum.edu.ea.domain.Category;
import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.Location;
import org.mum.edu.ea.domain.PositionCategory;
import org.mum.edu.ea.domain.PositionStatus;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.domain.WebUserProfileType;
import org.mum.edu.ea.repository.IPostJob;
import org.mum.edu.ea.repository.PositionCategoryRepository;
import org.mum.edu.ea.repository.WebUserProfileTypeRepository;
import org.mum.edu.ea.repository.WebUserRepository;
import org.mum.edu.ea.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorApplicationTests {

	@Autowired
	private WebUserProfileTypeRepository roleRepository;
	@Autowired
	PositionCategoryRepository catrepository;

	@Autowired
	IPostJob positionrepository;
	@Autowired
	WebUserRepository wrepository;

	@Test
	public void insertRole() {

		WebUserProfileType newrole = new WebUserProfileType();
		newrole.setProfilename("Admin");

		roleRepository.save(newrole);

		int number_of_role = roleRepository.findAll().size();

		assertTrue("---test role insertion----", number_of_role == 1);

	}
	
	
    @Test
	public void testCreatePositionCategory() {
		PositionCategory po = new PositionCategory();
		po.setType(Category.IT);
		catrepository.save(po);
		 int number_of_position = catrepository.findAll().size();

	    assertTrue("---test position insertion----", number_of_position == 1);
	}

	@Test
	public void insertPosition() {

		Position p = new Position();
		// add position field;
		p.setDuration(6);
		p.setDescription("-I want a qualified pepople in mathematique to help my song");
		p.setTitle("Maths Teacher");
		p.setStatus(PositionStatus.ACTIVATE);
		p.setPosteddate(DateUtils.returnCurrentDate());
		p.setEstimatedwage(1000);
		// set the position category
		 PositionCategory pc = catrepository.findByType(Category.IT);
		 p.setCategory(pc);
		 //set location
		 Location l = new Location();
		 l.setCity("FairField");
		 l.setState("IA");
		 l.setStreet("1000N 4Street");
		
		 p.setLocationId(l);
		 
		 positionrepository.save(p);
		
		 int number_of_position = positionrepository.findAll().size();
		
		 assertTrue("---test position insertion----",number_of_position == 1);
	}
	
	@Test
	public void testInsertUser() {
		
		WebUser user = new WebUser();
		user.setEmail("kuthu.eshan@gmail.com");
		user.setFirstname("bikesh");
		user.setLastname("kuthu");
		user.setEnabled(true);
		user.setPhone("64123301255");
		user.setPassword("hello");
		user.setTitle("Java Developer");
		
		wrepository.save(user);
		
		int number_of_position = wrepository.findAll().size();
			
		 assertTrue("---test position insertion----",number_of_position == 1);
		
	}
	
	

}
