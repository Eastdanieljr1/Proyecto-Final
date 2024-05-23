package modelo;

public class Usuario {
    private static String Contraseña="chiquito";
    private static boolean Administrador;
    
    public static String getContraseña() {
        return Contraseña;
    }
    
    public static boolean isAdministrador() {
        return Administrador;
    }
    
    public static void setAdministrador(boolean administrador) {
        Administrador = administrador;
    }
}
