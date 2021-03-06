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
public class AmigoPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "usuario")
    private int usuario;
    @Basic(optional = false)
    @Column(name = "amigo")
    private int amigo;

    public AmigoPK() {
    }

    public AmigoPK(int usuario, int amigo) {
        this.usuario = usuario;
        this.amigo = amigo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getAmigo() {
        return amigo;
    }

    public void setAmigo(int amigo) {
        this.amigo = amigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuario;
        hash += (int) amigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmigoPK)) {
            return false;
        }
        AmigoPK other = (AmigoPK) object;
        if (this.usuario != other.usuario) {
            return false;
        }
        if (this.amigo != other.amigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "paquete.AmigoPK[ usuario=" + usuario + ", amigo=" + amigo + " ]";
    }
    
}
