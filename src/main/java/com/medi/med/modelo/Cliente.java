package com.medi.med.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor 
public class Cliente {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	@Column(name = "CODIGO", unique = true, nullable = false )
	private Integer codigo;	
	
	@Column(name = "NOMBRE", length = 20)
	private String nombre;

	@Column(name = "DIRECCION", length = 20)
	private String direccion;
	
	 	

}
