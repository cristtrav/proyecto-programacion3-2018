/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hugo
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane login;
    @FXML
    private AnchorPane loginlabel;
    @FXML
    private Button acceder;
    @FXML
    private PasswordField contraseña;
    @FXML
    private TextField usuario;

    private Image img;

    private final ChangeListener<Number> chLnrPosX = (ObservableValue<? extends Number> obs, Number valorAnterior, Number valorNuevo) -> {
        this.loginlabel.setLayoutX((valorNuevo.doubleValue() / 2) - (this.loginlabel.getPrefWidth() / 2));
    };
    private final ChangeListener<Number> chLnrPosY = (ObservableValue<? extends Number> obs, Number valorAnterior, Number valorNuevo) -> {
        this.loginlabel.setLayoutY((valorNuevo.doubleValue() / 2) - (this.loginlabel.getPrefHeight() / 2));
    };
    @FXML
    private Button aiudaaa;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.login.widthProperty().addListener(this.chLnrPosX);
        this.login.heightProperty().addListener(this.chLnrPosY);
        
    }

    @FXML
    private void ayuda(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("¿Necesita ayuda?");
        alert.setContentText("Por favor contacte al Administrador.");
        alert.showAndWait();
    }

}
