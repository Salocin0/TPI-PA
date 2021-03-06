package Modelos.Login;

import Modelos.ABMGn;
import Modelos.Usuarios.Administradores.GestorVistaPrincipalAdmin;
import Modelos.Usuarios.Clientes.CreacionCuentaCliente.GestorRegistrarCliente;
import Modelos.Usuarios.Clientes.GestorVistaPrincipalCliente;
import Modelos.Usuarios.Comercios.Comercio;
import Modelos.Usuarios.Comercios.GestorVistaPrincipalComercio;
import Modelos.Usuarios.Comercios.CreacionCuentaComercio.GestorRegComercio;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends ABMGn {
    GestorLogin gl;

    public GestorLogin getGestorLogin() {
        if (gl == null) {
           synchronized (GestorLogin.class) {
                gl = new GestorLogin();
                gl.setForm(this);
           }
        }
        return gl;
    }
    public JComboBox<String> getCbTipoLogin() {
        return cbTipoLogin;
    }

    public void setCbTipoLogin(JComboBox<String> cbTipoLogin) {
        this.cbTipoLogin = cbTipoLogin;
    }

    public JPasswordField getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(JPasswordField txtContraseña) {
        this.txtContraseña = txtContraseña;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }
    
    private boolean cuadrosVasios() {
        return esNulo(txtCorreo.getText())|| esNulo(txtContraseña.getText());
    }
    
    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCrearCuentaComercio = new javax.swing.JButton();
        btnCrearCuentaUsuario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lbContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        lbCampoObligatorio = new javax.swing.JLabel();
        cbTipoLogin = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" ¿No Tienes Cuenta?"));

        btnCrearCuentaComercio.setText("Crear Cuenta Comercio");
        btnCrearCuentaComercio.setBorderPainted(false);
        btnCrearCuentaComercio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaComercioActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearCuentaComercio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearCuentaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearCuentaComercio)
                    .addComponent(btnCrearCuentaUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar"));

        lbCorreo.setText("Correo Electronico * :");

        lbContraseña.setText("Contraseña * :");

        lbCampoObligatorio.setBackground(new java.awt.Color(0, 0, 0));
        lbCampoObligatorio.setForeground(new java.awt.Color(255, 0, 0));
        lbCampoObligatorio.setText("(*) Campos Obligatorios");

        cbTipoLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Comercio", "Administrador" }));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContraseña))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbCampoObligatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTipoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCampoObligatorio)
                    .addComponent(cbTipoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEntrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCuentaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaUsuarioActionPerformed
        GestorRegistrarCliente gp = new GestorRegistrarCliente();
        gp.open();
        dispose();
    }//GEN-LAST:event_btnCrearCuentaUsuarioActionPerformed

    private void btnCrearCuentaComercioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaComercioActionPerformed
        GestorRegComercio gp = new GestorRegComercio();
        gp.open();
        dispose();
    }//GEN-LAST:event_btnCrearCuentaComercioActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String item = (String)cbTipoLogin.getSelectedItem();
        if (!cuadrosVasios()){    
            if(getGestorLogin().existeUsuario()){ 
                switch(item){
                    case "Usuario" : {//hace referencia a cliente
                        dispose();
                        GestorVistaPrincipalCliente gp = new GestorVistaPrincipalCliente();
                        gp.open();
                        break;
                    }
                    case "Comercio" : {  
                        GestorVistaPrincipalComercio gp = new GestorVistaPrincipalComercio();
                        gp.open();
                        gp.datosLogin((Comercio) this.getGestorLogin().traerUsuario(Comercio.class, this.getTxtCorreo().getText(), 1));
                        dispose();
                        break;
                    }
                    case "Administrador" : {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCampoObligatorio;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}