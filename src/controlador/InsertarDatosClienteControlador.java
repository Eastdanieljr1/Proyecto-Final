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
import modelo.Clientes;

public class InsertarDatosClienteControlador extends VentanasControlador 
        implements Initializable {
    
    private boolean esModificar;
    private int IDOriginal;

    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtCalle;
    @FXML
    private TextField txtNoCalle;
    @FXML
    private TextField txtCP;
    @FXML
    private TextField txtColonia;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtEstado;
    
    @FXML
    private Button btnCancelar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        esModificar = Iniciar();
    }
    
    private boolean Iniciar() {
        if(Clientes.getEditar()!=null){
            IDOriginal = Clientes.getEditar().getID();
            txtID.setText(IDOriginal + "");
            txtNombre.setText(Clientes.getEditar().getNombre());
            txtApellido.setText(Clientes.getEditar().getApellidoPat());
            txtTelefono.setText(Clientes.getEditar().getDireccion().getNoTelefono() + "");
            txtCalle.setText(Clientes.getEditar().getDireccion().getCalle());
            txtNoCalle.setText(Clientes.getEditar().getDireccion().getNoCalle() + "");
            txtCP.setText(Clientes.getEditar().getDireccion().getCodPostal() + "");
            txtColonia.setText(Clientes.getEditar().getDireccion().getColonia());
            txtCiudad.setText(Clientes.getEditar().getDireccion().getCiudad());
            txtEstado.setText(Clientes.getEditar().getDireccion().getEstado());
            return true;
        }
        else return false;
    }
    
    @FXML
    public void Aceptar(ActionEvent event) throws IOException {
        try{
            GuardarDatosCliente guardar = new GuardarDatosCliente(txtID, 
                    txtNombre, txtApellido, txtTelefono, txtCalle, txtNoCalle, txtCP,
                    txtColonia, txtCiudad, txtEstado);
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