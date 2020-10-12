package co.edu.usbbog.musb.musbws.controller;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Programa;
import co.edu.usbbog.musb.musbws.service.IProgramaService;




@RestController
public class ProgramaController {
	
	@Autowired
	private IProgramaService programaService;

	@PostMapping("/crearPrograma")
	public String crearPrograma(@RequestBody Programa programa) {
		
		JSONObject respuesta= new JSONObject();
		if(programaService.crearPrograma(programa).equals("Se guardo el tipo de Programa")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}

@PostMapping("/contarPrograma")

public String contarPrograma() {
	JSONObject respuesta= new JSONObject();
		int aux=programaService.contarPrograma();
		respuesta.put("Count", aux);
		return respuesta.toString();


}

@PostMapping("/eliminarPrograma")

public String eliminarPrograma(@RequestBody Programa programa) {
	JSONObject respuesta= new JSONObject();
	if(programaService.eliminarPrograma(programa).equals("Se elimino el Programa")) {
		respuesta.put("respuesta", true);
		return respuesta.toString();
	}else {
		respuesta.put("respuesta", false);
		return respuesta.toString();
	}

}

@PostMapping("/getPrograma")

public String getPrograma() {
	
	JSONArray array= new JSONArray();
	List<Programa> programas=programaService.findAll();
	for (int i = 0; i < programas.size(); i++) {
		
		JSONObject programaJson= new JSONObject();
		programaJson.put("id", programas.get(i).getId());
		programaJson.put("nombre", programas.get(i).getNombre());
		programaJson.put("director", programas.get(i).getDirector());
		programaJson.put("oficina", programas.get(i).getOficina());
		programaJson.put("facultad", programas.get(i).getFacultad());
		programaJson.put("ext", programas.get(i).getExt());
		array.put(programaJson);

	}
	return array.toString();



}


@PostMapping("/mostrarPrograma")

public String buscarPrograma(@RequestBody Programa programa) {
	JSONObject respuesta= new JSONObject();
	if(programaService.mostrarPrograma(programa.getId())!=null) {
		respuesta.put("respuesta", true);
		return respuesta.toString();
	}else {
		respuesta.put("respuesta", false);
		return respuesta.toString();
	}

}


@PostMapping("/modificarPrograma")

public String modificarPrograma(@RequestBody Programa programa) {
	JSONObject respuesta= new JSONObject();
	if(programaService.modificarPrograma(programa).equals("Se modifico el tipo de Programa")) {
		respuesta.put("respuesta", true);
		return respuesta.toString();
	}else {
		respuesta.put("respuesta", false);
		return respuesta.toString();
	}

}


}
