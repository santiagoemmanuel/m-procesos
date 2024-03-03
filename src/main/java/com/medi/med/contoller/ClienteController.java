package com.medi.med.contoller;

import java.util.List;


import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medi.med.dao.ClienteDao;
import com.medi.med.modelo.Cliente;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ViewScoped

public class ClienteController {
		

	private List<Cliente> clientes;	
	private Cliente clienteSeleccionado;
	
	@Autowired
	private ClienteDao clientDao;

	@PostConstruct
	public void init() {
		System.out.println("init  controller cliente ");
		this.cargarDatos();

	}

	public void cargarDatos() {			 			
		this.clientes = this.clientDao.findAll();
	}

	public void guardar() { 
		System.out.println("Guardando nuevo Cli");
		this.clientDao.save(this.clienteSeleccionado);
		this.cargarDatos();    
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("exito"));

		PrimeFaces.current().executeScript("PF('modalClienteW').hide()");
		PrimeFaces.current().ajax().update("form-cliente:mensajes", "form-cliente:tablaClienteId");

		this.clienteSeleccionado = null;
	}
	
	
	 public void nuevo(){	 
		 System.out.println("Iniciando nuevo client");
	        this.clienteSeleccionado = new Cliente();
	    }

	 public void  eliminar() {
		 
		 
		 this.clientDao.delete(clienteSeleccionado);		 
		 this.cargarDatos();		 		 
		 
		 PrimeFaces.current().ajax().update("form-cliente:mensajes", "form-cliente:tablaClienteId");
		 
	 }
	 
}
