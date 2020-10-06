package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Sede;
import co.edu.usbbog.musb.musbws.service.ISedeService;

@RestController
public class SedeController {
	@Autowired
	ISedeService sedeService;
	
	@PostMapping("/crearSede")
	public String crearSede(@RequestBody Sede sede) {
		return sedeService.crearSede(sede);		
	}
	
	@PostMapping("/eliminarSede")
	public String eliminarSede(@RequestBody Sede sede) {
		return sedeService.eliminarSede(sede);
	}
	
	
	
	
}
