package com.medi.med.contollerRest;

import java.util.List;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medi.med.dao.ClienteDao;
import com.medi.med.modelo.Cliente;




//http://localhost:8091/med/swagger-ui/index.html 


@CrossOrigin(origins = { "*" })
@RequestMapping("/ws")
@org.springframework.web.bind.annotation.RestController
public class RestClienteController {

	@Autowired 
	ClienteDao  ClientDao;
	
	

	
	// abajo Rest metodos  para acceso http 
	
	@GetMapping("/test") // //http://localhost:8091/med/ws/test
	String sayHello() {
		return "hello";
	}
	
	//http://localhost:8091/med/ws/clientes
	@GetMapping("/clientes") 
	List<Cliente> clientes() {			
		return this.ClientDao.findAll(); 
	}

	//http://localhost:8091/med/ws/factura/1
	@GetMapping("/cliente/{codigo}") 
	Cliente cliente(@PathVariable Integer codigo) {
		Optional<Cliente> opt = this.ClientDao.findById(codigo);		
		return opt.isPresent()?opt.get():null;
	}	
	
	@PostMapping("/cliente") //http://localhost:8091/med/ws/factura
	Cliente Cliente(@RequestBody Cliente cliente) {		
		return this.ClientDao.save(cliente);
	}		
	
	@DeleteMapping("/cliente/{codigo}") 
	void Cliente(@PathVariable Integer codigo) {		
		this.ClientDao.deleteById(codigo);
	}
		
}
