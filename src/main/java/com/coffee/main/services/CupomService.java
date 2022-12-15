package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Cupom;
import com.coffee.main.repositories.CupomRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CupomService {

	@Autowired
	private CupomRepository repository;
		
	public Cupom findById(Long id) {
		Optional<Cupom> cafeteria = repository.findById(id);
		return cafeteria.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Cupom> findAll() {
		return repository.findAll();
	}
	
	public Cupom insert (Cupom cafeteria) {
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
	
	public Cupom update(Long id, Cupom cafeteria) {
		try {
			Cupom entity = repository.getReferenceById(id);
			updateData(entity, cafeteria);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Cupom entity, Cupom obj) {
		entity.setCodigoCupom(obj.getCodigoCupom());
		entity.setDataValidade(obj.getDataValidade());		
	}
	
}
