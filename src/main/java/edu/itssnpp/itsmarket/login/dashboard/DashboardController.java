/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.login.dashboard;

import edu.itssnpp.itsmarket.entidades.Venta;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    @FXML
    private Label hastafechasemanal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void calculoMovimientoSemanal() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Venta> q = em.createQuery("SELECT aux FROM Venta aux WHERE aux.fecha>= :fechainicio AND fecha<=fechafin=:fec", Venta.class);

        Calendar kal = new GregorianCalendar();
        kal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        kal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

        q.setParameter("fec", new Date());
        q.setParameter("fechainicio", kal.getTime());
        q.setParameter("fechafin", kal.getTime());

        List<Venta> liz = q.getResultList();

        int totalventas = 0;
        Date fachada1 = new Date();
        Date fachada2 = new Date();

        SimpleDateFormat fch = new SimpleDateFormat("dd/mm/yy");

        for (Venta ve : liz) {
            totalventas = totalventas + ve.getTotal();
        }
        lblingresosemanal.setText(totalventas + " ");
        desdefechasemanal.setText(fch.format(fachada1));
        hastafechasemanal.setText(fch.format(fachada2));
    }

    public void calculoMovimientoMensual() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Venta> q = em.createQuery("SELECT aux FROM Venta aux WHERE aux.fecha>= :fechainicio AND fecha<=fechafin=:fec", Venta.class);

        Calendar kal = new GregorianCalendar();
        kal.add(Calendar.MONTH, 1);
        kal.set(Calendar.DAY_OF_MONTH, 1);
        kal.add(Calendar.DAY_OF_MONTH, -1);

        q.setParameter("fec", new Date());
        q.setParameter("fechainicio", kal.getTime());
        q.setParameter("fechafin", kal.getTime());

        List<Venta> liz = q.getResultList();

        int totalventasMens = 0;
        Date facha = new Date();

        SimpleDateFormat fch = new SimpleDateFormat("dd/mm/yy");

        for (Venta ve : liz) {
            totalventasMens = totalventasMens + ve.getTotal();
        }
        lblingresomensual.setText(totalventasMens + " ");
        fechaMovMensual.setText(fch.format(facha));
    }

    public void calculoMovimientoAnual() {

    }

    public void topProductosMasVendidos() {

    }

    public void totalVentasDia() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Venta> q = em.createQuery("SELECT aux FROM Venta aux WHERE aux.fecha=:fec", Venta.class);
        q.setParameter("fec", new Date());
        List<Venta> liz = q.getResultList();

        int total = 0;
        Date fech = new Date();

        SimpleDateFormat fc = new SimpleDateFormat("dd/mm/yy");
        for (Venta ve : liz) {
            total = total + ve.getTotal();
        }
        lbltotalventasdia.setText(total + " ");
        lblventasdia.setText(fc.format(fech));
    }

    public void calculoDeudaTotal() {

    }
}
