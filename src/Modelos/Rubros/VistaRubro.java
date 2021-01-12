package Modelos.Rubros;
import Modelos.ABMGn;
import Modelos.Usuarios.Administradores.GestorVistaPrincipalAdmin;
import java.awt.HeadlessException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VistaRubro extends ABMGn {
    DefaultTableModel modelo = new DefaultTableModel();
    private GestorRubro gr;
    
    //Metodos de seteo
    
    public GestorRubro getGestorRubro() {
        if (gr == null) {
           synchronized (GestorRubro.class) {
                gr = new GestorRubro();
                gr.setForm(this);
           }
        }
        return gr;
    }

    public JComboBox<String> getCbCantidad() {
        return cbCantidad;
    }

    public void setCbCantidad(JComboBox<String> cbCantidad) {
        this.cbCantidad = cbCantidad;
    }

    public JTable getTableRubro() {
        return tableDatos;
    }

    public void setTableRubro(JTable tableRubro) {
        this.tableDatos = tableRubro;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }
    
    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextArea TADescripcion) {
        this.txtDescripcion = TADescripcion;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField TBNombre) {
        this.txtNombre = TBNombre;
    }

    //Metodos
    
    public void cambiarEstadoPantalla(int num){
        switch(num){
            case 1: { //estado inicial
                habilitacionBotones(true);
                habilitacionExtras(true);
                break;
            }
            case 2: { //en modificacion
                habilitacionBotones(false);
                habilitacionExtras(false);
                break;
            } 
        }
    }
    
    public void habilitacionBotones(boolean valor){
        btnAgregar.setEnabled(valor);
        btnEliminar.setEnabled(valor);
        btnModificar.setEnabled(valor);
        btnReporte.setEnabled(valor);
        btnGuardar.setEnabled(!valor);
        btnCancelar.setEnabled(!valor);
    }

    public void habilitacionExtras(boolean valor){
        txtId.setEnabled(false);
        tableDatos.setEnabled(valor);
        cbCantidad.setEnabled(valor);
    }
     
    public void initializeTable() {
        modelo.addColumn("Objeto");
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        
        traerDatos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
        cambiarEstadoPantalla(1);
    }
    
    public int cantidad(String str){
        if("Todos".equals(str)){
            return -1;
        }
        else {
            return strToInt(str);
        }
    }
    
    public void traerDatos(int max){
        limpiarTabla(modelo);
        getGestorRubro().listarDatos(modelo,Rubro.class);
        this.tableDatos.setModel(modelo);
    }
    
    public void limpiarPantalla(){
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
    }
    
    public VistaRubro() {
        initComponents();
        initializeTable();
    }

    public boolean cuadrosVacios(){
        return esNulo(txtNombre)|| esNulo(txtDescripcion.getText());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JTextField();
        lbNombre = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lbId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cbCantidad = new javax.swing.JComboBox<>();
        btnReporte = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        jScrollPane1.setViewportView(txtDescripcion);

        txtNombre.setName("txtNombre"); // NOI18N

        lbNombre.setText("Nombre");
        lbNombre.setName("lbNombre"); // NOI18N

        lbDescripcion.setText("Descripcion");
        lbDescripcion.setName("lbDescripcion"); // NOI18N

        btnSalir.setText("Salir");
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(70, 23));
        btnEliminar.setMinimumSize(new java.awt.Dimension(70, 23));
        btnEliminar.setName("btnEliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setMaximumSize(new java.awt.Dimension(70, 23));
        btnAgregar.setMinimumSize(new java.awt.Dimension(70, 23));
        btnAgregar.setName("btnAgregar"); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setMaximumSize(new java.awt.Dimension(70, 23));
        btnModificar.setMinimumSize(new java.awt.Dimension(70, 23));
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableDatos.setName("tableDatos"); // NOI18N
        jScrollPane2.setViewportView(tableDatos);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lbId.setText("ID");

        cbCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "100", "Todos" }));
        cbCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCantidadActionPerformed(evt);
            }
        });

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbDescripcion)
                            .addComponent(lbNombre)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(lbId)
                            .addComponent(txtId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnReporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addGap(6, 6, 6)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            if (cuadrosVacios()==false){
                getGestorRubro().setForm(this);
                getGestorRubro().guardar();
                limpiarPantalla();
                traerDatos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
            }else{
                JOptionPane.showMessageDialog(null, "Existen cuadros vacios, completelos para continuar");
            }
        }
        catch(HeadlessException e) {
            System.out.println("Error al guardar:"+ e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al guardar");
        } 
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            getGestorRubro().setForm(this);
            if(JOptionPane.showConfirmDialog(null, "Se eliminara la fila seleccionada, esta seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0){
                getGestorRubro().eliminar();
                traerDatos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));  
            }
        }
        catch(HeadlessException e) {
            System.out.println("Error al intentar eliminar la fila"+ e.getMessage());
            JOptionPane.showMessageDialog(null, "no selecciono una fila de la tabla");
        }  
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            getGestorRubro().setForm(this);
            getGestorRubro().cargarDatos((Rubro) modelo.getValueAt(tableDatos.getSelectedRow(), 0));
            cambiarEstadoPantalla(2);
        }
        catch(Exception e) {
            System.out.println("Error al cargar los datos de la tabla a los cuadros de texto"+ e.getMessage());
            JOptionPane.showMessageDialog(null, "no selecciono una fila de la tabla");
        }    
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            getGestorRubro().setForm(this);
            getGestorRubro().guardar();
            limpiarPantalla();
            traerDatos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
            cambiarEstadoPantalla(1);
        }
        catch(Exception e) {
            System.out.println("Error al guardar los datos modificados:"+ e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al guardar los datos modificados");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarPantalla();
        cambiarEstadoPantalla(1);
   }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        GestorVistaPrincipalAdmin gvpa= new GestorVistaPrincipalAdmin();
        gvpa.open();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        this.gr.imprimir();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        traerDatos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCantidadActionPerformed
        traerDatos(cantidad(cbCantidad.getItemAt(cbCantidad.getSelectedIndex())));
    }//GEN-LAST:event_cbCantidadActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VistaRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {}
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbCantidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JTable tableDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}