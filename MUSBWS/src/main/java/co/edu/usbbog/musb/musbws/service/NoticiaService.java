package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Noticia;
import co.edu.usbbog.musb.musbws.repository.INoticiaRepository;

@Service
public class NoticiaService implements INoticiaService {
	@Autowired
	INoticiaRepository NotiRepo;

	@Override
	public String crearNoticia(Noticia noticia) {
		try {
			NotiRepo.save(noticia);
			return "Se agrego la noticia";
		} catch (IllegalArgumentException e) {
			return "No Se agrego la noticia" + e.getMessage();
		}

	}

	@Override
	public int contarNoticia() {
		try {
			long cantidad = 0;
			cantidad = NotiRepo.count();
			Integer i = (int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarNoticia(Noticia noticia) {
		try {
			if (NotiRepo.existsById(noticia.getId())) {
				NotiRepo.delete(noticia);
				NotiRepo.save(noticia);
				return "Se modifico noticia";
			} else {
				return "No se encontro noticia";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro noticia: " + e.getMessage();
		}
	}

	@Override
	public List<Noticia> findAll() {
		try {
			List<Noticia> encontrado = NotiRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarNoticia(Noticia noticia) {
		try {
			if (NotiRepo.existsById(noticia.getId())) {
				NotiRepo.delete(noticia);
				return "Se elimino noticia";
			} else {
				return "La noticia existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino noticia: " + e.getMessage();
		}
	}

	@Override
	public Noticia mostrarNoticia(int id) {
		Noticia noticia = new Noticia();
		try {
			if (NotiRepo.existsById(id)) {
				noticia = NotiRepo.getOne(id);
				return noticia;
			} else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	//@Override
	//public List<Noticia> getNotificaciones(Usuario user) {
	//	List<Noticia> NoticiaSinVer= NotiRepo.findByEstadoAndRecibe("enviado", user);
	//	return NoticiaSinVer;
	//}

}
