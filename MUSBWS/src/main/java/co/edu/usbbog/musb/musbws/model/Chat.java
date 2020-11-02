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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c")
    , @NamedQuery(name = "Chat.findById", query = "SELECT c FROM Chat c WHERE c.id = :id")
    , @NamedQuery(name = "Chat.findByMarcaTiempo", query = "SELECT c FROM Chat c WHERE c.marcaTiempo = :marcaTiempo")
    , @NamedQuery(name = "Chat.findByEstado", query = "SELECT c FROM Chat c WHERE c.estado = :estado")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "marca_tiempo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcaTiempo;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "envia", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Usuario envia;
    @JoinColumn(name = "recibe", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Usuario recibe;

    public Chat() {
    }

    public Chat(Integer id) {
        this.id = id;
    }

    public Chat(Integer id, String mensaje, Date marcaTiempo, String estado) {
        this.id = id;
        this.mensaje = mensaje;
        this.marcaTiempo = marcaTiempo;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getMarcaTiempo() {
        return marcaTiempo;
    }

    public void setMarcaTiempo(Date marcaTiempo) {
        this.marcaTiempo = marcaTiempo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getEnvia() {
        return envia;
    }

    public void setEnvia(Usuario envia) {
        this.envia = envia;
    }

    public Usuario getRecibe() {
        return recibe;
    }

    public void setRecibe(Usuario recibe) {
        this.recibe = recibe;
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
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.musb.musbws.model.Chat[ id=" + id + " ]";
    }
    
}
