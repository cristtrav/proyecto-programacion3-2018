
package edu.itssnpp.itsmarket.talonarios;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FXMLvistaController implements Initializable {

    @FXML
    private Text txtItsMarket;
    @FXML
    private Text txtNumeroFact;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private TextField txtPagoCliente;
    @FXML
    private MenuButton menCliente;
    @FXML
    private Button buttonagrega;
    @FXML
    private TextField txtcantidad;
    @FXML
    private TextField txtreferencia;
    @FXML
    private TextField txtprecio;
    @FXML
    private TextField txtimporte;
    @FXML
    private TextField txtdescuento;
    @FXML
    private TextField txtiva;
    @FXML
    private TextField txttotal;
    @FXML
    private Text textimbrad;
    @FXML
    private MenuButton mencliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnagregar(ActionEvent event) {
    
    
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

    }

    @FXML
    private void fecha(ActionEvent event) {
        DatePicker fecha1 = new DatePicker();

          DatePicker fecha2 = new DatePicker(LocalDate.now());
          fecha2.setEditable(false);
     
    }

    @FXML
    private void cliente(ActionEvent event) {
    }

    @FXML
    private void aumentar(MouseEvent event) {
        
    }
    
    
   
    
}
