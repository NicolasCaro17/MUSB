package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Programa;
import co.edu.usbbog.musb.musbws.repository.IProgramaRepository;


@Service
public class ProgramaService implements IProgramaService{
	
	@Autowired
	private IProgramaRepository rolRepo;

	@Override
	public String crearPrograma(Programa programa) {
		try {
			rolRepo.save(programa);
			return "Se guardo el programa";
		} catch (IllegalArgumentException e) {
			return "No se guardo el programa: " + e.getMessage();
		}

	}
}
