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


/**
 * FXML Controller class
 *
 * @author ivan
 */
public class FXMLcajaController implements Initializable {

    @FXML
    private Button abrircaja;
    
    @FXML
    private Button retirardinero;
    @FXML
    private Button cerrarcaja;
    @FXML
    private Tab cajaactual;
    @FXML
    private Tab cajaanterior;

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
    private void cerrarcaja(ActionEvent event) {
    }


}