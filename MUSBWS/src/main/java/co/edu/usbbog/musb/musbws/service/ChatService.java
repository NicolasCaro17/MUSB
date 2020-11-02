package co.edu.usbbog.musb.musbws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Chat;
import co.edu.usbbog.musb.musbws.model.Usuario;
import co.edu.usbbog.musb.musbws.repository.IChatRepository;

@Service
public class ChatService implements IChatService{
	
	@Autowired
	IChatRepository ChatRepo;

	@Override
	public String crearChat(Chat chat) {
		try {
			if(ChatRepo.existsById(chat.getId())) {
				ChatRepo.save(chat);
				return "Se guardo el chat";
			}else {
				return "No se guardo el chat";
			}
		} catch (IllegalArgumentException e) {
			return "No se guardo el chat" + e.getMessage();
		}
	}

	@Override
	public int contarChat() {
		try {
			long cantidad=0;
			cantidad=ChatRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarChat(Chat chat) {
        try {
            if(ChatRepo.existsById(chat.getId())) {
            	ChatRepo.delete(chat);
            	ChatRepo.save(chat);
                return "Se modifico el chat";
            }else {
                return "No se encontro el chat";
            }
        } catch (IllegalArgumentException e) {
            return "No se encontro el rol: " + e.getMessage();
        }
	}

	@Override
	public List<Chat> findAll() {
		try {
			List<Chat> encontrado=ChatRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarChat(Chat chat) {
        try {
            if (ChatRepo.existsById(chat.getId())) {
            	ChatRepo.delete(chat);
            return "Se elimino el chat";
            }else {
                return "El chat no existe";
            }
        } catch (IllegalArgumentException e) {
            return "No se elimino el chat: " + e.getMessage();
        }
	}

	@Override
	public Chat mostrarChat(int id) {
		Chat chat= new Chat();
		try {
			if(ChatRepo.existsById(id)) {
				chat=ChatRepo.getOne(id);
				return chat;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		
	}
	}

	@Override
	public List<Chat> getNotificaciones(Usuario user) {
		List<Chat> chatSinVer= ChatRepo.findByEstadoAndRecibe("enviado", user);
		return chatSinVer;
	}

	@Override
	public List<Chat> leerMensaje(Usuario user) {
		List<Chat> chatListos= ChatRepo.findByEstadoAndRecibe("enviado", user);
		for (Chat chat : chatListos) {
			chat.setEstado("leido");
			ChatRepo.save(chat);
		}
		return chatListos;
	}







}
