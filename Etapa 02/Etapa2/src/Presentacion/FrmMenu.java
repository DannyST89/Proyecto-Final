
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
  
        //centramos el formulario al abrirse
        this.setLocationRelativeTo(null);    
        //maximizamos el formulario al abrirse
        //
        this.setTitle("EasyMarket");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        panelMenuMini = new javax.swing.JPanel();
        btnFacturacion = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDashBoard = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 480));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setMaximumSize(new java.awt.Dimension(900, 480));
        panelMenu.setPreferredSize(new java.awt.Dimension(1146, 861));
        panelMenu.setRequestFocusEnabled(false);
        panelMenu.setVerifyInputWhenFocusTarget(false);
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContenido.setBackground(new java.awt.Color(255, 255, 255));

        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo bienvenida.png"))); // NOI18N

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoLayout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(lblBienvenida)
                .addGap(280, 280, 280))
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        panelMenu.add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 1050, 540));

        panelMenuMini.setBackground(new java.awt.Color(236, 236, 236));
        panelMenuMini.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFacturacion.setBackground(new java.awt.Color(236, 236, 236));
        btnFacturacion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnFacturacion.setForeground(new java.awt.Color(51, 51, 51));
        btnFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-payment-24.png"))); // NOI18N
        btnFacturacion.setText("   Facturación");
        btnFacturacion.setActionCommand(" Facturación");
        btnFacturacion.setBorder(null);
        btnFacturacion.setBorderPainted(false);
        btnFacturacion.setContentAreaFilled(false);
        btnFacturacion.setHideActionText(true);
        btnFacturacion.setNextFocusableComponent(btnClientes);
        btnFacturacion.setOpaque(true);
        btnFacturacion.setSelected(true);
        btnFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturacionActionPerformed(evt);
            }
        });
        panelMenuMini.add(btnFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 150, 40));

        btnClientes.setBackground(new java.awt.Color(236, 236, 236));
        btnClientes.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(51, 51, 51));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-search-client-24.png"))); // NOI18N
        btnClientes.setText("   Clientes");
        btnClientes.setBorder(null);
        btnClientes.setBorderPainted(false);
        btnClientes.setContentAreaFilled(false);
        btnClientes.setHideActionText(true);
        btnClientes.setNextFocusableComponent(btnClientes);
        btnClientes.setOpaque(true);
        btnClientes.setSelected(true);
        panelMenuMini.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 130, 40));

        btnProveedor.setBackground(new java.awt.Color(236, 236, 236));
        btnProveedor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(51, 51, 51));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-data-provider-24 (1).png"))); // NOI18N
        btnProveedor.setText("    Proveedores");
        btnProveedor.setBorder(null);
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.setHideActionText(true);
        btnProveedor.setNextFocusableComponent(btnClientes);
        btnProveedor.setOpaque(true);
        btnProveedor.setSelected(true);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        panelMenuMini.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 160, 40));

        btnInventario.setBackground(new java.awt.Color(236, 236, 236));
        btnInventario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(51, 51, 51));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-warehouse-24.png"))); // NOI18N
        btnInventario.setText("   Inventario");
        btnInventario.setBorder(null);
        btnInventario.setBorderPainted(false);
        btnInventario.setContentAreaFilled(false);
        btnInventario.setHideActionText(true);
        btnInventario.setNextFocusableComponent(btnClientes);
        btnInventario.setOpaque(true);
        btnInventario.setSelected(true);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        panelMenuMini.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 140, 40));

        btnProductos.setBackground(new java.awt.Color(236, 236, 236));
        btnProductos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(51, 51, 51));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-fast-moving-consumer-goods-24.png"))); // NOI18N
        btnProductos.setText("    Productos");
        btnProductos.setBorder(null);
        btnProductos.setBorderPainted(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setHideActionText(true);
        btnProductos.setNextFocusableComponent(btnClientes);
        btnProductos.setOpaque(true);
        btnProductos.setSelected(true);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        panelMenuMini.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 150, 40));

        btnEmpleados.setBackground(new java.awt.Color(236, 236, 236));
        btnEmpleados.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(51, 51, 51));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-member-24.png"))); // NOI18N
        btnEmpleados.setText("   Empleados");
        btnEmpleados.setBorder(null);
        btnEmpleados.setBorderPainted(false);
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.setHideActionText(true);
        btnEmpleados.setNextFocusableComponent(btnClientes);
        btnEmpleados.setOpaque(true);
        btnEmpleados.setSelected(true);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        panelMenuMini.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 150, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-settings-24.png"))); // NOI18N
        jButton1.setText("  Settings");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setSelected(true);
        panelMenuMini.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 120, 40));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(160, 4));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        panelMenuMini.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 160, 4));

        btnDashBoard.setBackground(new java.awt.Color(237, 237, 237));
        btnDashBoard.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDashBoard.setForeground(new java.awt.Color(255, 51, 255));
        btnDashBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-application-32.png"))); // NOI18N
        btnDashBoard.setText("Dashboard");
        btnDashBoard.setBorder(null);
        btnDashBoard.setBorderPainted(false);
        btnDashBoard.setContentAreaFilled(false);
        btnDashBoard.setFocusPainted(false);
        btnDashBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashBoardActionPerformed(evt);
            }
        });
        panelMenuMini.add(btnDashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        panelMenu.add(panelMenuMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 770));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EasyMarket.png"))); // NOI18N
        panelMenu.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 210, 150));

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bienvenido.png"))); // NOI18N
        panelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 200, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre del usuario");
        panelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-exit-32.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusPainted(false);
        btnSalir.setRequestFocusEnabled(false);
        panelMenu.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        //Abrimos el formulario para administrar empleados 
        panelContenido.removeAll();
        FrmAdministrarEmpleados frmEmpleados = new FrmAdministrarEmpleados();
        panelContenido.add(frmEmpleados);
        Dimension sizeContenedor = panelContenido.getSize();
        Dimension sizeFrm = frmEmpleados.getSize();
        frmEmpleados.setLocation((((int) sizeContenedor.getWidth() - (int) sizeFrm.getWidth()) / 2),
                        ((int) sizeContenedor.getHeight() - (int) sizeFrm.getHeight()) / 2);
        frmEmpleados.show();
    }//GEN-LAST:event_btnEmpleadosActionPerformed
//******************************************************************    
//Abrir el formulario para administrar Proveedores
    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        panelContenido.removeAll();
        //this.setUndecorated(true);
        FrmProveedor frmProveedor = new FrmProveedor();        
        panelContenido.add(frmProveedor);
        Dimension sizeContenedor = panelContenido.getSize();
        Dimension sizeFrm = frmProveedor.getSize();
        frmProveedor.setLocation((((int) sizeContenedor.getWidth() - (int) sizeFrm.getWidth()) / 2),
                        ((int) sizeContenedor.getHeight() - (int) sizeFrm.getHeight()) / 2);
        frmProveedor.show();
    }//GEN-LAST:event_btnProveedorActionPerformed
    
    private void btnDashBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashBoardActionPerformed
        panelContenido.removeAll();
        lblBienvenida.setVisible(true);
    }//GEN-LAST:event_btnDashBoardActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        panelContenido.removeAll();
        //this.setUndecorated(true);
        FrmProducto frmProducto = new FrmProducto();        
        panelContenido.add(frmProducto);
        Dimension sizeContenedor = panelContenido.getSize();
        Dimension sizeFrm = frmProducto.getSize();
        frmProducto.setLocation((((int) sizeContenedor.getWidth() - (int) sizeFrm.getWidth()) / 2),
                        ((int) sizeContenedor.getHeight() - (int) sizeFrm.getHeight()) / 2);
        frmProducto.show();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        panelContenido.removeAll();
        //this.setUndecorated(true);
        FrmInventario frmInventario = new FrmInventario();        
        panelContenido.add(frmInventario);
        Dimension sizeContenedor = panelContenido.getSize();
        Dimension sizeFrm = frmInventario.getSize();
        frmInventario.setLocation((((int) sizeContenedor.getWidth() - (int) sizeFrm.getWidth()) / 2),
                        ((int) sizeContenedor.getHeight() - (int) sizeFrm.getHeight()) / 2);
        frmInventario.show();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturacionActionPerformed
        panelContenido.removeAll();
        //this.setUndecorated(true);
        FrmFacturacion frmFacturacion = new FrmFacturacion();        
        panelContenido.add(frmFacturacion);
        Dimension sizeContenedor = panelContenido.getSize();
        Dimension sizeFrm = frmFacturacion.getSize();
        frmFacturacion.setLocation((((int) sizeContenedor.getWidth() - (int) sizeFrm.getWidth()) / 2),
                        ((int) sizeContenedor.getHeight() - (int) sizeFrm.getHeight()) / 2);
        frmFacturacion.show();
    }//GEN-LAST:event_btnFacturacionActionPerformed

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
   
   
    //**************************************************************
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnDashBoard;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnFacturacion;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuMini;
    // End of variables declaration//GEN-END:variables
}
