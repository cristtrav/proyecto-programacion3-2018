/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author traver
 */
@Entity
@Table(name = "detalle_compra")
@NamedQueries({
    @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d")})
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_compra")
    private Integer iddetalleCompra;
    @Column(name = "cantidad")
    private String cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_iva")
    private Float porcentajeIva;
    @Column(name = "precio_unitario")
    private Integer precioUnitario;
    @Column(name = "subtotal")
    private Integer subtotal;
    @JoinColumn(name = "compra", referencedColumnName = "idcompra")
    @ManyToOne(optional = false)
    private Compra compra;
    @JoinColumn(name = "producto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto producto;

    public DetalleCompra() {
    }

    public DetalleCompra(Integer iddetalleCompra) {
        this.iddetalleCompra = iddetalleCompra;
    }

    public Integer getIddetalleCompra() {
        return iddetalleCompra;
    }

    public void setIddetalleCompra(Integer iddetalleCompra) {
        this.iddetalleCompra = iddetalleCompra;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(Float porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleCompra != null ? iddetalleCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.iddetalleCompra == null && other.iddetalleCompra != null) || (this.iddetalleCompra != null && !this.iddetalleCompra.equals(other.iddetalleCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.DetalleCompra[ iddetalleCompra=" + iddetalleCompra + " ]";
    }
    
}
