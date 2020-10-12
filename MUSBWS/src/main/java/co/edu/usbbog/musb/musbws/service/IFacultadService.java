package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Facultad;


public interface IFacultadService {
	public String crearFacultad(Facultad facultad);
	public String modificarFacultad(Facultad facultad);
	public String eliminarFacultad(Facultad facultad);
	public Integer contarFacultad();
	public List<Facultad>findAll();
	public Facultad mostrarFacultad(int id);
	
}
