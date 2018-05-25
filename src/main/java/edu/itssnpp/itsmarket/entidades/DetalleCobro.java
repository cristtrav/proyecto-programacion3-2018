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
@Table(name = "detalle_cobro")
@NamedQueries({
    @NamedQuery(name = "DetalleCobro.findAll", query = "SELECT d FROM DetalleCobro d")})
public class DetalleCobro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_cobro")
    private Integer iddetalleCobro;
    @Column(name = "monto")
    private Integer monto;
    @JoinColumn(name = "cuota_venta", referencedColumnName = "idcuota_venta")
    @ManyToOne(optional = false)
    private CuotaVenta cuotaVenta;
    @JoinColumn(name = "medio_pago", referencedColumnName = "idmedio_pago")
    @ManyToOne(optional = false)
    private MedioPago medioPago;

    public DetalleCobro() {
    }

    public DetalleCobro(Integer iddetalleCobro) {
        this.iddetalleCobro = iddetalleCobro;
    }

    public Integer getIddetalleCobro() {
        return iddetalleCobro;
    }

    public void setIddetalleCobro(Integer iddetalleCobro) {
        this.iddetalleCobro = iddetalleCobro;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public CuotaVenta getCuotaVenta() {
        return cuotaVenta;
    }

    public void setCuotaVenta(CuotaVenta cuotaVenta) {
        this.cuotaVenta = cuotaVenta;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleCobro != null ? iddetalleCobro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCobro)) {
            return false;
        }
        DetalleCobro other = (DetalleCobro) object;
        if ((this.iddetalleCobro == null && other.iddetalleCobro != null) || (this.iddetalleCobro != null && !this.iddetalleCobro.equals(other.iddetalleCobro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.DetalleCobro[ iddetalleCobro=" + iddetalleCobro + " ]";
    }
    
}
