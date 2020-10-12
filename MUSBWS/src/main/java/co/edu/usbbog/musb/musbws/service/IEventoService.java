package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Evento;


public interface IEventoService {
	public String crearEvento(Evento evento);
	public String modificarEvento(Evento evento);
	public String eliminarEvento(Evento evento);
	public Integer contarEvento();
	public List<Evento>findAll();
	public Evento mostrarEvento(int id);
}
