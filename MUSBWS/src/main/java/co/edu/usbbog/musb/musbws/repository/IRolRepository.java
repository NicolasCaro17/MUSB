package co.edu.usbbog.musb.musbws.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.musb.musbws.model.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer>{
	
	public List<Rol> findByNombre(String nombre);	

}
