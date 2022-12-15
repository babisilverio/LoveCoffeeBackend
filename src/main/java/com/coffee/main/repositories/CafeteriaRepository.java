package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Cafeteria;

public interface CafeteriaRepository extends JpaRepository<Cafeteria, Long> {

}
