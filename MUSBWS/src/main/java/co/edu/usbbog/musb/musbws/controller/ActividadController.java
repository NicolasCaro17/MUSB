package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Actividad;
import co.edu.usbbog.musb.musbws.service.IActividadService;


@RestController
public class ActividadController {

	
	
	@Autowired
	private IActividadService activService;

	@PostMapping("/crearActividad")
	public String crearActividad(@RequestBody Actividad newActiv) {
		
		JSONObject respuesta= new JSONObject();
		if(activService.crearActividad(newActiv).equals("Se guardo la actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}
	
	@PostMapping("/contarActividad")
	public String contarActividad() {
		JSONObject respuesta= new JSONObject();
			int aux=activService.contarActividad();
			respuesta.put("Count", aux);
			return respuesta.toString();


	}

	@PostMapping("/eliminarActividad")
	public String eliminarActividad(@RequestBody Actividad newActiv) {
		JSONObject respuesta= new JSONObject();
		if(activService.eliminarActividad(newActiv).equals("Se elimino la actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

	@PostMapping("/getActividades")
	public String getActividades() {
		JSONArray array= new JSONArray();
		List<Actividad> actividades=activService.findAll();
		for (int i = 0; i < actividades.size(); i++) {
			JSONObject actJson= new JSONObject();
			actJson.put("id", actividades.get(i).getId());
			actJson.put("nombre", actividades.get(i).getNombre());
			array.put(actJson);

		}
		return array.toString();



	}


	@PostMapping("/mostrarActividad")
	public String buscarActividad(@RequestBody Actividad actividad) {
		JSONObject respuesta= new JSONObject();
		if(activService.mostrarActividad(actividad.getId())!=null) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}


	@PostMapping("/modificarActividad")
	
	public String modificarActividad(@RequestBody Actividad newActiv) {
		JSONObject respuesta= new JSONObject();
		if(activService.modificarActividad(newActiv).equals("Se modifico la actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}


	}

