package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import logica.App;
import logica.Usuario;

public class NuevoUsuarioFrame extends JFrame {
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    JTextField tfPassword, tfNombre, tfApellido, tfEdad;
    public void intialize(){
              

        /************************** Form panel *************************/

        JLabel lblNombre = new JLabel("Nombres", SwingConstants.CENTER);
        lblNombre.setFont(mainFont);

        tfNombre = new JTextField();
        tfNombre.setFont(mainFont);

        JLabel lblApellido = new JLabel("Apellidos", SwingConstants.CENTER);
        lblApellido.setFont(mainFont);

        tfApellido = new JTextField();
        tfApellido.setFont(mainFont);

        JLabel lblPassword = new JLabel("Password", SwingConstants.CENTER);
        lblPassword.setFont(mainFont);

        tfPassword = new JPasswordField();
        tfPassword.setFont(mainFont);

        JLabel lblGenero = new JLabel("Género", SwingConstants.CENTER);
        lblGenero.setFont(mainFont);

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
        datosPanel.add(lblPassword, BorderLayout.SOUTH);
        datosPanel.add(tfPassword, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblGenero, BorderLayout.CENTER);
        datosPanel.add(cbGenero, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblEdad, BorderLayout.CENTER);
        datosPanel.add(tfEdad, BorderLayout.AFTER_LAST_LINE);
        
        

        /************************** Buttons Label *************************/

        JButton btnOK = new JButton("Crear Cuenta");
        btnOK.setFont(mainFont);
        //btnOK.setBackground(new Color(178, 242, 187));
        btnOK.setBorderPainted(false);
        btnOK.setForeground(getForeground());
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = tfNombre.getText();
                String Apellido = tfApellido.getText();
                String Edad = tfEdad.getText();
                String Password = tfPassword.getText();
                String Genero = (String) cbGenero.getSelectedItem();
                
                if (Nombre.isEmpty() || Apellido.isEmpty() || Edad.isEmpty() || Password.length() == 0 || Genero.equals("Selecciona uno")) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos", "Advertencia" ,JOptionPane.WARNING_MESSAGE);
                    return;

                }
                InterfazIniciarSesion.codigoPaciente = InterfazIniciarSesion.codigoPaciente + 1;
                String codigoString = Integer.toString(InterfazIniciarSesion.codigoPaciente);
                JOptionPane.showMessageDialog(null, "Cuenta creada con éxito, tu código es: " + codigoString, "Cuenta Creada", JOptionPane.INFORMATION_MESSAGE);
                Usuario nuevoUsuario = new Usuario(codigoString, Password, Nombre, Apellido, Genero, Edad);
                App.usuarios.add(nuevoUsuario);
                AdminFrame.agregarPacienteATabla(nuevoUsuario);
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

        setTitle("Crear Cuenta");

        setContentPane(panelPrincipal);
        setSize(400, 600);
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
        NuevoUsuarioFrame nuevoUsuarioFrame = new NuevoUsuarioFrame();
        nuevoUsuarioFrame.intialize();
    }

    
}
