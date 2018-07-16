/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.clientes;

import edu.itssnpp.itsmarket.MainApp;
import static edu.itssnpp.itsmarket.MainApp.EMPLEADO;
import edu.itssnpp.itsmarket.entidades.CategoriaCliente;
import edu.itssnpp.itsmarket.entidades.Ciudad;
import edu.itssnpp.itsmarket.entidades.Cliente;
import edu.itssnpp.itsmarket.entidades.Empleado;
import edu.itssnpp.itsmarket.entidades.Funcionalidad;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author fredy
 */
public class TablaClientesFXMLController implements Initializable {

    @FXML
    private TableView<Cliente> lista;
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    @FXML
    private TableColumn<Cliente, String> nom;
    @FXML
    private TableColumn<Cliente, String> ap;
    @FXML
    private TableColumn<Cliente, Number> ci;
    @FXML
    private TableColumn<Cliente, Number> ruc;
    @FXML
    private TableColumn<Cliente, String> telf;
    @FXML
    private TableColumn<Cliente, String> direc;
    @FXML
    private TableColumn<Cliente, Ciudad> ciudad;
    @FXML
    private TableColumn<Cliente, String> email;
    @FXML
    private TableColumn<Cliente, CategoriaCliente> categoria;
    @FXML
    private TextField txf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarclientes();
        nom.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        ap.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        ci.setCellValueFactory(new PropertyValueFactory<>("ci"));
        ruc.setCellValueFactory(new PropertyValueFactory<>("dv_ruc"));
        telf.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        direc.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        ciudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        ciudad.setCellFactory((TableColumn<Cliente, Ciudad>c)-> new CiudadTableCell());
        categoria.setCellValueFactory(new PropertyValueFactory<>("categoriaCliente"));
        categoria.setCellFactory((TableColumn<Cliente, CategoriaCliente>cc)-> new CategoriaTableCell());
        
        EntityManager em=emf.createEntityManager();
        MainApp.EMPLEADO= em.find(Empleado.class, 1);
    }    

    @FXML
    private void agregar(ActionEvent event) {
        if(this.comprobarPermiso(1)){
        this.cargarModulo("/fxml/clientes/ClientesFXML.fxml", "Cliente", 1);
        cargarclientes();
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
        if(this.comprobarPermiso(2)){
        this.cargarModulo("/fxml/clientes/ClientesFXML.fxml", "Cliente", 2);
        cargarclientes();
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
        if(this.comprobarPermiso(3)){
        EntityManager em=emf.createEntityManager();
        lista.getSelectionModel().getSelectedItem();
        Alert e= new Alert(AlertType.CONFIRMATION);
        e.setTitle("Eliminar");
        e.setHeaderText("¿Desea eliminar el cliente seleccionado");
        Optional<ButtonType> result = e.showAndWait();
        if(result.get()== ButtonType.OK){
        em.getTransaction().begin();
        em.remove(em.merge(lista.getSelectionModel().getSelectedItem()));
        em.getTransaction().commit();
        cargarclientes();
        }
        }
        else{
          Alert a= new Alert(AlertType.INFORMATION);
            a.setTitle("Advertencia");
            a.setHeaderText("Usted no posee el permiso para realizar esta accion, favor solicitar permiso");
            a.showAndWait();  
        }
    }
    private void cargarclientes(){
      EntityManager em= emf.createEntityManager();
      TypedQuery<Cliente> q= em.createQuery("SELECT tm FROM Cliente tm", Cliente.class);
      lista.getItems().clear();
      lista.getItems().addAll(q.getResultList());
    }
    private void cargarModulo(String direccionFXML, String tituloPestania, int modo) {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream(direccionFXML));
            ClientesFXMLController c= loader.getController();
            if(modo==2){
            c.agregar.setText("Guardar");
            c.cargarcliente(lista.getSelectionModel().getSelectedItem());}
            else{
                c.agregar.setText("Agregar");
            }
            Tab t=new Tab();
            t.setText(tituloPestania);
            t.setContent(root);
            MainApp.VENTANAPRINCIPAL.tabPane.getTabs().add(t);
            MainApp.VENTANAPRINCIPAL.tabPane.getSelectionModel().select(t);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error al cargar modulo", ex);
            Alert errDlg=new Alert(Alert.AlertType.ERROR);
            errDlg.setTitle("Error al cargar módulo");
            errDlg.setHeaderText("Error al cargar módulo: '"+tituloPestania+"'. Archivo: '"+direccionFXML+"'.");
            errDlg.setContentText(ex.getMessage());
            errDlg.showAndWait();
        }
    }
    private static final Logger LOG = Logger.getLogger(TablaClientesFXMLController.class.getName());

    @FXML
    private void Actualizar(ActionEvent event) {
        cargarclientes();
    }

    @FXML
    private void OnActionBuscar(ActionEvent event) {
      buscar();  
    }

    @FXML
    private void OnKeyBuscar(KeyEvent event) {
        buscar();
    }
    
    private void buscar(){
        EntityManager em= emf.createEntityManager();
        String b= txf.getText();
      TypedQuery<Cliente> q= em.createQuery("SELECT c FROM Cliente c WHERE LOWER(c.nombres) LIKE :txt OR LOWER(c.apellidos) LIKE :txt OR SQL('CAST(? AS CHAR(11))',c.ci) LIKE :txt",Cliente.class);
      q.setParameter("txt", "%"+b.toLowerCase()+"%");
      lista.getItems().clear();
      lista.getItems().addAll(q.getResultList());
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
