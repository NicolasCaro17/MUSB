package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Facultad;
import co.edu.usbbog.musb.musbws.service.IFacultadService;

@RestController
public class FacultadController {
	@Autowired
	IFacultadService facultadService;
	@PostMapping("/crearFacultad")
	public String crearFacultad(@RequestBody Facultad facultad) {
		return facultadService.crearFacultad(facultad);
	}
}
