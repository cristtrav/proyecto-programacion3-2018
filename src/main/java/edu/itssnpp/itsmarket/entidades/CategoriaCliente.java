/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.entidades;

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

/**
 *
 * @author traver
 */
@Entity
@Table(name = "categoria_cliente")
@NamedQueries({
    @NamedQuery(name = "CategoriaCliente.findAll", query = "SELECT c FROM CategoriaCliente c")})
public class CategoriaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoria_cliente")
    private Integer idcategoriaCliente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaCliente")
    private List<Cliente> clienteList;

    public CategoriaCliente() {
    }

    public CategoriaCliente(Integer idcategoriaCliente) {
        this.idcategoriaCliente = idcategoriaCliente;
    }

    public CategoriaCliente(Integer idcategoriaCliente, String nombre) {
        this.idcategoriaCliente = idcategoriaCliente;
        this.nombre = nombre;
    }

    public Integer getIdcategoriaCliente() {
        return idcategoriaCliente;
    }

    public void setIdcategoriaCliente(Integer idcategoriaCliente) {
        this.idcategoriaCliente = idcategoriaCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoriaCliente != null ? idcategoriaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaCliente)) {
            return false;
        }
        CategoriaCliente other = (CategoriaCliente) object;
        if ((this.idcategoriaCliente == null && other.idcategoriaCliente != null) || (this.idcategoriaCliente != null && !this.idcategoriaCliente.equals(other.idcategoriaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.CategoriaCliente[ idcategoriaCliente=" + idcategoriaCliente + " ]";
    }
    
}
