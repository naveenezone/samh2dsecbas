package ca.n4softsol.rest.webservices.samh2dsecbas.item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ItemDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public long insert(Item item) {
		entityManager.persist(item);
		return item.getId();
	}
	
}
