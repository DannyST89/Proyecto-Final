
package Presentacion;

import Entidades.EntidadEmpleado;
import Logica.BLEmpleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


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
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        lblDireccionVerifica = new javax.swing.JLabel();
        lblTelefonoVerifica = new javax.swing.JLabel();
        lblNombreUsuarioVerifica = new javax.swing.JLabel();
        lblNombreVerifica = new javax.swing.JLabel();
        lblCorreoVerifica = new javax.swing.JLabel();
        lblContraseniaVerifica = new javax.swing.JLabel();
        lblPrimerApellidoVerifica = new javax.swing.JLabel();
        lblSegundoApellidoVerifica = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-user-24.png"))); // NOI18N
        setName("Administrar Empleados"); // NOI18N
        setNextFocusableComponent(txtNombre);
        setPreferredSize(new java.awt.Dimension(955, 610));
        setVisible(true);

        panelEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        panelEmpleados.setForeground(new java.awt.Color(255, 51, 51));
        panelEmpleados.setName("hala"); // NOI18N
        panelEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIdEmpleado.setText("ID");
        panelEmpleados.add(lblIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        panelEmpleados.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 147, 30));

        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        panelEmpleados.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 147, 30));

        lblDireccion.setText("Dirección");
        panelEmpleados.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        lblFechaIngreso.setText("Fecha Ingreso");
        panelEmpleados.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));
        panelEmpleados.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 147, 30));

        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cajero", "Bodeguero" }));
        panelEmpleados.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 147, 30));
        panelEmpleados.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 336, 30));

        lblTelefono.setText("Teléfono");
        panelEmpleados.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lblCargo.setText("Cargo");
        panelEmpleados.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));
        panelEmpleados.add(txtPrimerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 147, 30));
        panelEmpleados.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 147, 30));
        panelEmpleados.add(txtSegundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 147, 30));

        lblCorreo.setText("Correo Electrónico");
        panelEmpleados.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));
        panelEmpleados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 147, 30));
        panelEmpleados.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 147, 30));

        lblNombre.setText("Nombre");
        panelEmpleados.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        lblNombreUsuario.setText("Nombre Usuario");
        panelEmpleados.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        lblPrimerApellido.setText("Primer Apellido");
        panelEmpleados.add(lblPrimerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));
        panelEmpleados.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 147, 30));

        lblSegundoApellido.setText("Segundo Apellido");
        panelEmpleados.add(lblSegundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        lblContrasenia.setText("Contraseña");
        panelEmpleados.add(lblContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

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

        btnEliminar.setBackground(new java.awt.Color(98, 87, 219));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-24.png"))); // NOI18N
        btnEliminar.setText("  Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelEmpleados.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 120, 50));

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
        tblEmpleados.setShowHorizontalLines(true);
        tblEmpleados.setSurrendersFocusOnKeystroke(true);
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpleados);

        panelEmpleados.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 910, 220));

        lblDireccionVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDireccionVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblDireccionVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDireccionVerifica.setText("*");
        panelEmpleados.add(lblDireccionVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 20, 20));

        lblTelefonoVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTelefonoVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblTelefonoVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefonoVerifica.setText("*");
        panelEmpleados.add(lblTelefonoVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 20));

        lblNombreUsuarioVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombreUsuarioVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblNombreUsuarioVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreUsuarioVerifica.setText("*");
        panelEmpleados.add(lblNombreUsuarioVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        lblNombreVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombreVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblNombreVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreVerifica.setText("*");
        panelEmpleados.add(lblNombreVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        lblCorreoVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCorreoVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblCorreoVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCorreoVerifica.setText("*");
        panelEmpleados.add(lblCorreoVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        lblContraseniaVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblContraseniaVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblContraseniaVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContraseniaVerifica.setText("*");
        panelEmpleados.add(lblContraseniaVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        lblPrimerApellidoVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPrimerApellidoVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblPrimerApellidoVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrimerApellidoVerifica.setText("*");
        panelEmpleados.add(lblPrimerApellidoVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, -1, -1));

        lblSegundoApellidoVerifica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSegundoApellidoVerifica.setForeground(new java.awt.Color(51, 51, 51));
        lblSegundoApellidoVerifica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSegundoApellidoVerifica.setText("*");
        panelEmpleados.add(lblSegundoApellidoVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    //*********************************************************
    //Creamos el método para generar entidad
    private EntidadEmpleado generarEntidad(){        
        EntidadEmpleado empleado = new EntidadEmpleado();
        try{        
            if(!txtIdEmpleado.getText().equals("")){
                empleado.setExiste(true);
                empleado.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));
                empleado.setNombre(txtNombre.getText());
                empleado.setPrimerApellido(txtPrimerApellido.getText()); 
                empleado.setSegundoApellido(txtSegundoApellido.getText());  
                empleado.setTelefono(txtTelefono.getText());   
                empleado.setCorreo(txtCorreo.getText());                
                empleado.setDireccion(txtDireccion.getText());
                empleado.setCargo(cboCargo.getSelectedItem().toString());             
                empleado.setNombreUsuario(txtNombreUsuario.getText());    
                empleado.setConstrasenia(txtContrasenia.getText());
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
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        return empleado;
    }//Fin método generarEntidad
    //********************************************
    //Guardamos los datos
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        BLEmpleado logica = new BLEmpleado();
        EntidadEmpleado empleado = generarEntidad(); 
        try{
            if(!txtNombre.getText().trim().isEmpty() &&
               !txtPrimerApellido.getText().trim().isEmpty() &&
               !txtSegundoApellido.getText().trim().isEmpty() &&
               !txtTelefono.getText().trim().isEmpty() &&
               !txtCorreo.getText().trim().isEmpty() &&
               !txtNombreUsuario.getText().trim().isEmpty() &&
               !txtContrasenia.getText().trim().isEmpty() &&
               !txtDireccion.getText().trim().isEmpty()){
                if(empleado.isExiste()){
                    logica.modificarEmpleado(empleado);
                }else{   
                    logica.insertarEmpleado(empleado);
                }
                limpiarFormulario();
                cargarDatos("");
                JOptionPane.showMessageDialog(this, logica.getMensaje());
            }else{
                JOptionPane.showMessageDialog(null, "Debe completar todos los datos", "Error",JOptionPane.WARNING_MESSAGE);
            }           
            
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
        }
         
    }//GEN-LAST:event_btnGuardarActionPerformed
    //********************************************     
    
    //********************************************    

    //Al dar clic sobre las filas de la tabla me carga el datos en el formulario para poder modificarlo
    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
       BLEmpleado logica = new BLEmpleado();
       EntidadEmpleado empleado;
       String condicion;
        try
        {
           if(evt.getClickCount() == 2){
               int fila = tblEmpleados.rowAtPoint(evt.getPoint());
               txtIdEmpleado.setText(tblEmpleados.getValueAt(fila,0).toString());
               
               condicion = String.format("id_Empleado=%s", txtIdEmpleado.getText());
               
               empleado = logica.ObtenerUnEmpleado(condicion);
               
               txtNombre.setText(empleado.getNombre()); 
               txtPrimerApellido.setText(empleado.getPrimerApellido()); 
               txtSegundoApellido.setText(empleado.getSegundoApellido());  
               txtTelefono.setText(empleado.getTelefono());    
               txtCorreo.setText(empleado.getCorreo());
               txtDireccion.setText(empleado.getDireccion());
             
               //JOptionPane.showMessageDialog(this, elCargo);
               //cboCargo.removeAllItems();
               cboCargo.addItem(empleado.getCargo()); 
               txtFechaIngreso.setDate((Date)empleado.getFechaIngreso());
               txtNombreUsuario.setText(empleado.getNombreUsuario());                
               txtContrasenia.setText(empleado.getConstrasenia());
               
           } 
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }      
        
    }//GEN-LAST:event_tblEmpleadosMouseClicked
    //Eliminamos un dato de la tabla
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       BLEmpleado logica = new BLEmpleado();
       EntidadEmpleado empleado;
        try
        {
            empleado = generarEntidad();
            if(empleado.isExiste()){
                if(logica.eliminarEmpleado(empleado) > 0){
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                    limpiarFormulario();
                    cargarDatos("");
                }else{
                    JOptionPane.showMessageDialog(this, "No fue posible eliminar");
                    limpiarFormulario();
                }
            
            }else{            
                JOptionPane.showMessageDialog(this, "Debe seleccionar un dato a eliminar");
            }
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed
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
            lista = logica.ListarEmpleados(condicion);
            for(EntidadEmpleado empleado : lista){
                fila[0] = empleado.getIdEmpleado(); 
                fila[1] = empleado.getNombre();   
                fila[2] = empleado.getPrimerApellido();  
                fila[3] = empleado.getSegundoApellido();   
                fila[4] = empleado.getTelefono(); 
                fila[5] = empleado.getCorreo();
                fila[6] = empleado.getDireccion();   
                fila[7] = empleado.getFechaIngreso();    
                fila[8]= empleado.getCargo();      
                fila[9] = empleado.getNombreUsuario();  
                fila[10] = empleado.getConstrasenia();                
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
        modelo.addColumn("1° Apellido"); 
        modelo.addColumn("2° Apellido");  
        modelo.addColumn("Teléfono");  
        modelo.addColumn("Correo");  
        modelo.addColumn("Dirección");   
        modelo.addColumn("Fecha Ingreso");    
        modelo.addColumn("Cargo");           
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboCargo;
    private com.toedter.calendar.JMonthChooserBeanInfo jMonthChooserBeanInfo1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblContraseniaVerifica;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreoVerifica;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionVerifica;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblNombreUsuarioVerifica;
    private javax.swing.JLabel lblNombreVerifica;
    private javax.swing.JLabel lblPrimerApellido;
    private javax.swing.JLabel lblPrimerApellidoVerifica;
    private javax.swing.JLabel lblSegundoApellido;
    private javax.swing.JLabel lblSegundoApellidoVerifica;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoVerifica;
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
