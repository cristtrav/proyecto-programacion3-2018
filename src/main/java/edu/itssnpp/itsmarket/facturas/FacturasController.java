/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.facturas;

import edu.itssnpp.itsmarket.entidades.DetalleVenta;
import edu.itssnpp.itsmarket.entidades.Producto;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author equinox766
 */
public class FacturasController implements Initializable {

    @FXML
    private TextField txtsubtotal;
    @FXML
    private TextField txtiva;
    @FXML
    private TextField total;
    @FXML
    private ComboBox<String> ComboCliente;
    @FXML
    private TextField txtRuc;
    @FXML
    private ComboBox<Producto> ComboProd;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidad;
    @FXML
    private Button btnagg;
    @FXML
    private Button btneliminar;
    @FXML
    private TableView<DetalleVenta> tlbventa;
    private final ObservableList<DetalleVenta> lstventa = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn<DetalleVenta, Date> lstfecha;
    @FXML
    private TableColumn<DetalleVenta, String> lstproducto;
    @FXML
    private TableColumn<DetalleVenta, String> lstprecio;
    @FXML
    private TableColumn<DetalleVenta, String> lstcantidad;
    @FXML
    private TableColumn<DetalleVenta, String> lstimporte;
    @FXML
    private Text fecha;
    @FXML
    private DatePicker dpFecha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dpFecha.setValue(LocalDate.now());
        ComboCliente.getItems().addAll("Esteban Dido","Elsa Pito", "Elva Gina", "Elvio Lado", "Elber Galarga");
        Producto p=new Producto();
        
        
        lstfecha.setCellValueFactory(
                new PropertyValueFactory<>("fecha")
        );
        lstproducto.setCellValueFactory(
                new PropertyValueFactory<>("producto")
        );
        lstprecio.setCellValueFactory(
                new PropertyValueFactory<>("precio")
        );
        lstcantidad.setCellValueFactory(
                new PropertyValueFactory<>("cantidad")
        );
        lstimporte.setCellValueFactory(
                new PropertyValueFactory<>("importe")
        );
        
        lstfecha.setCellFactory((TableColumn<DetalleVenta, Date>f)-> new FechaVentaTableCell());
        
        this.tlbventa.setItems(lstventa);
        
    }    

    @FXML
    private void suubtotal(ActionEvent event) {
    }

    @FXML
    private void txtiva(ActionEvent event) {
    }

    @FXML
    private void total(ActionEvent event) {
    }

    @FXML
    private void Cliente(ActionEvent event) {
        String valorcomparar = ComboCliente.getSelectionModel().getSelectedItem();
        if (valorcomparar.equals("Esteban Dido")) {
            txtRuc.clear();
            txtRuc.setText("19216911");
        }
        if (valorcomparar.equals("Elsa Pito")) {
            txtRuc.clear();
            txtRuc.setText("19216912");
        }
        if (valorcomparar.equals("Elva Gina")) {
            txtRuc.clear();
            txtRuc.setText("19216913");
        }
        if (valorcomparar.equals("Elvio Lado")) {
            txtRuc.clear();
            txtRuc.setText("19216914");
        }
        if (valorcomparar.equals("Elber Galarga")) {
            txtRuc.clear();
            txtRuc.setText("19216915");
        }
    }

    @FXML
    private void Ruc(ActionEvent event) {
    }

    @FXML
    private void Producto(ActionEvent event) {
        
        txtCantidad.setText("1");
    }

    @FXML
    private void Precio(ActionEvent event) {
    }

    @FXML
    private void Cantidad(ActionEvent event) {
    }

    @FXML
    private void agg(ActionEvent event) {
        DetalleVenta p = new DetalleVenta();
                
        LocalDate fechaSeleccionada=this.dpFecha.getValue();
        Calendar cal=new GregorianCalendar(fechaSeleccionada.getYear(), fechaSeleccionada.getMonthValue()-1, fechaSeleccionada.getDayOfMonth());
        p.setFecha(cal.getTime());
        Integer cant=Integer.parseInt(this.txtCantidad.getText());
        Integer pu=Integer.parseInt(this.txtPrecio.getText());
        p.setCantidad(cant);
        p.setPrecio(pu);
        p.setImporte(pu*cant);
        p.setProducto(ComboProd.getSelectionModel().getSelectedItem());
        
        
        
        this.lstventa.add(p);
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }
    
}
