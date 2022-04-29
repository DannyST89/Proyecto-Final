
package Presentacion;

import Entidades.EntidadProveedor;
import Logica.BLProveedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DSdev
 */
public class FrmProveedor extends javax.swing.JInternalFrame {

   
     DefaultTableModel modelo;
    public FrmProveedor() {
        initComponents();
        try {
            cargarDatos("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProveedor = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        txtIdProveedor = new javax.swing.JTextField();
        txtExtension = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtNumeroCuenta = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(930, 550));
        setPreferredSize(new java.awt.Dimension(930, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelProveedor.setBackground(new java.awt.Color(255, 255, 255));
        panelProveedor.setMinimumSize(new java.awt.Dimension(930, 540));
        panelProveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelProveedor.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 120, 50));

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
        panelProveedor.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 120, 50));

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProveedor);

        panelProveedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 700, 221));

        txtIdProveedor.setEditable(false);
        txtIdProveedor.setBackground(new java.awt.Color(153, 153, 153));
        panelProveedor.add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 110, -1));
        panelProveedor.add(txtExtension, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 110, -1));
        panelProveedor.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 114, -1));
        panelProveedor.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 114, -1));
        panelProveedor.add(txtNumeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 116, -1));
        panelProveedor.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 116, -1));
        panelProveedor.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 108, -1));

        getContentPane().add(panelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 950, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private EntidadProveedor generarEntidad(){        
        EntidadProveedor proveedor = new EntidadProveedor();
        if(!txtIdProveedor.getText().equals("")){
            proveedor.setExiste(true);
            proveedor.setId_proveedor(Integer.parseInt(txtIdProveedor.getText()));
        }else{
            proveedor.setNombreProveedor(txtNombreProveedor.getText());            
            proveedor.setTelefono(txtTelefono.getText());   
            proveedor.setCorreo(txtCorreo.getText());                
            proveedor.setDireccion(txtDireccion.getText());
            proveedor.setExtension(Integer.parseInt(txtExtension.getText()));
            proveedor.setNumeroCuenta(txtNumeroCuenta.getText());  
        }
        return proveedor;
    }//Fin método generarEntidad   
    
       
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        BLEmpleado logica = new BLEmpleado();
//        EntidadEmpleado empleado;
//        try
//        {
//            empleado = generarEntidad();
//            if(empleado.isExiste()){
//                if(logica.eliminarEmpleado(empleado) > 0){
//                    JOptionPane.showMessageDialog(this, logica.getMensaje());
//                    limpiarFormulario();
//                    cargarDatos("");
//                }else{
//                    JOptionPane.showMessageDialog(this, "No fue posible eliminar");
//                    limpiarFormulario();
//                }
//
//            }else{
//                JOptionPane.showMessageDialog(this, "Debe seleccionar un dato a eliminar");
//            }
//        } catch (Exception ex)
//        {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        BLProveedor logica = new BLProveedor();
        EntidadProveedor proveedor = generarEntidad();
        try{

            logica.insertarEmpleado(proveedor);
            cargarDatos("");
           
            JOptionPane.showMessageDialog(this, logica.getMensaje());
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
 //***********************************************
    //Método para limpiar el formulario
    public void limpiarFormulario(){
        txtIdProveedor.setText(null);
        txtNombreProveedor.setText(null); 
        txtTelefono.setText(null); 
        txtCorreo.setText(null);  
        txtTelefono.setText(null);    
        txtDireccion.setText(null);  
        txtDireccion.setText(null);  
        txtCorreo.setText(null);
        txtExtension.setText(null);
        txtNumeroCuenta.setText(null);

    }//Fin limpiarFormulario
    //***********************************************
    //Método para cargar los datos en la tabla
    private void cargarDatos(String condicion) throws Exception{
        BLProveedor logica = new BLProveedor();
        List<EntidadProveedor> lista;
        limpiarTabla();
        Object[] fila = new Object[12];
        try
        {
            lista = logica.ListarProveedor(condicion);
            for(EntidadProveedor proveedor : lista){
                fila[0] = proveedor.getId_proveedor(); 
                fila[1] = proveedor.getNombreProveedor();   
                fila[2] = proveedor.getDireccion();  
                fila[3] = proveedor.getTelefono();   
                fila[4] = proveedor.getExtension(); 
                fila[5] = proveedor.getCorreo();
                fila[6] = proveedor.getNumeroCuenta();   
               
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
        tblProveedor.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre Proveedor");
        modelo.addColumn("Dirección");  
        modelo.addColumn("Teléfono");  
        modelo.addColumn("Extensión");   
        modelo.addColumn("Correo");  
        modelo.addColumn("Número Cuenta");   

    }//Fin método limpiarTabla
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelProveedor;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtExtension;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNumeroCuenta;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
