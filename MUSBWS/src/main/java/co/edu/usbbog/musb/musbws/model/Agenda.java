/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.musb.musbws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nico_
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByUsuario", query = "SELECT a FROM Agenda a WHERE a.agendaPK.usuario = :usuario")
    , @NamedQuery(name = "Agenda.findByEvento", query = "SELECT a FROM Agenda a WHERE a.agendaPK.evento = :evento")
    , @NamedQuery(name = "Agenda.findByPapel", query = "SELECT a FROM Agenda a WHERE a.papel = :papel")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgendaPK agendaPK;
    @Basic(optional = false)
    @Column(name = "papel")
    private String papel;
    @JoinColumn(name = "evento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento1;
    @JoinColumn(name = "usuario", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public Agenda() {
    }

    public Agenda(AgendaPK agendaPK) {
        this.agendaPK = agendaPK;
    }

    public Agenda(AgendaPK agendaPK, String papel) {
        this.agendaPK = agendaPK;
        this.papel = papel;
    }

    public Agenda(int usuario, int evento) {
        this.agendaPK = new AgendaPK(usuario, evento);
    }

    public AgendaPK getAgendaPK() {
        return agendaPK;
    }

    public void setAgendaPK(AgendaPK agendaPK) {
        this.agendaPK = agendaPK;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Evento getEvento1() {
        return evento1;
    }

    public void setEvento1(Evento evento1) {
        this.evento1 = evento1;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendaPK != null ? agendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.agendaPK == null && other.agendaPK != null) || (this.agendaPK != null && !this.agendaPK.equals(other.agendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.musb.musbws.model.Agenda[ agendaPK=" + agendaPK + " ]";
    }
    
}
