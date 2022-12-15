package com.coffee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coffee.main.entities.Reserva;
import com.coffee.main.repositories.ReservaRepository;
import com.coffee.main.services.exception.DatabaseException;
import com.coffee.main.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository repository;
		
	public Reserva findById(Long id) {
		Optional<Reserva> reserva = repository.findById(id);
		return reserva.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public List<Reserva> findAll() {
		return repository.findAll();
	}
	
	public Reserva insert (Reserva reserva) {
		return repository.save(reserva);
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
	
	public Reserva update(Long id, Reserva reserva) {
		try {
			Reserva entity = repository.getReferenceById(id);
			updateData(entity, reserva);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Reserva entity, Reserva obj) {
		entity.setDataReserva(obj.getDataReserva());
		entity.setHoraReserva(obj.getHoraReserva());
	}
	
}
