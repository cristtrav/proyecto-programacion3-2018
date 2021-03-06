
package edu.itssnpp.itsmarket.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author traver
 */
@Entity
@Table(name = "funcionalidad")
@NamedQueries({
    @NamedQuery(name = "Funcionalidad.findAll", query = "SELECT f FROM Funcionalidad f")})
public class Funcionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfuncionalidad")
    private Integer idfuncionalidad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "funcionalidadList")
    private List<Empleado> empleadoList;
    @JoinColumn(name = "modulo", referencedColumnName = "idmodulo")
    @ManyToOne(optional = false)
    private Modulo modulo;

    public Funcionalidad() {
    }

    public Funcionalidad(Integer idfuncionalidad) {
        this.idfuncionalidad = idfuncionalidad;
    }

    public Funcionalidad(Integer idfuncionalidad, String nombre) {
        this.idfuncionalidad = idfuncionalidad;
        this.nombre = nombre;
    }

    public Integer getIdfuncionalidad() {
        return idfuncionalidad;
    }

    public void setIdfuncionalidad(Integer idfuncionalidad) {
        this.idfuncionalidad = idfuncionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionalidad != null ? idfuncionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidad)) {
            return false;
        }
        Funcionalidad other = (Funcionalidad) object;
        if ((this.idfuncionalidad == null && other.idfuncionalidad != null) || (this.idfuncionalidad != null && !this.idfuncionalidad.equals(other.idfuncionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.Funcionalidad[ idfuncionalidad=" + idfuncionalidad + " ]";
    }  
}
