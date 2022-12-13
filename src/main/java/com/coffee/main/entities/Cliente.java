package com.coffee.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@Getter @Setter private String nomeCliente;
	@Getter @Setter private String cpf;
	@Getter @Setter private String email;
	@Getter @Setter private String telefone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	@Getter @Setter private List<Reserva> reservas = new ArrayList<>();
	

}
