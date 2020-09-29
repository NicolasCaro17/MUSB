package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Usuario;
import co.edu.usbbog.musb.musbws.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	@Autowired
	IUsuarioRepository UsuRepo;

	@Override
	public String crearUsuario(Usuario usuario) {
		try {
			UsuRepo.save(usuario);
			return "Se agrego el usuario";
		} catch (IllegalArgumentException e) {
			return "No se agrego el usuario"+e.getMessage();
		}
	}
	
}
