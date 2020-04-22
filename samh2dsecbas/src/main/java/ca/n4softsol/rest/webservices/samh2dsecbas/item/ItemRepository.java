package ca.n4softsol.rest.webservices.samh2dsecbas.item;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByUsername(String username);

}
