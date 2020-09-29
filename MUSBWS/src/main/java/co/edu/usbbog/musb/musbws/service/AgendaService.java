package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Agenda;
import co.edu.usbbog.musb.musbws.repository.IAgendaRepository;

@Service
public class AgendaService implements IAgendaService{
	
	@Autowired
	IAgendaRepository AgRepo;

	@Override
	public String crearAgenda(Agenda agenda) {
		try {
			AgRepo.save(agenda);
			return "Se guardo la Agenda";
		} catch (IllegalArgumentException e) {
			return "No se guardo la Agenda"+ e.getMessage();
		}
	}

}
