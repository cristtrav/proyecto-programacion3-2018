/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.talonarios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author clarapenayo
 */
public class FXMLvistaController implements Initializable {

    @FXML
    private Text txtItsMarket;
    @FXML
    private Text txtNumeroFact;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private TextField txtDomicilioCliente;
    @FXML
    private TextField txtPagoCliente;
    @FXML
    private ChoiceBox<?> cmbCliente;
    @FXML
    private Button buttonAgregarCliente;
    @FXML
    private Text txtTimbradoNunero;
    @FXML
    private Text txtfechainicio;
    @FXML
    private Text txtfechafin;
    @FXML
    private TableColumn<?, ?> tablaCantidad;
    @FXML
    private TableColumn<?, ?> tablaConcepto;
    @FXML
    private TableColumn<?, ?> tablaPrecio;
    @FXML
    private TableColumn<?, ?> tablaImporte;
    @FXML
    private TableColumn<?, ?> tablatotalBruto;
    @FXML
    private TableColumn<?, ?> tablaDescuento;
    @FXML
    private TableColumn<?, ?> tablaIva;
    @FXML
    private TableColumn<?, ?> tablaTotal;
    @FXML
    private TextField txtRucCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnagregar(ActionEvent event) {
    String cliente= cmbCliente.getValue().toString();
    }
    
}
