package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.usbbog.musb.musbws.model.TipoActividad;
import co.edu.usbbog.musb.musbws.repository.ITipoActividadRepository;

@Service
public class TipoDeActividadService implements ITipoDeActividadService{
	@Autowired
	ITipoActividadRepository TipoARepo;

	@Override
	public String crearTipoDeActividad(TipoActividad tactividad) {
		try {
			TipoARepo.save(tactividad);
			return "Se agrego el tipo de actividad";
		} catch (IllegalArgumentException e) {
			return "No se agrego el tipo de actividad"+e.getMessage();
		}
	}
	
}
