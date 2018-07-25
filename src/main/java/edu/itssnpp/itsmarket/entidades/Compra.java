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
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")})
public class Compra implements Serializable {

    @Column(name = "total")
    private Integer total;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompra")
    private Integer idcompra;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "contado")
    private Boolean contado;
    @Column(name = "nro_factura")
    private Integer nroFactura;
    @Column(name = "cod_establecimiento")
    private Integer codEstablecimiento;
    @Column(name = "cod_caja")
    private Integer codCaja;
    @Column(name = "pagado")
    private Boolean pagado;
    @JoinColumn(name = "empleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "proveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<DetalleCompra> detalleCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<CuotaCompra> cuotaCompraList;

    public Compra() {
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Boolean getContado() {
        return contado;
    }

    public void setContado(Boolean contado) {
        this.contado = contado;
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Integer getCodEstablecimiento() {
        return codEstablecimiento;
    }

    public void setCodEstablecimiento(Integer codEstablecimiento) {
        this.codEstablecimiento = codEstablecimiento;
    }

    public Integer getCodCaja() {
        return codCaja;
    }

    public void setCodCaja(Integer codCaja) {
        this.codCaja = codCaja;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleCompra> getDetalleCompraList() {
        return detalleCompraList;
    }

    public void setDetalleCompraList(List<DetalleCompra> detalleCompraList) {
        this.detalleCompraList = detalleCompraList;
    }

    public List<CuotaCompra> getCuotaCompraList() {
        return cuotaCompraList;
    }

    public void setCuotaCompraList(List<CuotaCompra> cuotaCompraList) {
        this.cuotaCompraList = cuotaCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.Compra[ idcompra=" + idcompra + " ]";
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
}
