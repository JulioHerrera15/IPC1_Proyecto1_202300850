package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import logica.App;
import logica.Doctor;


public class CrearDoctorFrame extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    JTextField tfPassword, tfNombre, tfApellido, tfEspecialidad, tfEdad, tfTelefono;
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

        

        String[] generos = {"Selecciona uno", "Masculino", "Femenino"};
        JComboBox<String> cbGenero = new JComboBox<>(generos);
        cbGenero.setFont(mainFont);

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

        JButton btnOK = new JButton("Añadir Doctor");
        btnOK.setFont(mainFont);
        btnOK.setBackground(new Color(251, 123, 123));
        btnOK.setForeground(new Color(255, 255, 255));
        btnOK.setBorderPainted(false);
        btnOK.setForeground(getForeground());
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombres = tfNombre.getText();
                String Apellidos = tfApellido.getText();
                String Especialidad = tfEspecialidad.getText(); 
                String Password = tfPassword.getText();               
                String Genero = (String) cbGenero.getSelectedItem();
                String Telefono = tfTelefono.getText();
                String Edad = tfEdad.getText();
                
                
                if (Nombres.isEmpty() || Apellidos.isEmpty() || Especialidad.isEmpty() || Password.length() == 0 || Genero.equals("Selecciona uno") || Edad.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos", "Advertencia" ,JOptionPane.WARNING_MESSAGE);
                    return;

                }
                InterfazIniciarSesion.codigoDoctor = InterfazIniciarSesion.codigoDoctor + 1;
                String codigoString = Integer.toString(InterfazIniciarSesion.codigoDoctor);
                JOptionPane.showMessageDialog(null, "Doctor creado con éxito, código: " + codigoString, "Doctor Creado", JOptionPane.INFORMATION_MESSAGE);
                Doctor nuevoDoctor = new Doctor(codigoString, Nombres, Apellidos, Especialidad, Password, Genero, Telefono, Edad, "No disponible");
                App.doctores.add(nuevoDoctor);
                AdminFrame.agregarDoctorATabla(nuevoDoctor);
                AdminFrame.actualizarGraficaDoctores();
                dispose();
                
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

        setTitle("Nuevo Doctor");

        setContentPane(panelPrincipal);
        setSize(400, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);   
             
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
