
package Presentacion;

import java.awt.event.WindowEvent;


public class FrmAdministrarEmpleados extends javax.swing.JInternalFrame {

 
    public FrmAdministrarEmpleados() {
        initComponents();
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
        txtNombre2 = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblPrimerApellido = new javax.swing.JLabel();
        txtTelefono3 = new javax.swing.JTextField();
        lblSegundoApellido = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Administrar Empleados"); // NOI18N
        setResizable(false);

        panelEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        panelEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        panelEmpleados.setName("hala"); // NOI18N
        panelEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIdEmpleado.setText("ID");
        panelEmpleados.add(lblIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        panelEmpleados.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 147, 33));
        panelEmpleados.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 94, 147, 33));

        lblDireccion.setText("Dirección");
        panelEmpleados.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        lblFechaIngreso.setText("Fecha Ingreso");
        panelEmpleados.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));
        panelEmpleados.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 147, 33));

        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelEmpleados.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 150, 33));
        panelEmpleados.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 312, 33));

        lblTelefono.setText("Teléfono");
        panelEmpleados.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        lblCargo.setText("Cargo");
        panelEmpleados.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));
        panelEmpleados.add(txtPrimerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 94, 147, 33));
        panelEmpleados.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 147, 33));
        panelEmpleados.add(txtSegundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 94, 147, 33));

        lblCorreo.setText("Correo Electrónico");
        panelEmpleados.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));
        panelEmpleados.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 94, 147, 33));
        panelEmpleados.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 147, 33));

        lblNombre.setText("Nombre");
        panelEmpleados.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 72, -1, -1));

        lblNombreUsuario.setText("Nombre Usuario");
        panelEmpleados.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        lblPrimerApellido.setText("Primer Apellido");
        panelEmpleados.add(lblPrimerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 72, -1, -1));
        panelEmpleados.add(txtTelefono3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 147, 33));

        lblSegundoApellido.setText("Segundo Apellido");
        panelEmpleados.add(lblSegundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 72, -1, -1));

        lblContrasenia.setText("Contraseña");
        panelEmpleados.add(lblContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

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
        jScrollPane1.setViewportView(tblEmpleados);

        panelEmpleados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 630, 200));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-64.png"))); // NOI18N
        jButton4.setText("Actualizar");
        panelEmpleados.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 150, 60));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-save-64.png"))); // NOI18N
        jButton5.setText("Guardar");
        panelEmpleados.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 150, 60));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-remove-48.png"))); // NOI18N
        jButton6.setText("Eliminar");
        panelEmpleados.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 150, 60));

        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Administrar Empleados.png"))); // NOI18N
        panelEmpleados.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 440, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JMonthChooserBeanInfo jMonthChooserBeanInfo1;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtTelefono3;
    // End of variables declaration//GEN-END:variables
}
