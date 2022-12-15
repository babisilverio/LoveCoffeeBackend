package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Cliente;
import com.coffee.main.repositories.ClienteRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
		
	public Cliente findById(Long id) {
		Optional<Cliente> cafeteria = repository.findById(id);
		return cafeteria.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente insert (Cliente cafeteria) {
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
	
	public Cliente update(Long id, Cliente cafeteria) {
		try {
			Cliente entity = repository.getReferenceById(id);
			updateData(entity, cafeteria);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNomeCliente(obj.getNomeCliente());
		entity.setCpf(obj.getCpf());
		entity.setTelefone(obj.getTelefone());
		entity.setEmail(obj.getEmail());
	}
	
}
