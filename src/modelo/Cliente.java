package modelo;

import java.util.Objects;

public class Cliente {
    private int ID;
    private String nombre;
    private String apellidoPat;
    private String direccionLec;
    private Direccion direccion;
        
    public Cliente(int ID, String nombre, String apellidoPat, Direccion direccion) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.direccion = direccion;
        setDireccionLec();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getDireccionLec() {
        return direccionLec;
    }

    public void setDireccionLec() {
        this.direccionLec = this.direccion.toString();
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
        final Cliente other = (Cliente) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPat, other.apellidoPat)) {
            return false;
        }
        if (!Objects.equals(this.direccionLec, other.direccionLec)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return true;
    }
}
