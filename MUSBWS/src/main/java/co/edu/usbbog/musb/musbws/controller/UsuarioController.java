package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Usuario;
import co.edu.usbbog.musb.musbws.service.IUsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	IUsuarioService usuarioService;
	@PostMapping("/crearUsuario")
	public String crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearUsuario(usuario);
	}
	
}
