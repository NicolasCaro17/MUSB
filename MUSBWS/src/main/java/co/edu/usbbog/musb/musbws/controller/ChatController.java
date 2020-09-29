package co.edu.usbbog.musb.musbws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Chat;
import co.edu.usbbog.musb.musbws.service.IChatService;

@RestController
public class ChatController {
	@Autowired
	IChatService chatService;
	
	@PostMapping("/crearChat")
	public String CrearChat(@RequestBody Chat chat) {
		return chatService.crearChat(chat);
		
	}
}
