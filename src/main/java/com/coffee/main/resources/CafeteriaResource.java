package com.coffee.main.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coffee.main.entities.Cafeteria;
import com.coffee.main.services.CafeteriaService;

@RestController
@RequestMapping(value = "/cafeteria")
public class CafeteriaResource {
	
	@Autowired
	private CafeteriaService service;
	
	public ResponseEntity<List<Cafeteria>> findAll() {
		List<Cafeteria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cafeteria> findById(@PathVariable Long id) {
		Cafeteria cafeteria = service.findById(id);
		return ResponseEntity.ok().body(cafeteria);
	}
	
	@PostMapping
	public ResponseEntity<Cafeteria> insert(@RequestBody Cafeteria cafeteria) {
		cafeteria = service.insert(cafeteria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cafeteria.getId()).toUri();
		return ResponseEntity.created(uri).body(cafeteria);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cafeteria> update(@PathVariable Long id, @RequestBody Cafeteria cafeteria) {
		cafeteria = service.update(id, cafeteria);
		return ResponseEntity.ok().body(cafeteria);
	}

}
