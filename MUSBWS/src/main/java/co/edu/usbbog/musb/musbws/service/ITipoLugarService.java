package co.edu.usbbog.musb.musbws.service;

import java.util.List;


import co.edu.usbbog.musb.musbws.model.TipoLugar;

public interface ITipoLugarService {

	public String crearTipoLugar(TipoLugar Tlugar);
	public int contarTipoLugar();
	public String modificarTipoLugar(TipoLugar Tlugar);
	public List<TipoLugar> findAll();	
	public String eliminarTipoLugar(TipoLugar Tlugar);
	public TipoLugar mostrarTipoLugar(int id);

}
