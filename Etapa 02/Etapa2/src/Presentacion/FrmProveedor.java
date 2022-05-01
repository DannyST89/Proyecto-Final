
package Presentacion;

import Entidades.EntidadProveedor;
import Logica.BLProveedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBorder(null);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(930, 550));
        setNextFocusableComponent(txtNombreProveedor);
        setPreferredSize(new java.awt.Dimension(930, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelProveedor.setBackground(new java.awt.Color(255, 255, 255));
        panelProveedor.setFocusable(false);
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
        panelProveedor.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 120, 50));

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
        panelProveedor.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 120, 50));

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
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        panelProveedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 700, 221));

        txtIdProveedor.setEditable(false);
        txtIdProveedor.setBackground(new java.awt.Color(153, 153, 153));
        panelProveedor.add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 110, -1));
        panelProveedor.add(txtExtension, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 110, -1));
        panelProveedor.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 114, -1));
        panelProveedor.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 114, -1));
        panelProveedor.add(txtNumeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 116, -1));
        panelProveedor.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 250, -1));
        panelProveedor.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 108, -1));

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID");
        panelProveedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre Proveedor");
        panelProveedor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Dirección");
        panelProveedor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Teléfono");
        panelProveedor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Extensión");
        panelProveedor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Correo");
        panelProveedor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Número Cuenta");
        panelProveedor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("*");
        panelProveedor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 10, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("*");
        panelProveedor.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 10, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("*");
        panelProveedor.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 10, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("*");
        panelProveedor.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 10, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("*");
        panelProveedor.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 10, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("*");
        panelProveedor.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 10, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Administrar Proveedor");
        panelProveedor.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 580, 50));

        getContentPane().add(panelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private EntidadProveedor generarEntidad(){        
        EntidadProveedor proveedor = new EntidadProveedor();
        try
        {
            if (!txtIdProveedor.getText().equals(""))
            {
                proveedor.setExiste(true);
                proveedor.setId_proveedor(Integer.parseInt(txtIdProveedor.getText()));
                proveedor.setNombreProveedor(txtNombreProveedor.getText());
                proveedor.setTelefono(txtTelefono.getText());
                proveedor.setCorreo(txtCorreo.getText());
                proveedor.setDireccion(txtDireccion.getText());
                proveedor.setExtension(Integer.parseInt(txtExtension.getText()));
                proveedor.setNumeroCuenta(txtNumeroCuenta.getText());
            } else
            {
                proveedor.setNombreProveedor(txtNombreProveedor.getText());
                proveedor.setTelefono(txtTelefono.getText());
                proveedor.setCorreo(txtCorreo.getText());
                proveedor.setDireccion(txtDireccion.getText());
                proveedor.setExtension(Integer.parseInt(txtExtension.getText()));
                proveedor.setNumeroCuenta(txtNumeroCuenta.getText());
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        return proveedor;
    }//Fin método generarEntidad   
    
       
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        BLProveedor logica = new BLProveedor();
        EntidadProveedor proveedor;
        try
        {
            proveedor = generarEntidad();
            if(proveedor.isExiste()){
                if(logica.eliminarProveedor(proveedor) > 0){
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        BLProveedor logica = new BLProveedor();
        
        try{
            if(!txtNombreProveedor.getText().trim().isEmpty() &&
               !txtDireccion.getText().trim().isEmpty() &&
               !txtTelefono.getText().trim().isEmpty() &&
               !txtExtension.getText().trim().isEmpty() &&
               !txtCorreo.getText().trim().isEmpty() &&
               !txtNumeroCuenta.getText().trim().isEmpty()){
                EntidadProveedor proveedor = generarEntidad();
                logica.insertarProveedor(proveedor);
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

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        BLProveedor logica = new BLProveedor();
        EntidadProveedor proveedor;
        String condicion;
        try
        {
           if(evt.getClickCount() == 2){
               int fila = tblProveedor.rowAtPoint(evt.getPoint());
               txtIdProveedor.setText(tblProveedor.getValueAt(fila,0).toString());
               
               condicion = String.format("id_Proveedor=%s", txtIdProveedor.getText());
               
               proveedor = logica.ObtenerUnProveedor(condicion);
               
               txtNombreProveedor.setText(proveedor.getNombreProveedor()); 
               txtTelefono.setText(proveedor.getTelefono()); 
               txtExtension. setText(String.valueOf(proveedor.getExtension()));  
               txtTelefono.setText(proveedor.getTelefono());    
               txtCorreo.setText(proveedor.getCorreo());
               txtDireccion.setText(proveedor.getDireccion());
               txtNumeroCuenta.setText(proveedor.getNumeroCuenta());                

               
           } 
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }      
        
    }//GEN-LAST:event_tblProveedorMouseClicked
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
                fila[7] = proveedor.getEstado();   
 
               
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
        modelo.addColumn("Estado");   


    }//Fin método limpiarTabla
    //**********************************************

 
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
