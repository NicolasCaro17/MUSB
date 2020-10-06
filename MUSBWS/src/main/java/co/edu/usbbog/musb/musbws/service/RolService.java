package co.edu.usbbog.musb.musbws.service;

import java.util.ArrayList;
import java.util.Iterator;
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
        	int busqueda= rol.getId();
            if(rolRepo.getOne(busqueda)!=null) {
                rolRepo.delete(rol);
                rolRepo.save(rol);
                return "Se modifico el rol";
            }else {
                return "No se modifico el rol";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico el rol: " + e.getMessage();
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
			if(rolRepo.getOne(rol.getId())!=null) {
				rolRepo.delete(rol);
				return "Se elimino el rol";
			}else {
			return "No Se elimino el rol";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino el rol: " + e.getMessage();
		}
	}

	@Override
	public Rol mostrarRol(int id) {
		Rol rol= new Rol();
		try {
			if(rolRepo.getOne(id)!=null) {
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
