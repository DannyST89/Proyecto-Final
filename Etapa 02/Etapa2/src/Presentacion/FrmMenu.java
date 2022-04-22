
package Presentacion;

import javax.swing.JPanel;

public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        //centramos el formulario al abrirse
        this.setLocationRelativeTo(null);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        btnFacturacion = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnAdministrarEmpleados = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnAdministrarClientes1 = new javax.swing.JButton();
        btnProveerdor = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnAdminUsers = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFacturacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-payment-64.png"))); // NOI18N
        btnFacturacion.setText("Facturación");
        panelMenu.add(btnFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 170, 80));

        btnProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-hamper-48.png"))); // NOI18N
        btnProducto.setText("Productos");
        panelMenu.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 180, 80));

        btnAdministrarEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdministrarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-employees-64.png"))); // NOI18N
        btnAdministrarEmpleados.setText("Empleados");
        btnAdministrarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarEmpleadosActionPerformed(evt);
            }
        });
        panelMenu.add(btnAdministrarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 170, 80));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EasyMarket.png"))); // NOI18N
        panelMenu.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 310, 280));

        btnAdministrarClientes1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdministrarClientes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-clients-64.png"))); // NOI18N
        btnAdministrarClientes1.setText("Clientes");
        panelMenu.add(btnAdministrarClientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 180, 80));

        btnProveerdor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProveerdor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-provide-60.png"))); // NOI18N
        btnProveerdor.setText("Proveedores");
        panelMenu.add(btnProveerdor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 180, 80));

        btnInventario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-storage-64.png"))); // NOI18N
        btnInventario.setText("Inventario");
        panelMenu.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 170, 80));

        btnAdminUsers.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-24.png"))); // NOI18N
        btnAdminUsers.setBorder(null);
        btnAdminUsers.setBorderPainted(false);
        panelMenu.add(btnAdminUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jMenuBar1.setPreferredSize(new java.awt.Dimension(187, 40));

        jMenu1.setText("Opciones");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Administrar Usuario");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Al dar clic en el botón se abrirá el formulario para administrar los empleados
    private void btnAdministrarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarEmpleadosActionPerformed

        FrmAdministrarEmpleados frmEmpleados = new FrmAdministrarEmpleados();
        frmEmpleados.setVisible(true);
    }//GEN-LAST:event_btnAdministrarEmpleadosActionPerformed

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
    //***************************************

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminUsers;
    private javax.swing.JButton btnAdministrarClientes1;
    private javax.swing.JButton btnAdministrarEmpleados;
    private javax.swing.JButton btnFacturacion;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveerdor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
