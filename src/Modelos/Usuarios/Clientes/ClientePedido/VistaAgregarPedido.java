package Modelos.Usuarios.Clientes.ClientePedido;

import Modelos.ABMGn;
import Modelos.Usuarios.Clientes.GestorVistaPrincipalCliente;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaAgregarPedido extends ABMGn {
    DefaultTableModel modeloProducto = new DefaultTableModel();
    DefaultTableModel modeloPedido = new DefaultTableModel();
    public GestorVistaAgregarPedido grc;

    public DefaultTableModel getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(DefaultTableModel modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    public DefaultTableModel getModeloPedido() {
        return modeloPedido;
    }

    public void setModeloPedido(DefaultTableModel modeloPedido) {
        this.modeloPedido = modeloPedido;
    }

    
    public JComboBox<String> getCbCantidad() {
        return cbCantidad;
    }

    public void setCbCantidad(JComboBox<String> cbCantidad) {
        this.cbCantidad = cbCantidad;
    }
    
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnQuitar() {
        return btnQuitar;
    }

    public void setBtnQuitar(JButton btnQuitar) {
        this.btnQuitar = btnQuitar;
    }

    public JComboBox<String> getCbComercio() {
        return cbComercio;
    }

    public void setCbComercio(JComboBox<String> cbComercio) {
        this.cbComercio = cbComercio;
    }

    public JComboBox<String> getCbRubro() {
        return cbRubro;
    }

    public void setCbRubro(JComboBox<String> cbRubro) {
        this.cbRubro = cbRubro;
    }

    public JLabel getLbTotal() {
        return lbTotal;
    }

    public void setLbTotal(JLabel lbTotal) {
        this.lbTotal = lbTotal;
    }

    public JTable getTbPedido() {
        return tbPedidos;
    }

    public void setTbPedido(JTable tbPedido) {
        this.tbPedidos = tbPedido;
    }

    public JTable getTbProductos() {
        return tbProductos;
    }

    public void setTbProductos(JTable tbProductos) {
        this.tbProductos = tbProductos;
    }
    public GestorVistaAgregarPedido getGestorVistaAgrePed() {
        if (grc == null) {
           synchronized (GestorVistaAgregarPedido.class) {
                grc = new GestorVistaAgregarPedido();
                grc.setForm(this);
           }
        }
        return grc;
    }
    
//    public void limpiarComboComercio(){
//        while(this.getCbComercio().getItemCount()>0){
//            this.getCbComercio().removeItemAt(0);
//        }
//    }
//    
    public void enbledPedido() {
        this.getCbRubro().setEnabled(true);
        this.getCbComercio().setEnabled(false);
        this.getCbCantidad().setEnabled(false);
        
    }
    
    public void estadoPantalla(int val){
        switch(val){
            case 1 -> {//estado inicial (selleccion rubro)
                comboBoxs(true,false,false);
                tbAndBtn(false,false,false,false);
                this.getBtnGuardar().setEnabled(false);
            }
            case 2->{//(selleccion rubro+categoria producto+comercio)
                comboBoxs(true,true,false);
                tbAndBtn(false,false,false,false);
                this.getBtnGuardar().setEnabled(false);
            }
            case 3->{//(armado del pedido)
                comboBoxs(true,true,true);
                tbAndBtn(true,true,true,true);
                this.getBtnGuardar().setEnabled(false);
            }
            case 4->{//pedido ya armado
                comboBoxs(true,true,true);
                tbAndBtn(true,true,true,true);
                this.getBtnGuardar().setEnabled(true);
            }
        }
    }
    
    public void comboBoxs(boolean rubro,boolean comercio,boolean cantidad){
        this.getCbRubro().setEnabled(rubro);
        this.getCbComercio().setEnabled(comercio);
        this.getCbCantidad().setEnabled(cantidad);
    }
    
    public void tbAndBtn(boolean tbPedido,boolean tbProductos,boolean btnAgregar,boolean btnQuitar){
        this.getTbPedido().setEnabled(tbPedido);
        this.getTbProductos().setEnabled(tbProductos);
        this.getBtnAgregar().setEnabled(btnAgregar);
        this.getBtnQuitar().setEnabled(btnQuitar);
    }
    
    public void initializeTableProducto() {
        modeloProducto.addColumn("Objeto");
        modeloProducto.addColumn("ID");
        modeloProducto.addColumn("Nombre");
        modeloProducto.addColumn("Descripcion");
        modeloProducto.addColumn("Categoria");
        modeloProducto.addColumn("Precio");
        
        this.getTbProductos().setModel(modeloProducto);
    }
    public void initializeTablePedido() {
        modeloPedido.addColumn("Objeto");
        modeloPedido.addColumn("Nombre");
        modeloPedido.addColumn("Descripcion");
        modeloPedido.addColumn("Precio");
        modeloPedido.addColumn("Cantidad");
        modeloPedido.addColumn("SubTotal");
        this.getTbPedido().setModel(modeloPedido);
        //traerDatos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
    }
    
    public int cantidad(String str){
        if("Todos".equals(str)){
            return -1;
        }
        else {
            return strToInt(str);
        }
    }
    
    public void traerDatosProductos(int max){
        limpiarTabla(modeloProducto);
        getGestorVistaAgrePed().listarDatosProducto(modeloProducto);
        this.getTbProductos().setModel(modeloProducto);
    }
    
    public void inicioVentana(){
        initializeTablePedido();
        initializeTableProducto();
        estadoPantalla(1);
        getGestorVistaAgrePed().iniciarComboRubro();
    }
    
    public VistaAgregarPedido() {
        initComponents();
        inicioVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panFiltro = new javax.swing.JPanel();
        lbRubro = new javax.swing.JLabel();
        cbRubro = new javax.swing.JComboBox<>();
        lbComercio = new javax.swing.JLabel();
        cbComercio = new javax.swing.JComboBox<>();
        panBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panPrincipal = new javax.swing.JPanel();
        panPedido = new javax.swing.JPanel();
        lbTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        panAgrQuit = new javax.swing.JPanel();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        panProductos = new javax.swing.JPanel();
        lbProductos = new javax.swing.JLabel();
        cbCantidad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbRubro.setText("Rubro");

        cbRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRubroActionPerformed(evt);
            }
        });

        lbComercio.setText("Comercio");

        cbComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComercioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFiltroLayout = new javax.swing.GroupLayout(panFiltro);
        panFiltro.setLayout(panFiltroLayout);
        panFiltroLayout.setHorizontalGroup(
            panFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRubro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbComercio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbComercio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panFiltroLayout.setVerticalGroup(
            panFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRubro)
                    .addComponent(lbComercio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbComercio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBotonesLayout = new javax.swing.GroupLayout(panBotones);
        panBotones.setLayout(panBotonesLayout);
        panBotonesLayout.setHorizontalGroup(
            panBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        panBotonesLayout.setVerticalGroup(
            panBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        panPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        panPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 255))); // NOI18N

        lbTotal.setText("Total:");

        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbPedidos);

        javax.swing.GroupLayout panPedidoLayout = new javax.swing.GroupLayout(panPedido);
        panPedido.setLayout(panPedidoLayout);
        panPedidoLayout.setHorizontalGroup(
            panPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPedidoLayout.setVerticalGroup(
            panPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPedidoLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal)
                .addGap(16, 16, 16))
        );

        btnQuitar.setText("<--");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAgregar.setText("-->");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAgrQuitLayout = new javax.swing.GroupLayout(panAgrQuit);
        panAgrQuit.setLayout(panAgrQuitLayout);
        panAgrQuitLayout.setHorizontalGroup(
            panAgrQuitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgrQuitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAgrQuitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panAgrQuitLayout.setVerticalGroup(
            panAgrQuitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAgrQuitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addContainerGap())
        );

        lbProductos.setText("Productos");

        cbCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "100", "Todos" }));
        cbCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCantidadActionPerformed(evt);
            }
        });

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbProductos);

        javax.swing.GroupLayout panProductosLayout = new javax.swing.GroupLayout(panProductos);
        panProductos.setLayout(panProductosLayout);
        panProductosLayout.setHorizontalGroup(
            panProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProductos)
                    .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panProductosLayout.setVerticalGroup(
            panProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panAgrQuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(panAgrQuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(panBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRubroActionPerformed
        estadoPantalla(2);
        getGestorVistaAgrePed().iniciarComboComercio();
    }//GEN-LAST:event_cbRubroActionPerformed

    private void cbComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComercioActionPerformed
        estadoPantalla(3);
        traerDatosProductos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
    }//GEN-LAST:event_cbComercioActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        this.getGestorVistaAgrePed().quitar();
        this.getGestorVistaAgrePed().cambiarEstado();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.getGestorVistaAgrePed().agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        getGestorVistaAgrePed().guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        GestorVistaPrincipalCliente gvpc = new GestorVistaPrincipalCliente();
        gvpc.open();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCantidadActionPerformed
        traerDatosProductos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
    }//GEN-LAST:event_cbCantidadActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaAgregarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAgregarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAgregarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAgregarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAgregarPedido().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitar;
    public javax.swing.JComboBox<String> cbCantidad;
    private javax.swing.JComboBox<String> cbComercio;
    private javax.swing.JComboBox<String> cbRubro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbComercio;
    private javax.swing.JLabel lbProductos;
    private javax.swing.JLabel lbRubro;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JPanel panAgrQuit;
    private javax.swing.JPanel panBotones;
    private javax.swing.JPanel panFiltro;
    private javax.swing.JPanel panPedido;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel panProductos;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}