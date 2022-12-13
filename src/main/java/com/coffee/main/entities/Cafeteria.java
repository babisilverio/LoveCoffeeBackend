package com.coffee.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "CAFETERIA")
public class Cafeteria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@Getter @Setter private String nome;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	@Getter @Setter private Endereco endereco;
	
	@OneToOne(mappedBy = "cafeteria", cascade = CascadeType.ALL)
	@Getter @Setter private Cardapio cardapio;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cafeteria")
	@Getter @Setter private List<Cupom> cupons = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne
	@MapsId
	@Getter @Setter private Administrador administrador;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cafeteria")
	@Getter @Setter private List<Reserva> reservas = new ArrayList<>();
	

}
