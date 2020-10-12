package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
		JSONObject respuesta = new JSONObject();
		if (noticiaService.crearNoticia(noticia).equals("Se guardo noticia")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	@PostMapping("/contarNoticia")
	public String contarNoticia() {
		JSONObject respuesta = new JSONObject();
		int aux = noticiaService.contarNoticia();
		respuesta.put("Count", aux);
		return respuesta.toString();

	}
	
	@PostMapping("/eliminarNoticia")
	public String eliminarNoticia(@RequestBody Noticia noticia) {
		JSONObject respuesta = new JSONObject();
		if (noticiaService.eliminarNoticia(noticia).equals("Se elimino noticia")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}
	
	@PostMapping("/getNoticias")
	public String getNoticia() {
		JSONArray array = new JSONArray();
		List<Noticia> noticia = noticiaService.findAll();
		for (int i = 0; i < noticia.size(); i++) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", noticia.get(i).getId());
			rolJson.put("nombre", noticia.get(i).getNombre());
			rolJson.put("fecha", noticia.get(i).getFecha());
			rolJson.put("Descripccion", noticia.get(i).getDescripcion());
			rolJson.put("Foto", noticia.get(i).getFoto());
			rolJson.put("Facultad", noticia.get(i).getFacultad());
			rolJson.put("programa", noticia.get(i).getPrograma());
			rolJson.put("sede", noticia.get(i).getSede());
			array.put(rolJson);

		}
		return array.toString();

	}
	
	@PostMapping("/mostrarNoticia")
	public String buscarNoticia(@RequestBody Noticia noticia) {
		JSONArray array = new JSONArray();
		Noticia noticias = noticiaService.mostrarNoticia(noticia.getId());
		if (noticias != null) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", noticias.getId());
			rolJson.put("nombre", noticias.getNombre());
			rolJson.put("fecha", noticia.getFecha());
			rolJson.put("Descripccion", noticia.getDescripcion());
			rolJson.put("Foto", noticia.getFoto());
			rolJson.put("Facultad", noticia.getFacultad());
			rolJson.put("programa", noticia.getPrograma());
			rolJson.put("sede", noticia.getSede());
			array.put(rolJson);
			return array.toString();
		} else {
			return "No se encontro";
		}

	}

	@PostMapping("/modificarNoticia")
	public String modificarNoticia(@RequestBody Noticia noticia) {
		JSONObject respuesta = new JSONObject();
		if (noticiaService.modificarNoticia(noticia).equals("Se modifico Noticia")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}	
}
