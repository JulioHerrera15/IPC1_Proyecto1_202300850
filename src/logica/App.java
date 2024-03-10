package logica;

import javax.swing.*;

import interfaz.AdminFrame;
import interfaz.InterfazIniciarSesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

    public static Administrador administrador = new Administrador("202300850", "proyecto1IPC1");
    public static List<Doctor> doctores = new ArrayList<>();
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();
    public static List<Cita> citas = new ArrayList<>();
    public static List<Horario> horarios = new ArrayList<>();
    public static HashMap<String, ArrayList<Cita>> citasPorPaciente = new HashMap<>();

        
    public static void main(String[] args) {

        

        SwingUtilities.invokeLater(() -> {
            AdminFrame adminFrame = new AdminFrame(App.doctores, App.usuarios, App.productos);
            InterfazIniciarSesion nuevaSesion = new InterfazIniciarSesion();
            adminFrame.setVisible(true);
            nuevaSesion.setVisible(true);
            
        });

    }

    public static void actualizarDoctorEnLista(Doctor doctor) {
        for (int i = 0; i < AdminFrame.modeloTablaDoctores.getRowCount(); i++) {
            if (AdminFrame.modeloTablaDoctores.getValueAt(i, 0).equals(doctor.getCodigo())) {
                AdminFrame.modeloTablaDoctores.setValueAt(doctor.getNombres(), i, 1);
                AdminFrame.modeloTablaDoctores.setValueAt(doctor.getApellidos(), i, 2);
                AdminFrame.modeloTablaDoctores.setValueAt(doctor.getEspecialidad(), i, 3);
                AdminFrame.modeloTablaDoctores.setValueAt(doctor.getContrasena(), i, 4);
                AdminFrame.modeloTablaDoctores.setValueAt(doctor.getGenero(), i, 5);
                AdminFrame.modeloTablaDoctores.setValueAt(doctor.getTelefono(), i, 6);
                AdminFrame.modeloTablaDoctores.setValueAt(doctor.getEdad(), i, 7);
                return;
            }
        }
    }

    public static void actualizarPacienteEnLista(Usuario usuario) {
        for (int i = 0; i < AdminFrame.modeloTablaPacientes.getRowCount(); i++) {
            if (AdminFrame.modeloTablaPacientes.getValueAt(i, 0).equals(usuario.getCodigo())) {
                AdminFrame.modeloTablaPacientes.setValueAt(usuario.getNombres(), i, 1);
                AdminFrame.modeloTablaPacientes.setValueAt(usuario.getApellidos(), i, 2);
                AdminFrame.modeloTablaPacientes.setValueAt(usuario.getContrasena(), i, 3);
                AdminFrame.modeloTablaPacientes.setValueAt(usuario.getGenero(), i, 4);
                AdminFrame.modeloTablaPacientes.setValueAt(usuario.getEdad(), i, 5);
                return;
            }
        }
    }

    public static void actualizarProductoEnLista(Producto producto) {
        for (int i = 0; i < AdminFrame.modeloTablaProductos.getRowCount(); i++) {
            if (AdminFrame.modeloTablaProductos.getValueAt(i, 0).equals(producto.getCodigo())) {
                AdminFrame.modeloTablaProductos.setValueAt(producto.getNombre(), i, 1);
                AdminFrame.modeloTablaProductos.setValueAt(producto.getDescripcion(), i, 2);
                AdminFrame.modeloTablaProductos.setValueAt(producto.getCantidad(), i, 3);
                AdminFrame.modeloTablaProductos.setValueAt(producto.getPrecio(), i, 4);
                return;
            }
        }
    }


    
}