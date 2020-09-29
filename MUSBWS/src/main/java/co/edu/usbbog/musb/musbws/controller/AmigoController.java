package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Amigo;
import co.edu.usbbog.musb.musbws.service.IAmigoService;

@RestController
public class AmigoController {
	@Autowired
	IAmigoService amigoService;
	
	@PostMapping("/crearAmigo")
	public String CrearAmigo(@RequestBody Amigo amigo) {
		return amigoService.crearAmigo(amigo);
		
	}
	
}
