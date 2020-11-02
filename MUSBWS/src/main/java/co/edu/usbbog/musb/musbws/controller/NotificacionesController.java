package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Chat;
import co.edu.usbbog.musb.musbws.model.Usuario;
import co.edu.usbbog.musb.musbws.service.IChatService;

@RestController
public class NotificacionesController {
	@Autowired
	private IChatService chatService;
	
	@PostMapping("/getNotificaciones")
	public String getNotificaciones(@RequestBody Usuario entrada) {
		JSONArray notificaciones= new JSONArray();
		List<Chat> notificacionesDeChat = chatService.getNotificaciones(entrada);
		for (Chat chat : notificacionesDeChat) {
			JSONObject notification= new JSONObject();
			notification.put("origen", chat.getEnvia().getNombres()+" "+ chat.getEnvia().getApellidos());
			notification.put("hora", chat.getMarcaTiempo().toString());
			notification.put("mensaje", chat.getMensaje());
			notificaciones.put(notification);
		}
		return notificaciones.toString();
		
	}
	
	@PostMapping("/leerMensaje")
	public String leerMensaje(@RequestBody Usuario entrada) {
		JSONArray notificaciones= new JSONArray();
		List<Chat> notificacionesDeChat = chatService.leerMensaje(entrada);
		for (Chat chat : notificacionesDeChat) {
			JSONObject notification= new JSONObject();
			notification.put("origen", chat.getEnvia().getNombres()+" "+ chat.getEnvia().getApellidos());
			notification.put("hora", chat.getMarcaTiempo().toString());
			notification.put("mensaje", chat.getMensaje());
			notificaciones.put(notification);
		}
		return notificaciones.toString();
		
	}
	
	
}
