package Modelos.Usuarios.Administradores;

import Modelos.Categoria_Producto.GestorCategoriaProducto;
import Modelos.Login.GestorLogin;
import Modelos.Rubros.GestorRubro;
import Modelos.Usuarios.Administradores.ABMCAdmin.GestorAdminABMC;
import Modelos.Usuarios.Administradores.ABMCCliente.GestorClienteABMC;
import Modelos.Usuarios.Administradores.ABMCComercio.GestorComercioABMC;

public class VistaPrincipalAdmin extends javax.swing.JFrame {

    public VistaPrincipalAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panABMCM = new javax.swing.JPanel();
        btnRubro = new javax.swing.JButton();
        btnCatProd = new javax.swing.JButton();
        panABMCU = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnComercio = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panABMCM.setBorder(javax.swing.BorderFactory.createTitledBorder("ABMC"));

        btnRubro.setText("Rubro");
        btnRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRubroActionPerformed(evt);
            }
        });

        btnCatProd.setText("Categoria Producto");
        btnCatProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panABMCMLayout = new javax.swing.GroupLayout(panABMCM);
        panABMCM.setLayout(panABMCMLayout);
        panABMCMLayout.setHorizontalGroup(
            panABMCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panABMCMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panABMCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCatProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRubro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panABMCMLayout.setVerticalGroup(
            panABMCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panABMCMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRubro)
                .addGap(18, 18, 18)
                .addComponent(btnCatProd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panABMCU.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnAdmin.setText("Administrador");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnComercio.setText("Comercio");
        btnComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComercioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panABMCULayout = new javax.swing.GroupLayout(panABMCU);
        panABMCU.setLayout(panABMCULayout);
        panABMCULayout.setHorizontalGroup(
            panABMCULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panABMCULayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panABMCULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnComercio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panABMCULayout.setVerticalGroup(
            panABMCULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panABMCULayout.createSequentialGroup()
                .addComponent(btnCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComercio))
        );

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panABMCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panABMCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panABMCU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panABMCM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        GestorAdminABMC gaa = new GestorAdminABMC();
        gaa.open();
        this.dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRubroActionPerformed
        GestorRubro gr = new GestorRubro();
        gr.open();
        this.dispose();
    }//GEN-LAST:event_btnRubroActionPerformed

    private void btnCatProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatProdActionPerformed
        GestorCategoriaProducto gcp = new GestorCategoriaProducto();
        gcp.open();
        this.dispose();
    }//GEN-LAST:event_btnCatProdActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        GestorClienteABMC gca = new GestorClienteABMC();
        gca.open();
        this.dispose();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComercioActionPerformed
        GestorComercioABMC gca = new GestorComercioABMC();
        gca.open();
        this.dispose();
    }//GEN-LAST:event_btnComercioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        GestorLogin gl = new GestorLogin();
        gl.open();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    
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
            java.util.logging.Logger.getLogger(VistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnCatProd;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnComercio;
    private javax.swing.JButton btnRubro;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel panABMCM;
    private javax.swing.JPanel panABMCU;
    // End of variables declaration//GEN-END:variables
}
