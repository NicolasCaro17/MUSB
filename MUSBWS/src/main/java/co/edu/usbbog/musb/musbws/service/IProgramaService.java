package co.edu.usbbog.musb.musbws.service;
import java.util.List;

import co.edu.usbbog.musb.musbws.model.Programa;



public interface IProgramaService {

	
	public String crearPrograma(Programa programa);
	public int contarPrograma();
	public String modificarPrograma(Programa programa);
	public List<Programa> findAll();	
	public String eliminarPrograma(Programa programa);
	public Programa mostrarPrograma(int id);

	
}
