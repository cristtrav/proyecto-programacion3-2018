/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.promociones;

import edu.itssnpp.itsmarket.entidades.Promocion;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javafx.scene.input.MouseEvent;
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
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    private TextField textfield;
    @FXML
    private TableView<Promocion> tablaCL;

    @FXML
    private TableColumn<Promocion, Integer> descuentoCL;
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
    private TableColumn<Promocion, String> nombreCL;
    @FXML
    private TextField nombretxt;
    @FXML
    private TableColumn<Promocion, Date> fechaInicioCL;
    @FXML
    private TableColumn<Promocion, Date> fechaFinCL;
    ObservableList<Promocion> Promocion = FXCollections.observableArrayList();
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
        EntityManager em = emf.createEntityManager();
        Calendar c=new GregorianCalendar(fechaInicio.getValue().getYear(), fechaInicio.getValue().getMonthValue()-1, fechaInicio.getValue().getDayOfMonth());
        Calendar c1=new GregorianCalendar(fechaFin.getValue().getYear(), fechaFin.getValue().getMonthValue()-1, fechaFin.getValue().getDayOfMonth());
        Promocion p = new Promocion();
        p.setNombre(nombretxt.getText());
        nombretxt.clear();
        p.setFechaInicio(c.getTime());
        p.setFechaFin(c1.getTime());
        p.setPorcentajeDescuento(Integer.parseInt(descuentotxt.getText()));
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        cargardatos();

    }

    @FXML
    private void eliminarBT(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
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
        EntityManager em = emf.createEntityManager();
        Calendar c=new GregorianCalendar(fechaInicio.getValue().getYear(), fechaInicio.getValue().getMonthValue()-1, fechaInicio.getValue().getDayOfMonth());
        Calendar c1=new GregorianCalendar(fechaFin.getValue().getYear(), fechaFin.getValue().getMonthValue()-1, fechaFin.getValue().getDayOfMonth());
        Promocion p = tablaCL.getSelectionModel().getSelectedItem();
        nombretxt.setText(p.getNombre());
        p.setFechaInicio(c.getTime());
        p.setFechaFin(c1.getTime());
        p.setPorcentajeDescuento(Integer.parseInt(descuentotxt.getText()));
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        cargardatos();
    }

    private void cargardatos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Promocion> q = em.createQuery("SELECT tm FROM Promocion tm", Promocion.class);
        tablaCL.getItems().clear();
        tablaCL.getItems().addAll(q.getResultList());
    }

    @FXML
    private void seleccionarPromocion(MouseEvent event) {
        EntityManager em = emf.createEntityManager();
        Promocion p = tablaCL.getSelectionModel().getSelectedItem();
        nombretxt.setText(p.getNombre());
        Calendar ci=new GregorianCalendar();
        Calendar c2=new GregorianCalendar();
        ci.setTime(p.getFechaInicio());
        c2.setTime(p.getFechaFin());
        fechaInicio.setValue(LocalDate.of(ci.get(Calendar.YEAR), ci.get(Calendar.MONTH)+1, ci.get(Calendar.DAY_OF_MONTH)));
        fechaFin.setValue(LocalDate.of(c2.get(Calendar.YEAR), c2.get(Calendar.MONTH)+1, c2.get(Calendar.DAY_OF_MONTH)));
        descuentotxt.setText(p.getPorcentajeDescuento().toString());
    }

}
