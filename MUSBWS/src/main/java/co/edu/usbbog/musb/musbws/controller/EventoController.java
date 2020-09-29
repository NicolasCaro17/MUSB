package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Evento;
import co.edu.usbbog.musb.musbws.service.IEventoService;

@RestController
public class EventoController {
	@Autowired
	IEventoService eventoService;
	@PostMapping("/crearEvento")
	public String crearEvento(@RequestBody Evento evento) {
		return eventoService.crearEvento(evento);
		
	}
}
