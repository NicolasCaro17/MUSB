package co.edu.usbbog.musb.musbws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.musb.musbws.model.Sede;
import co.edu.usbbog.musb.musbws.service.ISedeService;

@RestController
public class SedeController {
	@Autowired
	ISedeService sedeService;
	
	@PostMapping("/crearSede")
    public String crearTienda(@RequestBody Sede newSede) {
        JSONObject respuesta= new JSONObject();
        if(sedeService.crearSede(newSede).equals("Se guardo la sede")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarSede")
    public String eliminarTienda(@RequestBody Sede borrarSede) {
		JSONObject respuesta= new JSONObject();
		if(sedeService.eliminarSede(borrarSede).equals("Se elimino la sede")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarSede")
    public String buscarTienda(@RequestBody Sede sede) {
        JSONArray array = new JSONArray();
        Sede sedes = sedeService.mostrarSede(sede.getId());
        if (sedes != null) {
            JSONObject sedeJson = new JSONObject();
            sedeJson.put("id", sedes.getId());
            sedeJson.put("nombre", sedes.getNombre());
            sedeJson.put("url", sedes.getUrlMapa());
            sedeJson.put("nombre", sedes.getNombre());
            sedeJson.put("rector", sedes.getRector());
            sedeJson.put("direccion", sedes.getDireccion());
            sedeJson.put("telefono", sedes.getTelefono());
            array.put(sedeJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarSede")
	public String modificarTienda(@RequestBody Sede editSede) {
		JSONObject respuesta= new JSONObject();
		if(sedeService.modificarSede(editSede).equals("Se modifico la tienda")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarSede")
	public String contarTienda() {
		JSONObject respuesta= new JSONObject();
			int aux=sedeService.contarSede();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allSedes")
	public String getTiendas() {
		JSONArray array= new JSONArray();
		List<Sede> sedes=sedeService.findAll();
		for (int i = 0; i < sedes.size(); i++) {
			JSONObject sedeJson= new JSONObject();
			  sedeJson.put("id", sedes.get(i).getId());
	            sedeJson.put("nombre", sedes.get(i).getNombre());
	            sedeJson.put("url", sedes.get(i).getUrlMapa());
	            sedeJson.put("nombre", sedes.get(i).getNombre());
	            sedeJson.put("rector", sedes.get(i).getRector());
	            sedeJson.put("direccion", sedes.get(i).getDireccion());
	            sedeJson.put("telefono", sedes.get(i).getTelefono());		
			array.put(sedeJson);			
		}
		return array.toString();		
	}
	
	
	
}
