package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Sede;

public interface ISedeService {
	public String crearSede(Sede sede);
	public String modificarSede(Sede sede);
	public String eliminarSede(Sede sede);
	public Integer contarSede();
	public List<Sede>findAll();
	public Sede mostrarSede(int id);
	
	
}
