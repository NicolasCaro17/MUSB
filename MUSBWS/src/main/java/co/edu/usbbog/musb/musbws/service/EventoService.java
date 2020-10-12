package co.edu.usbbog.musb.musbws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Evento;
import co.edu.usbbog.musb.musbws.model.Evento;
import co.edu.usbbog.musb.musbws.repository.IEventoRepository;

@Service
public class EventoService implements IEventoService{
	
	@Autowired
	IEventoRepository evenRepo;

	@Override
	public String crearEvento(Evento evento) {
		try {
			evenRepo.save(evento);
			return "Se guardo el evento";
		} catch (IllegalArgumentException e) {
			return "Se guardo el evento"+ e.getMessage();
		}
		
	}

	@Override
	public String modificarEvento(Evento evento) {
		try {
            if(evenRepo.existsById(evento.getId())) {
                evenRepo.delete(evento);
                evenRepo.save(evento);
                return "Se modifico el evento";
            }else {
                return "No se encontro el evento";
            }
        } catch (IllegalArgumentException e) {
            return "No se encontro el evento: " + e.getMessage();
        }
	}

	@Override
	public String eliminarEvento(Evento evento) {
		try{
			if(evenRepo.existsById(evento.getId())) {
			evenRepo.delete(evento);
			return "Se elimino el evento";
			}else {
				return "No se elimino el evento";
			}
		}catch(IllegalArgumentException e) {
			return "No se pudo eliminar el evento: "+ e.getMessage();
		}
	}

	@Override
	public Integer contarEvento() {
		int contador=0;
		try {
			contador = (int) evenRepo.count();
			return contador;
		}catch(IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public List<Evento> findAll() {
		  List<Evento> listaEven = new ArrayList<Evento>();
	        try {
	        	listaEven = evenRepo.findAll();
	            return listaEven;
	        } catch (IllegalArgumentException e) {
	            return listaEven;
	        }
	}

	@Override
	public Evento mostrarEvento(int id) {
		Evento evento = new Evento();
		try {
			evento = evenRepo.getOne(id);
			return evento;
		}catch(IllegalArgumentException e) {
		return null;
	}
	}
	

}
