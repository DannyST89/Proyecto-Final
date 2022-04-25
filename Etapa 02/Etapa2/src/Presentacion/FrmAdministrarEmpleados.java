
package Presentacion;

import Entidades.EntidadEmpleado;
import Logica.BLEmpleado;
import java.util.List;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmAdministrarEmpleados extends javax.swing.JInternalFrame {
    //objeto global
    DefaultTableModel modelo;
    //Instanciamos la clase fecha
    Calendar fecha = new GregorianCalendar();
    
    public FrmAdministrarEmpleados() {
        initComponents();
        //mostramos la fecha
        txtFechaIngreso.setCalendar(fecha);
        //cargarmos los datos de la tabla desde un inicio
        try {
            cargarDatos("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooserBeanInfo1 = new com.toedter.calendar.JMonthChooserBeanInfo();
        panelEmpleados = new javax.swing.JPanel();
        lblIdEmpleado = new javax.swing.JLabel();
        txtFechaIngreso = new com.toedter.calendar.JDateChooser();
        txtIdEmpleado = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        cboCargo = new javax.swing.JComboBox<>();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        txtPrimerApellido = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblPrimerApellido = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblSegundoApellido = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Administrar Empleados"); // NOI18N
        setPreferredSize(new java.awt.Dimension(955, 610));

        panelEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        panelEmpleados.setForeground(new java.awt.Color(51, 51, 51));
        panelEmpleados.setName("hala"); // NOI18N
        panelEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIdEmpleado.setText("ID");
        panelEmpleados.add(lblIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        panelEmpleados.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 147, 33));

        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        panelEmpleados.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 147, 33));

        lblDireccion.setText("Dirección");
        panelEmpleados.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        lblFechaIngreso.setText("Fecha Ingreso");
        panelEmpleados.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));
        panelEmpleados.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 147, 33));

        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cajero", "Bodeguero" }));
        panelEmpleados.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 150, 33));
        panelEmpleados.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 312, 33));

        lblTelefono.setText("Teléfono");
        panelEmpleados.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lblCargo.setText("Cargo");
        panelEmpleados.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));
        panelEmpleados.add(txtPrimerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 147, 33));
        panelEmpleados.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 147, 33));
        panelEmpleados.add(txtSegundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 150, 33));

        lblCorreo.setText("Correo Electrónico");
        panelEmpleados.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));
        panelEmpleados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 147, 33));
        panelEmpleados.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 147, 33));

        lblNombre.setText("Nombre");
        panelEmpleados.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        lblNombreUsuario.setText("Nombre Usuario");
        panelEmpleados.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        lblPrimerApellido.setText("Primer Apellido");
        panelEmpleados.add(lblPrimerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));
        panelEmpleados.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 147, 33));

        lblSegundoApellido.setText("Segundo Apellido");
        panelEmpleados.add(lblSegundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, -1, -1));

        lblContrasenia.setText("Contraseña");
        panelEmpleados.add(lblContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        jButton4.setBackground(new java.awt.Color(98, 87, 219));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-available-updates-24.png"))); // NOI18N
        jButton4.setText("  Actualizar");
        panelEmpleados.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 120, 50));

        btnGuardar.setBackground(new java.awt.Color(98, 87, 219));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-save-24.png"))); // NOI18N
        btnGuardar.setText("  Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelEmpleados.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 120, 50));

        jButton6.setBackground(new java.awt.Color(98, 87, 219));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-24.png"))); // NOI18N
        jButton6.setText("  Eliminar");
        panelEmpleados.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 120, 50));

        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Administrar Empleados.png"))); // NOI18N
        panelEmpleados.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 440, 60));

        tblEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblEmpleados);

        panelEmpleados.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 910, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    //*********************************************************
    //Creamos el método para generar entidad
    private EntidadEmpleado generarEntidad(){        
        EntidadEmpleado empleado = new EntidadEmpleado();
        if(!txtIdEmpleado.getText().equals("")){
            empleado.setExiste(true);
            empleado.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));
        }else{
            empleado.setNombre(txtNombre.getText());
            empleado.setPrimerApellido(txtPrimerApellido.getText()); 
            empleado.setSegundoApellido(txtSegundoApellido.getText());  
            empleado.setTelefono(txtTelefono.getText());   
            empleado.setCorreo(txtCorreo.getText());                
            empleado.setDireccion(txtDireccion.getText());
            empleado.setCargo(cboCargo.getSelectedItem().toString());             
            empleado.setNombreUsuario(txtNombreUsuario.getText());    
            empleado.setConstrasenia(txtContrasenia.getText());
            
             //convertivmos java.util.Date a java.sql.Date
             //Realizamos la siguiente conversión  ya que surge el problema de que al ingresarse una fecha
             //en la capa de datos la fecha es de tipo java.sql.Date por es lo que vamos a recibir en la base de datos
             //para eso necesitamos hacer la conversión aquí para que en la capa de datos el datos que se 
             //envie a la base de datos sea el correcto.
            java.util.Date utilStartDate = txtFechaIngreso.getDate();
            java.sql.Date fechaIngreso = new java.sql.Date(utilStartDate.getTime());              
            empleado.setFechaIngreso(fechaIngreso);     
        }
        return empleado;
    }//Fin método generarEntidad
    //********************************************
    //Guardamos los datos
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        BLEmpleado logica = new BLEmpleado();
        EntidadEmpleado empleado = generarEntidad(); 
        try{
            logica.insertarEmpleado(empleado);
            limpiarFormulario();
            //cargarDatos("");
            JOptionPane.showMessageDialog(this, logica.getMensaje());
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
        }
         
    }//GEN-LAST:event_btnGuardarActionPerformed
    //***********************************************
    //Método para limpiar el formulario
    public void limpiarFormulario(){
        txtIdEmpleado.setText(null);
        txtNombre.setText(null); 
        txtPrimerApellido.setText(null); 
        txtSegundoApellido.setText(null);  
        txtTelefono.setText(null);    
        txtDireccion.setText(null);  
        txtNombreUsuario.setText(null);  
        txtCorreo.setText(null);
        txtContrasenia.setText(null);

    }//Fin limpiarFormulario
    //***********************************************
    //Método para cargar los datos en la tabla
    private void cargarDatos(String condicion) throws Exception{
        BLEmpleado logica = new BLEmpleado();
        List<EntidadEmpleado> lista;
        limpiarTabla();
        Object[] fila = new Object[12];
        try
        {
            lista = logica.ListarClientes(condicion);
            for(EntidadEmpleado empleado : lista){
                fila[0] = empleado.getIdEmpleado(); 
                fila[1] = empleado.getNombre();   
                fila[2] = empleado.getPrimerApellido();  
                fila[3] = empleado.getSegundoApellido();   
                fila[4] = empleado.getTelefono(); 
                fila[5] = empleado.getDireccion();   
                fila[6] = empleado.getNombreUsuario();    
                fila[7] = empleado.getCorreo();     
                fila[8] = empleado.getFechaIngreso();     
                fila[9] = empleado.getConstrasenia();
                fila[10]= empleado.getCargo();
                fila[11] = empleado.getEstado();
                modelo.addRow(fila);
            }
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    //*****************************************************
    //Método limpiar tabla
    private void limpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblEmpleados.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Primer Apellido"); 
        modelo.addColumn("Segundo Apellido");  
        modelo.addColumn("Teléfono");  
        modelo.addColumn("Correo Electrónico");   
        modelo.addColumn("Fecha Ingreso");    
        modelo.addColumn("Cargo");  
        modelo.addColumn("Dirección");    
        modelo.addColumn("Nombre Usuario");   
        modelo.addColumn("Contraseña");
        modelo.addColumn("Estado");
    }//Fin método limpiarTabla
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FrmAdministrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmAdministrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmAdministrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmAdministrarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdministrarEmpleados().setVisible(true);
            }
        });
    }//Fin método main
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JMonthChooserBeanInfo jMonthChooserBeanInfo1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPrimerApellido;
    private javax.swing.JLabel lblSegundoApellido;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelEmpleados;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private com.toedter.calendar.JDateChooser txtFechaIngreso;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
