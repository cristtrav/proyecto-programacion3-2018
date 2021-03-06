/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.login.dashboard;

import edu.itssnpp.itsmarket.entidades.Compra;
import edu.itssnpp.itsmarket.entidades.DetalleVenta;
import edu.itssnpp.itsmarket.entidades.Producto;
import edu.itssnpp.itsmarket.entidades.Venta;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @FXML
    private Label p1;
    @FXML
    private Label p2;
    @FXML
    private Label p3;
    @FXML
    private Label p4;
    @FXML
    private Label p5;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void calculoMovimientoSemanal() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Venta> q = em.createQuery("SELECT aux FROM Venta aux WHERE aux.fecha >=:fechainicio AND aux.fecha<=:fechafin", Venta.class);
        TypedQuery<Compra> w = em.createQuery("SELECT auxi FROM Compra auxi WHERE auxi.fecha >=:fechain AND auxi.fecha<=:fechafi", Compra.class);

        Calendar kal = new GregorianCalendar();
        kal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        kal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

        q.setParameter("fec", new Date());
        q.setParameter("fechainicio", kal.getTime());
        q.setParameter("fechafin", kal.getTime());
        w.setParameter("fecz", new Date());
        w.setParameter("fechain", kal.getTime());
        w.setParameter("fechafi", kal.getTime());

        List<Venta> liz = q.getResultList();
        List<Compra> lizi = w.getResultList();

        int totalventas = 0;
        int totalcompras = 0;
        int totaltotalseman = 0;

        Date fachada1 = new Date();
        Date fachada2 = new Date();

        SimpleDateFormat fch = new SimpleDateFormat("dd/mm/yy");

        for (Venta ve : liz) {
            totalventas = totalventas + ve.getTotal();
        }
        for (Compra co : lizi) {
            totalcompras = totalcompras + co.getTotal();
        }

        totaltotalseman = totalventas - totalcompras;

        lblingresosemanal.setText(totalventas + " ");
        lblegresosemanal.setText(totalcompras + " ");
        lbltotalsemanal.setText(totaltotalseman + " ");

        desdefechasemanal.setText(fch.format(fachada1));
        hastafechasemanal.setText(fch.format(fachada2));
    }

    public void calculoMovimientoMensual() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Venta> q = em.createQuery("SELECT aux FROM Venta aux WHERE aux.fecha >=:fechainicio AND aux.fecha <= :fechafin", Venta.class);
        TypedQuery<Compra> w = em.createQuery("SELECT auxi FROM Compra auxi WHERE auxi.fecha >=:fechain AND auxi.fecha<=:fechafi", Compra.class);

        Calendar kal = new GregorianCalendar();
        kal.add(Calendar.MONTH, 1);
        kal.set(Calendar.DAY_OF_MONTH, 1);
        kal.add(Calendar.DAY_OF_MONTH, -1);

        q.setParameter("fec", new Date());
        q.setParameter("fechainicio", kal.getTime());
        q.setParameter("fechafin", kal.getTime());
        w.setParameter("fecz", new Date());
        w.setParameter("fechain", kal.getTime());
        w.setParameter("fechafi", kal.getTime());

        List<Venta> liz = q.getResultList();
        List<Compra> lii = w.getResultList();

        int totalventasMens = 0;
        int totalcomprasmens = 0;
        int totaltotalmens = 0;

        Date facha = new Date();

        SimpleDateFormat fch = new SimpleDateFormat("dd/mm/yy");

        for (Venta ve : liz) {
            totalventasMens = totalventasMens + ve.getTotal();
        }
        for (Compra co : lii) {
            totalcomprasmens = totalcomprasmens + co.getTotal();
        }
        totaltotalmens = totalventasMens - totalcomprasmens;

        lblingresomensual.setText(totalventasMens + " ");
        lblegresomensual.setText(totalcomprasmens + " ");
        totalingresomensual.setText(totaltotalmens + " ");

        fechaMovMensual.setText(fch.format(facha));
    }

    public void calculoMovimientoAnual() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Venta> q = em.createQuery("SELECT aux FROM Venta aux WHERE aux.fecha >=:fechainicio AND aux.fecha <= :fechafin", Venta.class);
        TypedQuery<Compra> a = em.createQuery("SELECT auxi FROM Compra auxi WHERE auxi.fecha >=:fechain AND auxi.fecha<=:fechafi", Compra.class);

        Calendar kal = new GregorianCalendar();
        int year = kal.get(Calendar.YEAR);
        kal.set(Calendar.DAY_OF_MONTH, 1);
        kal.set(Calendar.MONTH, 0);
        kal.set(Calendar.DAY_OF_MONTH, 31);
        kal.set(Calendar.MONTH, 11);

        q.setParameter("fec", new Date());
        q.setParameter("fechainicio", kal.getTime());
        q.setParameter("fechafin", kal.getTime());
        a.setParameter("fecz", new Date());
        a.setParameter("fechain", kal.getTime());
        a.setParameter("fechafi", kal.getTime());

        List<Venta> liz = q.getResultList();
        List<Compra> lio = a.getResultList();

        int totalventasanual = 0;
        int totalcomprasanual = 0;
        int totaltotalanual = 0;

        Date facha = new Date();

        SimpleDateFormat fch = new SimpleDateFormat("dd/mm/yy");

        for (Venta ve : liz) {
            totalventasanual = totalventasanual + ve.getTotal();
        }
        for (Compra co : lio) {
            totalventasanual = totalcomprasanual + co.getTotal();
        }
        totaltotalanual = totalventasanual - totalcomprasanual;

        lblingresoanual.setText(totalventasanual + " ");
        lblegresoanual.setText(totalcomprasanual + " ");
        lbltotalanual.setText(totaltotalanual + " ");

        lblanho.setText(fch.format(facha));

    }

    public void topProductosMasVendidos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<DetalleVenta> q = em.createQuery("SELECT aux FROM DetalleVenta aux", DetalleVenta.class);
        
        q.setParameter("DetalleVenta", getClass());
        
        List<DetalleVenta> lizta = q.getResultList();
        
        Map<Producto, Double> calculo = new HashMap<>();
        
        for (DetalleVenta dv : lizta) {
            if (calculo.get(dv.getProducto()) == null) {
                calculo.put(dv.getProducto(), dv.getCantidad());
            } else {
                double ca = calculo.get(dv.getProducto());
                ca = ca + dv.getCantidad();
                calculo.put(dv.getProducto(), ca);
            }
        }
        listaproductos.getChildren();
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Compra> q = em.createQuery("SELECT aux FROM Compra aux", Compra.class);
        q.setParameter("feci", new Date());
        List<Compra> liza = q.getResultList();

        int totalco = 0;

        for (Compra co : liza) {
            totalco = totalco + co.getTotal();
        }
        lbltotalDeuda.setText(totalco + " ");
    }
}
