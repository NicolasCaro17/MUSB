package co.edu.usbbog.musb.musbws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.musb.musbws.model.Agenda;
import co.edu.usbbog.musb.musbws.model.AgendaPK;

public interface IAgendaRepository extends JpaRepository<Agenda, AgendaPK>{

}
