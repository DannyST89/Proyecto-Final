
package Presentacion;

import Entidades.EntidadInventario;
import Entidades.EntidadProducto;
import Logica.BLInventario;
import Logica.BLProducto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmInventario extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    public FrmInventario() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        txtIdInventario = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        txtCodigoBarras = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidadIngresada = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 870, 260));

        txtIdInventario.setEditable(false);
        txtIdInventario.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtIdInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 140, 30));

        txtIdProducto.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 140, 30));

        txtCodigoBarras.setEditable(false);
        jPanel1.add(txtCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 140, 30));

        txtDescripcion.setEditable(false);
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 140, 30));

        txtCantidadIngresada.setText("0");
        jPanel1.add(txtCantidadIngresada, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 140, 30));

        btnAgregarProducto.setBackground(new java.awt.Color(98, 87, 219));
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 130, 40));

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
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 120, 50));

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID Inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ID Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Descripci??n");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Cantidad Ingresada");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("C??digo de Barras");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, -1, -1));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Existencia");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));
        jPanel1.add(txtExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 140, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 51, 255));
        jLabel8.setText("Administrar Inventario");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 460, 40));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         BLInventario logica = new BLInventario();
        
        try{
            if(!txtIdProducto.getText().trim().isEmpty() &&
               !txtDescripcion.getText().trim().isEmpty() &&
               !txtCantidadIngresada.getText().trim().isEmpty() &&
               //!txtExistencia.getText().trim().isEmpty() &&
               !txtCodigoBarras.getText().trim().isEmpty()){
                EntidadInventario inventario = generarEntidad();
                logica.insertarInventario(inventario);
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

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        BLProducto logica = new BLProducto();
        String condicion;
        EntidadProducto producto = new EntidadProducto();       
        
        try
        {
            if(!txtIdProducto.getText().trim().isEmpty()){               
                condicion = String.format("ID_PRODUCTO=%s", txtIdProducto.getText());
                producto = logica.ObtenerUnProducto(condicion);
            
                txtDescripcion.setText(producto.getDescripcion());   
                txtCodigoBarras.setText(producto.getCodigoBarra());

            }else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese un producto antes de continuar", "Error",JOptionPane.WARNING_MESSAGE);
            }
           
        } catch (Exception ex)
        {
             JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed
    //Cargar los datos en los formularios al hacer doble clic
    
    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        BLInventario logica = new BLInventario();
        EntidadInventario inventario;
        String condicion;
        try
        {
           if(evt.getClickCount() == 2){
               int fila = tblInventario.rowAtPoint(evt.getPoint());
               txtIdInventario.setText(tblInventario.getValueAt(fila,0).toString());
               
               condicion = String.format("ID_INVENTARIO=%s", txtIdInventario.getText());
               
               inventario = logica.ObtenerUnInventario(condicion);
               txtIdInventario.setText(String.valueOf(inventario.getIdInventario()));
               txtIdProducto.setText(String.valueOf(inventario.getIdProducto())); 
               txtDescripcion.setText(inventario.getDescripcion()); 
               txtCantidadIngresada.setText(String.valueOf(inventario.getCantidadIngresada()));  
               txtExistencia.setText(String.valueOf(inventario.getExistencia())); 
               txtCodigoBarras.setText(inventario.getCodigoBarra()); 
              
           } 
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }      
    }//GEN-LAST:event_tblInventarioMouseClicked
    //M??todo para eliminar a registros en el inventario
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       BLInventario logica = new BLInventario();
       EntidadInventario inventario;
        try
        {
            inventario = generarEntidad();
            if(inventario.isExiste()){
                if(logica.eliminarInventario(inventario) > 0){
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
    //********************************************************************
    private EntidadInventario generarEntidad(){        
        EntidadInventario inventario = new EntidadInventario();
        try
        {
            if (!txtIdInventario.getText().equals(""))
            {
                inventario.setExiste(true);
                inventario.setIdInventario(Integer.parseInt(txtIdInventario.getText()));
                inventario.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
                inventario.setDescripcion(txtDescripcion.getText());
                inventario.setCantidadIngresada(Integer.parseInt(txtCantidadIngresada.getText()));
                inventario.setExistencia(Integer.parseInt(txtExistencia.getText()));
                inventario.setCodigoBarra(txtCodigoBarras.getText());

            } else
            {
                inventario.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
                inventario.setDescripcion(txtDescripcion.getText());
                inventario.setCantidadIngresada(Integer.parseInt(txtCantidadIngresada.getText()));
                inventario.setExistencia(Integer.parseInt(txtExistencia.getText()));
                inventario.setCodigoBarra(txtCodigoBarras.getText());
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        return inventario;
    }//Fin m??todo generarEntidad 
    //***********************************************
    //M??todo para cargar los datos en la tabla
    private void cargarDatos(String condicion) throws Exception{
        BLInventario logica = new BLInventario();
        List<EntidadInventario> lista;
        limpiarTabla();
        Object[] fila = new Object[12];
        try
        {
            lista = logica.ListarInventario(condicion);
            for(EntidadInventario inventario : lista){
                fila[0] = inventario.getIdInventario(); 
                fila[1] = inventario.getIdProducto();   
                fila[2] = inventario.getDescripcion();  
                fila[3] = inventario.getCantidadIngresada();   
                fila[4] = inventario.getExistencia(); 
                fila[5] = inventario.getCantidadVendida();
                fila[6] = inventario.getCodigoBarra(); 
               
                modelo.addRow(fila);
            }
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    } 
     //M??todo limpiar tabla
    private void limpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblInventario.setModel(modelo);
        modelo.addColumn("ID Inventario");
        modelo.addColumn("ID Producto");
        modelo.addColumn("Descripci??n");  
        modelo.addColumn("Cantidad Ingresada");  
        modelo.addColumn("Existencia");   
        modelo.addColumn("Cantidad Vendida");  
        modelo.addColumn("C??digo de Barra");  

    }//Fin m??todo limpiarTabla
    //**********************************************
    //M??todo para limpiar el formulario
    public void limpiarFormulario(){
        txtIdInventario.setText(null);
        txtIdProducto.setText(null); 
        txtDescripcion.setText(null); 
        txtCantidadIngresada.setText(null);  
        txtExistencia.setText(null);    
        txtCodigoBarras.setText(null);  

    }//Fin limpiarFormulario
    
    
    //***********************************************
 
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtCantidadIngresada;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtIdInventario;
    private javax.swing.JTextField txtIdProducto;
    // End of variables declaration//GEN-END:variables
}
