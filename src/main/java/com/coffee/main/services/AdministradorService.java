package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Administrador;
import com.coffee.main.repositories.AdministradorRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository repository;
	
	public Administrador findById(Long id) {
		Optional<Administrador> admin = repository.findById(id);
		return admin.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Administrador> findAll() {
		return repository.findAll();
	}
	
	public Administrador insert (Administrador admin) {
		return repository.save(admin);
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Administrador update(Long id, Administrador admin) {
		try {
			Administrador entity = repository.getReferenceById(id);
			updateData(entity, admin);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Administrador entity, Administrador obj) {
	}
	


}
