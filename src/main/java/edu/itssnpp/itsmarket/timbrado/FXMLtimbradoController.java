/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.timbrado;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author clarapenayo
 */
public class FXMLtimbradoController implements Initializable {

    @FXML
    private TextField txttimbrado;
    @FXML
    private TextField txtcodig;
    @FXML
    private TextField txtvencim;
    @FXML
    private TextField txtemision;
    @FXML
    private TextField txtinicio;
    @FXML
    private TextField txtfin;
    @FXML
    private ComboBox<?> cmbcaja;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void caja(ActionEvent event) {
    }
    
}
