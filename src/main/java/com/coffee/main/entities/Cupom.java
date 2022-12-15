package com.coffee.main.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUPOM")
public class Cupom implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoCupom;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Instant dataValidade;
	
	@ManyToOne
	@JoinColumn(name="cafeteria_id")
	private Cafeteria cafeteria;
	
	public Cupom() { }

	public Cupom(Long id, String codigoCupom, Instant dataValidade, Cafeteria cafeteria) {
		super();
		this.id = id;
		this.codigoCupom = codigoCupom;
		this.dataValidade = dataValidade;
		this.cafeteria = cafeteria;
	}

	public String getCodigoCupom() {
		return codigoCupom;
	}

	public void setCodigoCupom(String codigoCupom) {
		this.codigoCupom = codigoCupom;
	}

	public Instant getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Instant dataValidade) {
		this.dataValidade = dataValidade;
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
		return "Cupom [id=" + id + ", codigoCupom=" + codigoCupom + ", dataValidade=" + dataValidade + ", cafeteria="
				+ cafeteria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cafeteria, codigoCupom, dataValidade, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupom other = (Cupom) obj;
		return Objects.equals(cafeteria, other.cafeteria) && Objects.equals(codigoCupom, other.codigoCupom)
				&& Objects.equals(dataValidade, other.dataValidade) && Objects.equals(id, other.id);
	}
	
}
