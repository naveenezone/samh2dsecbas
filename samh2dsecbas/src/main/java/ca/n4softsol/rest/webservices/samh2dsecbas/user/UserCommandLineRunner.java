package ca.n4softsol.rest.webservices.samh2dsecbas.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserDAOService userDaoService;
	
	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack","Admin");
		long idValue =userDaoService.insertAndSave(user);
		log.info("New User is created : " + user);
	}

}
