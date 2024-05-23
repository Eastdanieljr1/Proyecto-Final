/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import modelo.Clientes;

/**
 * FXML Controller class
 *
 * @author aaa
 */
public class VistaClientesControlador extends VentanasControlador implements Initializable {
    
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableColumn colID;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPat;
    @FXML
    private TableColumn colDireccion;
    
    private ObservableList<Cliente> clientes;
    private ArrayList<Cliente> lista;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colApellidoPat.setCellValueFactory(new PropertyValueFactory<>("apellidoPat"));
        this.colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccionLec"));
        
        lista = new ArrayList();
        lista = Clientes.getClientes();
        clientes = FXCollections.observableArrayList(lista);
        tblClientes.setItems(clientes);
    }
    
    public void Agregar(ActionEvent event) throws Exception {
        setAccion(null);
    }
    
    public void Modificar(ActionEvent event) throws Exception {
        if(tblClientes.getSelectionModel().getSelectedItem()==null)
            VentanaEmergente(Alert.AlertType.INFORMATION,"AVISO", "Elemento vacío",
                    "Primero tiene que seleccionar un cliente\nen la tabla.");
        else setAccion(tblClientes.getSelectionModel().getSelectedItem());
    }
    
    public void Eliminar(ActionEvent event) throws IOException {
        if(this.tblClientes.getSelectionModel().getSelectedItem()!=null){
            Clientes cliente = new Clientes();
            cliente.EliminarCliente(this.tblClientes.getSelectionModel().getSelectedItem());
            clientes.remove(this.tblClientes.getSelectionModel().getSelectedItem());
            VentanaEmergente(Alert.AlertType.INFORMATION, "HECHO","Datos borrados.",
                    "Se han borrado con éxito los datos\nde la persona seleccionada.");
            this.tblClientes.refresh();
        }else{
            VentanaEmergente(Alert.AlertType.ERROR,"AVISO", "Elemento vacío", 
                    "Primero tiene que seleccionar una persona\nen la tabla.");
        }
    }
    
    public void setAccion(Cliente cliente) throws Exception {
        Clientes.setEditar(cliente);
        AbrirVentana("/vista/InsertarDatosCliente.fxml", "Datos del cliente");
        
        lista = Clientes.getClientes();
        clientes = FXCollections.observableArrayList(lista);
        tblClientes.setItems(clientes); 
        tblClientes.refresh();
    }
}
