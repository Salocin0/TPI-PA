/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import GUtilr.UtilJtable;
import Hibernate.GestorHibernate;
import Modelos.GestorRubro;
import Modelos.Rubro;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author nicol
 */
public class ABMCRubro extends javax.swing.JFrame {
    GestorABMCRubro gABM = new GestorABMCRubro();
    DefaultTableModel modelo = new DefaultTableModel();
    GestorRubro gr = new GestorRubro();
    public void initializeTable() {
        modelo.addColumn("Objeto");
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        TraerDatos();
    }
    public void TraerDatos(){
        limpiarTabla();
        gABM.listarDatos(modelo);
        this.TableRubro.setModel(modelo);
    }
    public void limpiarTabla(){
        while(modelo.getRowCount()>=1){
            modelo.removeRow(modelo.getRowCount()-1);
        } 

    }
    /*public void initializeTable2(JTable tbl) {
        String[] titulo = {"ID", "Nombre", "Descripcion"};
        String[] ancho ={"150","150","150"};
        DefaultTableModel modelo = new DefaultTableModel();
        
        this.newModelTable(tbl, titulo,ancho,UtilJtable.noEditable );
    }*/
  
    public ABMCRubro() {
        initComponents();
        initializeTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TADescripcion = new javax.swing.JTextArea();
        TBNombre = new javax.swing.JTextField();
        LBNombre = new javax.swing.JLabel();
        LBDescripcion = new javax.swing.JLabel();
        BTNSalir = new javax.swing.JButton();
        BTNEliminar = new javax.swing.JButton();
        BTNAgregar = new javax.swing.JButton();
        BTNModificar = new javax.swing.JButton();
        CBBuscar = new javax.swing.JComboBox<>();
        TBBuscar = new javax.swing.JTextField();
        BTNBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableRubro = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        BTNCancelar = new javax.swing.JButton();
        BTNGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TADescripcion.setColumns(20);
        TADescripcion.setRows(5);
        TADescripcion.setName("TADescripcion"); // NOI18N
        jScrollPane1.setViewportView(TADescripcion);

        TBNombre.setName("TBNombre"); // NOI18N

        LBNombre.setText("Nombre");
        LBNombre.setName("LBNombre"); // NOI18N

        LBDescripcion.setText("Descripcion");
        LBDescripcion.setName("LBDescripcion"); // NOI18N

        BTNSalir.setText("Salir");
        BTNSalir.setName("BTNSalir"); // NOI18N

        BTNEliminar.setText("Eliminar");
        BTNEliminar.setMaximumSize(new java.awt.Dimension(70, 23));
        BTNEliminar.setMinimumSize(new java.awt.Dimension(70, 23));
        BTNEliminar.setName("BTNEliminar"); // NOI18N
        BTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminarActionPerformed(evt);
            }
        });

        BTNAgregar.setText("Agregar");
        BTNAgregar.setMaximumSize(new java.awt.Dimension(70, 23));
        BTNAgregar.setMinimumSize(new java.awt.Dimension(70, 23));
        BTNAgregar.setName("BTNAgregar"); // NOI18N
        BTNAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgregarActionPerformed(evt);
            }
        });

        BTNModificar.setText("Modificar");
        BTNModificar.setMaximumSize(new java.awt.Dimension(70, 23));
        BTNModificar.setMinimumSize(new java.awt.Dimension(70, 23));
        BTNModificar.setName("BTNModificar"); // NOI18N
        BTNModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNModificarActionPerformed(evt);
            }
        });

        CBBuscar.setName("CBBuscar"); // NOI18N

        TBBuscar.setName("TBBuscar"); // NOI18N

        BTNBuscar.setText("Buscar");
        BTNBuscar.setName("BTNBuscar"); // NOI18N

        TableRubro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableRubro.setName("TableRubro"); // NOI18N
        jScrollPane2.setViewportView(TableRubro);

        BTNCancelar.setText("Cancelar");
        BTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCancelarActionPerformed(evt);
            }
        });

        BTNGuardar.setText("Guardar");
        BTNGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BTNSalir)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LBDescripcion)
                                    .addComponent(LBNombre)
                                    .addComponent(TBNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BTNModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(BTNGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTNCancelar))
                                    .addComponent(BTNAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BTNEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(CBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTNBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTNGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNBuscar)
                    .addComponent(TBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgregarActionPerformed
        GestorABMCRubro gr=new GestorABMCRubro();
        gr.guardar(1,TBNombre.getText(), TADescripcion.getText());
        TBNombre.setText("");
        TADescripcion.setText("");
        TraerDatos();
    }//GEN-LAST:event_BTNAgregarActionPerformed

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        GestorHibernate gh = new GestorHibernate();
        Rubro r;
        r = (Rubro) modelo.getValueAt(TableRubro.getSelectedRow(), 0);
        r.setEstado(0);
        gh.actualizarObjeto(r);
        TraerDatos();
    }//GEN-LAST:event_BTNEliminarActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
        GestorHibernate gh = new GestorHibernate();
        Rubro r;
        r = (Rubro) modelo.getValueAt(TableRubro.getSelectedRow(), 0);
        TBNombre.setText(r.getNombre());
        TADescripcion.setText(r.getDescripcion());
        //desabilitar tabla y botones para evitar errores
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void BTNGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGuardarActionPerformed
        GestorHibernate gh = new GestorHibernate();
        Rubro r;
        r = (Rubro) modelo.getValueAt(TableRubro.getSelectedRow(), 0);
        r.setNombre(TBNombre.getText());
        r.setDescripcion(TADescripcion.getText());
        gh.actualizarObjeto(r);
        TraerDatos();
    }//GEN-LAST:event_BTNGuardarActionPerformed

    private void BTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ABMCRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABMCRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABMCRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABMCRubro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            public void run() {
                new ABMCRubro().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAgregar;
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNCancelar;
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JButton BTNGuardar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JButton BTNSalir;
    private javax.swing.JComboBox<String> CBBuscar;
    private javax.swing.JLabel LBDescripcion;
    private javax.swing.JLabel LBNombre;
    private javax.swing.JTextArea TADescripcion;
    private javax.swing.JTextField TBBuscar;
    private javax.swing.JTextField TBNombre;
    private javax.swing.JTable TableRubro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    Object getTbl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
