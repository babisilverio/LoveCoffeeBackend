package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
