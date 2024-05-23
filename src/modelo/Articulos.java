package modelo;

import java.util.ArrayList;

public class Articulos {
    private static ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private static Articulo editar;

    public static Articulo getEditar() {
        return editar;
    }

    public static void setEditar(Articulo editar) {
        Articulos.editar = editar;
    }
    
    public boolean ExisteArticulo(int ID, String nombre, float precioPub, float precioPro) {
        boolean existe = false;
        for(Articulo articulo : articulos){
            if(articulo.getID( )== ID && articulo.getNombre().equals(nombre) && 
                    articulo.getPrecioPub() == precioPub &&  articulo.getPrecioPro() == precioPro){
                existe = true;
                    break;
            }
        }
        return existe;
    }
    
    public boolean ExisteIDArticulo(int ID) {
        boolean existe = false;
        for(Articulo articulo : articulos){
            if(articulo.getID() == ID){
                existe = true;
                    break;
            }
        }
        return existe;
    }
    
    public void CrearArticulo(int ID, String nombre, float precioPub, float precioPro, int cantidad) {
        articulos.add(new Articulo (ID, nombre, precioPub, precioPro, cantidad));
    }
    
    public void AgregarArticulo(int ID, int cantidad) {
       for(Articulo articulo : articulos){
            if(articulo.getID()==ID){
                articulo.Agregar(cantidad);
                    break;
            }
        }
    }
    
    public void VenderArticulo(int ID, int Cantidad) {
        for(Articulo articulo : articulos){
            if(articulo.getID() == ID){
                articulo.Vender(Cantidad);
                    break;
            }
        }
    }
    
    public boolean isArticuloAgotado(int ID, int Cantidad) {
        boolean agotado = false;
        for(Articulo articulo : articulos){
            if(articulo.getID() == ID){
                if(articulo.getCantidad() == 0){
                    agotado = true;
                        break;
                }
            }
        }
        return agotado;
    }
    
    public boolean isArticuloInsuficiente(int ID, int Cantidad) {
        boolean insuficiente = true;
        for(Articulo articulo : articulos){
            if(articulo.getID() == ID){
                if(articulo.getCantidad() < Cantidad){
                    insuficiente = false;
                        break;
                }
            }
        }
        return insuficiente;
    }
    
    public void ModificarArticulo(int IDOriginal, int ID, String nombre, float precioPub, 
            float precioPro, int cantidad) {
        for(Articulo articulo: articulos){
            if(articulo.getID() == IDOriginal){
                articulo.setID(ID);
                articulo.setNombre(nombre);
                articulo.setPrecioPub(precioPub);
                articulo.setPrecioPro(precioPro);
                articulo.setCantidad(cantidad);
                    break;
            }
        }
    }
    
    public void EliminarArticulo(Articulo selectedItem) {
        articulos.remove(selectedItem);
    }
    
    public static ArrayList<Articulo> getArticulos() {
        return articulos;
    }
}