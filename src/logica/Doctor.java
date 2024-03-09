package logica;

import java.util.Objects;

public class Doctor extends Usuario {
    public static Doctor doctor;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String codigo;
    private String contrasena;
    private String edad;
    private String telefono;
    private String genero;

    public Doctor(String codigo, String nombres, String apellidos, String especialidad, String contrasena, String genero, String telefono, String edad) {
        super(codigo, nombres, apellidos, contrasena, genero, edad);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.edad = edad;
        this.telefono = telefono;
        this.genero = genero;

    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigo() {
        return codigo;
    }
    

    public String getContrasena() {
        return contrasena;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public static void actualizarDoctorEnLista(Doctor doctor) {
        for (int i = 0; i < interfaz.AdminFrame.modeloTablaDoctores.getRowCount(); i++) {
            if (interfaz.AdminFrame.modeloTablaDoctores.getValueAt(i, 0).equals(doctor.getCodigo())) {
                interfaz.AdminFrame.modeloTablaDoctores.setValueAt(doctor.getNombres(), i, 1);
                interfaz.AdminFrame.modeloTablaDoctores.setValueAt(doctor.getApellidos(), i, 2);
                interfaz.AdminFrame.modeloTablaDoctores.setValueAt(doctor.getEspecialidad(), i, 3);
                interfaz.AdminFrame.modeloTablaDoctores.setValueAt(doctor.getGenero(), i, 4);
                interfaz.AdminFrame.modeloTablaDoctores.setValueAt(doctor.getTelefono(), i, 5);
                interfaz.AdminFrame.modeloTablaDoctores.setValueAt(doctor.getEdad(), i, 6);
                return;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Doctor doctor = (Doctor) obj;
        return Objects.equals(nombres, doctor.nombres);
        // Compara otros campos si es necesario
    }

    

    
}