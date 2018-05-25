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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author traver
 */
@Entity
@Table(name = "medio_pago")
@NamedQueries({
    @NamedQuery(name = "MedioPago.findAll", query = "SELECT m FROM MedioPago m")})
public class MedioPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedio_pago")
    private Integer idmedioPago;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "detalle_medio_pago", joinColumns = {
        @JoinColumn(name = "medio_pago", referencedColumnName = "idmedio_pago")}, inverseJoinColumns = {
        @JoinColumn(name = "promocion", referencedColumnName = "idpromocion")})
    @ManyToMany
    private List<Promocion> promocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medioPago")
    private List<DetalleCobro> detalleCobroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medioPago")
    private List<DetallePago> detallePagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medioPago")
    private List<DetalleMovimientoCaja> detalleMovimientoCajaList;

    public MedioPago() {
    }

    public MedioPago(Integer idmedioPago) {
        this.idmedioPago = idmedioPago;
    }

    public MedioPago(Integer idmedioPago, String nombre) {
        this.idmedioPago = idmedioPago;
        this.nombre = nombre;
    }

    public Integer getIdmedioPago() {
        return idmedioPago;
    }

    public void setIdmedioPago(Integer idmedioPago) {
        this.idmedioPago = idmedioPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    public List<DetalleCobro> getDetalleCobroList() {
        return detalleCobroList;
    }

    public void setDetalleCobroList(List<DetalleCobro> detalleCobroList) {
        this.detalleCobroList = detalleCobroList;
    }

    public List<DetallePago> getDetallePagoList() {
        return detallePagoList;
    }

    public void setDetallePagoList(List<DetallePago> detallePagoList) {
        this.detallePagoList = detallePagoList;
    }

    public List<DetalleMovimientoCaja> getDetalleMovimientoCajaList() {
        return detalleMovimientoCajaList;
    }

    public void setDetalleMovimientoCajaList(List<DetalleMovimientoCaja> detalleMovimientoCajaList) {
        this.detalleMovimientoCajaList = detalleMovimientoCajaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedioPago != null ? idmedioPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioPago)) {
            return false;
        }
        MedioPago other = (MedioPago) object;
        if ((this.idmedioPago == null && other.idmedioPago != null) || (this.idmedioPago != null && !this.idmedioPago.equals(other.idmedioPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.MedioPago[ idmedioPago=" + idmedioPago + " ]";
    }
    
}
