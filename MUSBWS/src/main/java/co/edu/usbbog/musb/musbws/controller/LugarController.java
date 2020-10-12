package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Facultad;
import co.edu.usbbog.musb.musbws.model.Lugar;
import co.edu.usbbog.musb.musbws.service.ILugarService;

@RestController
public class LugarController {
	@Autowired
	ILugarService lugarService;

	@PostMapping("/crearLugar")
	public String crearLugar(@RequestBody Lugar lugar) {
		JSONObject respuesta = new JSONObject();
		if (lugarService.crearLugar(lugar).equals("Se guardo el lugar")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}

	@PostMapping("/eliminarLugar")
	public String eliminarLugar(@RequestBody Lugar borrarLugar) {
		JSONObject respuesta = new JSONObject();
		if (lugarService.eliminarLugar(borrarLugar).equals("Se elimino el lugar")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}

	@PostMapping("/mostrarLugar")
	public String buscarLugar(@RequestBody Lugar lugar) {
		JSONArray array = new JSONArray();
		Lugar lugares = lugarService.mostrarLugar(lugar.getId());
		if (lugares != null) {
			JSONObject facultadJson = new JSONObject();
			facultadJson.put("id", lugares.getId());
			facultadJson.put("nombre", lugares.getNombre());
			facultadJson.put("descripcion", lugares.getDescripcion());
			facultadJson.put("ubicacion", lugares.getUbicacion());
			facultadJson.put("foto", lugares.getFoto());
			array.put(facultadJson);
			return array.toString();
		} else {
			return "No se encontro";
		}
	}
	@PostMapping("/modificarLugar")
	public String modificarLugar(@RequestBody Lugar lugar) {
		JSONObject respuesta = new JSONObject();
		if (lugarService.modificarLugar(lugar).equals("Se modifico el lugar")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
		
		@PostMapping("/contarLugar")
		public String contarFacultad() {
			JSONObject respuesta = new JSONObject();
			int aux = lugarService.contarLugar();
			respuesta.put("Count", aux);
			return respuesta.toString();
		}
		
		@PostMapping("/allLugares")
		public String getLugar() {
			JSONArray array = new JSONArray();
			List<Lugar> lugares = lugarService.findAll();
			for (int i = 0; i < lugares.size(); i++) {
				JSONObject facultadJson = new JSONObject();
				facultadJson.put("id", lugares.get(i).getId());
				facultadJson.put("nombre", lugares.get(i).getNombre());
				facultadJson.put("descripcion", lugares.get(i).getDescripcion());
				facultadJson.put("ubicacion", lugares.get(i).getUbicacion());
				facultadJson.put("foto", lugares.get(i).getFoto());
				array.put(facultadJson);
			}
			return array.toString();
		}

	}

	

