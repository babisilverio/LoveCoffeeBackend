package com.coffee.main.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.main.entities.Endereco;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

	@GetMapping
	public ResponseEntity<Endereco> findAll() {
		Endereco e = new Endereco(1L, "Rua dos Crenaques", 348, "Apto 202 bloco 06", "Santa Monica", "BH", "MG");
		return ResponseEntity.ok().body(e);
	}
}
