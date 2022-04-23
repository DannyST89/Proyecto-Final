
package Presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FrmMenu extends javax.swing.JFrame {

    boolean a;
    public FrmMenu() {
        initComponents();
        botonTransparene();
        //centramos el formulario al abrirse
        this.setLocationRelativeTo(null);    
        //maximizamos el formulario al abrirse
        //this.setExtendedState(FrmMenu.MAXIMIZED_BOTH);      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        panelMenuMini = new javax.swing.JPanel();
        btnEmpleados = new javax.swing.JButton();
        btnFacturacion = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnAdminUsers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 480));
        setMinimumSize(new java.awt.Dimension(900, 480));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setMaximumSize(new java.awt.Dimension(900, 480));
        panelMenu.setPreferredSize(new java.awt.Dimension(1146, 861));
        panelMenu.setRequestFocusEnabled(false);
        panelMenu.setVerifyInputWhenFocusTarget(false);
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContenido.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        panelMenu.add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 960, 770));

        panelMenuMini.setBackground(new java.awt.Color(255, 255, 255));
        panelMenuMini.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(51, 51, 51));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-member-32.png"))); // NOI18N
        btnEmpleados.setText("   Empleados");
        btnEmpleados.setBorder(null);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        panelMenuMini.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 150, 60));

        btnFacturacion.setBackground(new java.awt.Color(255, 255, 255));
        btnFacturacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-payment-64.png"))); // NOI18N
        btnFacturacion.setText("Facturación");
        panelMenuMini.add(btnFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 220, 80));

        btnClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-clients-64.png"))); // NOI18N
        btnClientes.setText("Clientes");
        panelMenuMini.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, 80));

        btnProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-provide-60.png"))); // NOI18N
        btnProveedor.setText("Proveedores");
        panelMenuMini.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 220, 80));

        btnInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnInventario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-storage-64.png"))); // NOI18N
        btnInventario.setText("Inventario");
        panelMenuMini.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 220, 80));

        btnProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hamper-48.png"))); // NOI18N
        btnProductos.setText("Productos");
        panelMenuMini.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 220, 80));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EasyMarket.png"))); // NOI18N
        panelMenuMini.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 220, 160));

        btnAdminUsers.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-24.png"))); // NOI18N
        btnAdminUsers.setBorder(null);
        btnAdminUsers.setBorderPainted(false);
        panelMenuMini.add(btnAdminUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, 30));

        panelMenu.add(panelMenuMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Al dar clic en el botón se abrirá el formulario para administrar los empleados
    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed

        FrmAdministrarEmpleados frmEmpleados = new FrmAdministrarEmpleados();
        
        
        panelContenido.add(frmEmpleados);
        //Centrar formulario
        Dimension sizeContenedor = panelContenido.getSize();
        Dimension sizeFrm = frmEmpleados.getSize();
        frmEmpleados.setLocation((((int) sizeContenedor.getWidth() - (int) sizeFrm.getWidth()) / 2),
                        ((int) sizeContenedor.getHeight() - (int) sizeFrm.getHeight()) / 2);
        frmEmpleados.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed
    //**************************************************************
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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }
      //*****************************************************
        //Método para hacer transparentes los botones
    public void botonTransparene(){
        btnEmpleados.setOpaque(false);   
        btnEmpleados.setContentAreaFilled(false);  
        btnFacturacion.setContentAreaFilled(false);   
        btnClientes.setContentAreaFilled(false);  
        btnProveedor.setContentAreaFilled(false); 
        btnProductos.setContentAreaFilled(false);    
        btnInventario.setContentAreaFilled(false);    

 
        
 

        //btnEmpleados.setBorderPainted(false);
    }
   
    //**************************************************************
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminUsers;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnFacturacion;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuMini;
    // End of variables declaration//GEN-END:variables
}
