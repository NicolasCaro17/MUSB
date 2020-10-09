package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.edu.usbbog.musb.musbws.model.Rol;
import co.edu.usbbog.musb.musbws.service.IRolService;

@RestController
public class RolController {

	@Autowired
	private IRolService rolService;

	@PostMapping("/crearRol")
	public String crearRol(@RequestBody Rol newRol) {
		JSONObject respuesta = new JSONObject();
		if (rolService.crearRol(newRol).equals("Se guardo el rol")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

	@PostMapping("/contarRol")
	public String contarRol() {
		JSONObject respuesta = new JSONObject();
		int aux = rolService.contarRol();
		respuesta.put("Count", aux);
		return respuesta.toString();

	}

	@PostMapping("/eliminarRol")
	public String eliminarRol(@RequestBody Rol newRol) {
		JSONObject respuesta = new JSONObject();
		if (rolService.eliminarRol(newRol).equals("Se elimino el rol")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

	@PostMapping("/getRoles")
	public String getRoles() {
		JSONArray array = new JSONArray();
		List<Rol> roles = rolService.findAll();
		for (int i = 0; i < roles.size(); i++) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", roles.get(i).getId());
			rolJson.put("nombre", roles.get(i).getNombre());
			array.put(rolJson);

		}
		return array.toString();

	}

	@PostMapping("/mostrarRol")
	public String buscarRol(@RequestBody Rol rol) {
		JSONArray array = new JSONArray();
		Rol roles = rolService.mostrarRol(rol.getId());
		if (roles != null) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", roles.getId());
			rolJson.put("nombre", roles.getNombre());
			array.put(rolJson);
			return array.toString();
		} else {
			return "No se encontro";
		}

	}

	@PostMapping("/modificarRol")
	public String modificarRol(@RequestBody Rol newRol) {
		JSONObject respuesta = new JSONObject();
		if (rolService.modificarRol(newRol).equals("Se modifico el rol")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

}
