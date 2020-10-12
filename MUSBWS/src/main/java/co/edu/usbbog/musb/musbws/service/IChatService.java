package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import co.edu.usbbog.musb.musbws.model.Chat;

public interface IChatService {
	public String crearChat(Chat chat);
	public int contarChat();
	public String modificarChat(Chat chat);
	public List<Chat> findAll();	
	public String eliminarChat(Chat chat);
	public Chat mostrarChat(int id);
}
