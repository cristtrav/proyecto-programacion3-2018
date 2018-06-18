/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.pago_proveedores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mathias
 */
public class Pago_proveedorController implements Initializable {

    @FXML
    private Button btnpagar;
    @FXML
    private TextField txtmontoapagar;
    @FXML
    private SplitMenuButton cargaproveedores;
    @FXML
    private TableView<?> tablaproductos;
    @FXML
    private TableColumn<?, ?> columnafactura;
    @FXML
    private TableColumn<?, ?> colu_fecha;
    @FXML
    private TableColumn<?, ?> colu_monto;
    @FXML
    private Button btneliminar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO.kljnljn
    }    

    @FXML
    private void pagar(ActionEvent event) {
    }

    @FXML
    private void montoapagar(ActionEvent event) {
    }


    @FXML
    private void cargoproveedores(ActionEvent event) {
    }

    @FXML
    private void eliminarfact(ActionEvent event) {
    }
    
}
