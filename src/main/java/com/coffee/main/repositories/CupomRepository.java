package com.coffee.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.main.entities.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, Long> {

}
