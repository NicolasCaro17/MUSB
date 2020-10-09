package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Sede;
import co.edu.usbbog.musb.musbws.repository.ISedeRepository;
@Service
public class SedeService implements ISedeService{
	@Autowired
	private ISedeRepository sedeRepo;
	
	@Override
	public String crearSede(Sede sede) {
		try {
			sedeRepo.save(sede);
			return "Se guardo la sede";
		} catch (IllegalArgumentException e) {
			return "No se guardo la sede"+e.getMessage();
		}
	}

	@Override
	public String modificarSede(Sede sede) {
		try {
			if (mostrarSede(sede.getId())!= null) {
				sedeRepo.delete(sede);
				sedeRepo.save(sede);
				return "Se modifico la Sede";
			}else {
				return "No se pudo modificar la Sede";
				
			}
		}catch(IllegalArgumentException e) {
			return "No se pudo modificar la sede" + e.getMessage();
		}
	}

	@Override
	public String eliminarSede(Sede sede) {
		try{
			if(sede.getId()!= null) {
			sedeRepo.delete(sede);
			return "Se elimino la sede";
			}else {
				return "No se elimino la sede";
			}
		}catch(IllegalArgumentException e) {
			return "No se pudo eliminar la sede: "+ e.getMessage();
		}
	}

	@Override
	public Integer contarSede() {
		int contador=0;
		try {
			contador = (int) sedeRepo.count();
			return contador;
		}catch(IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public List<Sede> findBySede(String sede) {
		try {
			List<Sede> listaSede =sedeRepo.findAll();
			return listaSede;
		}catch(IllegalArgumentException e) {
			return null;
		}
		
	}
	
	@Override
	public Sede mostrarSede(int id) {
		Sede sede = new Sede();
		try {
			sede = sedeRepo.getOne(id);
			return sede;
		}catch(IllegalArgumentException e) {
		return null;
	}
	}
	
}
