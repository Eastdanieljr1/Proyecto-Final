/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.scene.control.TextField;
import modelo.Cliente;
import modelo.Clientes;
import modelo.Direccion;

/**
 *
 * @author Luis Poot
 */
public class GuardarDatosCliente {
    
    private boolean tareaHecha = false;
    private boolean esModificar;
    private int IDOriginal;
    private int ID;
    private String Nombre;
    private String Apellido;
    private int Telefono;
    private String Calle;
    private int NoCalle;
    private int CodPostal;
    private String Colonia;
    private String Ciudad;
    private String Estado;

    public GuardarDatosCliente(TextField txtID, TextField txtNombre, TextField txtApellido, 
            TextField txtTelefono, TextField txtCalle, TextField txtNoCalle, TextField txtCP, 
            TextField txtColonia, TextField txtCiudad, TextField txtEstado) {
        this.ID = Integer.parseInt(txtID.getText());
        this.Nombre = txtNombre.getText();
        this.Apellido = txtApellido.getText();
        this.Telefono = Integer.parseInt(txtTelefono.getText());
        this.Calle = txtCalle.getText();
        this.NoCalle = Integer.parseInt(txtNoCalle.getText());
        this.CodPostal = Integer.parseInt(txtCP.getText());
        this.Colonia = txtColonia.getText();
        this.Ciudad = txtCiudad.getText();
        this.Estado = txtEstado.getText();
    }
    
    void Agregar() {
        Clientes clientes = new Clientes();
        Cliente cliente = new Cliente(ID, Nombre, Apellido, 
                new Direccion(Telefono, Calle, NoCalle, CodPostal, Colonia, Ciudad, Estado));
        
        if (clientes.ExisteCliente(cliente)){
            clientes.CrearCliente(cliente);
            setTareaHecha(true);
        }
        else{
            if(!clientes.ExisteIDCliente(ID)){
                clientes.CrearCliente(cliente);
                setTareaHecha(true);
            }
        }

    }

    void Modificar() {
        Clientes clientes=new Clientes();
        Cliente cliente = new Cliente(ID, Nombre, Apellido, 
                new Direccion(Telefono, Calle, NoCalle, CodPostal, Colonia, Ciudad, Estado));
        
        if( (IDOriginal!=ID && !clientes.ExisteIDCliente(ID)) || IDOriginal==ID){
            clientes.ModificarCliente(IDOriginal, ID, Nombre, Apellido, 
                    Telefono, Calle, NoCalle, CodPostal, Colonia, Ciudad, Estado);
            tareaHecha = true;
        }
    }

    boolean CamposVacios() {
        boolean existeVacio = false;
        if(Nombre.isEmpty() || Apellido.isEmpty() || Calle.isEmpty() || 
                Colonia.isEmpty() || Ciudad.isEmpty() || Estado.isEmpty()){
            existeVacio = true;
        }
        return existeVacio;
    }

    void setIDOriginal(int IDOriginal) {
        this.IDOriginal = IDOriginal;
    }

    boolean isTareaHecha() {
        return this.tareaHecha;
    }

    private void setTareaHecha(boolean hecho) {
        this.tareaHecha = hecho;
    }
}