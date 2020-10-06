package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Rol;

public interface IRolService {
	
	public String crearRol(Rol rol);
	public int contarRol();
	public String modificarRol(Rol rol);
	public List<Rol> findAll();	
	public String eliminarRol(Rol rol);
	public Rol mostrarRol(int id);

}
