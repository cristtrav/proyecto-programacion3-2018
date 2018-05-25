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
@Table(name = "detalle_pago")
@NamedQueries({
    @NamedQuery(name = "DetallePago.findAll", query = "SELECT d FROM DetallePago d")})
public class DetallePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_pago")
    private Integer iddetallePago;
    @Column(name = "monto")
    private Integer monto;
    @JoinColumn(name = "cuota_compra", referencedColumnName = "idpago")
    @ManyToOne(optional = false)
    private CuotaCompra cuotaCompra;
    @JoinColumn(name = "medio_pago", referencedColumnName = "idmedio_pago")
    @ManyToOne(optional = false)
    private MedioPago medioPago;

    public DetallePago() {
    }

    public DetallePago(Integer iddetallePago) {
        this.iddetallePago = iddetallePago;
    }

    public Integer getIddetallePago() {
        return iddetallePago;
    }

    public void setIddetallePago(Integer iddetallePago) {
        this.iddetallePago = iddetallePago;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public CuotaCompra getCuotaCompra() {
        return cuotaCompra;
    }

    public void setCuotaCompra(CuotaCompra cuotaCompra) {
        this.cuotaCompra = cuotaCompra;
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
        hash += (iddetallePago != null ? iddetallePago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePago)) {
            return false;
        }
        DetallePago other = (DetallePago) object;
        if ((this.iddetallePago == null && other.iddetallePago != null) || (this.iddetallePago != null && !this.iddetallePago.equals(other.iddetallePago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.DetallePago[ iddetallePago=" + iddetallePago + " ]";
    }
    
}
