/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.categoria;

import edu.itssnpp.itsmarket.entidades.CategoriaProducto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author User
 */
public class VistacategoriaController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private AnchorPane secundario;
    @FXML
    private ListView<CategoriaProducto> lista;
    @FXML
    private Button crear;
    @FXML
    private Button eliminar;
    @FXML
    private TextField buscar;
    @FXML
    private TextField texto;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    private final EntityManager em = emf.createEntityManager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         lista.setCellFactory((ListView<CategoriaProducto> s) -> new Categoriaconvertidor());
        this.listar();
        Platform.runLater(() -> {
            this.principal.widthProperty().addListener((ObservableValue<? extends Number> obs, Number oldValue, Number newValue) -> {
                this.secundario.setLayoutX((this.principal.getWidth() / 2) - (this.secundario.getWidth() / 2));
            });
            this.principal.heightProperty().addListener((ObservableValue<? extends Number> obs, Number oldValue, Number newValue) -> {
                this.secundario.setLayoutY((this.principal.getHeight() / 2) - (this.secundario.getHeight() / 2));
            });
        });
    }    

    @FXML
    private void crear(ActionEvent event) {
        String a = texto.getText();

        CategoriaProducto t = new CategoriaProducto();
        t.setNombre(a);

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        this.listar();
        texto.clear();
    }


    @FXML
    private void eliminar(ActionEvent event) {
        CategoriaProducto t3 = lista.getSelectionModel().getSelectedItem();

        em.getTransaction().begin();
        em.remove(em.merge(t3));
        em.getTransaction().commit();

        this.listar();
    }
    private void listar() {
        //codigo que consulta a la base de datos y carga en la lista
        this.lista.getItems().clear();
        TypedQuery<CategoriaProducto> q = this.em.createQuery("SELECT m FROM CategoriaProducto m", CategoriaProducto.class);
        for (CategoriaProducto m : q.getResultList()) {
            this.lista.getItems().add(m);

        }
    }
    @FXML
    private void buscar(KeyEvent event) {
                String a = ((TextField)event.getSource()).getText();
        if (a.isEmpty()) {
            this.listar();
        } else {
            this.lista.getItems().clear();
            TypedQuery<CategoriaProducto> q = this.em.createQuery("SELECT m FROM CategoriaProducto m WHERE LOWER(m.nombre) LIKE :txbusq", CategoriaProducto.class);
            q.setParameter("txbusq", "%" + a.toLowerCase() + "%");
            for (CategoriaProducto m : q.getResultList()) {
                this.lista.getItems().add(m);

            }
        }
    }
    
}
