/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Luis Poot
 */
public class VentanasControlador {
    
    protected void VentanaPrincipal(String URL, String Nombre) throws IOException{
        // load main form in to VBox (Root)
        VBox mainPane = (VBox) FXMLLoader.load( getClass().getResource(URL) );
        // add main form into the scene
        Scene scene = new Scene(mainPane);
        Stage primaryStage = new Stage();
        primaryStage.setTitle(Nombre);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);    // make the main form fit to the screen
        primaryStage.show(); 
    }
    
    protected void AbrirVentana(String fxml, String titulo) throws Exception {      
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(titulo);
        stage.showAndWait();
    }
    
    protected void VentanaEmergente(Alert.AlertType tipo, String titulo, 
            String encabezadoTexto, String contenidoTexto) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezadoTexto);
        alert.setContentText(contenidoTexto);
        alert.showAndWait();
    }
    
    public void setDataPane(VBox dataPane, Node node) {
        // update VBox with new form(FXML) depends on which button is clicked
        dataPane.getChildren().setAll(node);
    }

    public VBox fadeAnimate(String url) throws IOException {
        VBox vbox = (VBox) FXMLLoader.load(getClass().getResource(url));
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(vbox);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        return vbox;
    }
    
    protected void Cerrar(Button boton){
        Stage mystage= (Stage) boton.getScene().getWindow();
        mystage.close();
    }
}
