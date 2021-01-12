package Modelos.Usuarios.Comercios.CreacionCuentaComercio;

import Modelos.ABMGn;
import Modelos.Login.GestorLogin;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VistaRegComercio extends ABMGn {
    public GestorRegComercio grc;
    
    public JComboBox<String> getCbRubro() {
        return cbRubro;
    }

    public void setCbRubro(JComboBox<String> cbRubro) {
        this.cbRubro = cbRubro;
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

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }
    
    public GestorRegComercio getGestorRegComercio() {
        if (grc == null) {
           synchronized (GestorRegComercio.class) {
                grc = new GestorRegComercio();
                grc.setForm(this);
           }
        }
        return grc;
    }
    
    public boolean CuadrosNulos(){
        return !(esNulo(txtContraseña)||esNulo(txtDireccion)||esNulo(txtTelefono)||esNulo(txtCorreo)||esNulo(txtNombre)); 
    }

    public VistaRegComercio() {
        initComponents();
        getGestorRegComercio().iniciarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panDatosCuenta = new javax.swing.JPanel();
        lbCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lbContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        panDatosUsuario = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lbRubro = new javax.swing.JLabel();
        cbRubro = new javax.swing.JComboBox<>();
        BtnCancelar = new javax.swing.JButton();
        BtnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Comercio");

        panDatosCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cuenta"));

        lbCorreo.setText("Correo Electronico");

        lbContraseña.setText("Contraseña");

        javax.swing.GroupLayout panDatosCuentaLayout = new javax.swing.GroupLayout(panDatosCuenta);
        panDatosCuenta.setLayout(panDatosCuentaLayout);
        panDatosCuentaLayout.setHorizontalGroup(
            panDatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDatosCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContraseña)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panDatosCuentaLayout.createSequentialGroup()
                        .addGroup(panDatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCorreo)
                            .addComponent(lbContraseña))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panDatosCuentaLayout.setVerticalGroup(
            panDatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDatosCuentaLayout.createSequentialGroup()
                .addComponent(lbCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Comercio"));

        lbNombre.setText("Nombre");

        lbDireccion.setText("Direccion");

        lbTelefono.setText("telefono");
        lbTelefono.setToolTipText("");

        lbRubro.setText("Rubro");

        javax.swing.GroupLayout panDatosUsuarioLayout = new javax.swing.GroupLayout(panDatosUsuario);
        panDatosUsuario.setLayout(panDatosUsuarioLayout);
        panDatosUsuarioLayout.setHorizontalGroup(
            panDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono)
                    .addComponent(txtDireccion)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panDatosUsuarioLayout.createSequentialGroup()
                        .addGroup(panDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombre)
                            .addComponent(lbDireccion)
                            .addComponent(lbTelefono)
                            .addComponent(lbRubro))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbRubro, 0, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
        panDatosUsuarioLayout.setVerticalGroup(
            panDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDatosUsuarioLayout.createSequentialGroup()
                .addComponent(lbNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRubro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnCrear.setText("Crear");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDatosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panDatosCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panDatosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panDatosCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCrear)
                            .addComponent(BtnCancelar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        GestorLogin gl = new GestorLogin();
        gl.open();
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        if(CuadrosNulos()){
            getGestorRegComercio().setForm(this);
            getGestorRegComercio().guardar();
            GestorLogin gl = new GestorLogin();
            gl.open();
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Complete los campos");
        }
    }//GEN-LAST:event_BtnCrearActionPerformed

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
            java.util.logging.Logger.getLogger(VistaRegComercio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegComercio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegComercio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegComercio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegComercio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnCrear;
    private javax.swing.JComboBox<String> cbRubro;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRubro;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JPanel panDatosCuenta;
    private javax.swing.JPanel panDatosUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}