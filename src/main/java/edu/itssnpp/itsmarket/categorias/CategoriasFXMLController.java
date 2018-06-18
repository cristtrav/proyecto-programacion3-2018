package edu.itssnpp.itsmarket.categorias;

import edu.itssnpp.itsmarket.entidades.CategoriaCliente;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    @FXML
    private Button agregar;

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
        if(agregar.getText().equals("Agregar")){
        CategoriaCliente cc= new CategoriaCliente();
        cc.setNombre(txf.getText());
        txf.clear();
        em.getTransaction().begin();
        em.persist(cc);
        em.getTransaction().commit();
        
        }
        else{
        CategoriaCliente cc= tabla.getSelectionModel().getSelectedItem();
        cc.setNombre(txf.getText());
        txf.clear();
        em.getTransaction().begin();
        em.merge(cc);
        em.getTransaction().commit();
        agregar.setText("Agregar");   
        }
        cargardatos(); 
    }

    @FXML
    private void eliminar(ActionEvent event) {
        EntityManager em=emf.createEntityManager();
        tabla.getSelectionModel().getSelectedItem();
        Alert e= new Alert(AlertType.CONFIRMATION);
        e.setTitle("Eliminar");
        e.setHeaderText("¿Desea eliminar la categoria");
        Optional<ButtonType> result = e.showAndWait();
        if(result.get()== ButtonType.OK){
        em.getTransaction().begin();
        em.remove(em.merge(tabla.getSelectionModel().getSelectedItem()));
        em.getTransaction().commit();
        cargardatos();}
    }

    @FXML
    private void modificar(ActionEvent event) {
        EntityManager em=emf.createEntityManager();
        CategoriaCliente cc= tabla.getSelectionModel().getSelectedItem();
        txf.setText(tabla.getSelectionModel().getSelectedItem().getNombre());
        agregar.setText("Guardar");
    }   
    
    private void cargardatos(){
        EntityManager em=emf.createEntityManager();
        TypedQuery<CategoriaCliente> q=em.createQuery("SELECT tm FROM CategoriaCliente tm",CategoriaCliente.class);
        tabla.getItems().clear();
        tabla.getItems().addAll(q.getResultList());
    }
}
