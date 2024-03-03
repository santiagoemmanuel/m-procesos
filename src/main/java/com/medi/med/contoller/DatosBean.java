package com.medi.med.contoller;

import org.springframework.stereotype.Component;


import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;
import lombok.Setter;

@Component
@SessionScoped
@Getter
@Setter
public class DatosBean {
	
	private Integer noFactura;

}
