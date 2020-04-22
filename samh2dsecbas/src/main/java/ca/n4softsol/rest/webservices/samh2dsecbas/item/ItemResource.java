package ca.n4softsol.rest.webservices.samh2dsecbas.item;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ItemResource {

	@Autowired
	private ItemRepository itemRepository;

	private static List<Item> items = new ArrayList();

	public List<Item> getAllItems() {
		return items;

	}

	// GET /users/{username}/Items/{id}
	@GetMapping("/users/{username}/items/{id}")
	public Item getItem(@PathVariable String username, @PathVariable long id) {
		return itemRepository.findById(id).get();
	}

	// Retrieve all Item for a user
	@GetMapping("/users/{username}/items")
	public List<Item> getAllItems(@PathVariable String username) {
		return itemRepository.findByUsername(username);
	}

	// DELETE /users/{username}/items/{id}
	@DeleteMapping("/users/{username}/items/{id}")
	public ResponseEntity<Item> deleteItem(@PathVariable String username, @PathVariable long id) {
		Item itemSelected = itemRepository.findById(id).get();
		itemRepository.deleteById(id);
//		return ResponseEntity.noContent().build();
		return new ResponseEntity<Item>(itemSelected, HttpStatus.OK);
	}

	// PUT /users/{username}/items/{id}
	@PutMapping("/users/{username}/items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable String username, @PathVariable long id,
			@RequestBody Item item) {
		Item itemUpdated = itemRepository.save(item);
		return new ResponseEntity<Item>(itemUpdated, HttpStatus.OK);
	}

	// POST /users/{username}/items
	@PostMapping("/users/{username}/items")
	public ResponseEntity<Item> createItem(@PathVariable String username, @RequestBody Item item) {
		item.setUsername(username);
		Item itemCreated = itemRepository.save(item);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(itemCreated.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
