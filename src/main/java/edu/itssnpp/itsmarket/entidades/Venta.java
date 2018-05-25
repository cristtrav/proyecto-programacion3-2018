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
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventa")
    private Integer idventa;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @Column(name = "contado")
    private Boolean contado;
    @Column(name = "nro_factura")
    private Integer nroFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<CuotaVenta> cuotaVentaList;
    @JoinColumn(name = "cliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "empleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "timbrado", referencedColumnName = "timbrado")
    @ManyToOne(optional = false)
    private Timbrado timbrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<DetalleVenta> detalleVentaList;

    public Venta() {
    }

    public Venta(Integer idventa) {
        this.idventa = idventa;
    }

    public Venta(Integer idventa, int total) {
        this.idventa = idventa;
        this.total = total;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public List<CuotaVenta> getCuotaVentaList() {
        return cuotaVentaList;
    }

    public void setCuotaVentaList(List<CuotaVenta> cuotaVentaList) {
        this.cuotaVentaList = cuotaVentaList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Timbrado getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(Timbrado timbrado) {
        this.timbrado = timbrado;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.Venta[ idventa=" + idventa + " ]";
    }
    
}
