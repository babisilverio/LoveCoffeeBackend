package com.coffee.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Administrador;
import com.coffee.main.repositories.AdministradorRepository;

@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository repository;
	


}
