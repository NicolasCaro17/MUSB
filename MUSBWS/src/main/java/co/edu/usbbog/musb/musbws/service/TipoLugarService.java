package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.TipoLugar;
import co.edu.usbbog.musb.musbws.repository.ITipoLugarRepository;


@Service
public class TipoLugarService implements ITipoLugarService {

	
	@Autowired
	private ITipoLugarRepository TlugarRepo;
	@Override
	public String crearTipoLugar(TipoLugar Tlugar) {
		try {
			TlugarRepo.save(Tlugar);
			return "Se guardo el tipo de actividad";
		} catch (IllegalArgumentException e) {
			return "No se guardo el tipo de actividad: " + e.getMessage();
		}

	}

	@Override
	public int contarTipoLugar() {
		try {
			long cantidad=0;
			cantidad=TlugarRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
    public String modificarTipoLugar(TipoLugar Tlugar) {
        try {
        	int busqueda= Tlugar.getId();
            if(TlugarRepo.getOne(busqueda)!=null) {
            	TlugarRepo.delete(Tlugar);
            	TlugarRepo.save(Tlugar);
                return "Se modifico el tipo de actividad";
            }else {
                return "No se modifico el tipo de actividad";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico el tipo de actividad: " + e.getMessage();
        }
    }

	@Override
	public List<TipoLugar> findAll() {
		try {
			List<TipoLugar> encontrado=TlugarRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarTipoLugar(TipoLugar Tlugar) {
		try {
			if(TlugarRepo.getOne(Tlugar.getId())!=null) {
				TlugarRepo.delete(Tlugar);
				return "Se elimino el tipo de actividad";
			}else {
			return "No Se elimino el tipo de actividad";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino el tipo de actividad: " + e.getMessage();
		}
	}

	@Override
	public TipoLugar mostrarTipoLugar(int id) {
		TipoLugar Tlugar= new TipoLugar();
		try {
			if(TlugarRepo.getOne(id)!=null) {
				Tlugar=TlugarRepo.getOne(id);
				return Tlugar;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
