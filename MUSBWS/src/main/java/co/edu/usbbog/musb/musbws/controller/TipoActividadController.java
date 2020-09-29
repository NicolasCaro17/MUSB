package co.edu.usbbog.musb.musbws.controller;

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
		return tipoAService.crearTipoDeActividad(tipoActividad);
	}
}
