/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectocs;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Angelo Meza
 */
public class frmAlcaide extends javax.swing.JFrame {

    /**
     * Creates new form frmAlcaide
     */
    public frmAlcaide() {
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

        jPanelBackGround = new javax.swing.JPanel();
        jPanelSide = new javax.swing.JPanel();
        btnActividades = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTalleres = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnProfesores = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnReclusos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LlbIconUser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BtnOpcion5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanelBanner = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanelExit2 = new javax.swing.JPanel();
        lblExit2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        choice1 = new java.awt.Choice();
        choice2 = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanelBackGround.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSide.setBackground(new java.awt.Color(54, 33, 89));
        jPanelSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActividades.setBackground(new java.awt.Color(85, 65, 118));
        btnActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActividadesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActividadesMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("ACTIVIDADES");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/list.png"))); // NOI18N

        javax.swing.GroupLayout btnActividadesLayout = new javax.swing.GroupLayout(btnActividades);
        btnActividades.setLayout(btnActividadesLayout);
        btnActividadesLayout.setHorizontalGroup(
            btnActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnActividadesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        btnActividadesLayout.setVerticalGroup(
            btnActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnActividadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btnActividadesLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel9)))
                .addGap(41, 41, 41))
        );

        jPanelSide.add(btnActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 290, 50));

        btnTalleres.setBackground(new java.awt.Color(64, 43, 100));
        btnTalleres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTalleres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTalleresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTalleresMouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("TALLERES");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/group.png"))); // NOI18N

        javax.swing.GroupLayout btnTalleresLayout = new javax.swing.GroupLayout(btnTalleres);
        btnTalleres.setLayout(btnTalleresLayout);
        btnTalleresLayout.setHorizontalGroup(
            btnTalleresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTalleresLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        btnTalleresLayout.setVerticalGroup(
            btnTalleresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTalleresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnTalleresLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanelSide.add(btnTalleres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 290, 50));

        btnProfesores.setBackground(new java.awt.Color(64, 43, 100));
        btnProfesores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfesoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfesoresMouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/teacher.png.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("PROFESORES");

        javax.swing.GroupLayout btnProfesoresLayout = new javax.swing.GroupLayout(btnProfesores);
        btnProfesores.setLayout(btnProfesoresLayout);
        btnProfesoresLayout.setHorizontalGroup(
            btnProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfesoresLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        btnProfesoresLayout.setVerticalGroup(
            btnProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProfesoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnProfesoresLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanelSide.add(btnProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 290, 50));

        btnReclusos.setBackground(new java.awt.Color(64, 43, 100));
        btnReclusos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReclusos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReclusosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReclusosMouseExited(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/prison.png"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("RECLUSOS");

        javax.swing.GroupLayout btnReclusosLayout = new javax.swing.GroupLayout(btnReclusos);
        btnReclusos.setLayout(btnReclusosLayout);
        btnReclusosLayout.setHorizontalGroup(
            btnReclusosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReclusosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        btnReclusosLayout.setVerticalGroup(
            btnReclusosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReclusosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReclusosLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(14, 14, 14))
        );

        jPanelSide.add(btnReclusos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 290, 50));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("USER");
        jPanelSide.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        LlbIconUser.setForeground(new java.awt.Color(153, 153, 153));
        LlbIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/UserIconBanner.png"))); // NOI18N
        jPanelSide.add(LlbIconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 40, 40));
        jPanelSide.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 230, 20));

        BtnOpcion5.setBackground(new java.awt.Color(85, 55, 100));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/arrow.png"))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Log Out");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout BtnOpcion5Layout = new javax.swing.GroupLayout(BtnOpcion5);
        BtnOpcion5.setLayout(BtnOpcion5Layout);
        BtnOpcion5Layout.setHorizontalGroup(
            BtnOpcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnOpcion5Layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        BtnOpcion5Layout.setVerticalGroup(
            BtnOpcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnOpcion5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(14, 14, 14))
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelSide.add(BtnOpcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 290, 50));

        jLabel1.setBackground(new java.awt.Color(54, 33, 89));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ROL:");
        jLabel1.setOpaque(true);
        jPanelSide.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 65, -1, 30));

        jTextField1.setBackground(new java.awt.Color(54, 33, 89));
        jTextField1.setText("Angelo Meza");
        jTextField1.setBorder(null);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.setFocusable(false);
        jPanelSide.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 160, 20));

        jPanelBackGround.add(jPanelSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, -1));

        jPanelBanner.setBackground(new java.awt.Color(122, 72, 221));
        jPanelBanner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("SISTEMA CARCELARIO DE ACTIVIDADES");
        jPanelBanner.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 64, -1, -1));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("ALCAIDE");
        jPanelBanner.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 24, -1, -1));

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
            .addComponent(lblExit2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanelBanner.add(jPanelExit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, -1, -1));

        jPanelBackGround.add(jPanelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 0, 1060, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "data 1", "data 2", "data 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        jPanelBackGround.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 257, 807, 320));
        jPanelBackGround.add(choice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 204, 185, -1));
        jPanelBackGround.add(choice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 198, 185, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackGround, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnActividadesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActividadesMouseExited
        resetColor(btnActividades);
        resetColor(btnTalleres);
        resetColor(btnProfesores);
        resetColor(btnReclusos);

    }//GEN-LAST:event_btnActividadesMouseExited

    private void btnTalleresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseExited
        resetColor(btnActividades);
        resetColor(btnTalleres);
        resetColor(btnProfesores);
        resetColor(btnReclusos);
    }//GEN-LAST:event_btnTalleresMouseExited

    private void btnProfesoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesoresMouseExited
        resetColor(btnActividades);
        resetColor(btnTalleres);
        resetColor(btnProfesores);
        resetColor(btnReclusos);    }//GEN-LAST:event_btnProfesoresMouseExited

    private void btnReclusosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReclusosMouseExited
        resetColor(btnActividades);
        resetColor(btnTalleres);
        resetColor(btnProfesores);
        resetColor(btnReclusos);    }//GEN-LAST:event_btnReclusosMouseExited

    private void btnActividadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActividadesMouseEntered
         setColor(btnActividades);
        resetColor(btnTalleres);
        resetColor(btnProfesores);
        resetColor(btnReclusos);
    }//GEN-LAST:event_btnActividadesMouseEntered

    private void btnTalleresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseEntered
        setColor(btnTalleres);
        resetColor(btnActividades);
        resetColor(btnProfesores);
        resetColor(btnReclusos);
    }//GEN-LAST:event_btnTalleresMouseEntered

    private void btnProfesoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesoresMouseEntered
         setColor(btnProfesores);
        resetColor(btnTalleres);
        resetColor(btnActividades);
        resetColor(btnReclusos);
    }//GEN-LAST:event_btnProfesoresMouseEntered

    private void btnReclusosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReclusosMouseEntered
         setColor(btnReclusos);
        resetColor(btnTalleres);
        resetColor(btnProfesores);
        resetColor(btnActividades);
    }//GEN-LAST:event_btnReclusosMouseEntered
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
            java.util.logging.Logger.getLogger(frmAlcaide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAlcaide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAlcaide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAlcaide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAlcaide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnOpcion5;
    private javax.swing.JLabel LlbIconUser;
    private javax.swing.JPanel btnActividades;
    private javax.swing.JPanel btnProfesores;
    private javax.swing.JPanel btnReclusos;
    private javax.swing.JPanel btnTalleres;
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelBackGround;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JPanel jPanelExit2;
    private javax.swing.JPanel jPanelSide;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblExit2;
    // End of variables declaration//GEN-END:variables
}
