package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.TipoLugar;
import co.edu.usbbog.musb.musbws.service.ITipoDeLugarService;

@RestController
public class TipoLugarController {
	@Autowired
	ITipoDeLugarService tipoLugarService;
	@PostMapping("/crearTipoLugar")
	public String crearTipoLugar(@RequestBody TipoLugar tipoLugar) {
		return tipoLugarService.crearTipoDeLugar(tipoLugar);
	}
}
