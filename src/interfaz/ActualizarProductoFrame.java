package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import logica.App;
import logica.Producto;



public class ActualizarProductoFrame extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    JTextField tfDescripcion, tfNombre, tfPrecio, tfCantidad;
    private Producto producto;
    
    

    public ActualizarProductoFrame(Producto producto) {
        this.producto = producto;
    }
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
        

        

        tfNombre.setText(producto.getNombre());
        tfDescripcion.setText(producto.getDescripcion());
        tfCantidad.setText(String.valueOf(producto.getCantidad()));
        tfPrecio.setText(String.valueOf(producto.getPrecio()));



        
        datosPanel.setLayout(new GridLayout(0,1,0,1));
        datosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        datosPanel.setOpaque(false);
        if (tfNombre != null && tfDescripcion != null && tfCantidad != null && tfPrecio != null) {
            
            datosPanel.add(lblNombre);
            datosPanel.add(tfNombre);           
            datosPanel.add(lblDescripcion);
            datosPanel.add(tfDescripcion);
            datosPanel.add(lblCantidad);
            datosPanel.add(tfCantidad);
            datosPanel.add(lblPrecio);
            datosPanel.add(tfPrecio);

        }
        
        
        

        /************************** Buttons Label *************************/

        JButton btnOK = new JButton("Actualizar");
        btnOK.setFont(mainFont);
        btnOK.setBackground(new Color(251, 123, 123));
        btnOK.setForeground(new Color(255, 255, 255));
        btnOK.setBorderPainted(false);
        btnOK.setForeground(getForeground());
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
                AdminFrame.actualizarGraficaProductos();
                
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
        
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(datosPanel, BorderLayout.NORTH);
        panelPrincipal.add(buttonPanel, BorderLayout.SOUTH);
        
        add(panelPrincipal);
        
        

        /************************** Frame settings *************************/

        setTitle("Actualizar Producto");

        setContentPane(panelPrincipal);
        setSize(400, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);   
             
    }

    private void actualizarProducto() {
        // Obtener los datos actualizados del doctor desde los campos de texto
        String nombre = tfNombre.getText();
        String descripcion = tfDescripcion.getText();
        int cantidad = Integer.parseInt(tfCantidad.getText());
        double precio = Double.parseDouble(tfPrecio.getText());
        
        

        // Actualizar los datos del doctor
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);
        

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");        

        // Actualizar el doctor en la lista
        App.actualizarProductoEnLista(producto);

        // Cerrar la ventana
        dispose();
    }
}
