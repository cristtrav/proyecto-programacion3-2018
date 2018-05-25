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
@Table(name = "cuota_compra")
@NamedQueries({
    @NamedQuery(name = "CuotaCompra.findAll", query = "SELECT c FROM CuotaCompra c")})
public class CuotaCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Integer idpago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "pagado")
    private Boolean pagado;
    @Basic(optional = false)
    @Column(name = "monto_cuota")
    private int montoCuota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuotaCompra")
    private List<DetallePago> detallePagoList;
    @JoinColumn(name = "compra", referencedColumnName = "idcompra")
    @ManyToOne(optional = false)
    private Compra compra;

    public CuotaCompra() {
    }

    public CuotaCompra(Integer idpago) {
        this.idpago = idpago;
    }

    public CuotaCompra(Integer idpago, int montoCuota) {
        this.idpago = idpago;
        this.montoCuota = montoCuota;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
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

    public int getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(int montoCuota) {
        this.montoCuota = montoCuota;
    }

    public List<DetallePago> getDetallePagoList() {
        return detallePagoList;
    }

    public void setDetallePagoList(List<DetallePago> detallePagoList) {
        this.detallePagoList = detallePagoList;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuotaCompra)) {
            return false;
        }
        CuotaCompra other = (CuotaCompra) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.CuotaCompra[ idpago=" + idpago + " ]";
    }
    
}
