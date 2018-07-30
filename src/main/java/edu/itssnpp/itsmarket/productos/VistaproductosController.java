/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itssnpp.itsmarket.productos;

import edu.itssnpp.itsmarket.entidades.CategoriaProducto;
import edu.itssnpp.itsmarket.entidades.Marca;
import edu.itssnpp.itsmarket.entidades.Producto;
import edu.itssnpp.itsmarket.entidades.UnidadMedida;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author User
 */
public class VistaproductosController implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private AnchorPane secundario;
    @FXML
    private TextField brnombre;
    @FXML
    private TextField brprcompra;
    @FXML
    private TextField brprventa;
    @FXML
    private TextField nombre;
    @FXML
    private TextField preciocompra;
    @FXML
    private TextField precioventa;
    @FXML
    private TextField iva;
    @FXML
    private TextField barras;
    @FXML
    private ComboBox<Marca> marca;
    @FXML
    private ComboBox<CategoriaProducto> categoria;
    @FXML
    private ComboBox<UnidadMedida> unimedida;
    @FXML
    private Button guardar;
    @FXML
    private TableView<Producto> tabla;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
    private final EntityManager em = emf.createEntityManager();
    @FXML
    private Button modificar;
    @FXML
    private Button borrar;
    @FXML
    private TableColumn<Producto, String> name;
    @FXML
    private TableColumn<Producto, String> compra;
    @FXML
    private TableColumn<Producto, String> venta;
    @FXML
    private TableColumn<Producto, String> codb;
    @FXML
    private TableColumn<Producto, String> porcent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.listar();
        Platform.runLater(() -> {
            this.principal.widthProperty().addListener((ObservableValue<? extends Number> obs, Number oldValue, Number newValue) -> {
                this.secundario.setLayoutX((this.principal.getWidth() / 2) - (this.secundario.getWidth() / 2));
            });
            this.principal.heightProperty().addListener((ObservableValue<? extends Number> obs, Number oldValue, Number newValue) -> {
                this.secundario.setLayoutY((this.principal.getHeight() / 2) - (this.secundario.getHeight() / 2));
            });
        });

        name.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );
        compra.setCellValueFactory(
                new PropertyValueFactory<>("precioCompra")
        );
        venta.setCellValueFactory(
                new PropertyValueFactory<>("precioVenta")
        );
        codb.setCellValueFactory(
                new PropertyValueFactory<>("codBarra")
        );
        porcent.setCellValueFactory(
                new PropertyValueFactory<>("porcentajeIva")
        );

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        this.marca.setCellFactory((ListView<Marca> p) -> new MarcasListCell());
        this.marca.setButtonCell(new MarcasListCell());

        TypedQuery<Marca> q = em.createQuery("SELECT p FROM Marca p", Marca.class);
        this.marca.getItems().addAll(q.getResultList());

        this.categoria.setCellFactory((ListView<CategoriaProducto> p) -> new CategoriaListCell());
        this.categoria.setButtonCell(new CategoriaListCell());

        TypedQuery<CategoriaProducto> r = em.createQuery("SELECT p FROM CategoriaProducto p", CategoriaProducto.class);
        this.categoria.getItems().addAll(r.getResultList());
        
        this.unimedida.setCellFactory((ListView<UnidadMedida> p) -> new UnidadMedidaListCell());
        this.unimedida.setButtonCell(new UnidadMedidaListCell());

        TypedQuery<UnidadMedida> s = em.createQuery("SELECT p FROM UnidadMedida p", UnidadMedida.class);
        this.unimedida.getItems().addAll(s.getResultList());
    }

    @FXML
    private void brnombre(KeyEvent event) {
        String a = ((TextField) event.getSource()).getText();
        if (a.isEmpty()) {
            this.listar();
        } else {
            this.tabla.getItems().clear();
            TypedQuery<Producto> q = this.em.createQuery("SELECT m FROM Producto m WHERE LOWER(m.nombre) LIKE :txbusq", Producto.class);
            q.setParameter("txbusq", "%" + a.toLowerCase() + "%");
            for (Producto m : q.getResultList()) {
                this.tabla.getItems().add(m);
            }
        }
    }

    @FXML
    private void brprcompra(KeyEvent event) {
        String a = ((TextField) event.getSource()).getText();
        if (a.isEmpty()) {
            this.listar();
        } else {
            this.tabla.getItems().clear();
            TypedQuery<Producto> q = this.em.createQuery("SELECT m FROM Producto m WHERE LOWER(m.precioCompra) LIKE :txbusq", Producto.class);
            q.setParameter("txbusq", "%" + a.toLowerCase() + "%");
            for (Producto m : q.getResultList()) {
                this.tabla.getItems().add(m);
            }
        }
    }

    @FXML
    private void brprventa(KeyEvent event) {
        String a = ((TextField) event.getSource()).getText();
        if (a.isEmpty()) {
            this.listar();
        } else {
            this.tabla.getItems().clear();
            TypedQuery<Producto> q = this.em.createQuery("SELECT m FROM Producto m WHERE LOWER(m.precioVenta) LIKE :txbusq", Producto.class);
            q.setParameter("txbusq", "%" + a.toLowerCase() + "%");
            for (Producto m : q.getResultList()) {
                this.tabla.getItems().add(m);
            }
        }
    }

    @FXML
    private void guardar(ActionEvent event) {

        String a = nombre.getText();
        Producto t = new Producto();
        t.setNombre(a);

        String b = preciocompra.getText();
        t.setPrecioCompra(Integer.parseInt(b));

        String c = precioventa.getText();
        t.setPrecioVenta(Integer.parseInt(c));

        String d = iva.getText();
        t.setPorcentajeIva(Float.parseFloat(d));

        String e = barras.getText();
        t.setCodBarra(e);

        Marca m = marca.getSelectionModel().getSelectedItem();
        t.setMarca(m);

        CategoriaProducto f = categoria.getSelectionModel().getSelectedItem();
        t.setCategoriaProducto(f);

        UnidadMedida u = unimedida.getSelectionModel().getSelectedItem();
        t.setUnidadMedida(u);

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        this.listar();
        nombre.clear();
        preciocompra.clear();
        precioventa.clear();
        iva.clear();
        barras.clear();
        marca.getSelectionModel().clearSelection();
        categoria.getSelectionModel().clearSelection();
        unimedida.getSelectionModel().clearSelection();
    }

    private void listar() {
        //codigo que consulta a la base de datos y carga en la lista
        this.tabla.getItems().clear();
        TypedQuery<Producto> q = this.em.createQuery("SELECT m FROM Producto m", Producto.class);
        for (Producto m : q.getResultList()) {
            this.tabla.getItems().add(m);

        }
    }

    @FXML
    private void modificar(ActionEvent event) {

        Producto t2 = tabla.getSelectionModel().getSelectedItem();
        
        String g = nombre.getText();
        t2.setNombre(g);

        String h = preciocompra.getText();
        t2.setPrecioCompra(Integer.parseInt(h));

        String i = precioventa.getText();
        t2.setPrecioVenta(Integer.parseInt(i));

        String j = iva.getText();
        t2.setPorcentajeIva(Float.parseFloat(j));

        String k = barras.getText();
        t2.setCodBarra(k);

        Marca l = marca.getSelectionModel().getSelectedItem();
        t2.setMarca(l);

        CategoriaProducto n = categoria.getSelectionModel().getSelectedItem();
        t2.setCategoriaProducto(n);

        UnidadMedida o = unimedida.getSelectionModel().getSelectedItem();
        t2.setUnidadMedida(o);

        em.getTransaction().begin();
        em.merge(t2);
        em.getTransaction().commit();

        nombre.clear();
        preciocompra.clear();
        precioventa.clear();
        iva.clear();
        barras.clear();
        marca.getSelectionModel().clearSelection();
        categoria.getSelectionModel().clearSelection();
        unimedida.getSelectionModel().clearSelection();
        this.listar();
    }

    @FXML
    private void borrar(ActionEvent event) {
        Producto t3 = tabla.getSelectionModel().getSelectedItem();

        em.getTransaction().begin();
        em.remove(em.merge(t3));
        em.getTransaction().commit();

        this.listar();
    }

    @FXML
    private void clickParaModificar(MouseEvent event) {
        Producto t4 = tabla.getSelectionModel().getSelectedItem();
        nombre.setText(t4.getNombre());
    }
}
