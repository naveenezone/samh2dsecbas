package ca.n4softsol.rest.webservices.samh2dsecbas.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public long insertAndSave(User user) {
		entityManager.persist(user);
		return user.getId();
	}
	
}
