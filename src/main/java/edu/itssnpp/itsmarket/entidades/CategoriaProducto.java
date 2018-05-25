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
@Table(name = "categoria_producto")
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c")})
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoria_producto")
    private Integer idcategoriaProducto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaProducto")
    private List<Producto> productoList;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer idcategoriaProducto) {
        this.idcategoriaProducto = idcategoriaProducto;
    }

    public CategoriaProducto(Integer idcategoriaProducto, String nombre) {
        this.idcategoriaProducto = idcategoriaProducto;
        this.nombre = nombre;
    }

    public Integer getIdcategoriaProducto() {
        return idcategoriaProducto;
    }

    public void setIdcategoriaProducto(Integer idcategoriaProducto) {
        this.idcategoriaProducto = idcategoriaProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoriaProducto != null ? idcategoriaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProducto)) {
            return false;
        }
        CategoriaProducto other = (CategoriaProducto) object;
        if ((this.idcategoriaProducto == null && other.idcategoriaProducto != null) || (this.idcategoriaProducto != null && !this.idcategoriaProducto.equals(other.idcategoriaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.CategoriaProducto[ idcategoriaProducto=" + idcategoriaProducto + " ]";
    }
    
}
