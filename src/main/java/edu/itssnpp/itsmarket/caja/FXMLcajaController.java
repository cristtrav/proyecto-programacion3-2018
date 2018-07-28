/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.caja;

import edu.itssnpp.itsmarket.entidades.DetalleMovimientoCaja;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author ivan
 */
public class FXMLcajaController implements Initializable {

    private static final Logger LOG = Logger.getLogger(FXMLcajaController.class.getName());

    @FXML
    private Button retirardinero;
    @FXML
    private Button cerrarcaja;
    //Detalle
    @FXML
    private TableColumn<DettCajas, String> detamonto;
    @FXML
    private TableColumn<DettCajas, String> detanrocaja;
    @FXML
    private Tab detallemovi;
    @FXML
    private TableView<DettCajas> tl_Detalle;

    private final ObservableList<DettCajas> data
            = FXCollections.observableArrayList();

    Integer x = 0;
    @FXML
    private Tab cajaactual;
    @FXML
    private Button abrircaja;
    @FXML
    private TableColumn<?, ?> montoinicial;
    @FXML
    private TableColumn<?, ?> montofial;
    @FXML
    private TableColumn<?, ?> nrocaja;
    @FXML
    private TableColumn<?, ?> fechahoraapertura;
    @FXML
    private TableColumn<?, ?> fechahoracierre;
    @FXML
    private TableColumn<?, ?> mediodepago;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        x = 0;
        if (x == 0) {
            cerrarcaja.setDisable(true);
            retirardinero.setDisable(true);
            detallemovi.setDisable(true);
        } else {
            abrircaja.setDisable(true);

        }
        DettCajas dett = new DettCajas();

        dett.setMedioPago("asd");
        dett.setMonto("asd");
        dett.setNroCaja("asd");
        data.add(dett);

        detamonto.setCellValueFactory(
                new PropertyValueFactory<>("monto"));
        detanrocaja.setCellValueFactory(
                new PropertyValueFactory<>("medioPago"));
        detanrocaja.setCellValueFactory(
                new PropertyValueFactory<>("nroCaja"));
        this.tl_Detalle.setItems(data);
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager entitymanager = emfactory.createEntityManager();
//        BUSQUEDA DE OBJETOS

        TypedQuery query = entitymanager.createQuery("SELECT d FROM DetalleMovimientoCaja d", DetalleMovimientoCaja.class);
        List<DetalleMovimientoCaja> list = query.getResultList();
        for (DetalleMovimientoCaja objeto : list) {
            dett.setMonto(String.valueOf(objeto.getMonto()));
            dett.setNroCaja(String.valueOf(objeto.getMovimientoCaja().getNroCaja()));
            dett.setMedioPago(objeto.getMedioPago().getNombre());
        }

    }

    @FXML
    private void abrircaja(ActionEvent event) {
        try {
            //Se crea un dialogo especial para poder obtener el texto del usuario
            Parent root = FXMLLoader.load(getClass().getResource("/FXMLAbrirCaja/FXMLabrircaja.fxml"));

            Scene scene = new Scene(root);

            Stage st = new Stage();
            st.setScene(scene);
            st.show();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al cargar ventana", ex);
        }

//        EntityManagerFactory emfactory1 = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
//        EntityManager entitymanager2 = emfactory1.createEntityManager();
//        Query query2 = entitymanager2.createQuery("SELECT a FROM MovimientoCaja a WHERE a.empleado=:a");
//        Object rta = null;
//        query2.setParameter("a", rta);
    }
    //se obtiene la respuesta

    @FXML
    private void cerrarcaja(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlcerrarcaja/FXMLcerrarcaja.fxml"));

        Scene scene = new Scene(root);

        Stage st = new Stage();
        st.setScene(scene);
        st.show();
    }

    @FXML
    private void retirardinero(ActionEvent event) {
    }

}
