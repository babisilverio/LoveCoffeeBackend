package com.coffee.main.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MESA")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroMesa;
	private int qtdePessoas;
	
	public Mesa() {}

	public Mesa(Long id, String numeroMesa, int qtdePessoas) {
		super();
		this.id = id;
		this.numeroMesa = numeroMesa;
		this.qtdePessoas = qtdePessoas;
	}

	public String getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public int getQtdePessoas() {
		return qtdePessoas;
	}

	public void setQtdePessoas(int qtdePessoas) {
		this.qtdePessoas = qtdePessoas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", numeroMesa=" + numeroMesa + ", qtdePessoas=" + qtdePessoas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numeroMesa, qtdePessoas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		return Objects.equals(id, other.id) && Objects.equals(numeroMesa, other.numeroMesa)
				&& qtdePessoas == other.qtdePessoas;
	}
	
}
