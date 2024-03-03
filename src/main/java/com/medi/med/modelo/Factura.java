package com.medi.med.modelo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FACTURA")
@Getter
@Setter
@NoArgsConstructor
public class Factura {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "NO_FACTURA", unique = true, nullable = false, length = 8)
	private Integer noFactura;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CODIGO", referencedColumnName = "CODIGO" ,nullable=false, insertable=false, updatable=false)
	private Cliente cliente;
	
	@Column(name = "CODIGO")
	private Integer codigo;
	
	
	
	@Column(name = "NUMERO_ORDERN")
	private String numeroOrden;


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "fac", cascade = CascadeType.ALL)
	@OrderBy("codigoDetalle ASC")
	private Set<FacDetalle> facDetalles = new HashSet<FacDetalle>(0);

}
