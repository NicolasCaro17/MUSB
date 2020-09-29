package co.edu.usbbog.musb.musbws.controller;

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
	IActividadService actividadService;
	
	@PostMapping("/crearActividad")
	public String crearActividad(@RequestBody Actividad actividad) {
		JSONObject respuesta= new JSONObject();
		if(actividadService.crearActividad(actividad).equals("Se guardo la actividad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
}
