package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Articulos;

public class InsertarDatosArticuloControlador extends VentanasControlador 
        implements Initializable {
    
    private boolean esModificar;
    private int IDOriginal;
    
    @FXML
    protected TextField txtID;
    @FXML
    protected TextField txtNombre;
    @FXML
    protected TextField txtPrecioPub;
    @FXML
    protected TextField txtPrecioPro;
    @FXML
    protected TextField txtCantidad;
    
    @FXML
    private Button btnCancelar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        esModificar = Iniciar();
    }    
    
    private boolean Iniciar() {
        if(Articulos.getEditar()!=null){
            IDOriginal = Articulos.getEditar().getID();
            txtID.setText(IDOriginal + "");
            txtNombre.setText(Articulos.getEditar().getNombre());
            txtPrecioPub.setText(Articulos.getEditar().getPrecioPub() + "");
            txtPrecioPro.setText(Articulos.getEditar().getPrecioPro() + "");
            txtCantidad.setText(Articulos.getEditar().getCantidad() + "");
            return true;
        }
        else return false;
    }
    
    @FXML
    public void Aceptar(ActionEvent event) throws IOException {
        try{
            GuardarDatosArticulo guardar = new GuardarDatosArticulo(txtID, 
                    txtNombre, txtPrecioPub, txtPrecioPro, txtCantidad);
            if(!guardar.CamposVacios()) {
                if(esModificar) {
                    guardar.setIDOriginal(IDOriginal);
                    guardar.Modificar();
                }
                else guardar.Agregar();
                if(guardar.isTareaHecha()) {
                    Cerrar(btnCancelar);
                    VentanaEmergente(Alert.AlertType.INFORMATION,"HECHO","Datos guardados.",
                            "Se han guardado con éxito los datos\n que se ingresaron.");
                }else{
                    VentanaEmergente(Alert.AlertType.ERROR,"Error", "ID existente.", 
                            "No podemos registrar 2 artículos con el mismo ID.");
                }
            }
            else VentanaEmergente(Alert.AlertType.ERROR, "Error", 
                    "Formato incorrecto.", "Campos vacíos.");
        }catch (NumberFormatException e) {
            VentanaEmergente(Alert.AlertType.ERROR, "Error", "Formato incorrecto.", 
                    "Ha ingresado algún dato incorrecto.");
        }
    }
    
    @FXML
    public void Cancelar(ActionEvent event) throws IOException {
        Cerrar(this.btnCancelar);
    }
    
}