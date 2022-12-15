package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
