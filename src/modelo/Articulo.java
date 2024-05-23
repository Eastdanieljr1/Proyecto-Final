package modelo;

import java.util.Objects;

public class Articulo {
    protected int ID;
    protected String nombre;
    protected float precioPub;
    protected float precioPro;
    protected int cantidad;
    
    public Articulo(int ID, String nombre, float precioPub, float precioPro, int cantidad) {
        this.ID = ID;
        this.nombre = nombre;
        this.precioPub = precioPub;
        this.precioPro = precioPro;
        this.cantidad = cantidad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioPub() {
        return precioPub;
    }

    public void setPrecioPub(float precioPub) {
        this.precioPub = precioPub;
    }

    public float getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(float precioPro) {
        this.precioPro = precioPro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void Vender(int cantidad) {
        this.cantidad -= cantidad;
    }
    
    public void Agregar(int cantidad) {
        this.cantidad += cantidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articulo other = (Articulo) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (Float.floatToIntBits(this.precioPub) != Float.floatToIntBits(other.precioPub)) {
            return false;
        }
        if (Float.floatToIntBits(this.precioPro) != Float.floatToIntBits(other.precioPro)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }   
}