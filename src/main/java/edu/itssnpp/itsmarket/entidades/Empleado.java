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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author traver
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "ci")
    private Integer ci;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @JoinTable(name = "permiso", joinColumns = {
        @JoinColumn(name = "empleado", referencedColumnName = "idempleado")}, inverseJoinColumns = {
        @JoinColumn(name = "funcionalidad", referencedColumnName = "idfuncionalidad")})
    @ManyToMany
    private List<Funcionalidad> funcionalidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<MovimientoCaja> movimientoCajaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Compra> compraList;
    @JoinColumn(name = "cargo", referencedColumnName = "idcargo")
    @ManyToOne(optional = false)
    private Cargo cargo;
    @JoinColumn(name = "ciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Venta> ventaList;

    public Empleado() {
    }

    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Funcionalidad> getFuncionalidadList() {
        return funcionalidadList;
    }

    public void setFuncionalidadList(List<Funcionalidad> funcionalidadList) {
        this.funcionalidadList = funcionalidadList;
    }

    public List<MovimientoCaja> getMovimientoCajaList() {
        return movimientoCajaList;
    }

    public void setMovimientoCajaList(List<MovimientoCaja> movimientoCajaList) {
        this.movimientoCajaList = movimientoCajaList;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.itssnpp.itsmarket.entidades.Empleado[ idempleado=" + idempleado + " ]";
    }
    
}
