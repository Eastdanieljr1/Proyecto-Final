/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import modelo.Articulos;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Clientes;

/**
 *
 * @author Luis Poot
 */
public class VentaControlador  extends VentanasControlador implements Initializable {
    Carrito carrito;
    
    @FXML
    CheckBox CheckSinRegistro;
    @FXML
    TextField txtCliente;
    @FXML
    TextField txtArticulo;
    @FXML
    Spinner<Integer> NumArticulos;
    @FXML
    Button btnVerificar;
    @FXML
    Label lblCliente;
    
    String Vienvenida = "Lista de compra del cliente";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.lblCliente.setText(Vienvenida);
        this.carrito = new Carrito();
        NumArticulos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12));
        //this.btnVerificar.setMouseTransparent(true);
    }
    
    public void Verificar(ActionEvent event) throws IOException {
        try{
            int IdCliente = Integer.parseInt(this.txtCliente.getText());
            Clientes cliente = new Clientes();

            if(cliente.ExisteIDCliente(IdCliente)){
                this.carrito.setCliente(IdCliente);
                this.lblCliente.setText(Vienvenida + " " + this.carrito.getCliente().getNombre());
            } else {
                VentanaEmergente(Alert.AlertType.ERROR, "", "Cliente no registrado", 
                        "Asegurese de que el id del cliente se encuentre registrado.");
            }
        } catch(Exception e) {
            VentanaEmergente(Alert.AlertType.ERROR, "AVISO", "Ingrese un ID", 
                        "Asegurese de ingresar el id del cliente.");
        }
    }
    
    public void Agregar(ActionEvent event) throws IOException {
        try {
            int IdArticulo = Integer.parseInt(this.txtArticulo.getText());
            int cantidad = NumArticulos.getValue();
            Articulos articulo = new Articulos();

            if ( articulo.ExisteIDArticulo(IdArticulo) ){
                if ( articulo.isArticuloAgotado(IdArticulo, cantidad) ) {
                    VentanaEmergente(Alert.AlertType.WARNING, "AVISO", "Articulo agotado", 
                        "Ya no existe en stock.");
                } else {
                    if ( articulo.isArticuloInsuficiente(IdArticulo, cantidad) ) {
                        VentanaEmergente(Alert.AlertType.WARNING, "AVISO", "Articulo insuficiente", 
                        "Se agregaron los productos en existencia únicamente.");
                    }
                    this.carrito.setArticulos(IdArticulo, cantidad);
                }
            } else {
                VentanaEmergente(Alert.AlertType.ERROR, "AVISO", "Articulo no registrado", 
                        "Asegurese de que el id del articulo se encuentre registrado.");
            }
        } catch(Exception e) {
            VentanaEmergente(Alert.AlertType.ERROR, "AVISO", "Ingrese datos válidos", 
                        "Asegurese de ingresar los datos correspondientes.");
        }
    }
    
    public void Eliminar(ActionEvent event) throws IOException {
        try {
            int IdArticulo = Integer.parseInt(this.txtArticulo.getText());
            int cantidad = NumArticulos.getValue();
            Articulos articulo = new Articulos();

            if ( articulo.ExisteIDArticulo(IdArticulo) ){
                if ( articulo.isArticuloAgotado(IdArticulo, cantidad) ) {
                    VentanaEmergente(Alert.AlertType.WARNING, "AVISO", "Articulo agotado", 
                        "Ya no existe en stock.");
                } else {
                    if ( articulo.isArticuloInsuficiente(IdArticulo, cantidad) ) {
                        VentanaEmergente(Alert.AlertType.WARNING, "AVISO", "Articulo insuficiente", 
                        "Se agregaron los productos en existencia únicamente.");
                    }
                    this.carrito.setArticulos(IdArticulo, cantidad);
                }
            } else {
                VentanaEmergente(Alert.AlertType.ERROR, "AVISO", "Articulo no registrado", 
                        "Asegurese de que el id del articulo se encuentre registrado.");
            }
        } catch(Exception e) {
            VentanaEmergente(Alert.AlertType.ERROR, "AVISO", "Ingrese datos válidos", 
                        "Asegurese de ingresar los datos correspondientes.");
        }
    }
    
    public void Cobrar(ActionEvent event) throws IOException {
        
    }
    
    public void Cancelar(ActionEvent event) throws IOException {
        
    }
    
}
