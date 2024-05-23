/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.scene.control.TextField;
import modelo.Articulos;

/**
 *
 * @author Luis Poot
 */
public class GuardarDatosArticulo {
    private boolean tareaHecha = false;
    private int IDOriginal;
    private int ID;
    private String nombre;
    private float precioPub;
    private float precioPro;
    private int cantidad;
    
    GuardarDatosArticulo(TextField txtID, TextField txtNombre, 
            TextField txtPrecioPub, TextField txtPrecioPro, TextField txtCantidad) {
        this.ID = Integer.parseInt(txtID.getText());
        this.nombre = txtNombre.getText();
        this.precioPub = Float.parseFloat(txtPrecioPub.getText());
        this.precioPro = Float.parseFloat(txtPrecioPro.getText());
        this.cantidad = Integer.parseInt(txtCantidad.getText());
    }
    
    public void Agregar() {
        Articulos articulo=new Articulos();
        
        if (articulo.ExisteArticulo(ID, nombre, precioPub, precioPro)){
            articulo.AgregarArticulo(ID, cantidad);
            setTareaHecha(true);
        }
        else{
            if(!articulo.ExisteIDArticulo(ID)){
                articulo.CrearArticulo(ID, nombre, precioPub, precioPro, cantidad);
                setTareaHecha(true);
            }
        }
    }
    
    public void Modificar() {
        Articulos articulo=new Articulos();
        
        if( (IDOriginal!=ID && !articulo.ExisteIDArticulo(ID)) || IDOriginal==ID){
            articulo.ModificarArticulo(IDOriginal, ID, nombre, precioPub, precioPro, cantidad);
            tareaHecha = true;
        }
    }
    
    public boolean CamposVacios() {
        return nombre.isEmpty();
    }

    public boolean isTareaHecha() {
        return tareaHecha;
    }

    public void setTareaHecha(boolean tareaHecha) {
        this.tareaHecha = tareaHecha;
    }

    public void setIDOriginal(int IDOriginal) {
        this.IDOriginal = IDOriginal;
    }
    
}