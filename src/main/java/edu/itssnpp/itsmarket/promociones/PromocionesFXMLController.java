/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.promociones;

import edu.itssnpp.itsmarket.entidades.Promocion;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author dario
 */
public class PromocionesFXMLController implements Initializable {

    @FXML
    private Label label;
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    private TextField textfield;
    @FXML
    private TableView<Promocion> tablaCL;
    
    @FXML
    private TableColumn<Promocion,Integer> descuentoCL;
    private TextField fechatxt;
    @FXML
    private TextField descuentotxt;
    @FXML
    private Button añadirBT;
    @FXML
    private Button eliminarBT;
    @FXML
    private Button nuevoBT;
    @FXML
    private Button modificarBT;
    @FXML
    private TableColumn<Promocion,String> nombreCL;
    @FXML
    private TextField nombretxt;    
    @FXML
    private TableColumn<Promocion, Date> fechaInicioCL;
    @FXML
    private TableColumn<Promocion, Date> fechaFinCL;
    ObservableList<Promocion> Promocion=FXCollections.observableArrayList();
    private TextField fechaFINtxt;
    @FXML
    private DatePicker fechaInicio;
    @FXML
    private DatePicker fechaFin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargardatos();
        DefaultTableModel lista = new DefaultTableModel();
        nombreCL.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );
        fechaInicioCL.setCellValueFactory(
                new PropertyValueFactory<>("fechaInicio")
        );
        fechaFinCL.setCellValueFactory(
                new PropertyValueFactory<>("fechaFin")
        );
        descuentoCL.setCellValueFactory(
                new PropertyValueFactory<>("porcentajeDescuento")
        );
        
        // TODO
    }    

    @FXML
    private void añadirBT(ActionEvent event) {
    EntityManager em=emf.createEntityManager();
    Promocion p= new Promocion();
    p.setNombre(nombretxt.getText());
    nombretxt.clear();
    em.getTransaction().begin();
    em.persist(p);
    em.getTransaction().commit();
    cargardatos();
        
    }

    @FXML
    private void eliminarBT(ActionEvent event) {
         EntityManager em=emf.createEntityManager();
         tablaCL.getSelectionModel().getSelectedItem();
         em.getTransaction().begin();
         em.remove(em.merge(tablaCL.getSelectionModel().getSelectedItem()));
         em.getTransaction().commit();
         cargardatos();
    }

    @FXML
    private void nuevoBT(ActionEvent event) {
        nombretxt.setText("");
        fechaInicio.setValue(null);
        fechaFin.setValue(null);
        descuentotxt.setText("");
        modificarBT.setDisable(false);
        eliminarBT.setDisable(false);
        añadirBT.setDisable(false);
    }

    @FXML
    private void modificarBT(ActionEvent event) {
         EntityManager em=emf.createEntityManager();
         Promocion p=tablaCL.getSelectionModel().getSelectedItem();
         nombretxt.setText(tablaCL.getSelectionModel().getSelectedItem().getNombre());
         em.getTransaction().begin();
         em.merge(p);
         em.getTransaction().commit();
         cargardatos();
    }

    private void cargardatos() {
        EntityManager em=emf.createEntityManager();
        TypedQuery<Promocion> q=em.createQuery("SELECT tm FROM Promocion tm",Promocion.class);
        tablaCL.getItems().clear();
        tablaCL.getItems().addAll(q.getResultList());
    }
    
}
