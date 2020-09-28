package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Amigo;
import co.edu.usbbog.musb.musbws.repository.IAmigoRepository;

@Service
public class AmigoService implements IAmigoService{

	@Autowired
	private IAmigoRepository AmgRepo;
	
	@Override
	public String crearAmigo(Amigo amigo) {
		try {
			AmgRepo.save(amigo);
			return "Se guardo al amigo";
		} catch (IllegalArgumentException e) {
			return "No se guardo al amigo"+ e.getMessage();
		}
	}

}
