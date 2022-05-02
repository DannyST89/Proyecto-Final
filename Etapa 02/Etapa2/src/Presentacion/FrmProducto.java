
package Presentacion;
import Atxy2k.CustomTextField.RestrictedTextField;
import Entidades.EntidadProducto;
import Entidades.EntidadProveedor;
import Logica.BLProducto;
import Logica.BLProveedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmProducto extends javax.swing.JInternalFrame {

   DefaultTableModel modelo;
    public FrmProducto() {
        initComponents();
        //Creamos una restricción para el campo de idProducto para 
        //Eliminar el desbordamiento, además se restringen los campos al ingresar datos
//        RestrictedTextField restricted = new RestrictedTextField(txtIdProducto);    
//        RestrictedTextField onlyInt = new RestrictedTextField(txtIdProveedor);
//        onlyInt.setOnlyNums(true);
//        restricted.setLimit(10);
//        restricted.setOnlyNums(true);
        try {
            cargarDatos("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        txtPrecioUnidad = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        btnAgregarProveedor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoBarra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelContenido.setBackground(new java.awt.Color(255, 255, 255));
        panelContenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        panelContenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 600, 300));

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
        panelContenido.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 120, 50));

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
        panelContenido.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 120, 50));

        txtIdProveedor.setBackground(new java.awt.Color(204, 204, 204));
        panelContenido.add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 134, 30));

        txtIdProducto.setEditable(false);
        txtIdProducto.setBackground(new java.awt.Color(204, 204, 204));
        txtIdProducto.setForeground(new java.awt.Color(51, 51, 51));
        panelContenido.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 134, 30));
        panelContenido.add(txtPrecioUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 134, 30));

        txtNombreProveedor.setEditable(false);
        panelContenido.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 134, 30));

        btnAgregarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarProveedor.setForeground(new java.awt.Color(51, 51, 51));
        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-search-client-30.png"))); // NOI18N
        btnAgregarProveedor.setText("Agregar Proveedor");
        btnAgregarProveedor.setBorder(null);
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });
        panelContenido.add(btnAgregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 150, 40));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ID Producto");
        panelContenido.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre Proveedor");
        panelContenido.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Precio Unidad");
        panelContenido.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Administrar Productos");
        panelContenido.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 490, 70));
        panelContenido.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 134, 30));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Descripción");
        panelContenido.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));
        panelContenido.add(txtCodigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 134, 30));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Código de barra");
        panelContenido.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Generar Entidad
    private EntidadProducto generarEntidad(){
        EntidadProducto producto = new EntidadProducto();
        
      
        try
        {
            if(!txtIdProducto.getText().equals("")){
                producto.setExiste(true);
                producto.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
                producto.setIdProveedor(Integer.parseInt(txtIdProveedor.getText())); 
                producto.setCodigoBarra(txtCodigoBarra.getText());              
                producto.setNombreProveedor(txtNombreProveedor.getText());
                producto.setDescripcion(txtDescripcion.getText());
                producto.setPrecioUnidad(Double.parseDouble(txtPrecioUnidad.getText()));
            }else{
                producto.setIdProveedor(Integer.parseInt(txtIdProveedor.getText()));   
                producto.setCodigoBarra(txtCodigoBarra.getText());  
                producto.setNombreProveedor(txtNombreProveedor.getText());
                producto.setDescripcion(txtDescripcion.getText());
                producto.setPrecioUnidad(Double.parseDouble(txtPrecioUnidad.getText()));          
            
            }
            
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        return producto;
    }
    //Al dar clic en el botón nos trae el proveedor con ese id
    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        BLProveedor logica = new BLProveedor();
        String condicion;
        EntidadProveedor proveedor = new EntidadProveedor();       
        
        try
        {
            if(!txtIdProveedor.getText().trim().isEmpty()){               
                condicion = String.format("id_Proveedor=%s", txtIdProveedor.getText());
                proveedor = logica.ObtenerUnProveedor(condicion);
            
                txtNombreProveedor.setText(proveedor.getNombreProveedor());
            }else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese un proveedor antes de continuar", "Error",JOptionPane.WARNING_MESSAGE);
            }
           
        } catch (Exception ex)
        {
             JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
        }
        
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed
    //Insertar un producto
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        BLProducto logica = new BLProducto();
        try
        {
            if(!txtNombreProveedor.getText().trim().isEmpty() &&
               !txtIdProveedor.getText().trim().isEmpty() && 
               !txtCodigoBarra.getText().trim().isEmpty() &&
               //!txtIdProducto.getText().trim().isEmpty() &&
               !txtDescripcion.getText().trim().isEmpty() &&
               !txtPrecioUnidad.getText().trim().isEmpty()){    
                
                EntidadProducto producto = generarEntidad();
                logica.insertarProducto(producto);
                JOptionPane.showMessageDialog(this, logica.getMensaje());
                limpiarFormulario();
                cargarDatos("");
            }else{
                JOptionPane.showMessageDialog(null, "Debe completar todos los datos", "Error",JOptionPane.WARNING_MESSAGE);            
            }
            
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    //Selecionar un producto
    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        BLProducto logica = new BLProducto();
        EntidadProducto producto;
        String condicion;
        try
        {
           if(evt.getClickCount() == 2){
               int fila = tblProductos.rowAtPoint(evt.getPoint());
               txtIdProducto.setText(tblProductos.getValueAt(fila,0).toString());
               
               condicion = String.format("ID_PRODUCTO=%s", txtIdProducto.getText());
               
               producto = logica.ObtenerUnProducto(condicion);
               txtIdProveedor.setText(String.valueOf(producto.getIdProveedor()));       
               txtCodigoBarra.setText(producto.getCodigoBarra()); 
               txtNombreProveedor.setText(producto.getNombreProveedor()); 
               txtDescripcion.setText(producto.getDescripcion()); 
               txtPrecioUnidad.setText(String.valueOf(producto.getPrecioUnidad()));  
           } 
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }      
        
    }//GEN-LAST:event_tblProductosMouseClicked
    //metodo para eliminar un producto
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        BLProducto logica = new BLProducto();
        EntidadProducto producto;
        try
        {
            producto = generarEntidad();
            if(producto.isExiste()){
                if(logica.eliminarProducto(producto) > 0){
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
    //**********************************************************
    //Método para limpiar el formulario
    public  void limpiarFormulario(){
        txtIdProveedor.setText(null);
        txtIdProducto.setText(null);   
        txtNombreProveedor.setText(null);    
        txtDescripcion.setText(null);   
        txtPrecioUnidad.setText(null);    
        txtCodigoBarra.setText(null);

        
    }
    //********************************************************
    //método para cargar los datos en la tabla
    //Método para cargar los datos en la tabla
    private void cargarDatos(String condicion) throws Exception{
        BLProducto logica = new BLProducto();
        List<EntidadProducto> lista;
        limpiarTabla();
        Object[] fila = new Object[12];
        try
        {
            lista = logica.ListarProducto(condicion);
            for(EntidadProducto producto : lista){
                fila[0] = producto.getIdProducto(); 
                fila[1] = producto.getIdProveedor();  
                fila[2] = producto.getCodigoBarra();   
                fila[3] = producto.getNombreProveedor();   
                fila[4] = producto.getDescripcion();  
                fila[5] = producto.getPrecioUnidad();    
               
                modelo.addRow(fila);
            }
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    //*****************************************************
    private void limpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblProductos.setModel(modelo);
        modelo.addColumn("ID Producto");
        modelo.addColumn("ID Proveedor");  
        modelo.addColumn("Código de barra");
        modelo.addColumn("Nombre Proveedor");
        modelo.addColumn("Descripción");  
        modelo.addColumn("Precio Unidad");   

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
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCodigoBarra;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPrecioUnidad;
    // End of variables declaration//GEN-END:variables
}
