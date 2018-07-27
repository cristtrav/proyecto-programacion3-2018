/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.facturas;

import edu.itssnpp.itsmarket.entidades.Cliente;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
    private ComboBox<Cliente> ComboCliente;
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        this.ComboProd.setCellFactory((ListView<Producto> p) -> new ProductoListCell());
        this.ComboProd.setButtonCell(new ProductoListCell());

        TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p", Producto.class);
        this.ComboProd.getItems().addAll(q.getResultList());
   
        
        this.ComboCliente.setCellFactory((ListView<Cliente> p) -> new ClienteLIstCell());
        this.ComboCliente.setButtonCell(new ClienteLIstCell());

        TypedQuery<Cliente> e = em.createQuery("SELECT p FROM Cliente p", Cliente.class);
        this.ComboCliente.getItems().addAll(e.getResultList());
        

        lstfecha.setCellValueFactory(
                new PropertyValueFactory<>("fecha"));
        lstproducto.setCellValueFactory(
                new PropertyValueFactory<>("producto"));
        lstprecio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));
        lstcantidad.setCellValueFactory(
                new PropertyValueFactory<>("cantidad"));
        lstimporte.setCellValueFactory(
                new PropertyValueFactory<>("importe"));
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
        String ruc = this.ComboCliente.getValue().getCi()+"-"+this.ComboCliente.getValue().getDvRuc();
        txtRuc.setText(ruc);
        
        
        
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
        Integer precio = this.ComboProd.getValue().getPrecioVenta();
        txtPrecio.setText(precio +"");
    }

    @FXML
    private void Cantidad(ActionEvent event) {
    }

    @FXML
    private void agg(ActionEvent event) {
        DetalleVenta p = new DetalleVenta();

        LocalDate fechaSeleccionada = this.dpFecha.getValue();
        Calendar cal = new GregorianCalendar(fechaSeleccionada.getYear(), fechaSeleccionada.getMonthValue() - 1, fechaSeleccionada.getDayOfMonth());
        p.setFecha(cal.getTime());
        Integer cant = Integer.parseInt(this.txtCantidad.getText());
        Integer pu = Integer.parseInt(this.txtPrecio.getText());
        p.setCantidad(cant);
        p.setPrecio(pu);
        p.setImporte(pu * cant);
        p.setProducto(ComboProd.getSelectionModel().getSelectedItem());
       
        this.lstventa.add(p);

        txtPrecio.setText("0");
        txtRuc.setText("0");
        txtCantidad.setText("0");
        ComboCliente.getSelectionModel().clearAndSelect(0);
        ComboProd.getSelectionModel().clearAndSelect(0);
        this.sumarSubtotal();
    }

    @FXML
    private void eliminar(ActionEvent event) {
        
        
    }

    private void sumarSubtotal() {
        int subtotal = 0;
        for (DetalleVenta dv : this.tlbventa.getItems()) {
            subtotal = subtotal + dv.getPrecioUnitario();

        }
        this.txtsubtotal.setText(subtotal + "");
    }

    private void restar() {
        int resta = 0;
        for (DetalleVenta dv : this.tlbventa.getItems()) {
            resta = -resta + dv.getPrecioUnitario();

        }
        this.txtsubtotal.setText(resta + "");
    }

}
