package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
