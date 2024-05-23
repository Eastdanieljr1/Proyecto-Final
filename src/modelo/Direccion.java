package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Direccion implements Serializable {
    private int NoTelefono;
    private String calle;
    private int NoCalle;
    private int CodPostal;
    private String colonia;
    private String ciudad;
    private String estado;

    public Direccion(int NoTelefono, String calle, int NoCalle, int CodPostal, 
            String colonia, String ciudad, String estado) {
        this.NoTelefono = NoTelefono;
        this.calle = calle;
        this.NoCalle = NoCalle;
        this.CodPostal = CodPostal;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
    }
    
    public int getNoTelefono() {
        return NoTelefono;
    }

    public void setNoTelefono(int NoTelefono) {
        this.NoTelefono = NoTelefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNoCalle() {
        return NoCalle;
    }

    public void setNoCalle(int NoCalle) {
        this.NoCalle = NoCalle;
    }

    public int getCodPostal() {
        return CodPostal;
    }

    public void setCodPostal(int CodPostal) {
        this.CodPostal = CodPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Teléfono: " + NoTelefono + ", calle: " + 
                calle + ", No. calle: " + NoCalle + ", Cod. postal: " + 
                CodPostal + ", colonia: " + colonia + ", ciudad: " + 
                ciudad + ", " + estado;
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
        final Direccion other = (Direccion) obj;
        if (this.NoTelefono != other.NoTelefono) {
            return false;
        }
        if (this.NoCalle != other.NoCalle) {
            return false;
        }
        if (this.CodPostal != other.CodPostal) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.colonia, other.colonia)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }
    
}
