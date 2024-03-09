package logica;

public class Administrador{
    private String codigo;
    private String contrasena;
    public Administrador(String codigo, String contrasena) {
        this.codigo = codigo;
        this.contrasena = contrasena;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}