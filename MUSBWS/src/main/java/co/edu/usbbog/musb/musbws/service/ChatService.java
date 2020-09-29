package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Chat;
import co.edu.usbbog.musb.musbws.repository.IChatRepository;

@Service
public class ChatService implements IChatService{
	
	@Autowired
	IChatRepository ChatRepo;

	@Override
	public String crearChat(Chat chat) {
		try {
			ChatRepo.save(chat);
			return "Se guardo el chat";
		} catch (IllegalArgumentException e) {
			return "No se guardo el chat" + e.getMessage();
		}
	}

}
