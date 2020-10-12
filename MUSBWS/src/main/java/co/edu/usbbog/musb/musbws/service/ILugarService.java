package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Lugar;


public interface ILugarService {
	public String crearLugar(Lugar lugar);
	public String modificarLugar(Lugar lugar);
	public String eliminarLugar(Lugar lugar);
	public Integer contarLugar();
	public List<Lugar>findAll();
	public Lugar mostrarLugar(int id);
	
}
