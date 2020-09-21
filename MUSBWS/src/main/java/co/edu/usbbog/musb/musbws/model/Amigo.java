/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.musb.musbws.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nicos
 */
@Entity
@Table(catalog = "musb_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amigo.findAll", query = "SELECT a FROM Amigo a")
    , @NamedQuery(name = "Amigo.findByUsuario", query = "SELECT a FROM Amigo a WHERE a.amigoPK.usuario = :usuario")
    , @NamedQuery(name = "Amigo.findByAmigo", query = "SELECT a FROM Amigo a WHERE a.amigoPK.amigo = :amigo")
    , @NamedQuery(name = "Amigo.findByFechaInicio", query = "SELECT a FROM Amigo a WHERE a.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Amigo.findByFechaFin", query = "SELECT a FROM Amigo a WHERE a.fechaFin = :fechaFin")
    , @NamedQuery(name = "Amigo.findByRelacion", query = "SELECT a FROM Amigo a WHERE a.relacion = :relacion")})
public class Amigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmigoPK amigoPK;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(length = 20)
    private String relacion;
    @JoinColumn(name = "amigo", referencedColumnName = "codigo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;
    @JoinColumn(name = "usuario", referencedColumnName = "codigo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario2;

    public Amigo() {
    }

    public Amigo(AmigoPK amigoPK) {
        this.amigoPK = amigoPK;
    }

    public Amigo(AmigoPK amigoPK, Date fechaInicio) {
        this.amigoPK = amigoPK;
        this.fechaInicio = fechaInicio;
    }

    public Amigo(int usuario, int amigo) {
        this.amigoPK = new AmigoPK(usuario, amigo);
    }

    public AmigoPK getAmigoPK() {
        return amigoPK;
    }

    public void setAmigoPK(AmigoPK amigoPK) {
        this.amigoPK = amigoPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amigoPK != null ? amigoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigo)) {
            return false;
        }
        Amigo other = (Amigo) object;
        if ((this.amigoPK == null && other.amigoPK != null) || (this.amigoPK != null && !this.amigoPK.equals(other.amigoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.musb.musbws.model.Amigo[ amigoPK=" + amigoPK + " ]";
    }
    
}
