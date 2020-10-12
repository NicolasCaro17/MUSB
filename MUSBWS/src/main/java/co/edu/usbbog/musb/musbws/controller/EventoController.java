package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Evento;
import co.edu.usbbog.musb.musbws.service.IEventoService;

@RestController
public class EventoController {
	@Autowired
	IEventoService eventoService;

	@PostMapping("/crearEvento")
	public String crearFacultad(@RequestBody Evento evento) {
		JSONObject respuesta = new JSONObject();
		if (eventoService.crearEvento(evento).equals("Se guardo el evento")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	@PostMapping("/eliminarEvento")
	public String eliminarEvento(@RequestBody Evento borrarEvento) {
		JSONObject respuesta = new JSONObject();
		if (eventoService.eliminarEvento(borrarEvento).equals("Se elimino el evento")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	@PostMapping("/mostrarEvento")
	public String buscarEvento(@RequestBody Evento evento) {
		JSONArray array = new JSONArray();
		Evento eventos = eventoService.mostrarEvento(evento.getId());
		if (eventos != null) {
			JSONObject eventoJson = new JSONObject();
			eventoJson.put("id", eventos.getId());
			eventoJson.put("descripcion", eventos.getDescripcion());
			eventoJson.put("fechaInicio", eventos.getFechaInicio());
			eventoJson.put("fechaFin", eventos.getFechaFin());
			//eventoJson.put("lugar", eventos.getLugar());
			//eventoJson.put("actividad", eventos.getActividad());

			array.put(eventoJson);
			return array.toString();
		} else {
			return "No se encontro";
		}

	}
	
	@PostMapping("/modificarEvento")
	public String modificarEvento(@RequestBody Evento evento) {
		JSONObject respuesta = new JSONObject();
		if (eventoService.modificarEvento(evento).equals("Se modifico el evento")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	@PostMapping("/contarEvento")
	public String contarEvento() {
		JSONObject respuesta = new JSONObject();
		int aux = eventoService.contarEvento();
		respuesta.put("Count", aux);
		return respuesta.toString();
	}
	
	@PostMapping("/allEvento")
	public String getEvento() {
		JSONArray array = new JSONArray();
		List<Evento> facultades = eventoService.findAll();
		for (int i = 0; i < facultades.size(); i++) {
			JSONObject facultadJson = new JSONObject();
			facultadJson.put("id", facultades.get(i).getId());
			facultadJson.put("descripcion", facultades.get(i).getDescripcion());
			facultadJson.put("fechaInicio", facultades.get(i).getFechaInicio());
			facultadJson.put("fechaFin", facultades.get(i).getFechaFin());
			//eventoJson.put("lugar", eventos.get(i).getLugar());
			//eventoJson.put("actividad", eventos.get(i).getActividad());
			array.put(facultadJson);
		}
		return array.toString();
	}


	
	
	
	
}
