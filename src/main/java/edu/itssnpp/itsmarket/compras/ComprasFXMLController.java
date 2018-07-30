/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.compras;

import edu.itssnpp.itsmarket.entidades.Compra;
import edu.itssnpp.itsmarket.entidades.DetalleCompra;
import edu.itssnpp.itsmarket.entidades.Producto;
import edu.itssnpp.itsmarket.entidades.Promocion;
import edu.itssnpp.itsmarket.entidades.Proveedor;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author davidmartinez
 */
public class ComprasFXMLController implements Initializable {
    
    @FXML
    private Button Agregar;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    @FXML
    private Button Eliminar;
    @FXML
    private TableColumn<DetalleCompra,Integer > Cantidad;
    private TableColumn<DetalleCompra,Integer> importe;
    @FXML
    private DatePicker fecha;
    @FXML
    private TableView<DetalleCompra> tabla;
    private Text producto;
    @FXML
    private TextField subtotal;
    private TextField cargar;
    @FXML
    private TextField cantidadCL;
    @FXML
    private TextField importeCL;
    private Button nuevo;
    @FXML
    private Button modificarBT;
    @FXML
    private ComboBox<Producto> comboproducto;
    @FXML
    private TableColumn<DetalleCompra,String> Productos;
    @FXML
    private TableColumn<DetalleCompra,Date > PrecioUnitario;
    @FXML
    private TableColumn<DetalleCompra,Date> Importe;
    
    @FXML
    private TextField Preciounitario;
    @FXML
    private TextField iva;
    @FXML
    private TextField total;
    @FXML
    private ToggleGroup pago;
    @FXML
    private ComboBox<Proveedor> comboproveedor;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargardatos();
        DefaultTableModel lista = new DefaultTableModel();
        cargarproducto();
        comboproducto.setCellFactory((ListView<Producto> n) -> new ProductoListCell());
        comboproducto.setButtonCell(new ProductoListCell());
       
    }    



    @FXML
    private void txtagregar(ActionEvent event) {
         EntityManager em = emf.createEntityManager();
         DetalleCompra c= new DetalleCompra();
         Compra com= new Compra();
         Calendar cal=new GregorianCalendar(fecha.getValue().getYear(), fecha.getValue().getMonthValue()-1, fecha.getValue().getDayOfMonth());
         Integer ca = Integer.parseInt(this.cantidadCL.getText());
         Integer pu = Integer.parseInt(this.Preciounitario.getText());
         c.setProducto(comboproducto.getSelectionModel().getSelectedItem());
         c.setPrecioUnitario(pu);
         Preciounitario.clear();
         c.setCantidad(ca.toString());
         cantidadCL.clear();
         c.setImporte(ca*pu);
         com.setFecha(cal.getTime());
   
    }

    @FXML
    private void txteliminar(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        tabla.getSelectionModel().getSelectedItem();
        em.getTransaction().begin();
        em.remove(em.merge(tabla.getSelectionModel().getSelectedItem()));
        em.getTransaction().commit();
        cargardatos();
    
    }



    private void cargardatos() {
       
    }

    @FXML
    private void modificar(ActionEvent event) {
           
    }
    private void cargarproducto(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Producto> q = em.createQuery("SELECT tm FROM Producto tm", Producto.class);
        comboproducto.getItems().clear();
        comboproducto.getItems().addAll(q.getResultList());
    }

    @FXML
    private void SeleccionarProductos(MouseEvent event) {
        EntityManager em = emf.createEntityManager();
        DetalleCompra dc = tabla.getSelectionModel().getSelectedItem();
        cantidadCL.setText(dc.getCantidad());
        importeCL.setText(dc.getPrecioUnitario().toString());
        
    }
    private void cargarproveedor(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Proveedor> q = em.createQuery("SELECT tm FROM Proveedor tm", Proveedor.class);
        comboproveedor.getItems().clear();
        comboproveedor.getItems().addAll(q.getResultList());
}
}
