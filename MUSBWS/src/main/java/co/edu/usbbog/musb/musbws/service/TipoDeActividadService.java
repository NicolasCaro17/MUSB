package co.edu.usbbog.musb.musbws.service;

import java.util.List;

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

	@Override
	public int contarTipoDeActividad() {
		try {
			long cantidad=0;
			cantidad=TipoARepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarTipoActividad(TipoActividad tactividad) {
	      try {
	            if(TipoARepo.existsById(tactividad.getId())) {
	            	TipoARepo.delete(tactividad);
	            	TipoARepo.save(tactividad);
	                return "Se modifico el tipo de actividad";
	            }else {
	                return "No se encontro el tipo de actividad";
	            }
	        } catch (IllegalArgumentException e) {
	            return "No se encontro el tipo de actividad: " + e.getMessage();
	        }
	}

	@Override
	public List<TipoActividad> findAll() {
		try {
			List<TipoActividad> encontrado=TipoARepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarTipoActividad(TipoActividad tactividad) {
	    try {
            if (TipoARepo.existsById(tactividad.getId())) {
            	TipoARepo.delete(tactividad);
            return "Se elimino el tipo de actividad";
            }else {
                return "el tipo de actividad no existe";
            }
        } catch (IllegalArgumentException e) {
            return "No se elimino el tipo de actividad: " + e.getMessage();
        }
	}

	@Override
	public TipoActividad mostrarTipoActividad(int id) {
		TipoActividad tipo= new TipoActividad();
		try {
			if(TipoARepo.existsById(id)) {
				tipo=TipoARepo.getOne(id);
				return tipo;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
}
