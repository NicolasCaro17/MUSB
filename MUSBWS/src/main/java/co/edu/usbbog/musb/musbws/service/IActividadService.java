package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Actividad;


public interface IActividadService {

	public String crearActividad(Actividad actividad);

	public int contarActividad();
	public String modificarActividad(Actividad actividad);
	public List<Actividad> findAll();	
	public String eliminarActividad(Actividad actividad);
	public Actividad mostrarActividad(int id);

}

