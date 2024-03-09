package interfaz;
import com.formdev.flatlaf.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import logica.App;
import logica.Cita;
import logica.Doctor;
import logica.Producto;
import logica.Usuario;
public class PacienteFrame extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    final private Font titleFont = new Font("Segoe UI", Font.BOLD, 25);
    final private Font encabezadoFont = new Font("Segoe UI", Font.BOLD, 30);
    final private Font tableFont = new Font("Segoe UI", Font.PLAIN, 15);    
    JButton editarPerfilButton = new JButton("Editar perfil");
    static DefaultTableModel citasModelTable = new DefaultTableModel();
    JComboBox<String> especialidadComboBox;
    JComboBox<String> doctorComboBox;
    
    JTextField citaText;
    private static Usuario usuario;

    public PacienteFrame(Usuario usuario) {
        Usuario.usuario = usuario;
    }
    public void initialize (){
        Usuario usuarioActual = null;
        for (Usuario usuario : App.usuarios) {
            if (usuario.getCodigo().equals(InterfazIniciarSesion.tfCodigo.getText())){
                usuarioActual = usuario;
                break;
            }
        }
        if (usuarioActual != null) {
            PacienteFrame.usuario = usuarioActual;
            String nombrePaciente = PacienteFrame.usuario.getNombres();
            JTabbedPane pacientePane = new JTabbedPane();

            JPanel solicitarCitaPanel = new JPanel(new BorderLayout());
            JLabel bienvenidaLabel = new JLabel("Bienvenido " + nombrePaciente, SwingConstants.CENTER);
            JPanel encabezadoJPanel = new JPanel();
            encabezadoJPanel.setLayout(new BorderLayout());
            encabezadoJPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            encabezadoJPanel.add(bienvenidaLabel, BorderLayout.WEST);
            encabezadoJPanel.add(editarPerfilButton, BorderLayout.EAST);
            

            // Agrega el panel al marco
            this.add(encabezadoJPanel, BorderLayout.NORTH);           
            
            bienvenidaLabel.setFont(encabezadoFont);
            JLabel citaLabel = new JLabel("Motivo de la cita:", SwingConstants.CENTER);
            citaLabel.setFont(titleFont);
            citaText = new JTextField();
            citaText.setFont(mainFont);

            JLabel especialidadLabel = new JLabel("Especialidad: ", SwingConstants.LEFT);
            especialidadLabel.setFont(mainFont);
            ArrayList<String> especialidades = new ArrayList<>();
            especialidades.add("Seleccione una opción");
            for (Doctor doctor : App.doctores) {
                String especialidad = doctor.getEspecialidad();
                if (!especialidades.contains(especialidad)) {
                    especialidades.add(especialidad);
                }
            }
            String[] especialidadArray = especialidades.toArray(new String[0]);
            JComboBox<String> especialidadComboBox = new JComboBox<>(especialidadArray);
            especialidadComboBox.setFont(mainFont);
            JLabel doctorLabel = new JLabel("Doctor: ", SwingConstants.LEFT);
            doctorLabel.setFont(mainFont);
            
            ArrayList<String> nombresDoctores = new ArrayList<>();
            nombresDoctores.add("Seleccione una opción");
            String[] nombresDoctoresArray = nombresDoctores.toArray(new String[0]);
            JComboBox<String> doctorComboBox = new JComboBox<>(nombresDoctoresArray);
            especialidadComboBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent arg0) {
                    String especialidadSeleccionada = (String)especialidadComboBox.getSelectedItem();
                    nombresDoctores.clear();
                    nombresDoctores.add("Seleccione una opción");
                    for (Doctor doctor : App.doctores) {
                        if (doctor.getEspecialidad().equals(especialidadSeleccionada)) {
                            String nombreDoctor = "Dr. " + doctor.getNombres() + " " + doctor.getApellidos();
                            nombresDoctores.add(nombreDoctor);
                        }
                    }
                    
                    String [] nombresDoctoresArray = nombresDoctores.toArray(new String[0]);                                       
                    doctorComboBox.setFont(mainFont);
                    doctorComboBox.setModel(new DefaultComboBoxModel<>(nombresDoctoresArray));
                }
            });

            if (especialidadComboBox.getItemListeners().length > 0) {
                especialidadComboBox.getItemListeners()[0].itemStateChanged(null);
            }

            JButton mostrarDoctoresButton = new JButton("Mostrar doctores");
            mostrarDoctoresButton.setBackground(new Color(191, 90, 242));
            mostrarDoctoresButton.setForeground(Color.WHITE);
            mostrarDoctoresButton.setFont(mainFont);
            mostrarDoctoresButton.setBorderPainted(false);
            mostrarDoctoresButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String especialidadSeleccionada = (String)especialidadComboBox.getSelectedItem();
                    StringBuilder doctoresDisponibles = new StringBuilder();
                    for (Doctor doctor : App.doctores) {
                        if (doctor.getEspecialidad().equals(especialidadSeleccionada)) {
                            String nombreDoctor = "Dr. " + doctor.getNombres() + " " + doctor.getApellidos();
                            doctoresDisponibles.append(nombreDoctor).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, doctoresDisponibles.toString(), "Doctores disponibles", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            JButton mostrarHorariosButton = new JButton("Mostrar Horarios");
            mostrarHorariosButton.setBackground(new Color(191, 90, 242));
            mostrarHorariosButton.setForeground(Color.WHITE);
            mostrarHorariosButton.setFont(mainFont);
            mostrarHorariosButton.setBorderPainted(false);
            mostrarHorariosButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //Hacer que se muestren los horarios del doctor seleccionado
                }
            });

            JLabel horarioLabel = new JLabel("Seleccionar horario de cita: ", SwingConstants.CENTER);
            horarioLabel.setFont(titleFont);
            JLabel fechaLabel = new JLabel("Fecha: ", SwingConstants.LEFT);
            fechaLabel.setFont(mainFont);
            String[] fecha = {"Seleccione la opción", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
            JComboBox<String> fechaComboBox = new JComboBox<>(fecha);
            fechaComboBox.setFont(mainFont);
            JLabel horaLabel = new JLabel("Hora: ", SwingConstants.LEFT);
            horaLabel.setFont(mainFont);
            String[] hora = {"Seleccione la opción", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"};
            JComboBox<String> horaComboBox = new JComboBox<>(hora);
            horaComboBox.setFont(mainFont);

            JButton generarCitaButton = new JButton("Generar Cita");
            generarCitaButton.setBackground(new Color(191, 90, 242));
            generarCitaButton.setForeground(Color.WHITE);
            generarCitaButton.setFont(mainFont);
            generarCitaButton.setBorderPainted(false);
            List<String> codigosDoctores = new ArrayList<>();
            for (Doctor doctor : App.doctores) {
                doctorComboBox.addItem(doctor.getNombres());
                codigosDoctores.add(doctor.getCodigo());
            }
            generarCitaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    int indiceSeleccionado = doctorComboBox.getSelectedIndex()-1;
                    if (indiceSeleccionado >= 0 && indiceSeleccionado < codigosDoctores.size()) {
                        String codigoDoctor = codigosDoctores.get(indiceSeleccionado);
                        String motivoCita = citaText.getText();                    
                        Cita cita = new Cita(fechaComboBox.getSelectedItem().toString(), horaComboBox.getSelectedItem().toString(), usuario.getNombres(), citaText.getText(), especialidadComboBox.getSelectedItem().toString(), doctorComboBox.getSelectedItem().toString(), codigoDoctor);
                        App.citas.add(cita);      

                        citasModelTable.addRow(new Object[]{citasModelTable.getRowCount() + 1, motivoCita, "Pendiente", fechaComboBox.getSelectedItem().toString(), horaComboBox.getSelectedItem().toString()});
                        generarCitaButton.setEnabled(false);
                        if (motivoCita.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecciona un doctor");
                    }                    
                    
                    
                }
            });

            
            editarPerfilButton.setFont(mainFont);
            editarPerfilButton.setBackground(new Color(191, 90, 242));
            editarPerfilButton.setForeground(Color.WHITE);
            editarPerfilButton.setBounds(1027, 30, 150, 30);
            editarPerfilButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ActualizarPaciente actualizarPacienteFrame = new ActualizarPaciente(usuario);
                    actualizarPacienteFrame.initialize();
                }
            });

            // Agrega el botón al panel
            

            JPanel citaLabelPanel = new JPanel();
            citaLabelPanel.setLayout(new BorderLayout());     
            citaLabelPanel.setOpaque(false);
            citaLabelPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            citaLabelPanel.add(citaLabel, BorderLayout.WEST);

            JPanel boxPanel = new JPanel();
            boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
            boxPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            boxPanel.setOpaque(false);
            boxPanel.add(citaText);
            boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));

            JPanel especialidadPanel = new JPanel();
            especialidadPanel.setLayout(new BoxLayout(especialidadPanel, BoxLayout.X_AXIS));
            especialidadPanel.setOpaque(false);
            especialidadPanel.add(especialidadLabel);
            especialidadPanel.add(especialidadComboBox);
            especialidadPanel.add(Box.createRigidArea(new Dimension(50, 0)));
            especialidadPanel.add(mostrarDoctoresButton);

            JPanel doctorPanel = new JPanel();
            doctorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.X_AXIS));
            doctorPanel.add(doctorLabel);
            doctorPanel.add(doctorComboBox);
            doctorPanel.add(Box.createRigidArea(new Dimension(50, 0)));
            doctorPanel.add(mostrarHorariosButton);

            JPanel tituloPanel = new JPanel();
            tituloPanel.setLayout(new BorderLayout());
            tituloPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
            tituloPanel.setOpaque(false);
            tituloPanel.add(Box.createRigidArea(new Dimension(0, 50)));
            tituloPanel.add(horarioLabel, BorderLayout.WEST);
            

            JPanel inferiorPanel = new JPanel();
            inferiorPanel.setLayout(new BoxLayout(inferiorPanel, BoxLayout.X_AXIS));
            inferiorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            inferiorPanel.add(fechaLabel);
            inferiorPanel.add(fechaComboBox);
            inferiorPanel.add(Box.createRigidArea(new Dimension(75, 0)));
            inferiorPanel.add(horaLabel);
            inferiorPanel.add(horaComboBox);
            inferiorPanel.add(Box.createRigidArea(new Dimension(75, 0)));
            inferiorPanel.add(generarCitaButton);

            solicitarCitaPanel.setLayout(new BoxLayout(solicitarCitaPanel, BoxLayout.Y_AXIS));
            solicitarCitaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            solicitarCitaPanel.add(citaLabelPanel);
            solicitarCitaPanel.add(boxPanel);
            solicitarCitaPanel.add(especialidadPanel);
            solicitarCitaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            solicitarCitaPanel.add(doctorPanel);
            solicitarCitaPanel.add(tituloPanel);
            solicitarCitaPanel.add(inferiorPanel);

            JPanel estadoCitasPanel = new JPanel(new BorderLayout());

            JLabel historialCitasLabel = new JLabel("Historial de citas:", SwingConstants.LEFT);
            historialCitasLabel.setFont(titleFont);

            if (citasModelTable.getColumnCount() == 0) {
                citasModelTable.addColumn("No.");
                citasModelTable.addColumn("Motivo");
                citasModelTable.addColumn("Estado");
                citasModelTable.addColumn("Fecha");
                citasModelTable.addColumn("Hora");
            }

            JTable citasTable = new JTable(citasModelTable);
            citasTable.setFont(tableFont);

            JTableHeader header = citasTable.getTableHeader();
            header.setFont(mainFont);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            for (int i = 0; i < citasTable.getColumnCount(); i++) {
                citasTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }



            estadoCitasPanel.setLayout(new GridLayout(2,1,5,5));        
            estadoCitasPanel.add(historialCitasLabel, BorderLayout.NORTH);
            estadoCitasPanel.add(new JScrollPane(citasTable), BorderLayout.CENTER);
            estadoCitasPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            pacientePane.addTab("Solicitar Cita", solicitarCitaPanel);
            pacientePane.addTab("Estado de Cita", estadoCitasPanel);

            int numColumnas = 3;
            int numProductos = App.productos.size();
            int numFilas = (int) Math.ceil((double) numProductos / numColumnas);
            JPanel farmaciaPanel = new JPanel();            
            farmaciaPanel.setLayout(new GridLayout(numFilas, numColumnas, 10, 10));

            for (Producto producto : App.productos) {
                JPanel productoPanel = new JPanel();
                productoPanel.setLayout(new BoxLayout(productoPanel, BoxLayout.Y_AXIS));
                productoPanel.setBorder(new CompoundBorder(new LineBorder(new Color(191, 90, 242)), new EmptyBorder(10, 10, 10, 10)));

                JLabel nombreProductoLabel = new JLabel("Nombre: " + producto.getNombre());
                nombreProductoLabel.setFont(mainFont);
                productoPanel.add(nombreProductoLabel);

                JLabel descripcionProductoLabel = new JLabel("Descripción: " + producto.getDescripcion());
                descripcionProductoLabel.setFont(mainFont);
                productoPanel.add(descripcionProductoLabel);

                JLabel cantidadProductoLabel = new JLabel("Cantidad: " + String.valueOf(producto.getCantidad()));
                cantidadProductoLabel.setFont(mainFont);
                productoPanel.add(cantidadProductoLabel);

                JLabel precioProductoLabel = new JLabel("Precio: Q. " + String.valueOf(producto.getPrecio()) + "0");
                precioProductoLabel.setFont(mainFont);
                productoPanel.add(precioProductoLabel);
                farmaciaPanel.add(productoPanel);

            }
            pacientePane.addTab("Farmacia", farmaciaPanel);
            pacientePane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pacientePane.setFont(mainFont);



            add(pacientePane);

            setTitle("Paciente");
            setSize(300, 500);
            setMinimumSize(new Dimension(900, 500));
            setVisible(true);           
            
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            
        } 
        
        
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        PacienteFrame pacienteFrame = new PacienteFrame(usuario);
        pacienteFrame.initialize();
    }

    public static void setEstadoCita(int fila, String estado) {
        citasModelTable.setValueAt(estado, fila, 2); // Asume que la columna del estado es la 4
    }

   
}
