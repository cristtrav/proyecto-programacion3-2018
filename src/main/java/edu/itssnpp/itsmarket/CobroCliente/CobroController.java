/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.CobroCliente;

import edu.itssnpp.itsmarket.entidades.CuotaVenta;
import java.net.URL;
import java.util.Date;
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

/**
 * FXML Controller class
 *
 * @author kristel
 */
public class CobroController implements Initializable {

    @FXML
    private Button btnagregar;
    @FXML
    private Button btneliminar;
    @FXML
    private Button btneditar;
    @FXML
    private ComboBox<String> combocli;
    @FXML
    private TableView<CuotaVenta> tabla;
    private final ObservableList<CuotaVenta> lsttabla=FXCollections.observableArrayList();
    @FXML
    private TableColumn<CuotaVenta, Date> fepago;
    @FXML
    private TableColumn<CuotaVenta, Date> fevencimiento;
    @FXML
    private TableColumn<CuotaVenta, Boolean> pagado;
    @FXML
    private TableColumn<CuotaVenta, Integer> importe;
    @FXML
    private ComboBox<String> combocuota;
    @FXML
    private TextField txtfactura;
    @FXML
    private TextField txtmonto;
    @FXML
    private TextField txtcedula;
    @FXML
    private DatePicker dppago;
    @FXML
    private DatePicker dpvenc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agregar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void cliente(ActionEvent event) {
    }

    @FXML
    private void cuota(ActionEvent event) {
    }

    @FXML
    private void factura(ActionEvent event) {
    }

    @FXML
    private void monto(ActionEvent event) {
    }


    @FXML
    private void cedula(ActionEvent event) {
    }
    
}
