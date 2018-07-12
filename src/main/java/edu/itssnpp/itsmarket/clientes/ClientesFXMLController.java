package edu.itssnpp.itsmarket.clientes;

import edu.itssnpp.itsmarket.MainApp;
import edu.itssnpp.itsmarket.entidades.CategoriaCliente;
import edu.itssnpp.itsmarket.entidades.Ciudad;
import edu.itssnpp.itsmarket.entidades.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author fredy
 */
public class ClientesFXMLController implements Initializable {

    @FXML
    private TextField nombre;
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    @FXML
    private TextField apellido;
    @FXML
    private TextField cinro;
    @FXML
    private TextField dvruc;
    @FXML
    private TextField telefono;
    @FXML
    private TextField direccion;
    @FXML
    private TextField email;
    @FXML
    private TextField idcliente;
    @FXML
    private ComboBox<Ciudad> ciudad;
    @FXML
    private ComboBox<CategoriaCliente> categoria;
    @FXML
    public Button agregar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarciudad();
        ciudad.setCellFactory((ListView<Ciudad> c) -> new CiudadListCell());
        ciudad.setButtonCell(new CiudadListCell());
        cargarcategoria();
        categoria.setCellFactory((ListView<CategoriaCliente> c) -> new CategoriaClienteListCell());
        categoria.setButtonCell(new CategoriaClienteListCell());
    }    

    @FXML
    private void agregar(ActionEvent event) {
        if(nombre.getText().isEmpty()){
          Alert a= new Alert(Alert.AlertType.INFORMATION);
          a.setTitle("Error al agregar Cliente");
          a.setHeaderText("Usted no a ingresado ningun nombre para agregar, por favor ingrese un nombre");
          a.showAndWait();
        }
        else{
            if(cinro.getText().isEmpty()){
            Alert b= new Alert(Alert.AlertType.INFORMATION);
            b.setTitle("Error al agregar Cedula de Identidad");
            b.setHeaderText("Usted no a ingresado ningun número de cedula, por favor ingrese un número");
            b.showAndWait();
            }
            else{
        EntityManager em=emf.createEntityManager();
        if(agregar.getText().equals("Agregar")){
        Cliente c= new Cliente();
        c.setNombres(nombre.getText());
        nombre.clear();
        c.setApellidos(apellido.getText());
        apellido.clear();
        c.setCi(Integer.parseInt(cinro.getText()));
        cinro.clear();
        if(!dvruc.getText().isEmpty()){
        c.setDvRuc(Integer.parseInt(dvruc.getText()));
        dvruc.clear();}
        c.setTelefono(telefono.getText());
        telefono.clear();
        c.setDireccion(direccion.getText());
        direccion.clear();
        c.setCiudad(ciudad.getSelectionModel().getSelectedItem());
        c.setEmail(email.getText());
        email.clear();
        c.setCategoriaCliente(categoria.getSelectionModel().getSelectedItem());
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        idcliente.setText(c.getIdcliente().toString());
        }
        else{
        Cliente c= new Cliente();
        c.setIdcliente(Integer.parseInt(idcliente.getText()));
        idcliente.clear();
        c.setNombres(nombre.getText());
        nombre.clear();
        c.setApellidos(apellido.getText());
        apellido.clear();
        c.setCi(Integer.parseInt(cinro.getText()));
        cinro.clear();
        if(!dvruc.getText().isEmpty()){
        c.setDvRuc(Integer.parseInt(dvruc.getText()));
        dvruc.clear();}
        c.setTelefono(telefono.getText());
        telefono.clear();
        c.setDireccion(direccion.getText());
        direccion.clear();
        c.setCiudad(ciudad.getSelectionModel().getSelectedItem());
        c.setEmail(email.getText());
        email.clear();
        c.setCategoriaCliente(categoria.getSelectionModel().getSelectedItem());
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        for(Tab t:MainApp.VENTANAPRINCIPAL.tabPane.getTabs()){
            if(t.getText().equals("Cliente")){
                MainApp.VENTANAPRINCIPAL.tabPane.getTabs().remove(t);
                break;
                }
              }
            }
          }
        }
               
        
    }
    private void cargarciudad(){
        EntityManager em= emf.createEntityManager();
        TypedQuery<Ciudad> q= em.createQuery("SELECT tm FROM Ciudad tm", Ciudad.class);
        ciudad.getItems().clear();
        ciudad.getItems().addAll(q.getResultList());
    }
    private void cargarcategoria(){
       EntityManager em= emf.createEntityManager();
        TypedQuery<CategoriaCliente> q= em.createQuery("SELECT tm FROM CategoriaCliente tm", CategoriaCliente.class);
        categoria.getItems().clear();
        categoria.getItems().addAll(q.getResultList()); 
    }
    public void cargarcliente(Cliente cli){
      idcliente.setText(cli.getIdcliente().toString());
      nombre.setText(cli.getNombres());
      apellido.setText(cli.getApellidos());
      cinro.setText(cli.getCi().toString());
      if(cli.getDvRuc()!=null){
        dvruc.setText(cli.getDvRuc().toString());
      }
      telefono.setText(cli.getTelefono());
      direccion.setText(cli.getDireccion());
      email.setText(cli.getEmail());
      ciudad.setValue(cli.getCiudad());
      categoria.setValue(cli.getCategoriaCliente());
    }
}