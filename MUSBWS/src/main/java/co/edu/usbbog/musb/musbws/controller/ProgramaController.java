package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Programa;
import co.edu.usbbog.musb.musbws.service.IProgramaService;

@RestController
public class ProgramaController {
	
	@Autowired
	private IProgramaService programaService;
	
	@PostMapping("/crearPrograma")
	public String crearRol(@RequestBody Programa newPrograma) {
		return programaService.crearPrograma(newPrograma);		
	}

	
}
