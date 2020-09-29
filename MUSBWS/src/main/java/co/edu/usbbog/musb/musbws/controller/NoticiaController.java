package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Noticia;
import co.edu.usbbog.musb.musbws.service.INoticiaService;

@RestController
public class NoticiaController {
	@Autowired
	INoticiaService noticiaService;
	@PostMapping("/crearNoticia")
	public String crearNoticia(@RequestBody Noticia noticia) {
		return noticiaService.crearNoticia(noticia);
	}
		
}
