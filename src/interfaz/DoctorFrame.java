package interfaz;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import logica.App;
import logica.Cita;
import logica.Doctor;
import logica.Horario;

public class DoctorFrame extends JFrame {
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    final private Font tableFont = new Font("Segoe UI", Font.PLAIN, 15);
    final private Font encabezadoFont = new Font("Segoe UI", Font.BOLD, 30);
    public static int codigoCitas = 000;
    private JTabbedPane tabbedPane;
    DefaultTableModel modeloTablaHorario = new DefaultTableModel();
    private static List<String> horarios = new ArrayList<>();
    private static Doctor doctor;

    public DoctorFrame(Doctor doctor){
        Doctor.doctor = doctor;       
        
    }
    public void initialize(){
        Doctor doctorActual = null;
        for (Doctor doctor : App.doctores) {
            if (doctor.getCodigo().equals(InterfazIniciarSesion.tfCodigo.getText())){
                doctorActual = doctor;
                doctorActual.toString();
                break;
            }
        }
        if(doctorActual != null){
            DoctorFrame.doctor = doctorActual;
            String nombreDoctor = DoctorFrame.doctor.getNombres();
            setTitle("Doctor");
            setSize(1000, 1000);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            
            JPanel encabezadoJPanel = new JPanel();
            encabezadoJPanel.setLayout(new BorderLayout());
            encabezadoJPanel.setBounds(0, 0, 1200, 100);

            JButton editarPerfilDoctor = new JButton("Editar Perfil");
            editarPerfilDoctor.setBackground(new Color(50, 215, 75));
            editarPerfilDoctor.setForeground(new Color(255, 255, 255));
            final Doctor finalDoctorActual = doctorActual;
            editarPerfilDoctor.setFont(mainFont);
            editarPerfilDoctor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    EditarPerfilDoctorFrame actualizarDoctorFrame = new EditarPerfilDoctorFrame(finalDoctorActual);
                    actualizarDoctorFrame.initialize();
                }
            });
            encabezadoJPanel.add(editarPerfilDoctor, BorderLayout.EAST);

            JLabel titulo = new JLabel("Bienvenido Dr. " + nombreDoctor, SwingConstants.CENTER);
            titulo.setFont(encabezadoFont);
            encabezadoJPanel.add(titulo, BorderLayout.WEST);

            add(encabezadoJPanel, BorderLayout.NORTH);

            tabbedPane = new JTabbedPane();
            tabbedPane.setFont(mainFont);

            //Panel Citas
            JPanel panelCitas = new JPanel(new BorderLayout());
            tabbedPane.addTab("Citas", panelCitas);
            getContentPane().add(tabbedPane);

            // Crear un modelo de tabla y configurar las columnas
            DefaultTableModel modeloTablaCitas = new DefaultTableModel();
            modeloTablaCitas.addColumn("Fecha");
            modeloTablaCitas.addColumn("Hora");            
            modeloTablaCitas.addColumn("Paciente");
            modeloTablaCitas.addColumn("Motivo");
            
            

            



            

            // Iterar sobre todas las citas y añadir las citas del doctor a la tabla
            for (Cita cita : App.citas) {                
                if (cita.getCodigoDoctor().equals(doctorActual.getCodigo())) {
                    modeloTablaCitas.addRow(new Object[]{cita.getFecha(), cita.getHora(), cita.getPaciente(), cita.getMotivo()});
                }
            }

            // Crear una tabla y añadir el modelo a la tabla
            JTable tablaCitas = new JTable(modeloTablaCitas);
            tablaCitas.setFont(tableFont);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);


            for (int i = 0; i < tablaCitas.getColumnCount(); i++) {
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }          
            

            // Añadir la tabla a un JScrollPane
            JScrollPane scrollPaneCitas = new JScrollPane(tablaCitas);

            tablaCitas.getTableHeader().setFont(new Font(tableFont.getName(), Font.BOLD, tableFont.getSize()));

            JButton btnVerMas = new JButton("Ver más");
            btnVerMas.setBackground(new Color(50, 215, 75));
            btnVerMas.setForeground(new Color(255, 255, 255));
            btnVerMas.setFont(mainFont);
            btnVerMas.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = tablaCitas.getSelectedRow()+1;
                    if (selectedRow != -1) {
                        JOptionPane.showMessageDialog(null, "Paciente: " + tablaCitas.getValueAt(selectedRow, 2) + "\n" +
                                "Fecha: " + tablaCitas.getValueAt(selectedRow, 0) + "\n" +
                                "Hora: " + tablaCitas.getValueAt(selectedRow, 1) + "\n" +
                                "Motivo: " + tablaCitas.getValueAt(selectedRow, 3), "Cita", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            JButton btnAtender = new JButton("Atender");
            btnAtender.setBackground(new Color(50, 215, 75));
            btnAtender.setForeground(new Color(255, 255, 255));
            btnAtender.setFont(mainFont);
            btnAtender.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = tablaCitas.getSelectedRow();
                    if (selectedRow != -1) {
                        PacienteFrame.setEstadoCita(selectedRow, "Aceptada");
                        JOptionPane.showMessageDialog(null, "Esta cita será atendida", "Cita", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            });

            JButton btnRechazar = new JButton("Rechazar");
            btnRechazar.setBackground(new Color(50, 215, 75));
            btnRechazar.setForeground(new Color(255, 255, 255));
            btnRechazar.setFont(mainFont);
            btnRechazar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = tablaCitas.getSelectedRow();
                    if (selectedRow != -1) {
                        PacienteFrame.setEstadoCita(selectedRow, "Rechazada");
                        JOptionPane.showMessageDialog(null, "Esta cita será rechazada", "Cita", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }});

            JPanel panelBotones = new JPanel();
            panelBotones.add(btnVerMas);
            panelBotones.add(btnAtender);
            panelBotones.add(btnRechazar);

            panelCitas.add(panelBotones, BorderLayout.SOUTH);

            // Añadir el JScrollPane al panel de citas
            panelCitas.add(scrollPaneCitas, BorderLayout.CENTER);

            // Crear un JTextField para que el Doctor ingrese su horario
            JTextField horarioField = new JTextField();
            horarioField.setFont(mainFont);

            // Crear un botón para agregar el horario
            JButton asignarButton = new JButton("Asignar");
            asignarButton.setFont(mainFont);
            asignarButton.setBackground(new Color(50, 215, 75));
            asignarButton.setForeground(new Color(255, 255, 255));
            asignarButton.addActionListener(e -> {
                // Obtener el horario del JTextField
                Doctor doctor = DoctorFrame.doctor;
                codigoCitas++;
                // Formatear el código de citas
                String codigoCitasFormateado = String.format("%03d", codigoCitas);
            
                String horario = horarioField.getText();
                

                // Agregar el horario a la tabla
                modeloTablaHorario.addRow(new Object[]{codigoCitasFormateado, horario});

                // Crear un nuevo objeto Horario y agregarlo al ArrayList
                Horario nuevoHorario = new Horario(doctor, codigoCitas, horario);
                App.horarios.add(nuevoHorario);
                horarios.add(horario);

                // Limpiar el JTextField
                horarioField.setText("");
            });

            JLabel labelHorarioCitas = new JLabel("Horario de citas:");
            labelHorarioCitas.setFont(mainFont);
            JLabel tituloPanelAsignarHorarios = new JLabel("Mi horario disponible para citas:");
            tituloPanelAsignarHorarios.setFont(mainFont);
            tituloPanelAsignarHorarios.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel panelHorario = new JPanel();
            panelHorario.add(labelHorarioCitas);
            panelHorario.add(horarioField);
            panelHorario.add(asignarButton);
            panelHorario.add(tituloPanelAsignarHorarios);


            
            //Panel Asignar Horarios
            JPanel panelAsignarHorarios = new JPanel(new BorderLayout());
           
            
            
            panelAsignarHorarios.add(panelHorario, BorderLayout.NORTH);
            
            JTable tablaHorarios = new JTable();
            tablaHorarios.setFont(tableFont);

            tablaHorarios.getTableHeader().setFont(new Font(tableFont.getName(), Font.BOLD, tableFont.getSize()));

            
            
            modeloTablaHorario.addColumn("No.");
            modeloTablaHorario.addColumn("Horario de cita");
            
            tablaHorarios.setModel(modeloTablaHorario);
            JScrollPane scrollPane = new JScrollPane(tablaHorarios);
            panelAsignarHorarios.add(scrollPane, BorderLayout.CENTER);

            JPanel panelPrincipal = new JPanel(new BorderLayout());
            panelPrincipal.add(panelAsignarHorarios, BorderLayout.CENTER);
            getContentPane().add(panelPrincipal);
            titulo.setFont(encabezadoFont);
            panelPrincipal.add(titulo, BorderLayout.NORTH);
            panelPrincipal.add(tabbedPane, BorderLayout.CENTER);

            

            tabbedPane.addTab("Asignar Horarios", panelAsignarHorarios);

            getContentPane().add(panelPrincipal);
            
            
            setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "No se encontró el doctor", "Error", JOptionPane.ERROR_MESSAGE);
            
        }


    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DoctorFrame doctorFrame = new DoctorFrame(doctor);
        doctorFrame.initialize();
    }

    public static List<String> getHorarios() {
        return horarios;
    }


    

    
    
}
