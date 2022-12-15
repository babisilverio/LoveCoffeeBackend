package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Cafeteria;
import com.coffee.main.repositories.CafeteriaRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CafeteriaService {

	@Autowired
	private CafeteriaRepository repository;
		
	public Cafeteria findById(Long id) {
		Optional<Cafeteria> cafeteria = repository.findById(id);
		return cafeteria.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Cafeteria> findAll() {
		return repository.findAll();
	}
	
	public Cafeteria insert (Cafeteria cafeteria) {
		return repository.save(cafeteria);
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
	
	public Cafeteria update(Long id, Cafeteria cafeteria) {
		try {
			Cafeteria entity = repository.getReferenceById(id);
			updateData(entity, cafeteria);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Cafeteria entity, Cafeteria obj) {
		entity.setNome(obj.getNome());
		entity.setEndereco(obj.getEndereco());
	}
	
}
