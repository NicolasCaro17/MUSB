/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.musb.musbws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author nico_
 */
@Embeddable
public class AgendaPK implements Serializable {

<<<<<<< Updated upstream
    @Basic(optional = false)
=======
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
>>>>>>> Stashed changes
    @Column(name = "usuario")
    private int usuario;
    @Basic(optional = false)
    @Column(name = "evento")
    private int evento;

    public AgendaPK() {
    }

    public AgendaPK(int usuario, int evento) {
        this.usuario = usuario;
        this.evento = evento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuario;
        hash += (int) evento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgendaPK)) {
            return false;
        }
        AgendaPK other = (AgendaPK) object;
        if (this.usuario != other.usuario) {
            return false;
        }
        if (this.evento != other.evento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "paquete.AgendaPK[ usuario=" + usuario + ", evento=" + evento + " ]";
    }
    
}
