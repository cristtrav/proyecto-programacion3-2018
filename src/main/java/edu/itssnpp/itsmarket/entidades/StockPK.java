/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author traver
 */
@Embeddable
public class StockPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "producto")
    private int producto;
    @Basic(optional = false)
    @Column(name = "deposito")
    private int deposito;

    public StockPK() {
    }

    public StockPK(int producto, int deposito) {
        this.producto = producto;
        this.deposito = deposito;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getDeposito() {
        return deposito;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) producto;
        hash += (int) deposito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockPK)) {
            return false;
        }
        StockPK other = (StockPK) object;
        if (this.producto != other.producto) {
            return false;
        }
        if (this.deposito != other.deposito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.StockPK[ producto=" + producto + ", deposito=" + deposito + " ]";
    }
    
}
