package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Evento;
import co.edu.usbbog.musb.musbws.repository.IEventoRepository;

@Service
public class EventoService implements IEventoService{
	
	@Autowired
	IEventoRepository EvenRepo;

	@Override
	public String crearEvento(Evento evento) {
		try {
			EvenRepo.save(evento);
			return "Se guardo el evento";
		} catch (IllegalArgumentException e) {
			return "Se guardo el evento"+ e.getMessage();
		}
	}

}
