/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.compras;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author davidmartinez
 */
public class ComprasFXMLController implements Initializable {

    @FXML
    private Text FACTURA;
    @FXML
    private Button Agregar;
    @FXML
    private Button Eliminar;
    @FXML
    private TableColumn<?, ?> Producto;
    @FXML
    private TableColumn<?, ?> Precio;
    @FXML
    private TableColumn<?, ?> Cantidad;
    @FXML
    private TableColumn<?, ?> importe;
    @FXML
    private Text proveedor;
    @FXML
    private Text fecha;
    @FXML
    private MenuButton menuprovee;
    @FXML
    private TableView<?> tabla;
    @FXML
    private Text pago;
    @FXML
    private MenuButton pagos;
    @FXML
    private Label numero;
    @FXML
    private Text producto;
    @FXML
    private MenuButton productos;
    @FXML
    private Text subtotal;
    @FXML
    private Text iva;
    @FXML
    private Text total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    

    @FXML
    private void menprovee(ActionEvent event) {
        
    }

    @FXML
    private void agregar(ActionEvent event) {
        
    }

    @FXML
    private void eliminar(ActionEvent event) {
        
    }

    @FXML
    private void pagos(ActionEvent event) {
        
    }

    @FXML
    private void producto(ActionEvent event) {
        
    }

    @FXML
    private void fecha(ActionEvent event) {
        
    }
    
}
