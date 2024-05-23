package modelo;

import java.util.ArrayList;

public class Clientes {
    private static Cliente editar;
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
    public boolean ExisteCliente(Cliente cliente) {
        boolean existe=false;
        if(clientes.contains(cliente))
            existe = true;
        return existe;
    }
    
    public boolean ExisteIDCliente(int ID) {
        boolean existeID = false;
        for(Cliente cliente : clientes){
            if(cliente.getID() == ID){
                existeID = true;
                    break;
            }
        }
        return existeID;
    }
    
    public void CrearCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public void ModificarCliente(int IDOriginal, int ID, String nombre, 
            String apellidoPat, int NoTelefono, String calle, int NoCalle,
            int CodPostal, String colonia, String ciudad, String estado) {
        for(Cliente cliente : clientes){
            if(IDOriginal==cliente.getID()){
                cliente.setID(ID);
                cliente.setNombre(nombre);
                cliente.setApellidoPat(apellidoPat);
                cliente.getDireccion().setNoTelefono(NoTelefono);
                cliente.getDireccion().setCalle(calle);
                cliente.getDireccion().setNoCalle(NoCalle);
                cliente.getDireccion().setCodPostal(CodPostal);
                cliente.getDireccion().setColonia(colonia);
                cliente.getDireccion().setCiudad(ciudad);
                cliente.getDireccion().setEstado(estado);
                cliente.setDireccionLec();
                return;
            }
        }
    }

    public static Cliente getEditar() {
        return editar;
    }

    public static void setEditar(Cliente editar) {
        Clientes.editar = editar;
    }
    
    public void EliminarCliente(Cliente selectedItem) {
        clientes.remove(selectedItem);
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
