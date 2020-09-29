package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.Lugar;
import co.edu.usbbog.musb.musbws.repository.ILugarRepository;

@Service
public class LugarService implements ILugarService{
	@Autowired
	ILugarRepository lugRepo;

	@Override
	public String crearLugar(Lugar lugar) {
		try {
			lugRepo.save(lugar);
			return "Se guardo el lugar";
		} catch (IllegalArgumentException e) {
			return "Se guardo el lugar" + e.getMessage();
		}
	}
	
}
