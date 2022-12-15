package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Endereco;
import com.coffee.main.repositories.EnderecoRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
		
	public Endereco findById(Long id) {
		Optional<Endereco> Endereco = repository.findById(id);
		return Endereco.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	public Endereco insert (Endereco endereco) {
		return repository.save(endereco);
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
	
	public Endereco update(Long id, Endereco endereco) {
		try {
			Endereco entity = repository.getReferenceById(id);
			updateData(entity, endereco);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Endereco entity, Endereco obj) {
		entity.setLogradouro(obj.getLogradouro());
		entity.setNumero(obj.getNumero());
		entity.setComplemento(obj.getComplemento());
		entity.setBairro(obj.getBairro());
		entity.setCidade(obj.getCidade());
		entity.setUf(obj.getUf());
	}
	
}
