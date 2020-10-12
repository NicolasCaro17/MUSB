package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Noticia;


public interface INoticiaService {
	public String crearNoticia(Noticia noticia);
	public int contarNoticia();
	public String modificarNoticia(Noticia noticia);
	public List<Noticia> findAll();	
	public String eliminarNoticia(Noticia noticia);
	public Noticia mostrarNoticia(int id);
}
