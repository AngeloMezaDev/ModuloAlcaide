/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocs;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Mercy Palma
 */
public class fmrProfesores extends javax.swing.JFrame {

    /**
     * Creates new form fmrProfesores
     */
    public fmrProfesores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        JPanelMenu = new javax.swing.JPanel();
        btnAsistencias = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnCalificaciones = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnInformes = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LlbIconUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JPanelEncabezado = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanelExit2 = new javax.swing.JPanel();
        lblExit2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanelFondo.setMinimumSize(new java.awt.Dimension(1347, 600));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(1347, 600));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPanelMenu.setBackground(new java.awt.Color(54, 33, 89));
        JPanelMenu.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        JPanelMenu.setMinimumSize(new java.awt.Dimension(290, 600));
        JPanelMenu.setName(""); // NOI18N
        JPanelMenu.setPreferredSize(new java.awt.Dimension(290, 600));
        JPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAsistencias.setBackground(new java.awt.Color(85, 65, 118));
        btnAsistencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAsistenciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAsistenciasMouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("ASISTENCIAS");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/asistencia_1.png"))); // NOI18N

        javax.swing.GroupLayout btnAsistenciasLayout = new javax.swing.GroupLayout(btnAsistencias);
        btnAsistencias.setLayout(btnAsistenciasLayout);
        btnAsistenciasLayout.setHorizontalGroup(
            btnAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAsistenciasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4))
        );
        btnAsistenciasLayout.setVerticalGroup(
            btnAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAsistenciasLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnAsistenciasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4))
        );

        JPanelMenu.add(btnAsistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 290, 50));

        btnCalificaciones.setBackground(new java.awt.Color(64, 43, 100));
        btnCalificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCalificacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCalificacionesMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("CALIFICACIONES");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Informe.png"))); // NOI18N

        javax.swing.GroupLayout btnCalificacionesLayout = new javax.swing.GroupLayout(btnCalificaciones);
        btnCalificaciones.setLayout(btnCalificacionesLayout);
        btnCalificacionesLayout.setHorizontalGroup(
            btnCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCalificacionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5))
        );
        btnCalificacionesLayout.setVerticalGroup(
            btnCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCalificacionesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnCalificacionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5))
        );

        JPanelMenu.add(btnCalificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 290, 50));

        btnInformes.setBackground(new java.awt.Color(64, 43, 100));
        btnInformes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInformes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInformesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInformesMouseExited(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/teacher.png.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("INFORMES DE RECLUSOS");

        javax.swing.GroupLayout btnInformesLayout = new javax.swing.GroupLayout(btnInformes);
        btnInformes.setLayout(btnInformesLayout);
        btnInformesLayout.setHorizontalGroup(
            btnInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInformesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel7))
        );
        btnInformesLayout.setVerticalGroup(
            btnInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInformesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnInformesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7))
        );

        JPanelMenu.add(btnInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 290, 50));
        JPanelMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 230, 20));

        LlbIconUser.setForeground(new java.awt.Color(153, 153, 153));
        LlbIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/UserIconBanner.png"))); // NOI18N
        JPanelMenu.add(LlbIconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 40, 40));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("USER");
        JPanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel1.setBackground(new java.awt.Color(54, 33, 89));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ROL:");
        jLabel1.setOpaque(true);
        JPanelMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 65, -1, 30));

        btnSalir.setBackground(new java.awt.Color(85, 55, 100));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrow.png"))); // NOI18N

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Log Out");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalirLayout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(14, 14, 14))
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        JPanelMenu.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 290, 50));

        jPanelFondo.add(JPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        JPanelMenu.getAccessibleContext().setAccessibleParent(jPanelFondo);

        JPanelEncabezado.setBackground(new java.awt.Color(102, 0, 204));
        JPanelEncabezado.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        JPanelEncabezado.setMinimumSize(new java.awt.Dimension(1010, 84));
        JPanelEncabezado.setPreferredSize(new java.awt.Dimension(1060, 84));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("PROFESORES");

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("SISTEMA CARCELARIO \"CARCEQUIL - ASISTENCIAS\"");

        jPanelExit2.setBackground(new java.awt.Color(122, 72, 210));

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

        javax.swing.GroupLayout jPanelExit2Layout = new javax.swing.GroupLayout(jPanelExit2);
        jPanelExit2.setLayout(jPanelExit2Layout);
        jPanelExit2Layout.setHorizontalGroup(
            jPanelExit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExit2Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(lblExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelExit2Layout.setVerticalGroup(
            jPanelExit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExit2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout JPanelEncabezadoLayout = new javax.swing.GroupLayout(JPanelEncabezado);
        JPanelEncabezado.setLayout(JPanelEncabezadoLayout);
        JPanelEncabezadoLayout.setHorizontalGroup(
            JPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelEncabezadoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(JPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelEncabezadoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(681, Short.MAX_VALUE))
                    .addGroup(JPanelEncabezadoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelExit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        JPanelEncabezadoLayout.setVerticalGroup(
            JPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelEncabezadoLayout.createSequentialGroup()
                .addGroup(JPanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelEncabezadoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel11))
                    .addComponent(jPanelExit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        jPanelFondo.add(JPanelEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1053, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 910, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(547, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 345, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsistenciasMouseEntered
        setColor(btnAsistencias);
        resetColor(btnCalificaciones);
        resetColor(btnInformes);
    }//GEN-LAST:event_btnAsistenciasMouseEntered

    private void btnAsistenciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsistenciasMouseExited
        setColor(btnAsistencias);
        resetColor(btnCalificaciones);
        resetColor(btnInformes);
    }//GEN-LAST:event_btnAsistenciasMouseExited

    private void btnCalificacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalificacionesMouseEntered
        setColor(btnCalificaciones);
        resetColor(btnAsistencias);
        resetColor(btnInformes);
    }//GEN-LAST:event_btnCalificacionesMouseEntered

    private void btnCalificacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalificacionesMouseExited
        setColor(btnAsistencias);
        resetColor(btnCalificaciones);
        resetColor(btnInformes);
    }//GEN-LAST:event_btnCalificacionesMouseExited

    private void btnInformesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInformesMouseEntered
        setColor(btnInformes);
        resetColor(btnCalificaciones);
        resetColor(btnAsistencias);
    }//GEN-LAST:event_btnInformesMouseEntered

    private void btnInformesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInformesMouseExited
        setColor(btnAsistencias);
        resetColor(btnCalificaciones);
        resetColor(btnInformes);
    }//GEN-LAST:event_btnInformesMouseExited

    private void lblExit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExit2MouseClicked

    private void lblExit2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseEntered
        jPanelExit2.setBackground(Color.red);
        lblExit2.setBackground(Color.white);
    }//GEN-LAST:event_lblExit2MouseEntered

    private void lblExit2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseExited
        jPanelExit2.setBackground(new Color(33, 45, 62));
    }//GEN-LAST:event_lblExit2MouseExited

    void setColor(JPanel panel) {
        panel.setBackground(new Color(85, 65, 118));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(64, 43, 100));
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
            java.util.logging.Logger.getLogger(fmrProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmrProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmrProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmrProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmrProfesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelEncabezado;
    private javax.swing.JPanel JPanelMenu;
    private javax.swing.JLabel LlbIconUser;
    private javax.swing.JPanel btnAsistencias;
    private javax.swing.JPanel btnCalificaciones;
    private javax.swing.JPanel btnInformes;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelExit2;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblExit2;
    // End of variables declaration//GEN-END:variables
}
