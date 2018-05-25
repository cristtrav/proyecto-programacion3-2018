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
@Table(name = "detalle_movimiento_caja")
@NamedQueries({
    @NamedQuery(name = "DetalleMovimientoCaja.findAll", query = "SELECT d FROM DetalleMovimientoCaja d")})
public class DetalleMovimientoCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_movimiento_caja")
    private Integer iddetalleMovimientoCaja;
    @Column(name = "monto")
    private Integer monto;
    @Column(name = "ingreso")
    private Boolean ingreso;
    @JoinColumn(name = "medio_pago", referencedColumnName = "idmedio_pago")
    @ManyToOne(optional = false)
    private MedioPago medioPago;
    @JoinColumn(name = "movimiento_caja", referencedColumnName = "idmovimiento_caja")
    @ManyToOne(optional = false)
    private MovimientoCaja movimientoCaja;

    public DetalleMovimientoCaja() {
    }

    public DetalleMovimientoCaja(Integer iddetalleMovimientoCaja) {
        this.iddetalleMovimientoCaja = iddetalleMovimientoCaja;
    }

    public Integer getIddetalleMovimientoCaja() {
        return iddetalleMovimientoCaja;
    }

    public void setIddetalleMovimientoCaja(Integer iddetalleMovimientoCaja) {
        this.iddetalleMovimientoCaja = iddetalleMovimientoCaja;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public MovimientoCaja getMovimientoCaja() {
        return movimientoCaja;
    }

    public void setMovimientoCaja(MovimientoCaja movimientoCaja) {
        this.movimientoCaja = movimientoCaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleMovimientoCaja != null ? iddetalleMovimientoCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMovimientoCaja)) {
            return false;
        }
        DetalleMovimientoCaja other = (DetalleMovimientoCaja) object;
        if ((this.iddetalleMovimientoCaja == null && other.iddetalleMovimientoCaja != null) || (this.iddetalleMovimientoCaja != null && !this.iddetalleMovimientoCaja.equals(other.iddetalleMovimientoCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.DetalleMovimientoCaja[ iddetalleMovimientoCaja=" + iddetalleMovimientoCaja + " ]";
    }
    
}
