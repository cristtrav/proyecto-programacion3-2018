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
@Table(name = "deposito")
@NamedQueries({
    @NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d")})
public class Deposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddeposito")
    private Integer iddeposito;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deposito1")
    private List<Stock> stockList;

    public Deposito() {
    }

    public Deposito(Integer iddeposito) {
        this.iddeposito = iddeposito;
    }

    public Integer getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(Integer iddeposito) {
        this.iddeposito = iddeposito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddeposito != null ? iddeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.iddeposito == null && other.iddeposito != null) || (this.iddeposito != null && !this.iddeposito.equals(other.iddeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.Deposito[ iddeposito=" + iddeposito + " ]";
    }
    
}
