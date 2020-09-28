/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.musb.musbws.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nicos
 */
@Entity
@Table(catalog = "musb_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugar.findAll", query = "SELECT l FROM Lugar l")
    , @NamedQuery(name = "Lugar.findById", query = "SELECT l FROM Lugar l WHERE l.id = :id")
    , @NamedQuery(name = "Lugar.findByNombre", query = "SELECT l FROM Lugar l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Lugar.findByDescripcion", query = "SELECT l FROM Lugar l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "Lugar.findByUbicacion", query = "SELECT l FROM Lugar l WHERE l.ubicacion = :ubicacion")})
public class Lugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String ubicacion;
    @Lob
    private byte[] foto;
    @JoinColumn(name = "sede", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sede sede;
    @JoinColumn(name = "tipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoLugar tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugar")
    private List<Evento> eventoList;

    public Lugar() {
    }

    public Lugar(Integer id) {
        this.id = id;
    }

    public Lugar(Integer id, String nombre, String descripcion, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public TipoLugar getTipo() {
        return tipo;
    }

    public void setTipo(TipoLugar tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugar)) {
            return false;
        }
        Lugar other = (Lugar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.musb.musbws.model.Lugar[ id=" + id + " ]";
    }
    
}
