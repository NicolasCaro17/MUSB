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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCodigo", query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo")
    , @NamedQuery(name = "Usuario.findByTipoDocumento", query = "SELECT u FROM Usuario u WHERE u.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Usuario.findByNumDoc", query = "SELECT u FROM Usuario u WHERE u.numDoc = :numDoc")
    , @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia")
    , @NamedQuery(name = "Usuario.findByNacionalidad", query = "SELECT u FROM Usuario u WHERE u.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "num_doc")
    private int numDoc;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic(optional = false)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "telefono")
    private Integer telefono;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Rol> rolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private List<Agenda> agendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private List<Amigo> amigoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario2")
    private List<Amigo> amigoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "envia")
    private List<Chat> chatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recibe")
    private List<Chat> chatList1;
    @JoinColumn(name = "programa", referencedColumnName = "id")
    @ManyToOne
    private Programa programa;

    public Usuario() {
    }

    public Usuario(Integer codigo) {
        this.codigo = codigo;
    }

    public Usuario(Integer codigo, String tipoDocumento, int numDoc, String nombres, String apellidos, String correo, String contrasenia, String nacionalidad) {
        this.codigo = codigo;
        this.tipoDocumento = tipoDocumento;
        this.numDoc = numDoc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nacionalidad = nacionalidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Agenda> getAgendaList() {
        return agendaList;
    }

    public void setAgendaList(List<Agenda> agendaList) {
        this.agendaList = agendaList;
    }

    @XmlTransient
    public List<Amigo> getAmigoList() {
        return amigoList;
    }

    public void setAmigoList(List<Amigo> amigoList) {
        this.amigoList = amigoList;
    }

    @XmlTransient
    public List<Amigo> getAmigoList1() {
        return amigoList1;
    }

    public void setAmigoList1(List<Amigo> amigoList1) {
        this.amigoList1 = amigoList1;
    }

    @XmlTransient
    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @XmlTransient
    public List<Chat> getChatList1() {
        return chatList1;
    }

    public void setChatList1(List<Chat> chatList1) {
        this.chatList1 = chatList1;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "paquete.Usuario[ codigo=" + codigo + " ]";
    }
    
}
