package com.coffee.main.controller;

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

import com.coffee.main.entities.Cupom;
import com.coffee.main.services.CupomService;

@RestController
@RequestMapping(value = "/cupom")
public class CupomController {
	
	@Autowired
	private CupomService service;
	
	public ResponseEntity<List<Cupom>> findAll() {
		List<Cupom> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cupom> findById(@PathVariable Long id) {
		Cupom cupom = service.findById(id);
		return ResponseEntity.ok().body(cupom);
	}
	
	@PostMapping
	public ResponseEntity<Cupom> insert(@RequestBody Cupom cupom) {
		cupom = service.insert(cupom);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cupom.getId()).toUri();
		return ResponseEntity.created(uri).body(cupom);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cupom> update(@PathVariable Long id, @RequestBody Cupom cupom) {
		cupom = service.update(id, cupom);
		return ResponseEntity.ok().body(cupom);
	}

}
