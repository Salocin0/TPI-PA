package Modelos.Login;

import Modelos.ABMGn;
import Modelos.Usuarios.Administradores.GestorVistaPrincipalAdmin;
import Modelos.Usuarios.Clientes.CreacionCuentaCliente.GestorRegCliente;
import Modelos.Usuarios.Clientes.GestorVistaPrincipalCliente;
import Modelos.Usuarios.Comercios.GestorVistaPrincipalComercio;
import Modelos.Usuarios.Comercios.CreacionCuentaComercio.GestorRegComercio;
import javax.swing.JOptionPane;

public class Login extends ABMGn {

    private boolean cuadrosVasios() {
        return esNulo(txtCorreo.getText())|| esNulo(txtContraseña.getText());
    }

    private boolean existeUsuario() {
        return true;
    }
    
    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnSalir = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        lbCorreo = new javax.swing.JLabel();
        lbContraseña = new javax.swing.JLabel();
        btnCrearCuentaUsuario = new javax.swing.JButton();
        btnCrearCuentaComercio = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbSinCuenta = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        lbCampoObligatorio = new javax.swing.JLabel();
        cbTipoLogin = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lbCorreo.setText("Correo Electronico * :");

        lbContraseña.setText("Contraseña * :");

        btnCrearCuentaUsuario.setText("Crear Cuenta Usuario");
        btnCrearCuentaUsuario.setAlignmentY(0.0F);
        btnCrearCuentaUsuario.setBorderPainted(false);
        btnCrearCuentaUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCrearCuentaUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrearCuentaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaUsuarioActionPerformed(evt);
            }
        });

        btnCrearCuentaComercio.setText("Crear Cuenta Comercio");
        btnCrearCuentaComercio.setBorderPainted(false);
        btnCrearCuentaComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaComercioActionPerformed(evt);
            }
        });

        lbSinCuenta.setText(" ¿No Tienes Cuenta?");

        lbCampoObligatorio.setBackground(new java.awt.Color(0, 0, 0));
        lbCampoObligatorio.setForeground(new java.awt.Color(255, 0, 0));
        lbCampoObligatorio.setText("(*) Campos Obligatorios");

        cbTipoLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Comercio", "Administrador" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCorreo)
                            .addComponent(lbContraseña))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo)
                            .addComponent(txtContraseña)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbCampoObligatorio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTipoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbSinCuenta)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCrearCuentaUsuario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCrearCuentaComercio)))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCampoObligatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEntrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSinCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearCuentaUsuario)
                    .addComponent(btnCrearCuentaComercio))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCuentaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaUsuarioActionPerformed
        GestorRegCliente gp = new GestorRegCliente();
        gp.open();
        dispose();
    }//GEN-LAST:event_btnCrearCuentaUsuarioActionPerformed

    private void btnCrearCuentaComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaComercioActionPerformed
        GestorRegComercio gp = new GestorRegComercio();
        gp.open();
        dispose();
    }//GEN-LAST:event_btnCrearCuentaComercioActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        //FALTA VALIDAR USUARIO
        String item = (String)cbTipoLogin.getSelectedItem();
        if (!cuadrosVasios()){
            
            if(existeUsuario()){
                
                switch(item){
                    
                    case "Usuario" -> {//hace referencia a cliente
                        GestorVistaPrincipalCliente gp = new GestorVistaPrincipalCliente();
                        gp.open();
                        dispose();
                        break;
                    }
                    
                    case "Comercio" -> {  
                        GestorVistaPrincipalComercio gp = new GestorVistaPrincipalComercio();
                        gp.open();
                        dispose();
                        break;
                    }
                    
                    case "Administrador" -> {
                        GestorVistaPrincipalAdmin gp = new GestorVistaPrincipalAdmin ();
                        gp.open();
                        dispose();
                        break;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Datos ingresados no corresponden a ningun usuario, Intente de nuevo");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Complete los campos obligatorios");
        } 
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuentaComercio;
    private javax.swing.JButton btnCrearCuentaUsuario;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbTipoLogin;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCampoObligatorio;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbSinCuenta;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}