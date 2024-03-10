package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;

import logica.App;
import logica.Doctor;
public class EditarPerfilDoctorFrame extends JFrame{

    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    JTextField tfPassword, tfNombre, tfApellido, tfEspecialidad, tfEdad, tfTelefono;
    private Doctor doctor;
    String[] generos = {"Selecciona uno", "Masculino", "Femenino"};
    JComboBox<String> cbGenero = new JComboBox<>(generos);

    public EditarPerfilDoctorFrame(Doctor doctor) {
        this.doctor = doctor;
    }
    public void initialize(){
              

        /************************** Form panel *************************/

        JLabel lblNombre = new JLabel("Nombres", SwingConstants.CENTER);
        lblNombre.setFont(mainFont);

        tfNombre = new JTextField();
        tfNombre.setFont(mainFont);

        JLabel lblApellido = new JLabel("Apellidos", SwingConstants.CENTER);
        lblApellido.setFont(mainFont);

        tfApellido = new JTextField();
        tfApellido.setFont(mainFont);

        JLabel lblEspecialidad = new JLabel("Especialidad", SwingConstants.CENTER);
        lblEspecialidad.setFont(mainFont);

        tfEspecialidad = new JTextField();
        tfEspecialidad.setFont(mainFont);

        JLabel lblPassword = new JLabel("Password", SwingConstants.CENTER);
        lblPassword.setFont(mainFont);

        tfPassword = new JPasswordField();
        tfPassword.setFont(mainFont);

        JLabel lblGenero = new JLabel("Género", SwingConstants.CENTER);
        lblGenero.setFont(mainFont);

        JLabel lblTelefono = new JLabel("Teléfono (opcional)", SwingConstants.CENTER);
        lblTelefono.setFont(mainFont);

        tfTelefono = new JTextField();
        tfTelefono.setFont(mainFont);

        JLabel lblEdad = new JLabel("Edad", SwingConstants.CENTER);
        lblEdad.setFont(mainFont);

        tfEdad = new JTextField();
        tfEdad.setFont(mainFont);

              
        cbGenero.setFont(mainFont);


        tfNombre.setText(doctor.getNombres());
        tfApellido.setText(doctor.getApellidos());
        tfEspecialidad.setText(doctor.getEspecialidad());
        tfPassword.setText(doctor.getContrasena());
        cbGenero.setSelectedItem(doctor.getGenero());
        tfTelefono.setText(doctor.getTelefono());
        tfEdad.setText(doctor.getEdad());
        



        JPanel datosPanel = new JPanel();
        datosPanel.setLayout(new GridLayout(0,1,0,1));
        datosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        datosPanel.setOpaque(false);
        datosPanel.add(lblNombre, BorderLayout.NORTH);
        datosPanel.add(tfNombre, BorderLayout.AFTER_LAST_LINE);        
        datosPanel.add(lblApellido, BorderLayout.CENTER);
        datosPanel.add(tfApellido, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblEspecialidad, BorderLayout.CENTER);
        datosPanel.add(tfEspecialidad, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblPassword, BorderLayout.SOUTH);
        datosPanel.add(tfPassword, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblGenero, BorderLayout.CENTER);
        datosPanel.add(cbGenero, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblTelefono, BorderLayout.CENTER);
        datosPanel.add(tfTelefono, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblEdad, BorderLayout.CENTER);
        datosPanel.add(tfEdad, BorderLayout.AFTER_LAST_LINE);
        
        
        

        /************************** Buttons Label *************************/

        JButton btnOK = new JButton("Actualizar datos");
        btnOK.setFont(mainFont);
        btnOK.setBackground(new Color(50, 215, 75));
        btnOK.setForeground(new Color(255, 255, 255));
        btnOK.setBorderPainted(false);
        btnOK.setForeground(getForeground());
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDoctor();
                
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(mainFont);
        //btnVolver.setForeground(new Color(0, 0, 255));
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                
            }
        });

        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(btnOK);
        buttonPanel.add(btnVolver);
        buttonPanel.setLayout(new GridLayout(3,2,5,5));
        buttonPanel.setOpaque(false);

        /************************** Add components to panel *************************/

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        //panelPrincipal.setBackground(new Color(165, 216, 255));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(datosPanel, BorderLayout.NORTH);
        panelPrincipal.add(buttonPanel, BorderLayout.SOUTH);
        
        add(panelPrincipal);
        
        

        /************************** Frame settings *************************/

        setTitle("Editar mi perfil");

        setContentPane(panelPrincipal);
        setSize(400, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);   
             
    }

    private void actualizarDoctor() {
        // Obtener los datos actualizados del doctor desde los campos de texto
        String nombre = tfNombre.getText();
        String apellido =tfApellido.getText();
        String especialidad = tfEspecialidad.getText();
        String password = tfPassword.getText();
        String genero = (String) cbGenero.getSelectedItem();
        String telefono = tfTelefono.getText();
        String edad = tfEdad.getText();
        

        // Actualizar los datos del doctor
        doctor.setNombres(nombre);
        doctor.setApellidos(apellido);
        doctor.setEspecialidad(especialidad);
        doctor.setContrasena(password);
        doctor.setGenero(genero);
        doctor.setTelefono(telefono);
        doctor.setEdad(edad);
        

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");

        // Actualizar el doctor en la lista
        App.actualizarDoctorEnLista(doctor);

        // Cerrar la ventana
        dispose();
    }

    

    public static void main(String[] args) {
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacDarkLaf");
            
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        CrearDoctorFrame crearDoctorFrame = new CrearDoctorFrame();
        crearDoctorFrame.initialize();
    }
    
}
