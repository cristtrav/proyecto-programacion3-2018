/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.caja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author ivan
 */
public class FXMLcajaController implements Initializable {

    @FXML
    private Tab cajaactual;
    @FXML
    private Button abrircaja;
    @FXML
    private Button retirardinero;
    @FXML
    private Button cerrarcaja;
    @FXML
    private TableColumn<?, ?> montoinicial;
    @FXML
    private TableColumn<?, ?> montofial;
    @FXML
    private TableColumn<?, ?> nrocaja;
    @FXML
    private TableColumn<?, ?> fechahoraapertura;
    @FXML
    private TableColumn<?, ?> fechahoracierre;
    @FXML
    private Tab detallemovi;
    @FXML
    private TableView<?> tl_Detalle;
    @FXML
    private TableColumn<?, ?> detamonto;
    @FXML
    private TableColumn<?, ?> detanrocaja;
    @FXML
    private TableColumn<?, ?> mediodepago;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrircaja(ActionEvent event) {
    }

    @FXML
    private void retirardinero(ActionEvent event) {
    }

    @FXML
    private void cerrarcaja(ActionEvent event) {
    }
    
}
