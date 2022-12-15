package com.coffee.main.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARDAPIO")
public class Cardapio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cafeteria_id")
	private Cafeteria cafeteria;
	
	@OneToMany
	@JoinColumn(name = "produto_id")
	private List<Produto> produtos;
	
	
	public Cardapio() {	}

	public Cardapio(Long id, Cafeteria cafeteria) {
		super();
		this.id = id;
		this.cafeteria = cafeteria;
	}

	public Cafeteria getCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cardapio [id=" + id + ", cafeteria=" + cafeteria + ", produtos=" + produtos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cafeteria, id, produtos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cardapio other = (Cardapio) obj;
		return Objects.equals(cafeteria, other.cafeteria) && Objects.equals(id, other.id)
				&& Objects.equals(produtos, other.produtos);
	}

}
