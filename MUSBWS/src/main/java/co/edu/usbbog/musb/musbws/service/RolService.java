package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Rol;
import co.edu.usbbog.musb.musbws.repository.IRolRepository;

@Service
public class RolService implements IRolService {
	
	@Autowired
	private IRolRepository rolRepo;

	@Override
	public String crearRol(Rol rol) {
		try {
			rolRepo.save(rol);
			return "Se guardo el rol";
		} catch (IllegalArgumentException e) {
			return "No se guardo el rol: " + e.getMessage();
		}

	}

	@Override
	public int contarRol() {
		try {
			long cantidad=0;
			cantidad=rolRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}
	
	@Override
    public String modificarRol(Rol rol) {
        try {
            if(rolRepo.existsById(rol.getId())) {
                rolRepo.delete(rol);
                rolRepo.save(rol);
                return "Se modifico el rol";
            }else {
                return "No se encontro el rol";
            }
        } catch (IllegalArgumentException e) {
            return "No se encontro el rol: " + e.getMessage();
        }
    }

	@Override
	public List<Rol> findAll() {
		try {
			List<Rol> encontrado=rolRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
    public String eliminarRol(Rol rol) {
        try {
            if (rolRepo.existsById(rol.getId())) {
            rolRepo.delete(rol);
            return "Se elimino el rol";
            }else {
                return "El rol no existe";
            }
        } catch (IllegalArgumentException e) {
            return "No se elimino el rol: " + e.getMessage();
        }
    }

	@Override
	public Rol mostrarRol(int id) {
		Rol rol= new Rol();
		try {
			if(rolRepo.existsById(id)) {
				rol=rolRepo.getOne(id);
				return rol;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	

}
