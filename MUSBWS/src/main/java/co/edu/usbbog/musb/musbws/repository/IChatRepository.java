package co.edu.usbbog.musb.musbws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.musb.musbws.model.Chat;

public interface IChatRepository extends JpaRepository<Chat, Integer>{
	
}
