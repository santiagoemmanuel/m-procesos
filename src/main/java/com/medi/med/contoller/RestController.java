package com.medi.med.contoller;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.medi.med.dao.FacDao;
import com.medi.med.dao.FacDetalleDao;
import com.medi.med.modelo.Factura;
import com.medi.med.modelo.FacDetalle;


//http://localhost:8091/med/swagger-ui/index.html 


@CrossOrigin(origins = { "*" })
@RequestMapping("/ws")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired FacDao facDao;
	@Autowired FacDetalleDao facDetDao;
	

	
	// abajo Rest metodos  para acceso http 
	
	@GetMapping("/test") // //http://localhost:8091/med/ws/test
	String sayHello() {
		return "hello";
	}
	
	@GetMapping("/facturas") //http://localhost:8091/med/ws/facturas
	List<Factura> facturas() {		
		System.out.println("Rest controler get all items");
		return this.facDao.findAll(); 
	}

	@GetMapping("/factura/{noFactura}") //http://localhost:8091/med/ws/factura/1
	Factura facturas(@PathVariable Integer noFactura) {
		Optional<Factura> opt = this.facDao.findById(noFactura);		
		return opt.isPresent()?opt.get():null;
	}	
	
	@PostMapping("/factura") //http://localhost:8091/med/ws/factura
	Factura facturas(@RequestBody Factura fac) {		
		return this.facDao.save(fac);
	}
	
	
	
	
	/*Detalle */
	
	
	//http://localhost:8091/med/ws/detalles
	@GetMapping("/detalles")
	List<FacDetalle> facturasDetalle() {	
		return this.facDetDao.findAll();
	}
	
	//http://localhost:8091/med/ws/facturasDetalle/1
	/*
	@GetMapping("/detallesByFactura/{noFactura}")
	List<FacDetalle> facturasDetalleByFactura(@PathVariable Integer noFactura) {		
		return this.facDetDao.findFacNoFactura(noFactura);
	} */
	
	
	@PostMapping("/detalle") //http://localhost:8091/med/ws/facturaDetalle
	FacDetalle facturas(@RequestBody FacDetalle detalle) {		
		return this.facDetDao.save(detalle);
	}
	
	
	
}
