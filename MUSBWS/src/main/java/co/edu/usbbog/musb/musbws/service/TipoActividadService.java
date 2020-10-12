package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.TipoActividad;

import co.edu.usbbog.musb.musbws.repository.ITipoActividadRepository;


@Service
public class TipoActividadService implements ITipoDeActividadService {

	
	@Autowired
	private ITipoActividadRepository TactividadRepo;
	
	@Override
	public String crearTipoActividad(TipoActividad Tactividad) {
		try {
			TactividadRepo.save(Tactividad);
			return "Se guardo el tipo de actividad";
		} catch (IllegalArgumentException e) {
			return "No se guardo el tipo deactividad: " + e.getMessage();
		}

	}

	@Override
	public int contarTipoActividad() {
		try {
			long cantidad=0;
			cantidad=TactividadRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
    public String modificarTipoActividad(TipoActividad Tactividad) {
        try {
        	int busqueda= Tactividad.getId();
            if(TactividadRepo.getOne(busqueda)!=null) {
            	TactividadRepo.delete(Tactividad);
            	TactividadRepo.save(Tactividad);
                return "Se modifico el tipo de actividad";
            }else {
                return "No se modifico el tipo de actividad";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico el tipo de actividad: " + e.getMessage();
        }
    }

	@Override
	public List<TipoActividad> findAll() {
		try {
			List<TipoActividad> encontrado=TactividadRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarTipoActividad(TipoActividad Tactividad) {
		try {
			if(TactividadRepo.getOne(Tactividad.getId())!=null) {
				TactividadRepo.delete(Tactividad);
				return "Se elimino el tipo de actividad";
			}else {
			return "No Se elimino el tipo de actividad";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino el tipo de actividad: " + e.getMessage();
		}
	}

	@Override
	public TipoActividad mostrarTipoActividad(int id) {
		TipoActividad Tactividad= new TipoActividad();
		try {
			if(TactividadRepo.getOne(id)!=null) {
				Tactividad=TactividadRepo.getOne(id);
				return Tactividad;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	}
