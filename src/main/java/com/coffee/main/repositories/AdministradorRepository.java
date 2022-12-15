package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
