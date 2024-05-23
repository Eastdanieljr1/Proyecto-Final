/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Articulo;
import modelo.Articulos;

/**
 * FXML Controller class
 *
 * @author aaa
 */
public class VistaArticulosControlador extends VentanasControlador 
        implements Initializable {
    
    @FXML
    protected TableView<Articulo> tblArticulos;
    @FXML
    private TableColumn colID;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colPrecioPub;
    @FXML
    private TableColumn colPrecioPro;
    @FXML
    private TableColumn colCantidad;
    
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    
    private ArrayList<Articulo> lista;
    private ObservableList<Articulo> articulos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecioPub.setCellValueFactory(new PropertyValueFactory<>("precioPub"));
        colPrecioPro.setCellValueFactory(new PropertyValueFactory<>("precioPro"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        
        lista = new ArrayList();
        lista = Articulos.getArticulos();
        articulos = FXCollections.observableArrayList(lista);
        tblArticulos.setItems(articulos);
    }    
    
    public void Agregar(ActionEvent event) throws Exception {
        setAccion(null);
    }
    
    public void Modificar(ActionEvent event) throws Exception {
        if(tblArticulos.getSelectionModel().getSelectedItem()==null)
            VentanaEmergente(Alert.AlertType.ERROR, "AVISO", "Elemento vacío", 
                    "Primero tiene que seleccionar un artículo\nen la tabla.");
        else setAccion(tblArticulos.getSelectionModel().getSelectedItem());
    }
    
    public void Eliminar(ActionEvent event) throws Exception {
        if(tblArticulos.getSelectionModel().getSelectedItem() == null)
            VentanaEmergente(Alert.AlertType.ERROR, "AVISO", "Elemento vacío", 
                    "Primero tiene que seleccionar un artículo\nen la tabla.");
        else{
            Articulos articulo = new Articulos();
            articulo.EliminarArticulo(tblArticulos.getSelectionModel().getSelectedItem());
            articulos.remove(tblArticulos.getSelectionModel().getSelectedItem());
            VentanaEmergente(Alert.AlertType.INFORMATION, "HECHO","Datos borrados.",
                    "Se han borrado con éxito los datos\ndel artículo seleccionado.");
            tblArticulos.refresh();
        }
    }
    
    public void setAccion(Articulo articulo) throws Exception {
        Articulos.setEditar(articulo);
        AbrirVentana("/vista/InsertarDatosArticulo.fxml",
                "Datos del artículo");
        
        lista = Articulos.getArticulos();
        articulos = FXCollections.observableArrayList(lista);
        tblArticulos.setItems(articulos);
        tblArticulos.refresh();
    }
}
