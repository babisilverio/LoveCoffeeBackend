package com.coffee.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeCliente;
	private String cpf;
	private String email;
	private String telefone;
	
	@OneToMany
	@JoinColumn(name = "reserva_id")
	private List<Reserva> reservas = new ArrayList<>();

	public Cliente() {}

	public Cliente(Long id, String nomeCliente, String cpf, String email, String telefone, List<Reserva> reservas) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.reservas = reservas;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomeCliente=" + nomeCliente + ", cpf=" + cpf + ", email=" + email
				+ ", telefone=" + telefone + ", reservas=" + reservas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, nomeCliente, reservas, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nomeCliente, other.nomeCliente) && Objects.equals(reservas, other.reservas)
				&& Objects.equals(telefone, other.telefone);
	}
	
}
