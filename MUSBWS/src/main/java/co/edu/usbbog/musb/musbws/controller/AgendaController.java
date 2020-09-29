package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Agenda;
import co.edu.usbbog.musb.musbws.service.IAgendaService;

@RestController
public class AgendaController {
	@Autowired
	IAgendaService agendaService;
	
	@PostMapping("/crearAgenda")
	public String CrearAgenda(@RequestBody Agenda newAgenda) {
		return agendaService.crearAgenda(newAgenda);
		
	}
}
