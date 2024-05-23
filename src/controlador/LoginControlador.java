package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginControlador extends VentanasControlador 
        implements Initializable {
    @FXML
    private TextField txtContrasenia;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnSalir;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void Iniciar(ActionEvent event) throws IOException{
        //CODE LOGICA INICIO SESION
        
        VentanaPrincipal("/vista/Menu.fxml", this.txtNombre.getText());
        Cerrar(this.btnSalir);
    }
    
    public void Salir(ActionEvent event) throws Exception{
        Cerrar(this.btnSalir);
    }
}
