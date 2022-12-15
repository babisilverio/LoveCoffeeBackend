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
@Table(name = "RESERVA") 
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Instant dataReserva;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Instant horaReserva;
	
	@ManyToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "cafeteria_id")
	private Cafeteria cafeteria;

	public Reserva() {}

	public Reserva(Long id, Instant dataReserva, Instant horaReserva, Mesa mesa, Cliente cliente, Cafeteria cafeteria) {
		super();
		this.id = id;
		this.dataReserva = dataReserva;
		this.horaReserva = horaReserva;
		this.mesa = mesa;
		this.cliente = cliente;
		this.cafeteria = cafeteria;
	}

	public Instant getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Instant dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Instant getHoraReserva() {
		return horaReserva;
	}

	public void setHoraReserva(Instant horaReserva) {
		this.horaReserva = horaReserva;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {	
		this.mesa = mesa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		return "Reserva [id=" + id + ", dataReserva=" + dataReserva + ", horaReserva=" + horaReserva + ", mesa=" + mesa
				+ ", cliente=" + cliente + ", cafeteria=" + cafeteria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cafeteria, cliente, dataReserva, horaReserva, id, mesa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(cafeteria, other.cafeteria) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(dataReserva, other.dataReserva) && Objects.equals(horaReserva, other.horaReserva)
				&& Objects.equals(id, other.id) && Objects.equals(mesa, other.mesa);
	}
	
}
