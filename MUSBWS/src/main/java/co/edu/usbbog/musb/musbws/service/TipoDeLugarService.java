package co.edu.usbbog.musb.musbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.musb.musbws.model.TipoLugar;
import co.edu.usbbog.musb.musbws.repository.ITipoLugarRepository;

@Service
public class TipoDeLugarService implements ITipoDeLugarService{
	
	@Autowired
	ITipoLugarRepository TipLRepo;

	@Override
	public String crearTipoDeLugar(TipoLugar tipoLugar) {
		try {
			TipLRepo.save(tipoLugar);
			return "Se agrego el tipo de lugar";
		} catch (IllegalArgumentException e) {
			return "Se agrego el tipo de lugar"+e.getMessage();
		}
		
	}
	
}
