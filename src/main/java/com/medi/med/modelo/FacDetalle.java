package com.medi.med.modelo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="FAC_DETALLE")
@Getter
@Setter
@NoArgsConstructor
public class FacDetalle {
	

    
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "CODIGO_DETALLE", unique = true, nullable = false, length = 8)	
	private Integer codigoDetalle;
	
	
	@Column(name="NOMBRE_PRODUCTO", length = 20)
	private String nombreProducto;
	
	
	@Column(name="PRECIIO_UNITARIO", precision=22, scale=5)
    private BigDecimal precioUnitario;
	
	@Column(name="CANTDAD", precision=22, scale=5)
    private BigDecimal cantidad;
	
	
	@JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="NO_FACTURA", nullable=false, insertable=false, updatable=false)
    private Factura fac;
	
	@Column(name = "NO_FACTURA")
	private Integer noFactura;
	
	
}
