package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Programa;
import co.edu.usbbog.musb.musbws.repository.IProgramaRepository;



@Service
public class ProgramaService implements IProgramaService{
	
	
	@Autowired
	private IProgramaRepository programaRepo;
	@Override
	public String crearPrograma(Programa programa) {
		try {
			programaRepo.save(programa);
			return "Se guardo el programa";
		} catch (IllegalArgumentException e) {
			return "No se guardo el programa: " + e.getMessage();
		}

	}

	@Override
	public int contarPrograma() {
		try {
			long cantidad=0;
			cantidad=programaRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
    public String modificarPrograma(Programa programa) {
        try {
        	int busqueda= programa.getId();
            if(programaRepo.getOne(busqueda)!=null) {
            	programaRepo.delete(programa);
            	programaRepo.save(programa);
                return "Se modifico el programa";
            }else {
                return "No se modifico el programa";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico el programa: " + e.getMessage();
        }
    }

	@Override
	public List<Programa> findAll() {
		try {
			List<Programa> encontrado=programaRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarPrograma(Programa programa) {
		try {
			if(programaRepo.getOne(programa.getId())!=null) {
				programaRepo.delete(programa);
				return "Se elimino el programa";
			}else {
			return "No Se elimino el programa";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino el programa: " + e.getMessage();
		}
	}

	@Override
	public Programa mostrarPrograma(int id) {
		Programa Tlugar= new Programa();
		try {
			if(programaRepo.getOne(id)!=null) {
				Tlugar=programaRepo.getOne(id);
				return Tlugar;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}


