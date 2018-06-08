package edu.itssnpp.itsmarket.categorias;

import edu.itssnpp.itsmarket.entidades.CategoriaCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
 * @author fredy
 */
public class CategoriasFXMLController implements Initializable {

    @FXML
    private TextField txf;
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    @FXML
    private TableView<CategoriaCliente> tabla;
    @FXML
    private TableColumn<CategoriaCliente, String> columna;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargardatos();
       columna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    }    


    @FXML
    private void Agregar(ActionEvent event) {
        
        EntityManager em=emf.createEntityManager();
        CategoriaCliente cc= new CategoriaCliente();
        cc.setNombre(txf.getText());
        txf.clear();
        em.getTransaction().begin();
        em.persist(cc);
        em.getTransaction().commit();
        cargardatos();
    }

    @FXML
    private void eliminar(ActionEvent event) {
        EntityManager em=emf.createEntityManager();
        tabla.getSelectionModel().getSelectedItem();
        em.getTransaction().begin();
        em.remove(em.merge(tabla.getSelectionModel().getSelectedItem()));
        em.getTransaction().commit();
        cargardatos();
    }

    @FXML
    private void modificar(ActionEvent event) {
        EntityManager em=emf.createEntityManager();
        CategoriaCliente cc= tabla.getSelectionModel().getSelectedItem();
        txf.setText(tabla.getSelectionModel().getSelectedItem().getNombre());
        em.getTransaction().begin();
        em.merge(cc);
        em.getTransaction().commit();
        cargardatos();
    }   
    
    private void cargardatos(){
        EntityManager em=emf.createEntityManager();
        TypedQuery<CategoriaCliente> q=em.createQuery("SELECT tm FROM CategoriaCliente tm",CategoriaCliente.class);
        tabla.getItems().clear();
        tabla.getItems().addAll(q.getResultList());
    }
}
