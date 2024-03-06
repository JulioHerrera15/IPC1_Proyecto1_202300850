package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import logica.App;
import logica.Producto;

public class CrearProductoFrame extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    JTextField tfDescripcion, tfNombre, tfPrecio, tfCantidad, tfCodigo;

    public void initialize(){
              

        /************************** Form panel *************************/

        JLabel lblNombre = new JLabel("Nombre", SwingConstants.CENTER);
        lblNombre.setFont(mainFont);

        tfNombre = new JTextField();
        tfNombre.setFont(mainFont);

        JLabel lblDescripcion = new JLabel("Descripción", SwingConstants.CENTER);
        lblDescripcion.setFont(mainFont);

        tfDescripcion = new JTextField();
        tfDescripcion.setFont(mainFont);

        JLabel lblCantidad = new JLabel("Cantidad", SwingConstants.CENTER);
        lblCantidad.setFont(mainFont);

        tfCantidad = new JTextField();
        tfCantidad.setFont(mainFont);

        JLabel lblPrecio = new JLabel("Precio", SwingConstants.CENTER);
        lblPrecio.setFont(mainFont);

        tfPrecio = new JTextField();
        tfPrecio.setFont(mainFont);

        

        JPanel datosPanel = new JPanel();
        datosPanel.setLayout(new GridLayout(0,1,0,1));
        datosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        datosPanel.setOpaque(false);
        datosPanel.add(lblNombre, BorderLayout.NORTH);
        datosPanel.add(tfNombre, BorderLayout.AFTER_LAST_LINE);        
        datosPanel.add(tfCodigo, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblDescripcion, BorderLayout.SOUTH);
        datosPanel.add(tfDescripcion, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblCantidad, BorderLayout.CENTER);
        datosPanel.add(tfCantidad, BorderLayout.AFTER_LAST_LINE);
        datosPanel.add(lblPrecio, BorderLayout.CENTER);
        datosPanel.add(tfPrecio, BorderLayout.AFTER_LAST_LINE);
        
        

        /************************** Buttons Label *************************/

        JButton btnOK = new JButton("Agregar Producto");
        btnOK.setFont(mainFont);
        //btnOK.setBackground(new Color(178, 242, 187));
        btnOK.setBorderPainted(false);
        btnOK.setForeground(getForeground());
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = tfNombre.getText();
                String Descripcion = tfDescripcion.getText();
                int Cantidad = Integer.parseInt(tfCantidad.getText());
                double Precio = Double.parseDouble(tfPrecio.getText());

                if (Nombre.isEmpty() || Descripcion.isEmpty() || Cantidad == 0 || Precio == 0.0) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                InterfazIniciarSesion.codigoProducto = InterfazIniciarSesion.codigoProducto + 1;
                String codigoString = Integer.toString(InterfazIniciarSesion.codigoProducto);
                JOptionPane.showMessageDialog(null, "Producto creado con éxito", "Usuario creado", JOptionPane.INFORMATION_MESSAGE);
                Producto nuevoProducto = new Producto(codigoString, Nombre, Descripcion, Cantidad, Precio);
                App.productos.add(nuevoProducto);
                AdminFrame.agregarProductoTabla(nuevoProducto);
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

        setTitle("Agregar Producto");

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
        CrearPacienteFrame crearPaciente = new CrearPacienteFrame();
        crearPaciente.initialize();
    }
    
}
