package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.TipoActividad;


public interface ITipoDeActividadService {
	
	
	public String crearTipoActividad(TipoActividad Tactividad);
	
	public int contarTipoActividad();
	
	public String modificarTipoActividad(TipoActividad Tactividad);
	
	public List<TipoActividad> findAll();	
	
	public String eliminarTipoActividad(TipoActividad Tactividad);
	
	public TipoActividad mostrarTipoActividad(int id);
	

}