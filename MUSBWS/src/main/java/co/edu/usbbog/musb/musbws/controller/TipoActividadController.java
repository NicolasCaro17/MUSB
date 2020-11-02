package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.TipoActividad;
import co.edu.usbbog.musb.musbws.service.ITipoDeActividadService;

@RestController
public class TipoActividadController {
	@Autowired
	ITipoDeActividadService tipoAService;
	
	@PostMapping("/crearTipoActividad")
	public String crearTipoActividad(@RequestBody TipoActividad tipoActividad) {
		JSONObject respuesta = new JSONObject();
		if (tipoAService.crearTipoDeActividad(tipoActividad).equals("Se agrego el tipo de actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	@PostMapping("/contarTipoActividad")
	public String contarTipoActividad() {
		JSONObject respuesta = new JSONObject();
		int aux = tipoAService.contarTipoDeActividad();
		respuesta.put("Count", aux);
		return respuesta.toString();

	}
	
	@PostMapping("/eliminarTipoActividad")
	public String eliminarTipoActividad(@RequestBody TipoActividad tactividad) {
		JSONObject respuesta = new JSONObject();
		if (tipoAService.eliminarTipoActividad(tactividad).equals("Se elimino el tipo de actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	@PostMapping("/getTipoActividad")
	public String getTipoActividad() {
		JSONArray array = new JSONArray();
		List<TipoActividad> roles = tipoAService.findAll();
		for (int i = 0; i < roles.size(); i++) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", roles.get(i).getId());
			rolJson.put("nombre", roles.get(i).getNombre());
			rolJson.put("Descripccion", roles.get(i).getDescripcion());
			rolJson.put("Lista", roles.get(i).getActividadList());
			array.put(rolJson);

		}
		return array.toString();

	}
	
	
	@PostMapping("/mostrarTipoActividad")
	public String buscarTipoActividad(@RequestBody TipoActividad tactividad) {
		JSONArray array = new JSONArray();
		TipoActividad tacti = tipoAService.mostrarTipoActividad(tactividad.getId());
		if (tacti != null) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", tacti.getId());
			rolJson.put("nombre", tacti.getNombre());
			rolJson.put("Descripccion", tacti.getDescripcion());
			rolJson.put("lista", tacti.getActividadList());
			array.put(rolJson);
			return array.toString();
		} else {
			return "No se encontro";
		}

	}
	
	@PostMapping("/modificarTipoActividad")
	public String modificarTipoActividad(@RequestBody TipoActividad tactividad) {
		JSONObject respuesta = new JSONObject();
		if (tipoAService.modificarTipoActividad(tactividad).equals("Se modifico el tipo de actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

	
}
