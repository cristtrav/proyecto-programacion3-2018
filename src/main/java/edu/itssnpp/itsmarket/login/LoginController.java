/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.login;

import edu.itssnpp.itsmarket.MainApp;
import edu.itssnpp.itsmarket.entidades.Empleado;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

    private final ChangeListener<Number> chLnrPosX = (ObservableValue<? extends Number> obs, Number valorAnterior, Number valorNuevo) -> {
        this.loginlabel.setLayoutX((valorNuevo.doubleValue() / 2) - (this.loginlabel.getPrefWidth() / 2));
    };
    private final ChangeListener<Number> chLnrPosY = (ObservableValue<? extends Number> obs, Number valorAnterior, Number valorNuevo) -> {
        this.loginlabel.setLayoutY((valorNuevo.doubleValue() / 2) - (this.loginlabel.getPrefHeight() / 2));
    };
    @FXML
    private TextField usuarioTxt;
    @FXML
    private Button aiudaaaBtn;
    @FXML
    private Button accederBtn;
    @FXML
    private PasswordField contrasenhaTxt;

    /*ayudaaaa
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
    
    @FXML
    private void accederA(ActionEvent event) {
        this.accederBtn.setDisable(false);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Empleado> q = em.createQuery("SELECT tm FROM Empleado tm WHERE tm.ci=:ci", Empleado.class);
        int cedula = Integer.parseInt(usuarioTxt.getText());
        q.setParameter("ci", cedula);
        List<Empleado> rConsulta = q.getResultList();
        if (rConsulta.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Información");
            alert.setHeaderText("No existe Usuario :(");
            alert.setContentText("Usuario no registrado.");
            alert.showAndWait();
        } else {
            Empleado emp = rConsulta.get(0);
            String contrasenha = contrasenhaTxt.getText();
            if (emp.getPassword().equals(contrasenha)) {
                MainApp.VENTANAPRINCIPAL.menuBar.setDisable(false);
                for (Tab t:MainApp.VENTANAPRINCIPAL.tabPane.getTabs()){
                    if(t.getText().equals("Login")){
                        MainApp.VENTANAPRINCIPAL.tabPane.getTabs().remove(t);
                        break;
                    }
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Información");
                alert.setHeaderText("Contraseña incorrecta");
                alert.setContentText("Por favor intentelo nuevamente.");
                alert.showAndWait();
            }
        }
        for (Empleado tm : rConsulta) {
        }
    }
}
