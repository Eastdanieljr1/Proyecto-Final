package controlador;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuControlador extends VentanasControlador {
    @FXML
    private VBox dataPane;
    @FXML
    private Button btnSalir;
    
    public void Productos(ActionEvent event) throws IOException, Exception {
        setDataPane(dataPane, fadeAnimate("/vista/Articulos.fxml"));
    }

    public void Clientes(ActionEvent event) throws IOException {
        setDataPane(dataPane, fadeAnimate("/vista/Clientes.fxml"));
    }

    public void Ventas(ActionEvent event) throws IOException {
        setDataPane(dataPane, fadeAnimate("/vista/Venta.fxml"));
    }
    
    public void CerrarSesion(ActionEvent event) throws IOException, Exception {
        Cerrar(this.btnSalir);
        AbrirVentana("/vista/Login.fxml","LOGIN");
    }
    
    public void Salir(ActionEvent event) throws IOException, Exception {
        Cerrar(this.btnSalir);
    }
}