package co.edu.usbbog.musb.musbws.service;

import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Sede;
import co.edu.usbbog.musb.musbws.repository.ISedeRepository;
@Service
public class SedeService implements ISedeService{
	
	ISedeRepository SedeRepo;
	
	@Override
	public String crearSede(Sede sede) {
		try {
			SedeRepo.save(sede);
			return "Se guardo la sede";
		} catch (IllegalArgumentException e) {
			return "No se guardo la sede"+e.getMessage();
		}
	}
	
}
