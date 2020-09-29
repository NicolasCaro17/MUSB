package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Noticia;
import co.edu.usbbog.musb.musbws.repository.INoticiaRepository;

@Service
public class NoticiaService implements INoticiaService{
	@Autowired
	INoticiaRepository NotiRepo;

	@Override
	public String crearNoticia(Noticia noticia) {
		try {
			NotiRepo.save(noticia);
			return " Se agrego la noticia";
		} catch (IllegalArgumentException e) {
			return " Se agrego la noticia"+e.getMessage();
		}
		
	}
	
}
