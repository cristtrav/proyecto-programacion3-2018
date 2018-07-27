package edu.itssnpp.itsmarket.pago_proveedores;

import edu.itssnpp.itsmarket.entidades.CuotaCompra;
import edu.itssnpp.itsmarket.entidades.Proveedor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author mathias
 */
public class Pago_proveedorController implements Initializable {

    @FXML
    private Button btnpagar;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    @FXML
    private TextField txtmontoapagar;
    @FXML
    private TableView<CuotaCompra> tablaproductos;
    @FXML
    private TableColumn<CuotaCompra, Integer> colu_factura;
    @FXML
    private TableColumn<CuotaCompra, Integer> colu_vencimiento;
    @FXML
    private TableColumn<CuotaCompra, Integer> colu_fecha;
    @FXML
    private TableColumn<CuotaCompra, Integer> colu_monto;
    @FXML
    private Button btneliminar;
    @FXML
    private ComboBox<Proveedor> com_proveedor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
/*llamar a proveedor */
        cargarproveedor();
        com_proveedor.setCellFactory((ListView<Proveedor> p) -> new ProveedoresListCell());
        com_proveedor.setButtonCell(new ProveedoresListCell());
        
        colu_factura.setCellValueFactory(new PropertyValueFactory<>("nro_factura"));
        colu_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha_pago"));
        colu_monto.setCellValueFactory(new PropertyValueFactory<>("monto_cuota"));
        colu_vencimiento.setCellValueFactory(new PropertyValueFactory<>("fecha_vencimiento"));
        
       
        

    }

    @FXML
    private void pagar(ActionEvent event) {
    }

    @FXML
    private void montoapagar(ActionEvent event) {
    }

    @FXML
    private void eliminarfact(ActionEvent event) {

    }

    private void cargarproveedor() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Proveedor> q = em.createQuery("SELECT tm FROM Proveedor tm", Proveedor.class);
        com_proveedor.getItems().clear();
        com_proveedor.getItems().addAll(q.getResultList());
    }
    
}
