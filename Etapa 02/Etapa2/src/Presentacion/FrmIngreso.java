
package Presentacion;

public class FrmIngreso extends javax.swing.JFrame {

    /**
     * Creates new form FrmIngreso
     */
    public FrmIngreso() {
        initComponents();
        //Centramos el formulario al abrirse
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

        PanelFrmIngreso = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        imgPassword = new javax.swing.JLabel();
        imgUsuario1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtNombreUsuario1 = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelFrmIngreso.setBackground(new java.awt.Color(255, 255, 255));
        PanelFrmIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(99, 88, 219));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INGRESAR");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setMinimumSize(new java.awt.Dimension(64, 18));
        PanelFrmIngreso.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 228, 42));

        imgPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-key-24.png"))); // NOI18N
        PanelFrmIngreso.add(imgPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 38, 33));

        imgUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-24.png"))); // NOI18N
        PanelFrmIngreso.add(imgUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 38, 33));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PanelFrmIngreso.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 230, 30));

        txtNombreUsuario1.setBackground(new java.awt.Color(255, 255, 255));
        PanelFrmIngreso.add(txtNombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 230, 30));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EasyMarket.png"))); // NOI18N
        PanelFrmIngreso.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 310, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFrmIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFrmIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFrmIngreso;
    private javax.swing.JLabel imgPassword;
    private javax.swing.JLabel imgUsuario1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTextField txtNombreUsuario1;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}