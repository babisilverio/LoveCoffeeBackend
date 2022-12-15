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

import com.coffee.main.entities.Mesa;
import com.coffee.main.services.MesaService;

@RestController
@RequestMapping(value = "/mesa")
public class MesaController {
	
	@Autowired
	private MesaService service;
	
	public ResponseEntity<List<Mesa>> findAll() {
		List<Mesa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Mesa> findById(@PathVariable Long id) {
		Mesa mesa = service.findById(id);
		return ResponseEntity.ok().body(mesa);
	}
	
	@PostMapping
	public ResponseEntity<Mesa> insert(@RequestBody Mesa mesa) {
		mesa = service.insert(mesa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(mesa.getId()).toUri();
		return ResponseEntity.created(uri).body(mesa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Mesa> update(@PathVariable Long id, @RequestBody Mesa mesa) {
		mesa = service.update(id, mesa);
		return ResponseEntity.ok().body(mesa);
	}

}
