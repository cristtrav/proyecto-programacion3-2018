/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "stock")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockPK stockPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @JoinColumn(name = "deposito", referencedColumnName = "iddeposito", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Deposito deposito1;
    @JoinColumn(name = "producto", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto1;

    public Stock() {
    }

    public Stock(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public Stock(int producto, int deposito) {
        this.stockPK = new StockPK(producto, deposito);
    }

    public StockPK getStockPK() {
        return stockPK;
    }

    public void setStockPK(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Deposito getDeposito1() {
        return deposito1;
    }

    public void setDeposito1(Deposito deposito1) {
        this.deposito1 = deposito1;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockPK != null ? stockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockPK == null && other.stockPK != null) || (this.stockPK != null && !this.stockPK.equals(other.stockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.Stock[ stockPK=" + stockPK + " ]";
    }
    
}
