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
@Table(name = "movimiento_caja")
@NamedQueries({
    @NamedQuery(name = "MovimientoCaja.findAll", query = "SELECT m FROM MovimientoCaja m")})
public class MovimientoCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimiento_caja")
    private Integer idmovimientoCaja;
    @Column(name = "monto_inicial")
    private Integer montoInicial;
    @Column(name = "monto_final")
    private Integer montoFinal;
    @Column(name = "nro_caja")
    private Integer nroCaja;
    @Column(name = "fecha_hora_apertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraApertura;
    @Column(name = "fecha_hora_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCierre;
    @Column(name = "cerrado")
    private Boolean cerrado;
    @JoinColumn(name = "empleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "timbrado", referencedColumnName = "timbrado")
    @ManyToOne(optional = false)
    private Timbrado timbrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movimientoCaja")
    private List<DetalleMovimientoCaja> detalleMovimientoCajaList;

    public MovimientoCaja() {
    }

    public MovimientoCaja(Integer idmovimientoCaja) {
        this.idmovimientoCaja = idmovimientoCaja;
    }

    public Integer getIdmovimientoCaja() {
        return idmovimientoCaja;
    }

    public void setIdmovimientoCaja(Integer idmovimientoCaja) {
        this.idmovimientoCaja = idmovimientoCaja;
    }

    public Integer getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Integer montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Integer getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Integer montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Integer getNroCaja() {
        return nroCaja;
    }

    public void setNroCaja(Integer nroCaja) {
        this.nroCaja = nroCaja;
    }

    public Date getFechaHoraApertura() {
        return fechaHoraApertura;
    }

    public void setFechaHoraApertura(Date fechaHoraApertura) {
        this.fechaHoraApertura = fechaHoraApertura;
    }

    public Date getFechaHoraCierre() {
        return fechaHoraCierre;
    }

    public void setFechaHoraCierre(Date fechaHoraCierre) {
        this.fechaHoraCierre = fechaHoraCierre;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
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

    public List<DetalleMovimientoCaja> getDetalleMovimientoCajaList() {
        return detalleMovimientoCajaList;
    }

    public void setDetalleMovimientoCajaList(List<DetalleMovimientoCaja> detalleMovimientoCajaList) {
        this.detalleMovimientoCajaList = detalleMovimientoCajaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimientoCaja != null ? idmovimientoCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoCaja)) {
            return false;
        }
        MovimientoCaja other = (MovimientoCaja) object;
        if ((this.idmovimientoCaja == null && other.idmovimientoCaja != null) || (this.idmovimientoCaja != null && !this.idmovimientoCaja.equals(other.idmovimientoCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.MovimientoCaja[ idmovimientoCaja=" + idmovimientoCaja + " ]";
    }
    
}
