package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import co.edu.usbbog.musb.musbws.model.TipoActividad;
import co.edu.usbbog.musb.musbws.service.TipoActividadService;


@RestController
public class TipoActividadController {
	
	@Autowired
	private TipoActividadService TactividadService;
	
	@PostMapping("/crearTipoActividad")
	public String crearTipoActividad(@RequestBody TipoActividad Tactividad) {
		
		JSONObject respuesta= new JSONObject();
		if(TactividadService.crearTipoActividad(Tactividad).equals("Se guardo el tipo de actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}
	@PostMapping("/contarTipoActividad")
	public String contarTipoActividad() {
		JSONObject respuesta= new JSONObject();
			int aux=TactividadService.contarTipoActividad();
			respuesta.put("Count", aux);
			return respuesta.toString();


	}

	@PostMapping("/eliminarTipoActividad")
	public String eliminarTipoActividad(@RequestBody TipoActividad newRol) {
		JSONObject respuesta= new JSONObject();
		if(TactividadService.eliminarTipoActividad(newRol).equals("Se elimino el rol")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

	@PostMapping("/getTipoActividad")
	public String getTipoActividad() {
		JSONArray array= new JSONArray();
		List<TipoActividad> actividades=TactividadService.findAll();
		for (int i = 0; i < actividades.size(); i++) {
			JSONObject actividadJson= new JSONObject();
			actividadJson.put("id", actividades.get(i).getId());
			actividadJson.put("nombre", actividades.get(i).getNombre());
			actividadJson.put("descripcion", actividades.get(i).getDescripcion());
			array.put(actividadJson);

		}
		return array.toString();



	}


	@PostMapping("/mostrarTipoActividad")
	public String buscarTipoActividad(@RequestBody TipoActividad actividad) {
		JSONObject respuesta= new JSONObject();
		if(TactividadService.mostrarTipoActividad(actividad.getId())!=null) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}


	@PostMapping("/modificarTipoActividad")
	public String modificarTipoActividad(@RequestBody TipoActividad Tactividad) {
		JSONObject respuesta= new JSONObject();
		if(TactividadService.modificarTipoActividad(Tactividad).equals("Se modifico el tipo de actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}


	}

