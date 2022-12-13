package com.coffee.main.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENDERECO") 
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long id;

	@Getter @Setter private String logradouro;
	@Getter @Setter private int numero;
	@Getter @Setter private String complemento;
	@Getter @Setter private String bairro;
	@Getter @Setter private String cidade;
	@Getter @Setter private String uf;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "endereco")
	@Getter @Setter private Cafeteria cafeteria;

	
}
