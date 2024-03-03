package com.medi.med.contoller;

import java.io.IOException;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medi.med.dao.ClienteDao;
import com.medi.med.dao.FacDao;
import com.medi.med.dao.FacDetalleDao;
import com.medi.med.modelo.Cliente;
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

public class FacturaController {

	@Autowired 
	private FacDao facDao;
	@Autowired 
	private FacDetalleDao facDetDao;
	@Autowired 	
	private ClienteDao clientDao;

	private List<Factura> facturas;
	private Factura facturaSeleccionada;
	
	private List<Cliente> clientes;

	@PostConstruct
	public void init() {
		System.out.println("init  ");
		this.cargarFacturas();

	}

	public void cargarFacturas() {
		List<Factura> facInit = this.facDao.findAll();

		System.out.println("Get Facturas ");
		System.out.println(facInit.size());

		facInit.forEach(item -> {
			System.out.println(item.getNoFactura());
		});
		this.facturas = facInit;
	}

	public void guardarFactura() {

		this.facDao.save(this.facturaSeleccionada);
		this.cargarFacturas();    
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("exito"));

		PrimeFaces.current().executeScript("PF('ventanaModalFac').hide()");
		PrimeFaces.current().ajax().update("forma-c:mensajes", "forma-c:tablaFac");

		this.facturaSeleccionada = null;
	}
	
	
	 public void nuevaFactura(){	        
	        this.facturaSeleccionada = new Factura();
	        this.clientes = this.clientDao.findAll();
	    }

	 public void  eliminar() {
		 
		 System.out.println(facturas.size() +  "antes borrar");
		 this.facDao.delete(facturaSeleccionada);		 
		 this.cargarFacturas();
		 System.out.println(facturas.size() +  "despues borrar");		 
		 
		 PrimeFaces.current().ajax().update("forma-c:mensajes", "forma-c:tablaFac");
		 
	 }
	 
	 
	 @Inject
	 private DatosBean datosBean;
	 
	 public void enviarDatos() throws IOException {	
		 
		  FacesContext.getCurrentInstance().getExternalContext().redirect("detalle.xhtml");
		}
	 
}
