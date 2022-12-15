package com.coffee.main.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cafeteria cafeteria;

	public Administrador() {}

	public Administrador(Long id, String login, String senha, Cafeteria cafeteria) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.cafeteria = cafeteria;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		return "Administrador [id=" + id + ", login=" + login + ", senha=" + senha + ", cafeteria=" + cafeteria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cafeteria, id, login, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(cafeteria, other.cafeteria) && Objects.equals(id, other.id)
				&& Objects.equals(login, other.login) && Objects.equals(senha, other.senha);
	}
	
	
	
}
