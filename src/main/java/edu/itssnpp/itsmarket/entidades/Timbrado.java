
package edu.itssnpp.itsmarket.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "timbrado")
@NamedQueries({
    @NamedQuery(name = "Timbrado.findAll", query = "SELECT t FROM Timbrado t")})
public class Timbrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "timbrado")
    private Integer timbrado;
    @Column(name = "codigo_establecimiento")
    private Integer codigoEstablecimiento;
    @Column(name = "codigo_caja")
    private Integer codigoCaja;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "nro_inicio")
    private Integer nroInicio;
    @Column(name = "nro_fin")
    private Integer nroFin;
    @Column(name = "ult_numero")
    private String ultNumero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timbrado")
    private List<MovimientoCaja> movimientoCajaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timbrado")
    private List<Venta> ventaList;

    public Timbrado() {
    }

    public Timbrado(Integer timbrado) {
        this.timbrado = timbrado;
    }

    public Integer getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(Integer timbrado) {
        this.timbrado = timbrado;
    }

    public Integer getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public Integer getCodigoCaja() {
        return codigoCaja;
    }

    public void setCodigoCaja(Integer codigoCaja) {
        this.codigoCaja = codigoCaja;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getNroInicio() {
        return nroInicio;
    }

    public void setNroInicio(Integer nroInicio) {
        this.nroInicio = nroInicio;
    }

    public Integer getNroFin() {
        return nroFin;
    }

    public void setNroFin(Integer nroFin) {
        this.nroFin = nroFin;
    }

    public String getUltNumero() {
        return ultNumero;
    }

    public void setUltNumero(String ultNumero) {
        this.ultNumero = ultNumero;
    }

    public List<MovimientoCaja> getMovimientoCajaList() {
        return movimientoCajaList;
    }

    public void setMovimientoCajaList(List<MovimientoCaja> movimientoCajaList) {
        this.movimientoCajaList = movimientoCajaList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timbrado != null ? timbrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timbrado)) {
            return false;
        }
        Timbrado other = (Timbrado) object;
        if ((this.timbrado == null && other.timbrado != null) || (this.timbrado != null && !this.timbrado.equals(other.timbrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.Timbrado[ timbrado=" + timbrado + " ]";
    }
    
}
