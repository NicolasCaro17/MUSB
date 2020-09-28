/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.musb.musbws.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p")
    , @NamedQuery(name = "Programa.findById", query = "SELECT p FROM Programa p WHERE p.id = :id")
    , @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Programa.findByDirector", query = "SELECT p FROM Programa p WHERE p.director = :director")
    , @NamedQuery(name = "Programa.findByOficina", query = "SELECT p FROM Programa p WHERE p.oficina = :oficina")
    , @NamedQuery(name = "Programa.findByExt", query = "SELECT p FROM Programa p WHERE p.ext = :ext")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String director;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String oficina;
    @Basic(optional = false)
    @Column(nullable = false)
    private int ext;
    @JoinColumn(name = "facultad", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Facultad facultad;
    @OneToMany(mappedBy = "programa")
    private List<Noticia> noticiaList;
    @OneToMany(mappedBy = "programa")
    private List<Usuario> usuarioList;

    public Programa() {
    }

    public Programa(Integer id) {
        this.id = id;
    }

    public Programa(Integer id, String nombre, String director, String oficina, int ext) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.oficina = oficina;
        this.ext = ext;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public int getExt() {
        return ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @XmlTransient
    public List<Noticia> getNoticiaList() {
        return noticiaList;
    }

    public void setNoticiaList(List<Noticia> noticiaList) {
        this.noticiaList = noticiaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.musb.musbws.model.Programa[ id=" + id + " ]";
    }
    
}
