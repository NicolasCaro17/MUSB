package co.edu.usbbog.musb.musbws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Facultad;
import co.edu.usbbog.musb.musbws.model.Sede;
import co.edu.usbbog.musb.musbws.repository.IFacultadRepository;

@Service
public class FacultadService implements IFacultadService{
	
	@Autowired
	IFacultadRepository facRepo;

	@Override
	public String crearFacultad(Facultad facultad) {
		try {
			facRepo.save(facultad);
			return "Se guardo la facultad";
		} catch (IllegalArgumentException e) {
			return "No se guardo la facultad" + e.getMessage(); 
		}
	}

	@Override
	public String modificarFacultad(Facultad facultad) {
		 try {
	            if(facRepo.existsById(facultad.getId())) {
	                facRepo.delete(facultad);
	                facRepo.save(facultad);
	                return "Se modifico la facultad";
	            }else {
	                return "No se encontro la facultad";
	            }
	        } catch (IllegalArgumentException e) {
	            return "No se encontro la facultad: " + e.getMessage();
	        }
	}

	@Override
	public String eliminarFacultad(Facultad facultad) {
		try{
			if(facRepo.existsById(facultad.getId())) {
			facRepo.delete(facultad);
			return "Se elimino la facultad";
			}else {
				return "No se elimino la facultad";
			}
		}catch(IllegalArgumentException e) {
			return "No se pudo eliminar la facultad: "+ e.getMessage();
		}
	}

	@Override
	public Integer contarFacultad() {
		int contador=0;
		try {
			contador = (int) facRepo.count();
			return contador;
		}catch(IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public List<Facultad> findAll() {
		  List<Facultad> listaFac = new ArrayList<Facultad>();
	        try {
	        	listaFac = facRepo.findAll();
	            return listaFac;
	        } catch (IllegalArgumentException e) {
	            return listaFac;
	        }
	}

	@Override
	public Facultad mostrarFacultad(int id) {
		Facultad facultad = new Facultad();
		try {
			facultad = facRepo.getOne(id);
			return facultad;
		}catch(IllegalArgumentException e) {
		return null;
	}
	}

}
