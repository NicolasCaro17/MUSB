package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Facultad;
import co.edu.usbbog.musb.musbws.model.Sede;
import co.edu.usbbog.musb.musbws.service.IFacultadService;

@RestController
public class FacultadController {
	@Autowired
	IFacultadService facultadService;
	@PostMapping("/crearFacultad")
	public String crearFacultad(@RequestBody Facultad facultad) {
		 JSONObject respuesta= new JSONObject();
	        if(facultadService.crearFacultad(facultad).equals("Se guardo la facultad")) {
	            respuesta.put("respuesta", true);
	            return respuesta.toString();
	        }else {
	            respuesta.put("respuesta", false);
	            return respuesta.toString();
	        }
	}

	@PostMapping("/eliminarFacultad")
	public String eliminarTienda(@RequestBody Facultad borrarFacultad) {
		JSONObject respuesta = new JSONObject();
		if (facultadService.eliminarFacultad(borrarFacultad).equals("Se elimino la facultad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	@PostMapping("/mostrarFacultad")
	public String buscarFacultad(@RequestBody Facultad facultad) {
		JSONArray array = new JSONArray();
		Facultad facultades = facultadService.mostrarFacultad(facultad.getId());
		if (facultades != null) {
			JSONObject facultadJson = new JSONObject();
			facultadJson.put("id", facultades.getId());
			facultadJson.put("nombre", facultades.getNombre());
			facultadJson.put("decano", facultades.getDecano());
			facultadJson.put("oficina", facultades.getOficina());
			facultadJson.put("ext", facultades.getExt());
			//facultadJson.put("sede", facultades.getSede());

			array.put(facultadJson);
			return array.toString();
		} else {
			return "No se encontro";
		}

	}
	
	@PostMapping("/modificarFacultad")
	public String modificarFacultad(@RequestBody Facultad facultad) {
		JSONObject respuesta = new JSONObject();
		if (facultadService.modificarFacultad(facultad).equals("Se modifico la facultad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

	@PostMapping("/contarFacultad")
	public String contarFacultad() {
		JSONObject respuesta = new JSONObject();
		int aux = facultadService.contarFacultad();
		respuesta.put("Count", aux);
		return respuesta.toString();
	}

	@PostMapping("/allFacultades")
	public String getFacultad() {
		JSONArray array = new JSONArray();
		List<Facultad> facultades = facultadService.findAll();
		for (int i = 0; i < facultades.size(); i++) {
			JSONObject facultadJson = new JSONObject();
			facultadJson.put("id", facultades.get(i).getId());
			facultadJson.put("nombre", facultades.get(i).getNombre());
			facultadJson.put("decano", facultades.get(i).getDecano());
			facultadJson.put("oficina", facultades.get(i).getOficina());
			facultadJson.put("ext", facultades.get(i).getExt());
			//facultadJson.put("sede", facultades.get(i).getSede());
			array.put(facultadJson);
		}
		return array.toString();
	}

}
