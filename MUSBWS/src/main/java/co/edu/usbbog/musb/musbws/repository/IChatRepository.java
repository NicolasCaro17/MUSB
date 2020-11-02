package co.edu.usbbog.musb.musbws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.musb.musbws.model.Chat;
import co.edu.usbbog.musb.musbws.model.Usuario;

public interface IChatRepository extends JpaRepository<Chat, Integer>{
	public List<Chat> findByEstadoAndRecibe(String estado, Usuario recibe);
	public List<Chat> findByEstadoAndId(String estado, int id);
}
