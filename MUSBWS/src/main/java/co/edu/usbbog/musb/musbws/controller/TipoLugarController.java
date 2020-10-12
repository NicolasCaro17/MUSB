package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import co.edu.usbbog.musb.musbws.model.TipoLugar;
import co.edu.usbbog.musb.musbws.service.ITipoLugarService;


@RestController
public class TipoLugarController {

	
	@Autowired
	private ITipoLugarService TipoLugarService;

	@PostMapping("/crearTipoLugar")
	public String crearTipoLugar(@RequestBody TipoLugar Tlugar) {
		
		JSONObject respuesta= new JSONObject();
		if(TipoLugarService.crearTipoLugar(Tlugar).equals("Se guardo el tipo de lugar")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

@PostMapping("/contarTipoLugar")

public String contarTipoLugar() {
	JSONObject respuesta= new JSONObject();
		int aux=TipoLugarService.contarTipoLugar();
		respuesta.put("Count", aux);
		return respuesta.toString();


}

@PostMapping("/eliminarTipoLugar")

public String eliminarTipoLugar(@RequestBody TipoLugar Tlugar) {
	JSONObject respuesta= new JSONObject();
	if(TipoLugarService.eliminarTipoLugar(Tlugar).equals("Se elimino el tipo de lugar")) {
		respuesta.put("respuesta", true);
		return respuesta.toString();
	}else {
		respuesta.put("respuesta", false);
		return respuesta.toString();
	}

}

@PostMapping("/getTipoLugar")

public String getTipoLugar() {
	JSONArray array= new JSONArray();
	List<TipoLugar> Tlugares=TipoLugarService.findAll();
	for (int i = 0; i < Tlugares.size(); i++) {
		JSONObject TlugaresJson= new JSONObject();
		TlugaresJson.put("id", Tlugares.get(i).getId());
		TlugaresJson.put("nombre", Tlugares.get(i).getNombre());
		TlugaresJson.put("descripcion", Tlugares.get(i).getDescripcion());
		array.put(TlugaresJson);

	}
	return array.toString();



}


@PostMapping("/mostrarTipoLugar")

public String buscarTipoLugar(@RequestBody TipoLugar Tlugar) {
	JSONObject respuesta= new JSONObject();
	if(TipoLugarService.mostrarTipoLugar(Tlugar.getId())!=null) {
		respuesta.put("respuesta", true);
		return respuesta.toString();
	}else {
		respuesta.put("respuesta", false);
		return respuesta.toString();
	}

}


@PostMapping("/modificarTipoLugar")

public String modificarTipoLugar(@RequestBody TipoLugar Tlugar) {
	JSONObject respuesta= new JSONObject();
	if(TipoLugarService.modificarTipoLugar(Tlugar).equals("Se modifico el tipo de lugar")) {
		respuesta.put("respuesta", true);
		return respuesta.toString();
	}else {
		respuesta.put("respuesta", false);
		return respuesta.toString();
	}

}


}