/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author traver
 */
@Entity
@Table(name = "cuota_venta")
@NamedQueries({
    @NamedQuery(name = "CuotaVenta.findAll", query = "SELECT c FROM CuotaVenta c")})
public class CuotaVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuota_venta")
    private Integer idcuotaVenta;
    @Column(name = "fecha_cobro")
    @Temporal(TemporalType.DATE)
    private Date fechaCobro;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "pagado")
    private Boolean pagado;
    @Column(name = "monto_cuota")
    private Integer montoCuota;
    @JoinColumn(name = "venta", referencedColumnName = "idventa")
    @ManyToOne(optional = false)
    private Venta venta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuotaVenta")
    private List<DetalleCobro> detalleCobroList;

    public CuotaVenta() {
    }

    public CuotaVenta(Integer idcuotaVenta) {
        this.idcuotaVenta = idcuotaVenta;
    }

    public Integer getIdcuotaVenta() {
        return idcuotaVenta;
    }

    public void setIdcuotaVenta(Integer idcuotaVenta) {
        this.idcuotaVenta = idcuotaVenta;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public Integer getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(Integer montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<DetalleCobro> getDetalleCobroList() {
        return detalleCobroList;
    }

    public void setDetalleCobroList(List<DetalleCobro> detalleCobroList) {
        this.detalleCobroList = detalleCobroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuotaVenta != null ? idcuotaVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaVenta)) {
            return false;
        }
        CuotaVenta other = (CuotaVenta) object;
        if ((this.idcuotaVenta == null && other.idcuotaVenta != null) || (this.idcuotaVenta != null && !this.idcuotaVenta.equals(other.idcuotaVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.CuotaVenta[ idcuotaVenta=" + idcuotaVenta + " ]";
    }
    
}
