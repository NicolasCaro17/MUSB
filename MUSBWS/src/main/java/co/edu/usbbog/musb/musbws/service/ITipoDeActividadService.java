package co.edu.usbbog.musb.musbws.service;

import java.util.List;


import co.edu.usbbog.musb.musbws.model.TipoActividad;

public interface ITipoDeActividadService {
	public String crearTipoDeActividad(TipoActividad tactividad);
	public int contarTipoDeActividad();
	public String modificarTipoActividad(TipoActividad tactividad);
	public List<TipoActividad> findAll();	
	public String eliminarTipoActividad(TipoActividad tactividad);
	public TipoActividad mostrarTipoActividad(int id);
}
