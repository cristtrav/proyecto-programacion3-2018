package edu.itssnpp.itsmarket;

import edu.itssnpp.itsmarket.entidades.Empleado;
import edu.itssnpp.itsmarket.util.DatosFijos;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    
public static VentanaPrincipalController VENTANAPRINCIPAL;
public static Empleado EMPLEADO;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader= new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("/fxml/VentanaPrincipal.fxml"));
        VENTANAPRINCIPAL= loader.getController();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        VENTANAPRINCIPAL=loader.getController();

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        DatosFijos.verificarModulos();
        DatosFijos.verificarFuncionalidades();
    }

   
    public static void main(String[] args) {
        launch(args);
    }

}
