package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usbbog.musb.musbws.model.Actividad;
import co.edu.usbbog.musb.musbws.repository.IActividadRepository;


@Service
public class AcitividadService implements IActividadService{
	
	@Autowired
	private IActividadRepository activRepo;
	@Override
	public String crearActividad(Actividad actividad) {
		try {
			activRepo.save(actividad);
			return "Se guardo la actividad";
		} catch (IllegalArgumentException e) {
			return "No se guardo la actividad: " + e.getMessage();
		}

	}

	@Override
	public int contarActividad() {
		try {
			long cantidad=0;
			cantidad=activRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
    public String modificarActividad(Actividad actividad) {
        try {
        	int busqueda= actividad.getId();
            if(activRepo.getOne(busqueda)!=null) {
            	activRepo.delete(actividad);
            	activRepo.save(actividad);
                return "Se modifico la actividad";
            }else {
                return "No se modifico la actividad";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico la actividad: " + e.getMessage();
        }
    }

	@Override
	public List<Actividad> findAll() {
		try {
			List<Actividad> encontrado=activRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarActividad(Actividad actividad) {
		try {
			if(activRepo.getOne(actividad.getId())!=null) {
				activRepo.delete(actividad);
				return "Se elimino la actividad";
			}else {
			return "No Se elimino la actividad";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino la actividad: " + e.getMessage();
		}
	}

	@Override
	public Actividad mostrarActividad(int id) {
		Actividad actividad= new Actividad();
		try {
			if(activRepo.getOne(id)!=null) {
				actividad=activRepo.getOne(id);
				return actividad;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}