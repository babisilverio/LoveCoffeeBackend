package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
