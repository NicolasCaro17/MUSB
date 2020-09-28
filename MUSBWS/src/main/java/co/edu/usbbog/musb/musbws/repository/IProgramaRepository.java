package co.edu.usbbog.musb.musbws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.musb.musbws.model.Programa;

public interface IProgramaRepository extends JpaRepository<Programa, Integer> {
	
}
