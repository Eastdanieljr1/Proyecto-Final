package modelo;

import java.util.ArrayList;

public class Carrito {
    private Cliente cliente;
    private ArrayList<ArticuloComprado> articulos;

    public Carrito() {
        articulos = new ArrayList<ArticuloComprado>();
    } 
    
    public void setCliente(int ID) {
        for(Cliente cliente : Clientes.getClientes()){
            if(cliente.getID() == ID){
                this.cliente=cliente;
            }
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setArticulos(int id, int cantidad) {
        for(Articulo articulo : Articulos.getArticulos()){
            if(articulo.getID() == id){               
                this.articulos.add(new ArticuloComprado(articulo,cantidad));
                break;
            }
        }
    }
    
    public void RestarArticulos(int id, int cantidad){
        for(Articulo articulo : Articulos.getArticulos()){
            if(articulo.getID() == id){               
                this.articulos.add(new ArticuloComprado(articulo,cantidad));
                break;
            }
        }
    }
    
    public ArrayList<ArticuloComprado> getArticulos() {
        return articulos;
    }
}
