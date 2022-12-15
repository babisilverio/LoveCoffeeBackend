package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Cardapio;
import com.coffee.main.repositories.CardapioRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

@Service
public class CardapioService {

	@Autowired
	private CardapioRepository repository;
		
	public Cardapio findById(Long id) {
		Optional<Cardapio> cardapio = repository.findById(id);
		return cardapio.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Cardapio> findAll() {
		return repository.findAll();
	}
	
	public Cardapio insert (Cardapio cardapio) {
		return repository.save(cardapio);
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
}
