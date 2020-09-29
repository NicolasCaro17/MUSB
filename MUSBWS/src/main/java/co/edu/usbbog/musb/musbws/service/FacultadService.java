package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Facultad;
import co.edu.usbbog.musb.musbws.repository.IFacultadRepository;

@Service
public class FacultadService implements IFacultadService{
	
	@Autowired
	IFacultadRepository FacRepo;

	@Override
	public String crearFacultad(Facultad facultad) {
		try {
			FacRepo.save(facultad);
			return "Se guardo la facultad";
		} catch (IllegalArgumentException e) {
			return "No se guardo la facultad" + e.getMessage(); 
		}
	}

}
