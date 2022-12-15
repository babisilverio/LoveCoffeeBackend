package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Mesa;
import com.coffee.main.repositories.MesaRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MesaService {

	@Autowired
	private MesaRepository repository;
		
	public Mesa findById(Long id) {
		Optional<Mesa> mesa = repository.findById(id);
		return mesa.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Mesa> findAll() {
		return repository.findAll();
	}
	
	public Mesa insert (Mesa mesa) {
		return repository.save(mesa);
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
	
	public Mesa update(Long id, Mesa mesa) {
		try {
			Mesa entity = repository.getReferenceById(id);
			updateData(entity, mesa);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Mesa entity, Mesa obj) {
		entity.setNumeroMesa(obj.getNumeroMesa());
		entity.setQtdePessoas(obj.getQtdePessoas());
	}
	
}
