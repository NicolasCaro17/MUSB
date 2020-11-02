package co.edu.usbbog.musb.musbws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.musb.musbws.model.Noticia;

public interface INoticiaRepository extends JpaRepository<Noticia, Integer>{
	//public List<Noticia> findByEstadoAndRecibe(String estado, Usuario recibe);
}
