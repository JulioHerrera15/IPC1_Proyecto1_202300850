package interfaz;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.Doctor;
import logica.Usuario;
import logica.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class AdminFrame extends JFrame{
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 20);
    final private Font titleFont = new Font("Segoe UI", Font.BOLD, 30);
    final private Font tabFont = new Font("Segoe UI", Font.BOLD, 20);
    final private Font tableFont = new Font("Segoe UI", Font.PLAIN, 15);
    JButton btnAddUser = new JButton("Crear Paciente");
    JButton btnActualizarPaciente = new JButton("Actualizar Paciente");
    JButton btnEliminarPaciente = new JButton("Eliminar Paciente");
    JButton btnAddDoctor = new JButton("Agregar Doctor");
    JButton btnActualizarDoctor = new JButton("Actualizar Doctor");
    JButton btnEliminarDoctor = new JButton("Eliminar Doctor");
    JButton btnAddProducto = new JButton("Agregar Producto");
    JButton btnActualizarProducto = new JButton("Actualizar Producto");
    JButton btnEliminarProducto = new JButton("Eliminar Producto");
    public static DefaultTableModel modeloTablaDoctores = new DefaultTableModel();
    public static DefaultTableModel modeloTablaPacientes = new DefaultTableModel();
    static DefaultTableModel modeloTablaProductos = new DefaultTableModel();
    
    public AdminFrame(List<Doctor> doctores, List<Usuario> usuarios, List<Producto> productos) {
        initialize(doctores, usuarios, productos);
    }
    
    private void initialize(List<Doctor> doctores, List<Usuario> usuarios, List<Producto> productos){
        JLabel lbTitle = new JLabel("Bienvenido Administrador", SwingConstants.CENTER);
        lbTitle.setFont(titleFont);
        lbTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        lbTitle.setBounds(0, 20, 400, 40);
        add(lbTitle);
        

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(mainFont);
        //tabbedPane.setBackground(new Color(255, 169, 77));
        tabbedPane.setBounds(0, 0, 400, 300);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setBorder(null);

        JPanel panelPacientes = new JPanel(new BorderLayout());
        JTable tablaPacientes = new JTable();
        tablaPacientes.getTableHeader().setFont(new Font(tableFont.getName(), Font.BOLD, tableFont.getSize()));

        JLabel tituloPanelPacientes = new JLabel("Listado Pacientes");
        tituloPanelPacientes.setFont(tabFont);
        tituloPanelPacientes.setHorizontalAlignment(SwingConstants.CENTER);
        panelPacientes.add(tituloPanelPacientes, BorderLayout.NORTH);
        panelPacientes.setFont(tabFont);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tablaPacientes.setDefaultRenderer(Object.class, centerRenderer);

        if(modeloTablaPacientes.getColumnCount() == 0){
            modeloTablaPacientes.addColumn("Codigo");
            modeloTablaPacientes.addColumn("Nombres");
            modeloTablaPacientes.addColumn("Apellidos");
            modeloTablaPacientes.addColumn("Contraseña");
            modeloTablaPacientes.addColumn("Género");        
            modeloTablaPacientes.addColumn("Edad");
        }
        
        JPanel panelBotonesPacientes = new JPanel();
        panelBotonesPacientes.setLayout(new GridLayout(0,1,3,3));
        //panelBotonesPaciente.setBackground(new Color(251, 240, 154));
        panelBotonesPacientes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBotonesPacientes.setBounds(0, 0, 400, 300);
        panelBotonesPacientes.add(btnAddUser);
        panelBotonesPacientes.add(btnActualizarPaciente);
        panelBotonesPacientes.add(btnEliminarPaciente);

        tablaPacientes.setModel(modeloTablaPacientes);
        tablaPacientes.setFont(tableFont);
        JScrollPane scrollPanePacientes = new JScrollPane(tablaPacientes);
        panelPacientes.add(scrollPanePacientes, BorderLayout.CENTER);
        panelPacientes.add(panelBotonesPacientes, BorderLayout.EAST);
        tabbedPane.addTab("Pacientes", panelPacientes);
        tabbedPane.setFont(mainFont);
        getContentPane().add(tabbedPane);       


        JPanel panelDoctores = new JPanel(new BorderLayout());
        JTable tablaDoctores = new JTable();
        tablaDoctores.getTableHeader().setFont(new Font(tableFont.getName(), Font.BOLD, tableFont.getSize()));

        JLabel tituloPanelDoctores = new JLabel("Listado Doctores");
        tituloPanelDoctores.setFont(tabFont);
        tituloPanelDoctores.setHorizontalAlignment(SwingConstants.CENTER);           
        panelDoctores.add(tituloPanelDoctores, BorderLayout.NORTH);
        panelDoctores.setFont(tabFont);

        DefaultTableCellRenderer centerRendererDoctores = new DefaultTableCellRenderer();
        centerRendererDoctores.setHorizontalAlignment( JLabel.CENTER );
        tablaDoctores.setDefaultRenderer(Object.class, centerRenderer);        

        if (modeloTablaDoctores.getColumnCount() == 0) {
            modeloTablaDoctores.addColumn("Codigo");
            modeloTablaDoctores.addColumn("Nombres");
            modeloTablaDoctores.addColumn("Apellidos");
            modeloTablaDoctores.addColumn("Especialidad");
            modeloTablaDoctores.addColumn("Contraseña");
            modeloTablaDoctores.addColumn("Género");
            modeloTablaDoctores.addColumn("Teléfono");
            modeloTablaDoctores.addColumn("Edad");

        }     


        JPanel panelBotonesDoctor = new JPanel();
        panelBotonesDoctor.setLayout(new GridLayout(0,1,3,3));
        //panelBotonesPaciente.setBackground(new Color(251, 240, 154));
        panelBotonesDoctor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBotonesDoctor.setBounds(0, 0, 400, 300);
        panelBotonesDoctor.add(btnAddDoctor);
        panelBotonesDoctor.add(btnActualizarDoctor);
        panelBotonesDoctor.add(btnEliminarDoctor);

        tablaDoctores.setModel(modeloTablaDoctores);
        tablaDoctores.setFont(tableFont);
        JScrollPane scrollPaneDoctores = new JScrollPane(tablaDoctores);
        panelDoctores.add(scrollPaneDoctores, BorderLayout.CENTER);
        panelDoctores.add(panelBotonesDoctor, BorderLayout.EAST);
        tabbedPane.addTab("Doctores", panelDoctores);
        tabbedPane.setFont(mainFont);
        getContentPane().add(tabbedPane);


        JPanel panelProductos = new JPanel(new BorderLayout());
        JTable tablaProductos = new JTable();
        tablaProductos.getTableHeader().setFont(new Font(tableFont.getName(), Font.BOLD, tableFont.getSize()));

        JLabel tituloPanelProductos = new JLabel("Listado Productos");
        tituloPanelProductos.setFont(tabFont);
        tituloPanelProductos.setHorizontalAlignment(SwingConstants.CENTER);
        panelProductos.add(tituloPanelProductos, BorderLayout.NORTH);
        panelProductos.setFont(tabFont);

        DefaultTableCellRenderer centerRendererProductos = new DefaultTableCellRenderer();
        centerRendererProductos.setHorizontalAlignment( JLabel.CENTER );
        tablaProductos.setDefaultRenderer(Object.class, centerRenderer);

        if (modeloTablaProductos.getColumnCount() == 0) {
            modeloTablaProductos.addColumn("Codigo");
            modeloTablaProductos.addColumn("Nombre");
            modeloTablaProductos.addColumn("Descripción");
            modeloTablaProductos.addColumn("Cantidad");
            modeloTablaProductos.addColumn("Precio (Q.)");        
        }
        

        JPanel panelBotonProductos = new JPanel();
        panelBotonProductos.setLayout(new GridLayout(0,1,3,3));
        //panelBotonesPaciente.setBackground(new Color(251, 240, 154));
        panelBotonProductos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelBotonProductos.setBounds(0, 0, 400, 300);
        panelBotonProductos.add(btnAddProducto);
        panelBotonProductos.add(btnActualizarProducto);
        panelBotonProductos.add(btnEliminarProducto);

        tablaProductos.setModel(modeloTablaProductos);
        tablaProductos.setFont(tableFont);
        JScrollPane scrollPaneProductos = new JScrollPane(tablaProductos);
        panelProductos.add(scrollPaneProductos, BorderLayout.CENTER);
        panelProductos.add(panelBotonProductos, BorderLayout.EAST);
        tabbedPane.addTab("Productos", panelProductos);
        tabbedPane.setFont(mainFont);        
        getContentPane().add(tabbedPane);



        btnAddUser.setFont(mainFont);
        //btnAddUser.setBackground(new Color(178, 242, 187));
        btnAddUser.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAddUser.setBorderPainted(false);
        btnAddUser.setBounds(50, 100, 300, 40);
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearPacienteFrame nuevoPacienteFrame = new CrearPacienteFrame();
                nuevoPacienteFrame.initialize();
            }
        });
        
        btnActualizarPaciente.setFont(mainFont);
        //btnActualizarPaciente.setBackground(new Color(178, 242, 187));
        btnActualizarPaciente.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnActualizarPaciente.setBorderPainted(false);
        btnActualizarPaciente.setBounds(50, 150, 300, 40);
        btnActualizarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaPacientes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String codigo = (String) modeloTablaPacientes.getValueAt(filaSeleccionada, 0);
                    Usuario usuario = buscarPacientePorCodigo(codigo);
                    if (usuario != null) {
                        ActualizarPaciente interfazActualizarDoctor = new ActualizarPaciente(usuario);
                        interfazActualizarDoctor.initialize();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un doctor con el código proporcionado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un doctor para actualizar.");
                }
            }
        });
        
        

        btnEliminarPaciente.setFont(mainFont);
        //btnEliminarPaciente.setBackground(new Color(178, 242, 187));
        btnEliminarPaciente.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnEliminarPaciente.setBorderPainted(false);
        btnEliminarPaciente.setBounds(50, 200, 300, 40);
        btnEliminarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int filaSeleccionadaPaciente = tablaPacientes.getSelectedRow();
        
                if (filaSeleccionadaPaciente != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este paciente?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if(confirmacion == JOptionPane.YES_OPTION){
                        modeloTablaPacientes.removeRow(filaSeleccionadaPaciente);
                        JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un paciente para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });     
        
        
        btnAddDoctor.setFont(mainFont);
        //btnAddDoctor.setBackground(new Color(178, 242, 187));
        btnAddDoctor.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAddDoctor.setBorderPainted(false);
        btnAddDoctor.setBounds(50, 150, 300, 40);
        btnAddDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearDoctorFrame nuevoDoctorFrame = new CrearDoctorFrame();
                nuevoDoctorFrame.initialize();
            }
        });

        btnActualizarDoctor.setFont(mainFont);
        //btnAddDoctor.setBackground(new Color(178, 242, 187));
        btnActualizarDoctor.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnActualizarDoctor.setBorderPainted(false);
        btnActualizarDoctor.setBounds(50, 150, 300, 40);
        btnActualizarDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaDoctores.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String codigo = (String) modeloTablaDoctores.getValueAt(filaSeleccionada, 0);
                    Doctor doctor = buscarDoctorPorCodigo(codigo);
                    if (doctor != null) {
                        ActualizarDoctorFrame interfazActualizarDoctor = new ActualizarDoctorFrame(doctor);
                        interfazActualizarDoctor.initialize();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un doctor con el código proporcionado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un doctor para actualizar.");
                }
            }
        });

        btnEliminarDoctor.setFont(mainFont);
        //btnAddDoctor.setBackground(new Color(178, 242, 187));
        btnEliminarDoctor.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnEliminarDoctor.setBorderPainted(false);
        btnEliminarDoctor.setBounds(50, 150, 300, 40);
        btnEliminarDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int filaSeleccionadaDoctor = tablaDoctores.getSelectedRow();
        
                if (filaSeleccionadaDoctor != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este doctor?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if(confirmacion == JOptionPane.YES_OPTION){
                        modeloTablaDoctores.removeRow(filaSeleccionadaDoctor);
                        JOptionPane.showMessageDialog(null, "Doctor eliminado correctamente", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un doctor para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        btnAddProducto.setFont(mainFont);
        //btnAddProducto.setBackground(new Color(178, 242, 187));
        btnAddProducto.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAddProducto.setBorderPainted(false);
        btnAddProducto.setPreferredSize(new Dimension(100, 30));
        btnAddProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearProductoFrame nuevoProductoFrame = new CrearProductoFrame();
                nuevoProductoFrame.initialize();
            }
        });


        btnActualizarProducto.setFont(mainFont);
        //btnActualizarPaciente.setBackground(new Color(178, 242, 187));
        btnActualizarProducto.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnActualizarProducto.setBorderPainted(false);
        btnActualizarProducto.setBounds(50, 150, 300, 40);
       /* btnActualizarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarPaciente actualizarPaciente = new ActualizarPaciente();
                actualizarPaciente.initialize();
            }
        });*/
        
        

        btnEliminarProducto.setFont(mainFont);
        //btnEliminarPaciente.setBackground(new Color(178, 242, 187));
        btnEliminarProducto.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnEliminarProducto.setBorderPainted(false);
        btnEliminarProducto.setBounds(50, 200, 300, 40);
        btnEliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int filaseleccionadaProducto = tablaProductos.getSelectedRow();
        
                if (filaseleccionadaProducto != -1) {
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if(confirmacion == JOptionPane.YES_OPTION){
                        modeloTablaProductos.removeRow(filaseleccionadaProducto);
                        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBounds(0, 0, 400, 300);
        //panel.setBackground(new Color(251, 240, 154));
        panel.add(lbTitle, BorderLayout.NORTH);
        panel.add(tabbedPane, BorderLayout.CENTER);        

        add(panel);


        //setResizable(false);
        setSize(800, 500);
        setTitle("Administrador");
        setVisible(true);

    }

    public static void agregarDoctorATabla(Doctor doctor) {
        modeloTablaDoctores.addRow(new Object[]{doctor.getCodigo(), doctor.getNombres(), doctor.getApellidos(), doctor.getEspecialidad(), doctor.getContrasena(), doctor.getGenero(), doctor.getTelefono(), doctor.getEdad()});
    }

    public static void agregarPacienteATabla(Usuario usuario) {
        modeloTablaPacientes.addRow(new Object[]{usuario.getCodigo(), usuario.getNombres(), usuario.getApellidos(), usuario.getContrasena(), usuario.getGenero(), usuario.getEdad()});
    }

    public static void agregarProductoTabla(Producto producto) {
        modeloTablaProductos.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getDescripcion(), producto.getCantidad(), producto.getPrecio()});
    }

    public static void actualizarTablaPacientes(){
        List<Usuario> usuarios = logica.App.usuarios;
        modeloTablaPacientes.setRowCount(0);
        for (Usuario usuario : usuarios) {
            modeloTablaPacientes.addRow(new Object[]{usuario.getCodigo(), usuario.getNombres(), usuario.getApellidos(), usuario.getContrasena(), usuario.getGenero(), usuario.getEdad()});
        }
    }

    public Doctor buscarDoctorPorCodigo(String codigo) {
        List<Doctor> doctores = logica.App.doctores;
        for (Doctor doctor : doctores) {
            if (doctor instanceof Doctor && doctor.getCodigo().equals(codigo)) {
                return (Doctor) doctor;
            }
        }
        return null;
    }

    public Usuario buscarPacientePorCodigo(String codigo) {
        List<Usuario> usuarios = logica.App.usuarios;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Usuario && usuario.getCodigo().equals(codigo)) {
                return (Usuario) usuario;
            }
        }
        return null;
    }

    public static void actualizarTablaDoctores() {
        List<Doctor> doctores = logica.App.doctores;
        modeloTablaDoctores.setRowCount(0);
        for (Doctor doctor : doctores) {
            modeloTablaDoctores.addRow(new Object[]{doctor.getCodigo(), doctor.getNombres(), doctor.getApellidos(), doctor.getEspecialidad(), doctor.getContrasena(), doctor.getGenero(), doctor.getTelefono(), doctor.getEdad()});
        }
    }

    public static void actualizarTablaProductos() {
        List<Producto> productos = logica.App.productos;
        modeloTablaProductos.setRowCount(0);
        for (Producto producto : productos) {
            modeloTablaProductos.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getDescripcion(), producto.getCantidad(), producto.getPrecio()});
        }
    }

    

    
}