package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usbbog.musb.musbws.model.Actividad;
import co.edu.usbbog.musb.musbws.repository.IActividadRepository;

@Service
public class AcitividadService implements IActividadService{
	
	@Autowired
	private IActividadRepository ActRepo;

	@Override
	public String crearActividad(Actividad actividad) {
		try {
			ActRepo.save(actividad);
			return "Se guardo la actividad";
		} catch (IllegalArgumentException e) {
			return "No se guardo la actividad: " + e.getMessage();
		}
	}
	
	
}
