package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Lugar;
import co.edu.usbbog.musb.musbws.service.ILugarService;

@RestController
public class LugarController {
	@Autowired
	ILugarService lugarService;
	@PostMapping("/crearLugar")
	public String crearLugar(@RequestBody Lugar lugar) {
		return lugarService.crearLugar(lugar);
	}
}
