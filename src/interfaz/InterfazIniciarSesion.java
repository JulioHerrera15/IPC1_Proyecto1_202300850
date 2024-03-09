package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Collections;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.FlatLightLaf;
import logica.App;
import logica.Doctor;
import logica.Usuario;

public class InterfazIniciarSesion extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    public static int codigoPaciente = 202300100, codigoDoctor = 202300200, codigoProducto = 202300300;
    final private Font titleFont = new Font("Segoe UI", Font.BOLD, 30);
    static JTextField tfCodigo;
    JTextField tfPassword;
    JLabel lbWelcome, lbTitle;

    
    
    public void initialize(){
        
        /************************** Form panel *************************/

        JLabel lblCodigo = new JLabel("Código", SwingConstants.CENTER);
        lblCodigo.setFont(mainFont);

        tfCodigo = new JTextField();
        tfCodigo.setFont(mainFont);

        JLabel lblPassword = new JLabel("Password", SwingConstants.CENTER);
        lblPassword.setFont(mainFont);

        tfPassword = new JPasswordField();
        tfPassword.setFont(mainFont);

        /************************** Buttons Label *************************/

        JButton btnOK = new JButton("Iniciar Sesión");
        btnOK.setFont(mainFont);
        btnOK.setBackground(new Color(0, 122, 255));
        btnOK.setForeground(new Color(255, 255, 255));
        btnOK.setBorderPainted(false);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Codigo = tfCodigo.getText();
                String Password = new String(tfPassword.getText());

                               
                for (Usuario usuario : App.usuarios) {
                    if (usuario.getCodigo().equals(Codigo) && usuario.getContrasena().equals(Password)){
                        JOptionPane.showMessageDialog(null, "Bienvenido " + usuario.getNombres() + " " + usuario.getApellidos(), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                        PacienteFrame pacienteFrame = new PacienteFrame(usuario);
                        try {
                            FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#bf5af2")); // Esto cambiará el color de acento a rojo
                            UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacLightLaf");
                            SwingUtilities.updateComponentTreeUI(pacienteFrame);
                            pacienteFrame.pack();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        pacienteFrame.initialize();
                        return; // Salir del método después de encontrar una coincidencia
                    }
                }
                
                for (Doctor doctor : App.doctores) {
                    if(doctor.getCodigo().equals(Codigo) && doctor.getContrasena().equals(Password)){
                        JOptionPane.showMessageDialog(null, "Bienvenido Dr. " + doctor.getNombres() + " " + doctor.getApellidos(), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                        DoctorFrame doctorFrame = new DoctorFrame(doctor);
                        try {
                            FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#0f0")); // Esto cambiará el color de acento a rojo
                            UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacLightLaf");
                            SwingUtilities.updateComponentTreeUI(doctorFrame);
                            doctorFrame.pack();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        doctorFrame.initialize();
                        return; // Salir del método después de encontrar una coincidencia
                    }
                }
                
                if (Codigo.isEmpty() || Password.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                    return;
                } else if(Codigo.equals(App.administrador.getCodigo()) && Password.equals(App.administrador.getContrasena())){
                    JOptionPane.showMessageDialog(null, "Bienvenido Administrador", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    AdminFrame administradorFrame = new AdminFrame(logica.App.doctores, logica.App.usuarios, logica.App.productos);
                    try {
                        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#f00")); // Esto cambiará el color de acento a rojo
                        UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacLightLaf");
                        SwingUtilities.updateComponentTreeUI(administradorFrame);
                        administradorFrame.pack();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    administradorFrame.setVisible(true);
                }

                
            }
        });

        JButton btnCrearCuenta = new JButton("¿No tienes cuenta? ¡Crea una!");
        btnCrearCuenta.setFont(mainFont);
        btnCrearCuenta.setForeground(new Color(0, 122, 255));
        btnCrearCuenta.setBorderPainted(false);
        btnCrearCuenta.setContentAreaFilled(false);
        btnCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoUsuarioFrame nuevoUsuarioFrame = new NuevoUsuarioFrame();
                nuevoUsuarioFrame.intialize();
            }
        });
       

        
        // Carga la imagen
        ImageIcon imageIcon = new ImageIcon("src\\interfaz\\icon.png");
        ImageIcon userIcon = new ImageIcon("src\\interfaz\\user.png");

        // Escala la imagen para que se ajuste a un tamaño específico
        Image image = imageIcon.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);
        Image userImage = userIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        // Crea un nuevo ImageIcon con la imagen escalada
        imageIcon = new ImageIcon(image);
        userIcon = new ImageIcon(userImage);

        // Crea un JLabel y establece el ImageIcon como su icono
        JLabel label = new JLabel(imageIcon);
        JLabel labelUser = new JLabel(userIcon);
        

       

        
        //Título Login        
        lbTitle = new JLabel("Login", SwingConstants.CENTER);
        lbTitle.setFont(titleFont);
        JPanel LoginPanel = new JPanel(new GridLayout(0,1,0,1));        
        LoginPanel.setOpaque(false);
        LoginPanel.add(labelUser, BorderLayout.AFTER_LAST_LINE);
        LoginPanel.add(lbTitle);
        
        

        //Panel de formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5,1,5,5));
        formPanel.setOpaque(false);
        
        formPanel.add(lblCodigo);
        formPanel.add(tfCodigo);
        formPanel.add(lblPassword);
        formPanel.add(tfPassword);

        //Panel de botones
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3,2,5,5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnCrearCuenta);

        

        //Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));               
        mainPanel.add(label, BorderLayout.EAST);
        mainPanel.add(LoginPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);        
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        


        add(mainPanel);        

        
        setTitle("Login");
        setSize(300, 300);
        setMinimumSize(new Dimension(600, 450));
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){        
        FlatLightLaf.setup();

        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacLightLaf");
            
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        InterfazIniciarSesion mainFrame = new InterfazIniciarSesion();
        mainFrame.initialize();
        
    }
}