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
@Table(name = "unidad_medida")
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u")})
public class UnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidad_medida")
    private Integer idunidadMedida;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "divisible")
    private Boolean divisible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedida")
    private List<Producto> productoList;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer idunidadMedida) {
        this.idunidadMedida = idunidadMedida;
    }

    public UnidadMedida(Integer idunidadMedida, String nombre) {
        this.idunidadMedida = idunidadMedida;
        this.nombre = nombre;
    }

    public Integer getIdunidadMedida() {
        return idunidadMedida;
    }

    public void setIdunidadMedida(Integer idunidadMedida) {
        this.idunidadMedida = idunidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDivisible() {
        return divisible;
    }

    public void setDivisible(Boolean divisible) {
        this.divisible = divisible;
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
        hash += (idunidadMedida != null ? idunidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idunidadMedida == null && other.idunidadMedida != null) || (this.idunidadMedida != null && !this.idunidadMedida.equals(other.idunidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.UnidadMedida[ idunidadMedida=" + idunidadMedida + " ]";
    }
    
}
