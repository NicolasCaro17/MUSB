package co.edu.usbbog.musb.musbws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.musb.musbws.model.Amigo;
import co.edu.usbbog.musb.musbws.model.AmigoPK;

public interface IAmigoRepository extends JpaRepository<Amigo, AmigoPK>{

}
