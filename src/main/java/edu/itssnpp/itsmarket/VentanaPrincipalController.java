package edu.itssnpp.itsmarket;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VentanaPrincipalController implements Initializable {

    private static final Logger LOG = Logger.getLogger(VentanaPrincipalController.class.getName());
    
    
    private Label label;
    @FXML
    private TabPane tabPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
    }

    private void cargarModulo(String direccionFXML, String tituloPestania) {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = FXMLLoader.load(getClass().getResource(direccionFXML));
            Tab t=new Tab();
            t.setText(tituloPestania);
            t.setContent(root);
            this.tabPane.getTabs().add(t);
            this.tabPane.getSelectionModel().select(t);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error al cargar modulo", ex);
            Alert errDlg=new Alert(Alert.AlertType.ERROR);
            errDlg.setTitle("Error al cargar módulo");
            errDlg.setHeaderText("Error al cargar módulo: '"+tituloPestania+"'. Archivo: '"+direccionFXML+"'.");
            errDlg.setContentText(ex.getMessage());
            errDlg.showAndWait();
        }
    }
}
