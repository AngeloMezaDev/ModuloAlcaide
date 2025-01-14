/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTAS;

import CONTROLADOR.ctrlProfesores;
import CONTROLADOR.ctrlReclusos;
import CONTROLADOR.ctrlRegistroReclusos;
import MODELO.Actividad;
import MODELO.Profesor;
import MODELO.Recluso;
import java.awt.Color;
import java.awt.Window;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yordan
 */
public class frmEditarProfe extends javax.swing.JFrame {

    /**
     * *
     * Creates new form frmCreateNewProfe
     */
    private ctrlProfesores controlador;
    private static String usuario = "";
    private static String contraseña = "";

    private String nuevaContrasena;
    private frmPerfilProfesor perfilProfesor;

    public frmEditarProfe(String usuario, String contraseña) {
        initComponents();
        controlador = new ctrlProfesores();

        controlador.cargarDatosProfe(lbl_IdProfe, usuario, contraseña, txtApellidosProfe, txtNombresProfe, txtCedulaProfe, txtCorreoProfe, jDateFechaNacimiento);
        txtUsuarioProfe.setText(usuario);

     
        this.usuario = usuario;
        this.contraseña = contraseña;

        // setear la contraseña
        txtPasswordProfe.setText(contraseña);
        txtPasswConfirmProfe.setText(contraseña);

        this.perfilProfesor = perfilProfesor; // Asignar la referencia

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBanner = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanelExit2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblExit2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombresProfe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidosProfe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCedulaProfe = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtUsuarioProfe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCorreoProfe = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_IdProfe = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtPasswordProfe = new javax.swing.JPasswordField();
        txtPasswConfirmProfe = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        btnEditarReo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBanner.setBackground(new java.awt.Color(37, 150, 190));
        jPanelBanner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("EDITAR");
        jPanelBanner.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jPanelExit2.setBackground(new java.awt.Color(122, 72, 221));

        javax.swing.GroupLayout jPanelExit2Layout = new javax.swing.GroupLayout(jPanelExit2);
        jPanelExit2.setLayout(jPanelExit2Layout);
        jPanelExit2Layout.setHorizontalGroup(
            jPanelExit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanelExit2Layout.setVerticalGroup(
            jPanelExit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jPanelBanner.add(jPanelExit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/teacher.png.png"))); // NOI18N
        jPanelBanner.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        lblExit2.setBackground(new java.awt.Color(33, 45, 62));
        lblExit2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblExit2.setForeground(new java.awt.Color(255, 255, 255));
        lblExit2.setText("X");
        lblExit2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblExit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExit2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExit2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExit2MouseExited(evt);
            }
        });
        jPanelBanner.add(lblExit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 33, 34));

        getContentPane().add(jPanelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtNombresProfe.setEnabled(false);
        jPanel1.add(txtNombresProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 210, -1));

        jLabel2.setText("Apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtApellidosProfe.setEnabled(false);
        jPanel1.add(txtApellidosProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 210, -1));

        jLabel3.setText("Cédula:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        txtCedulaProfe.setEnabled(false);
        jPanel1.add(txtCedulaProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 170, -1));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 580, 10));

        jLabel6.setText("Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));
        jPanel1.add(txtUsuarioProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 170, -1));

        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel7.setText("CREDENCIALES");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel8.setText("Correo Electronico:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));
        jPanel1.add(txtCorreoProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 170, -1));

        jLabel9.setText("Nueva Contraseña:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jLabel12.setText("Confirme su nueva contraseña:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jLabel13.setText("ID:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        lbl_IdProfe.setText("#");
        jPanel1.add(lbl_IdProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 70, -1));

        jLabel15.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jDateFechaNacimiento.setDateFormatString("yyyy/MM/dd ");
        jDateFechaNacimiento.setEnabled(false);
        jDateFechaNacimiento.setFocusable(false);
        jPanel1.add(jDateFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 170, -1));

        txtPasswordProfe.setText("jPasswordField1");
        jPanel1.add(txtPasswordProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 170, -1));

        txtPasswConfirmProfe.setText("jPasswordField1");
        jPanel1.add(txtPasswConfirmProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 610, 400));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 115, 45));

        btnEditarReo.setText("MODIFICAR");
        btnEditarReo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarReoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditarReo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 115, 45));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblExit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseClicked
        this.dispose();
    }//GEN-LAST:event_lblExit2MouseClicked

    private void lblExit2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseEntered
        jPanelExit2.setBackground(Color.red);
        lblExit2.setBackground(Color.white);
    }//GEN-LAST:event_lblExit2MouseEntered

    private void lblExit2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseExited
        jPanelExit2.setBackground(new Color(122, 72, 221));
    }//GEN-LAST:event_lblExit2MouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    private void btnEditarReoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarReoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "Desea actualizar los cambios? Esto cerrará la sesión actual.",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            String nuevaContrasena = new String(txtPasswordProfe.getPassword());
            String confirmNuevaContrasena = new String(txtPasswConfirmProfe.getPassword());

            if (nuevaContrasena.equals(confirmNuevaContrasena)) {
                try {
                    controlador.actualizarDatos(txtUsuarioProfe.getText(), txtCorreoProfe.getText(), nuevaContrasena);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente. La sesión se cerrará.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // Cerrar el formulario frmEditarProfe
                    this.dispose();

                    // Cerrar el formulario frmPerfilProfesor si está abierto
                    for (Window window : Window.getWindows()) {
                        if (window instanceof frmPerfilProfesor) {
                            ((frmPerfilProfesor) window).cerrarFormulario();
                            break;  // Solo cerrar la primera instancia encontrada (si hay múltiples)
                        }
                    }

                    // Abrir el formulario de inicio de sesión (frmLogin)
                    Login loginForm = new Login();
                    loginForm.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(frmEditarProfe.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmEditarProfe.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_btnEditarReoActionPerformed
    private void limpiarInputs() {
        txtNombresProfe.setText("");
        txtApellidosProfe.setText("");
        txtCedulaProfe.setText("");
        txtUsuarioProfe.setText("");
        txtCorreoProfe.setText("");
        txtPasswordProfe.setText("");
        txtPasswConfirmProfe.setText("");
    }
// Método para obtener una instancia del formulario frmPerfilProfesor si ya está abierto

    private frmPerfilProfesor obtenerFormularioPerfilProfesorAbierto() {
        for (Window window : Window.getWindows()) {
            if (window instanceof frmPerfilProfesor) {
                return (frmPerfilProfesor) window;
            }
        }
        return null;
    }

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
            java.util.logging.Logger.getLogger(frmEditarProfe.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEditarProfe.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEditarProfe.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEditarProfe.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            public void run() {
                new frmEditarProfe(usuario, contraseña).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarReo;
    private com.toedter.calendar.JDateChooser jDateFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JPanel jPanelExit2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblExit2;
    private javax.swing.JLabel lbl_IdProfe;
    private javax.swing.JTextField txtApellidosProfe;
    private javax.swing.JTextField txtCedulaProfe;
    private javax.swing.JTextField txtCorreoProfe;
    private javax.swing.JTextField txtNombresProfe;
    private javax.swing.JPasswordField txtPasswConfirmProfe;
    private javax.swing.JPasswordField txtPasswordProfe;
    private javax.swing.JTextField txtUsuarioProfe;
    // End of variables declaration//GEN-END:variables
}
