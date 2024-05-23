package modelo;

public class ArticuloComprado {
    Articulo articulo;
    private int cantidadVendida;

    ArticuloComprado(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidadVendida = cantidad;
    }
 
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }   

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
