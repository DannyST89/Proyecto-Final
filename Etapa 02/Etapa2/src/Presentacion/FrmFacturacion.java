
package Presentacion;

import Entidades.EntidadFactura;
import Entidades.EntidadProducto;
import Logica.BLFactura;
import Logica.BLProducto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmFacturacion extends javax.swing.JInternalFrame {
    //Constant
    static final double IVA = 0.13;
    DefaultTableModel modelo;
    public FrmFacturacion() {
        initComponents();
        
         try {
            cargarDatos("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex.getMessage());
        }
         txtDescuento.setText(String.valueOf(0));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        txtIdFactura = new javax.swing.JTextField();
        txtIdEmpleado = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioUnidad = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelContenido.setBackground(new java.awt.Color(255, 255, 255));
        panelContenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFactura.setBackground(new java.awt.Color(255, 255, 255));
        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFactura);

        panelContenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 750, 370));

        btnEliminar.setBackground(new java.awt.Color(98, 87, 219));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelContenido.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 110, 40));

        txtSubtotal.setEditable(false);
        txtSubtotal.setForeground(new java.awt.Color(51, 51, 51));
        panelContenido.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 140, 30));

        txtIva.setEditable(false);
        txtIva.setForeground(new java.awt.Color(51, 51, 51));
        panelContenido.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 30));

        txtDescuento.setForeground(new java.awt.Color(51, 51, 51));
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });
        panelContenido.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 140, 30));

        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(51, 51, 51));
        panelContenido.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 140, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("SubTotal");
        panelContenido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("IVA");
        panelContenido.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Descuento");
        panelContenido.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Total");
        panelContenido.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        btnFacturar.setBackground(new java.awt.Color(98, 87, 219));
        btnFacturar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        panelContenido.add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 110, 40));

        txtCantidad.setForeground(new java.awt.Color(51, 51, 51));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });
        panelContenido.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 140, 30));

        txtIdFactura.setEditable(false);
        panelContenido.add(txtIdFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 140, 30));
        panelContenido.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 140, 30));

        txtDescripcion.setEditable(false);
        txtDescripcion.setForeground(new java.awt.Color(51, 51, 51));
        panelContenido.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 140, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID Factura");
        panelContenido.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ID Empleado");
        panelContenido.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Descripción");
        panelContenido.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Cantidad");
        panelContenido.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Precio Unidad");
        panelContenido.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        txtPrecioUnidad.setEditable(false);
        txtPrecioUnidad.setForeground(new java.awt.Color(51, 51, 51));
        panelContenido.add(txtPrecioUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 140, 30));

        btnAgregarProducto.setBackground(new java.awt.Color(98, 87, 219));
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        panelContenido.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, 40));

        txtIdProducto.setBackground(new java.awt.Color(255, 255, 255));
        panelContenido.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 102, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Facturación");
        panelContenido.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 340, -1));

        btnLimpiar.setBackground(new java.awt.Color(98, 87, 219));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelContenido.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 480, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //**********************************************************
    //método para generar entidad
    private EntidadFactura generarEntidad(){        
        EntidadFactura factura = new EntidadFactura();
        try
        {
            if (!txtIdFactura.getText().equals(""))
            {
                factura.setExiste(true);
                factura.setIdFactura(Integer.parseInt(txtIdFactura.getText()));
                factura.setIdImpleado(Integer.parseInt(txtIdEmpleado.getText()));
                factura.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
                factura.setDescripcion(txtDescripcion.getText());
                factura.setCantidad(Integer.parseInt(txtCantidad.getText()));
                factura.setPrecioUnidad(Double.parseDouble(txtPrecioUnidad.getText()));
                factura.setSubtotal(Double.parseDouble(txtSubtotal.getText()));
                factura.setIva(Double.parseDouble(txtIva.getText()));
                factura.setDescuento(Integer.parseInt(txtDescuento.getText()));
                factura.setTotal(Double.parseDouble(txtTotal.getText()));
            } else
            {
                factura.setIdImpleado(Integer.parseInt(txtIdEmpleado.getText()));
                factura.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
                factura.setDescripcion(txtDescripcion.getText());
                factura.setCantidad(Integer.parseInt(txtCantidad.getText()));
                factura.setPrecioUnidad(Double.parseDouble(txtPrecioUnidad.getText()));
                factura.setSubtotal(Double.parseDouble(txtSubtotal.getText()));
                factura.setIva(Double.parseDouble(txtIva.getText()));
                factura.setDescuento(Integer.parseInt(txtDescuento.getText()));
                factura.setTotal(Double.parseDouble(txtTotal.getText()));
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        return factura;
    }//Fin método generarEntidad     
    //Calcular todal de factura
    private void calculaTotalFactura(){
        double subtotal = Double.parseDouble(txtCantidad.getText());
        subtotal *= Double.parseDouble(txtPrecioUnidad.getText());
        txtSubtotal.setText(subtotal + "");
        //**********************************
        double impuesto = subtotal * IVA;        
        txtIva.setText(String.valueOf(impuesto));
        //***********************************        
        double descuento = Double.parseDouble(txtDescuento.getText());
        descuento *= (subtotal + impuesto) / 100; 
        //***********************************
        double total = subtotal + impuesto; 
         txtTotal.setText(String.valueOf(total - descuento));
    }      
    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
       BLFactura logica = new BLFactura();
        
        try{
            if(!txtIdEmpleado.getText().trim().isEmpty() &&
               !txtIdProducto.getText().trim().isEmpty() &&
               !txtDescripcion.getText().trim().isEmpty() &&
               !txtCantidad.getText().trim().isEmpty() &&
               !txtPrecioUnidad.getText().trim().isEmpty() &&
               !txtSubtotal.getText().trim().isEmpty() &&
               !txtIva.getText().trim().isEmpty() && 
               !txtDescuento.getText().trim().isEmpty() &&
               !txtTotal.getText().trim().isEmpty() ){
                EntidadFactura factura = generarEntidad();
                logica.insertarFactura(factura);
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
    }//GEN-LAST:event_btnFacturarActionPerformed
    
    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        BLFactura logica = new BLFactura();
        EntidadFactura factura;
        String condicion;
        try
        {
           if(evt.getClickCount() == 2){
               int fila = tblFactura.rowAtPoint(evt.getPoint());
               txtIdFactura.setText(tblFactura.getValueAt(fila,0).toString());
               
               condicion = String.format("ID_FACTURA=%s", txtIdFactura.getText());
               
               factura = logica.ObtenerUnaFactura(condicion);
               
               txtIdFactura.setText(String.valueOf(factura.getIdFactura())); 
               txtIdEmpleado.setText(String.valueOf(factura.getIdImpleado())); 
               txtIdProducto. setText(String.valueOf(factura.getIdProducto()));  
               txtDescripcion.setText(factura.getDescripcion());    
               txtCantidad.setText(String.valueOf(factura.getCantidad()));
               txtPrecioUnidad.setText(String.valueOf(factura.getPrecioUnidad()));
               txtSubtotal.setText(String.valueOf(factura.getSubtotal()));                
               txtIva.setText(String.valueOf(factura.getIva()));                
               txtDescuento.setText(String.valueOf(factura.getDescuento()));                
               txtSubtotal.setText(String.valueOf(factura.getSubtotal()));                
               txtTotal.setText(String.valueOf(factura.getTotal()));                    
           } 
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }      
    }//GEN-LAST:event_tblFacturaMouseClicked

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
                txtPrecioUnidad.setText(String.valueOf(producto.getPrecioUnidad()));

            }else{
                JOptionPane.showMessageDialog(null, "Por favor ingrese un producto antes de continuar", "Error",JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        calculaTotalFactura();
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        calculaTotalFactura();
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        BLFactura logica = new BLFactura();
       EntidadFactura factura;
        try
        {
            factura = generarEntidad();
            if(factura.isExiste()){
                if(logica.eliminarFactura(factura) > 0){
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                    limpiarFormulario();
                    cargarDatos("");
                }else{
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
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

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
       calculaTotalFactura();
    }//GEN-LAST:event_txtCantidadKeyReleased
    
    //***********************************************
    //Método para limpiar el formulario
    public void limpiarFormulario(){
        txtIdFactura.setText(null);
        txtIdEmpleado.setText(null); 
        txtIdProducto.setText(null); 
        txtDescripcion.setText(null);  
        txtCantidad.setText(null);    
        txtPrecioUnidad.setText(null);  
        txtSubtotal.setText(null);  
        txtIva.setText(null);
        txtDescuento.setText(null);
        txtTotal.setText(null);

    }//Fin limpiarFormulario
    //***********************************************
   private void cargarDatos(String condicion) throws Exception{
        BLFactura logica = new BLFactura();
        List<EntidadFactura> lista;
        limpiarTabla();
        Object[] fila = new Object[10];
        try
        {
            lista = logica.ListarFactura(condicion);
            for(EntidadFactura factura : lista){
                fila[0] = factura.getIdFactura(); 
                fila[1] = factura.getIdImpleado();   
                fila[2] = factura.getIdProducto();  
                fila[3] = factura.getDescripcion();   
                fila[4] = factura.getCantidad(); 
                fila[5] = factura.getPrecioUnidad();
                fila[6] = factura.getSubtotal();   
                fila[7] = factura.getIva();   
                fila[8] = factura.getDescuento();   
                fila[9] = factura.getTotal();                 
                modelo.addRow(fila);
            }
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    //Método limpiar tabla
    private void limpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblFactura.setModel(modelo);
        modelo.addColumn("ID Factura");
        modelo.addColumn("ID Empleado");
        modelo.addColumn("ID Producto");  
        modelo.addColumn("Descripción");  
        modelo.addColumn("Cantidad");   
        modelo.addColumn("Precio Unidad");  
        modelo.addColumn("Subtotal");  
        modelo.addColumn("IVA");   
        modelo.addColumn("Descuento");   
        modelo.addColumn("Total");   

    }//Fin método limpiarTabla
    //**********************************************
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtPrecioUnidad;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
