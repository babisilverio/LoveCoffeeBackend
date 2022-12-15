package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
