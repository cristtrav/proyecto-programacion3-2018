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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ivan
 */
public class FXMLabrircajaController implements Initializable {

    @FXML
    private TextField montoinicial2;
    @FXML
    private Button abrircaja2;
    @FXML
    private Button cancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        montoinicial2.getText();
    }    

    @FXML
    private void abrircaja2(ActionEvent event) {
    }

    @FXML
    private void cancelar2(ActionEvent event) {
    }
    
}
