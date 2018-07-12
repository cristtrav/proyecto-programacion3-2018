/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.login.dashboard;

import edu.itssnpp.itsmarket.entidades.Empleado;
import edu.itssnpp.itsmarket.entidades.Venta;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author hugo
 */
public class DashboardController implements Initializable {

    @FXML
    private Label lblingresosemanal;
    @FXML
    private Label desdefechasemanal;
    @FXML
    private Label hastafechamensual;
    @FXML
    private Label lblegresosemanal;
    @FXML
    private Label lbltotalsemanal;
    @FXML
    private Label lblingresoanual;
    @FXML
    private Label lblanho;
    @FXML
    private Label lblegresoanual;
    @FXML
    private Label lbltotalanual;
    @FXML
    private Label lblingresomensual;
    @FXML
    private Label lblegresomensual;
    @FXML
    private Label totalingresomensual;
    @FXML
    private Label lbltotalventasdia;
    @FXML
    private Label lblventasdia;
    @FXML
    private Label fechaMovMensual;
    @FXML
    private VBox listaproductos;
    @FXML
    private Label lbltotalDeuda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void calculoMovimientoSemanal() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Venta> q = em.createQuery("SELECT aux FROM Venta aux WHERE aux.fecha>==:fe", Venta.class);
        q.setParameter("fe", new Date());
        List<Venta> liz = q.getResultList();
        int totalventas=0;
        

    }

    lblingresosemanal.setText (value);
    lblegresosemanal.setText (value);
    desdefechasemanal.setText (value);
    hastafechamensual.setText (value);
}
