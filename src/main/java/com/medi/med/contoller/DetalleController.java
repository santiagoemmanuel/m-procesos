package com.medi.med.contoller;

import java.util.List;
import java.util.Optional;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medi.med.dao.FacDao;
import com.medi.med.dao.FacDetalleDao;
import com.medi.med.modelo.FacDetalle;
import com.medi.med.modelo.Factura;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ViewScoped

public class DetalleController {

	@Autowired
	FacDao facDao;
	
	@Autowired
	FacDetalleDao facDetDao;
	
	 @Inject
	 private DatosBean datosBean;

	private Factura factura;
	private FacDetalle detalleNuevo;
	//private List<FacDetalle> detalles;
	

	@PostConstruct
	public void init() {
		System.out.println("init detalle  ");
		Integer noFactura = this.datosBean.getNoFactura();  
		
		//detalles = this.facDetDao.findByIdNoFactura(1);
		this.cargarFactura(noFactura);
		
		System.out.println(noFactura + "-fin init detalle  ");
				
		
	}

	public void cargarFactura(Integer noFactura) {		
		
		Optional<Factura> opt = facDao.findById(noFactura);
		System.out.println( " present II");
		System.out.println(opt.isPresent() );
		System.out.println( " present F");
		this.factura = opt.isPresent()?opt.get():null;
	}

	public void guardarDetalle() {

		this.detalleNuevo.setNoFactura(this.datosBean.getNoFactura());
		this.facDetDao.save(this.detalleNuevo);
		this.cargarFactura(this.datosBean.getNoFactura());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("exito"));
		
		
		PrimeFaces.current().executeScript("PF('modalClienteW').hide()");
		PrimeFaces.current().ajax().update("form-cliente:mensajes", "form-cliente:tablaClienteId");

		this.detalleNuevo = null;
	}
	
	
	 public void nuevoDetalle(){
		 	
	        this.detalleNuevo = new FacDetalle();
	    }

	 public void  eliminar() {		 
		 
		 this.facDetDao.delete(detalleNuevo);		 
		 this.init();		 		 
		 
		 PrimeFaces.current().ajax().update("form-cliente:mensajes", "form-cliente:tablaClienteId");
		 
	 }
	 
	
	
	 
}
