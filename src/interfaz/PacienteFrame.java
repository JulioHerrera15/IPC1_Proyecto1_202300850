package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.*;
public class PacienteFrame extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    final private Font titleFont = new Font("Segoe UI", Font.BOLD, 25);
    JTextField citaText;
    public void initialize (){
        JTabbedPane pacientePane = new JTabbedPane();

        JPanel solicitarCitaPanel = new JPanel(new BorderLayout());

        JLabel citaLabel = new JLabel("Motivo de la cita:", SwingConstants.CENTER);
        citaLabel.setFont(titleFont);
        citaText = new JTextField();
        citaText.setFont(mainFont);

        JLabel especialidadLabel = new JLabel("Especialidad: ", SwingConstants.LEFT);
        especialidadLabel.setFont(mainFont);
        String[] especialidad = {"Seleccione la opción", "Cardiólogo", "Pediatra", "Urologo", "Ginecologo", "Oftalmologo", "Dermatologo", "Oncologo", "Neurologo", "Psiquiatra"};
        JComboBox<String> especialidadComboBox = new JComboBox<>(especialidad);
        especialidadComboBox.setFont(mainFont);
        JLabel doctorLabel = new JLabel("Doctor: ", SwingConstants.LEFT);
        doctorLabel.setFont(mainFont);
        String[] doctor = {"Seleccione la opción", "a", "b", "c"};
        JComboBox<String> doctorComboBox = new JComboBox<>(doctor);
        doctorComboBox.setFont(mainFont);

        JButton mostrarDoctoresButton = new JButton("Mostrar doctores");
        mostrarDoctoresButton.setFont(mainFont);
        mostrarDoctoresButton.setBorderPainted(false);
        mostrarDoctoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Hacer que se muestren los doctores de la especialidad seleccionada
            }
        });

        JButton mostrarHorariosButton = new JButton("Mostrar Horarios");
        mostrarHorariosButton.setFont(mainFont);
        mostrarHorariosButton.setBorderPainted(false);
        mostrarHorariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Hacer que se muestren los horarios del doctor seleccionado
            }
        });

        JLabel horarioLabel = new JLabel("Seleccionar horario de cita", SwingConstants.CENTER);
        horarioLabel.setFont(titleFont);
        JLabel fechaLabel = new JLabel("Fecha", SwingConstants.LEFT);
        fechaLabel.setFont(mainFont);
        String[] fecha = {"Seleccione la opción", "a", "b", "c"};
        JComboBox<String> fechaComboBox = new JComboBox<>(fecha);
        fechaComboBox.setFont(mainFont);
        JLabel horaLabel = new JLabel("Hora", SwingConstants.LEFT);
        horaLabel.setFont(mainFont);
        String[] hora = {"Seleccione la opción", "a", "b", "c"};
        JComboBox<String> horaComboBox = new JComboBox<>(hora);
        horaComboBox.setFont(mainFont);

        JButton generarCitaButton = new JButton("Generar Cita");
        generarCitaButton.setFont(mainFont);
        generarCitaButton.setBorderPainted(false);
        generarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Hacer que se genere la cita
            }
        });

        JPanel superiorPanel = new JPanel(new GridLayout(3,1,0,1));        
        superiorPanel.setOpaque(false);
        superiorPanel.add(citaLabel);
        superiorPanel.add(citaText);
        superiorPanel.add(horarioLabel);
        superiorPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel centroPanel = new JPanel(new GridLayout(2,2,0,1));        
        centroPanel.setOpaque(false);
        centroPanel.add(especialidadLabel);
        centroPanel.add(especialidadComboBox);
        centroPanel.add(mostrarDoctoresButton);
        centroPanel.add(doctorLabel);
        centroPanel.add(doctorComboBox);
        centroPanel.add(mostrarHorariosButton);
        centroPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel inferiorPanel = new JPanel();
        inferiorPanel.setLayout(new GridLayout(2,2,0,1)); 
        inferiorPanel.setOpaque(false);
        inferiorPanel.add(fechaLabel);
        inferiorPanel.add(fechaComboBox);
        inferiorPanel.add(horaLabel);
        inferiorPanel.add(horaComboBox);
        inferiorPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        // Crear un panel para el botón que utilizará un BoxLayout con alineación en el eje X
        JPanel botonPanel = new JPanel();
        botonPanel.setLayout(new BoxLayout(botonPanel, BoxLayout.X_AXIS));
        botonPanel.setOpaque(false);

        // Añadir el botón al panel del botón y centrarlo
        generarCitaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonPanel.add(generarCitaButton);

        // Añadir el panel del botón al panel inferior
        inferiorPanel.add(botonPanel);

        inferiorPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        solicitarCitaPanel.setLayout(new BorderLayout());
        solicitarCitaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        solicitarCitaPanel.add(superiorPanel, BorderLayout.NORTH);
        solicitarCitaPanel.add(centroPanel, BorderLayout.CENTER);
        solicitarCitaPanel.add(inferiorPanel, BorderLayout.SOUTH);

        JPanel estadoCitaPanel = new JPanel();

        pacientePane.addTab("Solicitar Cita", solicitarCitaPanel);
        pacientePane.addTab("Estado de Cita", estadoCitaPanel);

        add(pacientePane);

        setTitle("Paciente");
        setSize(300, 300);
        setMinimumSize(new Dimension(800, 500));
        setVisible(true);
    }

    public static void main(String[] args){
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacDarkLaf");
            
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        PacienteFrame pacienteFrame = new PacienteFrame();
        pacienteFrame.initialize();
    }
}
