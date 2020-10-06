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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nico_
 */
@Entity
@Table(name = "sede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s")
    , @NamedQuery(name = "Sede.findById", query = "SELECT s FROM Sede s WHERE s.id = :id")
    , @NamedQuery(name = "Sede.findByCiudad", query = "SELECT s FROM Sede s WHERE s.ciudad = :ciudad")
    , @NamedQuery(name = "Sede.findByUrlMapa", query = "SELECT s FROM Sede s WHERE s.urlMapa = :urlMapa")
    , @NamedQuery(name = "Sede.findByNombre", query = "SELECT s FROM Sede s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Sede.findByRector", query = "SELECT s FROM Sede s WHERE s.rector = :rector")
    , @NamedQuery(name = "Sede.findByDireccion", query = "SELECT s FROM Sede s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Sede.findByTelefono", query = "SELECT s FROM Sede s WHERE s.telefono = :telefono")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "url_mapa")
    private String urlMapa;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "rector")
    private String rector;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sede")
    private List<Lugar> lugarList;
    @OneToMany(mappedBy = "sede")
    private List<Noticia> noticiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sede")
    private List<Facultad> facultadList;

    public Sede() {
    }

    public Sede(Integer id) {
        this.id = id;
    }

    public Sede(Integer id, String ciudad, String urlMapa, String nombre, String rector, String direccion, int telefono) {
        this.id = id;
        this.ciudad = ciudad;
        this.urlMapa = urlMapa;
        this.nombre = nombre;
        this.rector = rector;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUrlMapa() {
        return urlMapa;
    }

    public void setUrlMapa(String urlMapa) {
        this.urlMapa = urlMapa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Lugar> getLugarList() {
        return lugarList;
    }

    public void setLugarList(List<Lugar> lugarList) {
        this.lugarList = lugarList;
    }

    @XmlTransient
    public List<Noticia> getNoticiaList() {
        return noticiaList;
    }

    public void setNoticiaList(List<Noticia> noticiaList) {
        this.noticiaList = noticiaList;
    }

    @XmlTransient
    public List<Facultad> getFacultadList() {
        return facultadList;
    }

    public void setFacultadList(List<Facultad> facultadList) {
        this.facultadList = facultadList;
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
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "paquete.Sede[ id=" + id + " ]";
    }
    
}
