package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.App;
import logica.Usuario;

public class ActualizarPaciente extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    JTextField tfPassword, tfNombre, tfApellido, tfEdad;
    String[] generos = {"Selecciona uno", "Masculino", "Femenino"};
    JComboBox<String> cbGenero = new JComboBox<>(generos);
    private Usuario usuario;
    
    public ActualizarPaciente(Usuario usuario) {
        this.usuario = usuario;
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

        cbGenero.setFont(mainFont);

        tfNombre.setText(usuario.getNombres());
        tfApellido.setText(usuario.getApellidos());        
        tfPassword.setText(usuario.getContrasena());
        cbGenero.setSelectedItem(usuario.getGenero());        
        tfEdad.setText(usuario.getEdad());

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

        JButton btnOK = new JButton("Actualizar Paciente");
        btnOK.setFont(mainFont);
        btnOK.setBackground(new Color(251, 123, 123));
        btnOK.setForeground(new Color(255, 255, 255));
        btnOK.setBorderPainted(false);
        btnOK.setForeground(getForeground());
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPaciente();
                
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

        setTitle("Actualizar Paciente");

        setContentPane(panelPrincipal);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);   
             
    }

    private void actualizarPaciente() {
        // Obtener los datos actualizados del paciente desde los campos de texto
        String nombre = tfNombre.getText();
        String apellido =tfApellido.getText();        
        String password = tfPassword.getText();
        String genero = (String) cbGenero.getSelectedItem();
        String edad = tfEdad.getText();
        

        // Actualizar los datos del paciente
        usuario.setNombres(nombre);
        usuario.setApellidos(apellido);
        usuario.setContrasena(password);
        usuario.setGenero(genero);
        usuario.setEdad(edad);
        

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente.");

        // Actualizar el doctor en la lista
        App.actualizarPacienteEnLista(usuario);

        // Cerrar la ventana
        dispose();
    }

    
    
}
