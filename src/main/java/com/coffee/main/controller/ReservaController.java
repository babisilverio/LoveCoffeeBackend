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

import com.coffee.main.entities.Reserva;
import com.coffee.main.services.ReservaService;

@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService service;
	
	public ResponseEntity<List<Reserva>> findAll() {
		List<Reserva> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reserva> findById(@PathVariable Long id) {
		Reserva reserva = service.findById(id);
		return ResponseEntity.ok().body(reserva);
	}
	
	@PostMapping
	public ResponseEntity<Reserva> insert(@RequestBody Reserva reserva) {
		reserva = service.insert(reserva);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(reserva.getId()).toUri();
		return ResponseEntity.created(uri).body(reserva);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva reserva) {
		reserva = service.update(id, reserva);
		return ResponseEntity.ok().body(reserva);
	}

}
