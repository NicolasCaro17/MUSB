package co.edu.usbbog.musb.musbws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Facultad;
import co.edu.usbbog.musb.musbws.model.Lugar;
import co.edu.usbbog.musb.musbws.repository.ILugarRepository;

@Service
public class LugarService implements ILugarService{
	@Autowired
	ILugarRepository lugRepo;

	@Override
	public String crearLugar(Lugar lugar) {
		try {
			lugRepo.save(lugar);
			return "Se guardo el lugar";
		} catch (IllegalArgumentException e) {
			return "No guardo el lugar" + e.getMessage();
		}
	}

	@Override
	public String modificarLugar(Lugar lugar) {
		try {
            if(lugRepo.existsById(lugar.getId())) {
                lugRepo.delete(lugar);
                lugRepo.save(lugar);
                return "Se modifico el lugar";
            }else {
                return "No se encontro el lugar";
            }
        } catch (IllegalArgumentException e) {
            return "No se encontro el lugar: " + e.getMessage();
        }
	}

	@Override
	public String eliminarLugar(Lugar lugar) {
		try{
			if(lugRepo.existsById(lugar.getId())) {
			lugRepo.delete(lugar);
			return "Se elimino el lugar";
			}else {
				return "No se elimino el lugar";
			}
		}catch(IllegalArgumentException e) {
			return "No se pudo eliminar el lugar: "+ e.getMessage();
		}
	}

	@Override
	public Integer contarLugar() {
		int contador=0;
		try {
			contador = (int) lugRepo.count();
			return contador;
		}catch(IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public List<Lugar> findAll() {
		  List<Lugar> listalug = new ArrayList<Lugar>();
	        try {
	        	listalug = lugRepo.findAll();
	            return listalug;
	        } catch (IllegalArgumentException e) {
	            return listalug;
	        }
	}

	@Override
	public Lugar mostrarLugar(int id) {
		Lugar lugar = new Lugar();
		try {
			lugar = lugRepo.getOne(id);
			return lugar;
		}catch(IllegalArgumentException e) {
		return null;
	}
	}
	
}
