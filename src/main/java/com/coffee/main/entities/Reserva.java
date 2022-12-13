package com.coffee.main.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RESERVA") 
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@Getter @Setter private Instant dataReserva;
	@Getter @Setter private Instant horaReserva;
	
	@ManyToOne
	@JoinColumn(name = "reserva_id")
	@Getter @Setter private Mesa mesa;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@Getter @Setter private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "cafeteria_id")
	@Getter @Setter private Cafeteria cafeteria;
	

}
