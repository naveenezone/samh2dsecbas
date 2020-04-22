package ca.n4softsol.rest.webservices.samh2dsecbas.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ItemCommandLineRunner.class);
	
	@Autowired
	private ItemDAOService itemDAOService;

	@Override
	public void run(String... args) throws Exception {
		Item item1 = new Item("sam", "Bread", (long) 2);
		Item item2 = new Item("sam", "Butter", (long) 1);
		Item item3 = new Item("sam", "Egg", (long) 24);
		Item item4 = new Item("sam", "Jam", (long) 1);
		Item item5 = new Item("sam", "Milk", (long) 3);
		long insert1 = itemDAOService.insert(item1);
		long insert2 = itemDAOService.insert(item2);
		long insert3 = itemDAOService.insert(item3);
		long insert4 = itemDAOService.insert(item4);
		long insert5 = itemDAOService.insert(item5);
		log.info("New Item is created : " + item1);
		log.info("New Item is created : " + item2);
		log.info("New Item is created : " + item3);
		log.info("New Item is created : " + item4);
		log.info("New Item is created : " + item5);
	}

}
