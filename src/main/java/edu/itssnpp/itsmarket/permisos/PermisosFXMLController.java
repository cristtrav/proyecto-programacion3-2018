package edu.itssnpp.itsmarket.permisos;

import edu.itssnpp.itsmarket.entidades.Empleado;
import edu.itssnpp.itsmarket.entidades.Funcionalidad;
import edu.itssnpp.itsmarket.entidades.Modulo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PermisosFXMLController implements Initializable {

    @FXML
    private Button eliminar;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    @FXML
    private Button agregar;
    @FXML
    private ComboBox<Modulo> box2;
    @FXML
    private ListView<Funcionalidad> list1;
    @FXML
    private ListView<Funcionalidad> list2;
    @FXML
    private ComboBox<Empleado> box1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarmodulos();
        box2.setCellFactory((ListView<Modulo> l) -> new ModulosListCell());
        box2.setButtonCell(new ModulosListCell());

        list1.setCellFactory((ListView<Funcionalidad> m) -> new FuncionalidadListCell());

        list2.setCellFactory((ListView<Funcionalidad> m) -> new FuncionalidadListCell());

        cargarempleado();
        box1.setCellFactory((ListView<Empleado> n) -> new EmpleadoListCell());
        box1.setButtonCell(new EmpleadoListCell());

    }

    @FXML
    private void Agregar(ActionEvent event) {
        EntityManager em = emf.createEntityManager();

        Funcionalidad f = list1.getSelectionModel().getSelectedItem();
        list2.getItems().add(f);

        Empleado e = box1.getSelectionModel().getSelectedItem();
        e.getFuncionalidadList().add(list1.getSelectionModel().getSelectedItem());

        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        

    }

    private void cargarmodulos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Modulo> q = em.createQuery("SELECT tm FROM Modulo tm", Modulo.class);
        box2.getItems().clear();
        box2.getItems().addAll(q.getResultList());

    }

    private void cargarfuncionalidad() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Funcionalidad> q = em.createQuery("SELECT tm FROM Funcionalidad tm", Funcionalidad.class);
        list1.getItems().clear();
        list1.getItems().addAll(q.getResultList());
    }

    @FXML
    private void modulo(ActionEvent event) {

        Modulo m = box2.getSelectionModel().getSelectedItem();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Funcionalidad> q = em.createQuery("SELECT tm FROM Funcionalidad tm where tm.modulo=:p", Funcionalidad.class);
        q.setParameter("p", m);
        list1.getItems().clear();
        list1.getItems().addAll(q.getResultList());
    }

    @FXML
    private void cargarempleado() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Empleado> q = em.createQuery("SELECT tm FROM Empleado tm", Empleado.class);
        box1.getItems().clear();
        box1.getItems().addAll(q.getResultList());
    }

}
