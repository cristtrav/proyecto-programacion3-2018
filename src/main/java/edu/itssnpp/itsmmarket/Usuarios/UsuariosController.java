/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmmarket.Usuarios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author aldo
 */
public class UsuariosController implements Initializable {

    @FXML
    private TextField txtusuario;
    @FXML
    private PasswordField txtpsw;
    @FXML
    private PasswordField txtpasw2;
    @FXML
    private TextField txtnombre;
    @FXML
    private TextField txtelefono;
    @FXML
    private Button btnregistrar;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String Usuario = "Admin";
        String Contraseña = "1234";
        
        String txtpsw = new String(txtpsw.gettextpsw());
        if(txtusuario.getText().equals(Usuario) && txtpsw.equals(Contraseña)){
            }
    }    
    

