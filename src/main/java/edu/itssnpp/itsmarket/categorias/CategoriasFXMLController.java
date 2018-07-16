package edu.itssnpp.itsmarket.categorias;

import edu.itssnpp.itsmarket.MainApp;
import static edu.itssnpp.itsmarket.MainApp.EMPLEADO;
import edu.itssnpp.itsmarket.entidades.CategoriaCliente;
import edu.itssnpp.itsmarket.entidades.Empleado;
import edu.itssnpp.itsmarket.entidades.Funcionalidad;
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
        if(this.comprobarPermiso(19))
        {
        if(txf.getText().isEmpty()){
          Alert a= new Alert(AlertType.INFORMATION);
          a.setTitle("Error al agregar Categoria");
          a.setHeaderText("Usted no a ingresado ninguna categoria para agregar, por favor ingrese una categoria");
          a.showAndWait();
        }
        else{
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
        }
        else{
            Alert a= new Alert(AlertType.INFORMATION);
            a.setTitle("Advertencia");
            a.setHeaderText("Usted no posee el permiso para realizar esta accion, favor solicitar permiso");
            a.showAndWait();
        }
        
    }

    @FXML
    private void eliminar(ActionEvent event) {
        if(this.comprobarPermiso(21))
        {
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
        cargardatos();
        }
        }
        else{
            Alert a= new Alert(AlertType.INFORMATION);
            a.setTitle("Advertencia");
            a.setHeaderText("Usted no posee el permiso para realizar esta accion, favor solicitar permiso");
            a.showAndWait();
        }
    }

    @FXML
    private void modificar(ActionEvent event) {
        if(this.comprobarPermiso(20))
        {
        EntityManager em=emf.createEntityManager();
        CategoriaCliente cc= tabla.getSelectionModel().getSelectedItem();
        txf.setText(tabla.getSelectionModel().getSelectedItem().getNombre());
        agregar.setText("Guardar");
        }
        else{
            Alert a= new Alert(AlertType.INFORMATION);
            a.setTitle("Advertencia");
            a.setHeaderText("Usted no posee el permiso para realizar esta accion, favor solicitar permiso");
            a.showAndWait();
        }
    }
    
    private void cargardatos(){
        EntityManager em=emf.createEntityManager();
        TypedQuery<CategoriaCliente> q=em.createQuery("SELECT tm FROM CategoriaCliente tm",CategoriaCliente.class);
        tabla.getItems().clear();
        tabla.getItems().addAll(q.getResultList());
    }
    
    private boolean comprobarPermiso(Integer idFuncionalidad){
       boolean permitido=false;
       for(Funcionalidad f:EMPLEADO.getFuncionalidadList()){
           if(f.getIdfuncionalidad().equals(idFuncionalidad)){
               permitido=true;
               break;
           }
       }
       return permitido;
    }
    
}
