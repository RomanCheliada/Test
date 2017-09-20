package ua.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.entity.Domain;
import ua.repository.DomainRepository;

@RestController
@RequestMapping("/domains")
@CrossOrigin
public class DomainResource {
	
	@Autowired
	private DomainRepository repository;
	
	@GetMapping
	public List<Domain> findAll(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Domain findOne(@PathVariable Integer id){
		return repository.findOne(id);
	}
	
	@PostMapping
	public Domain save(@RequestBody Domain domain){
		return repository.saveAndFlush(domain);
	}
	
	@PutMapping("/{id}")
	public Domain update(@PathVariable Integer id, @RequestBody Domain domain){
		domain.setId(id);
		return repository.saveAndFlush(domain);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		repository.delete(id);
		return ResponseEntity.ok().build();
	}
}
