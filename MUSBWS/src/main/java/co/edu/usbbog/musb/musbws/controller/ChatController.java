package co.edu.usbbog.musb.musbws.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
		JSONObject respuesta = new JSONObject();
		chat.setMarcaTiempo(new Date());
		if (chatService.crearChat(chat).equals("Se guardo el chat")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarChat")
	public String contarChat() {
		JSONObject respuesta = new JSONObject();
		int aux = chatService.contarChat();
		respuesta.put("Count", aux);
		return respuesta.toString();

	}
	
	@PostMapping("/eliminarChat")
	public String eliminarChat(@RequestBody Chat chat) {
		JSONObject respuesta = new JSONObject();
		if (chatService.eliminarChat(chat).equals("Se elimino el chat")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}
	
	@PostMapping("/getChat")
	public String getChat() {
		JSONArray array = new JSONArray();
		List<Chat> chatter = chatService.findAll();
		for (int i = 0; i < chatter.size(); i++) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", chatter.get(i).getId());
			rolJson.put("mensaje", chatter.get(i).getMensaje());
			rolJson.put("marca_tiempo", chatter.get(i).getMarcaTiempo());
			rolJson.put("estado", chatter.get(i).getEstado());
			rolJson.put("envia", chatter.get(i).getEnvia());
			rolJson.put("recibe", chatter.get(i).getRecibe());
			array.put(rolJson);

		}
		return array.toString();

	}
	
	@PostMapping("/mostrarChat")
	public String buscarChat(@RequestBody Chat chat) {
		JSONArray array = new JSONArray();
		Chat chatter = chatService.mostrarChat(chat.getId());
		if (chatter != null) {
			JSONObject rolJson = new JSONObject();
			rolJson.put("id", chatter.getId());
			rolJson.put("mensaje", chatter.getMensaje());
			rolJson.put("marca_tiempo", chatter.getMarcaTiempo());
			rolJson.put("estado", chatter.getEstado());
			rolJson.put("envia", chatter.getEnvia());
			rolJson.put("recibe", chatter.getRecibe());
			array.put(rolJson);
			return array.toString();
		} else {
			return "No se encontro";
		}

	}
	
	@PostMapping("/modificarChat")
	public String modificarChat(@RequestBody Chat chat) {
		JSONObject respuesta = new JSONObject();
		if (chatService.modificarChat(chat).equals("Se modifico el chat")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		} else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}

	}
	
}
