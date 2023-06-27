package VISTA;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class frmPerfil extends javax.swing.JFrame {

    public frmPerfil() {
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
        btnNotificaciones = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTalleres = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LlbIconUser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BtnOpcion5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanelBanner = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanelExit2 = new javax.swing.JPanel();
        lblExit2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        lblCodRec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanelBackGround.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBackGround.setFocusable(false);
        jPanelBackGround.setRequestFocusEnabled(false);
        jPanelBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSide.setBackground(new java.awt.Color(54, 33, 89));
        jPanelSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNotificaciones.setBackground(new java.awt.Color(85, 65, 118));
        btnNotificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNotificacionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNotificacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNotificacionesMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("NOTIFICACIONES");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/campana.png"))); // NOI18N

        javax.swing.GroupLayout btnNotificacionesLayout = new javax.swing.GroupLayout(btnNotificaciones);
        btnNotificaciones.setLayout(btnNotificacionesLayout);
        btnNotificacionesLayout.setHorizontalGroup(
            btnNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNotificacionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        btnNotificacionesLayout.setVerticalGroup(
            btnNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNotificacionesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(14, 14, 14))
        );

        jPanelSide.add(btnNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 290, 50));

        btnTalleres.setBackground(new java.awt.Color(64, 43, 100));
        btnTalleres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTalleres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTalleresMouseClicked(evt);
            }
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
                .addGap(12, 12, 12)
                .addComponent(jLabel4))
        );
        btnTalleresLayout.setVerticalGroup(
            btnTalleresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTalleresLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTalleresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(14, 14, 14))
        );

        jPanelSide.add(btnTalleres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 290, 50));

        btnPerfil.setBackground(new java.awt.Color(64, 43, 100));
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPerfilMouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/PrisioneroPerfil.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("PERFIL");

        javax.swing.GroupLayout btnPerfilLayout = new javax.swing.GroupLayout(btnPerfil);
        btnPerfil.setLayout(btnPerfilLayout);
        btnPerfilLayout.setHorizontalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        btnPerfilLayout.setVerticalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6))
        );

        jPanelSide.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 290, 50));

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

        lblLogOut.setBackground(new java.awt.Color(204, 204, 204));
        lblLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogOut.setForeground(new java.awt.Color(204, 204, 204));
        lblLogOut.setText("Log Out");
        lblLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BtnOpcion5Layout = new javax.swing.GroupLayout(BtnOpcion5);
        BtnOpcion5.setLayout(BtnOpcion5Layout);
        BtnOpcion5Layout.setHorizontalGroup(
            BtnOpcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnOpcion5Layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogOut)
                .addGap(12, 12, 12))
        );
        BtnOpcion5Layout.setVerticalGroup(
            BtnOpcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(BtnOpcion5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblLogOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSide.add(BtnOpcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 290, 50));

        jLabel1.setBackground(new java.awt.Color(54, 33, 89));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ROL:");
        jLabel1.setOpaque(true);
        jPanelSide.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 65, -1, 30));

        jTextField1.setBackground(new java.awt.Color(54, 33, 89));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Recluso");
        jTextField1.setBorder(null);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.setFocusable(false);
        jPanelSide.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 160, 20));

        jPanelBackGround.add(jPanelSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, -1));

        jPanelBanner.setBackground(new java.awt.Color(122, 72, 221));
        jPanelBanner.setRequestFocusEnabled(false);
        jPanelBanner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("SISTEMA CARCELARIO \"CARCEQUIL\" - PERFIL");
        jPanelBanner.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 64, -1, -1));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Reclusos");
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

        jPanel1.setBackground(new java.awt.Color(230, 240, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/preso.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 25)); // NOI18N
        jLabel8.setText("Cristhian Roberto Araujo Villalva");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Ecuatoriano");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBackGround.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 950, -1));

        jPanel2.setBackground(new java.awt.Color(222, 228, 230));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel16.setText("Código del recluso:");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel17.setText("Edad:");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel18.setText("Fecha de Nacimiento:");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel19.setText("E-mail:");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel20.setText("Actividades realizadas:");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel21.setText("Horas cumplidas:");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        lblCodRec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCodRec.setText("#######");
        lblCodRec.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField7)
                        .addComponent(jTextField8)
                        .addComponent(jTextField9)
                        .addComponent(jTextField6)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCodRec))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblCodRec))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addComponent(jLabel18))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanelBackGround.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 950, -1));

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

    private void btnNotificacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotificacionesMouseEntered
        setColor(btnNotificaciones);
        resetColor(btnTalleres);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnNotificacionesMouseEntered

    private void btnNotificacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotificacionesMouseExited
        resetColor(btnNotificaciones);
        resetColor(btnTalleres);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnNotificacionesMouseExited

    private void btnTalleresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseEntered
        setColor(btnTalleres);
        resetColor(btnNotificaciones);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnTalleresMouseEntered

    private void btnTalleresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseExited
        resetColor(btnNotificaciones);
        resetColor(btnTalleres);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnTalleresMouseExited

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
        setColor(btnPerfil);
        resetColor(btnTalleres);
        resetColor(btnNotificaciones);
    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseExited
        resetColor(btnNotificaciones);
        resetColor(btnTalleres);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnPerfilMouseExited

    private void lblExit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExit2MouseClicked

    private void lblExit2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseEntered
        jPanelExit2.setBackground(Color.red);
        lblExit2.setBackground(Color.white);
    }//GEN-LAST:event_lblExit2MouseEntered

    private void lblExit2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit2MouseExited
        jPanelExit2.setBackground(new Color(122,72,221));
    }//GEN-LAST:event_lblExit2MouseExited

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        // Mostrar mensaje de confirmación para cerrar sesión
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_OPTION);

        // Verificar la opción seleccionada por el usuario
        if (opcion == JOptionPane.YES_OPTION) {
            // Mostrar mensaje de sesión cerrada con éxito
            JOptionPane.showMessageDialog(null, "Sesión cerrada con éxito", "Sesión cerrada", JOptionPane.INFORMATION_MESSAGE);

            // Cerrar el formulario actual
            this.dispose();

            // Cargar el formulario de login
            Login loginForm = new Login();
            loginForm.setVisible(true);
        }
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void btnNotificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotificacionesMouseClicked
        frmReclusos noti= new frmReclusos();
        this.dispose();
        noti.setVisible(true);
    }//GEN-LAST:event_btnNotificacionesMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        frmPerfil perfil=new frmPerfil();
        this.dispose();
        perfil.setVisible(true);
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnTalleresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseClicked
        frmTalleres tall=new frmTalleres();
        this.dispose();
        tall.setVisible(true);
    }//GEN-LAST:event_btnTalleresMouseClicked

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
            java.util.logging.Logger.getLogger(frmReclusos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReclusos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReclusos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReclusos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnOpcion5;
    private javax.swing.JLabel LlbIconUser;
    private javax.swing.JPanel btnNotificaciones;
    private javax.swing.JPanel btnPerfil;
    private javax.swing.JPanel btnTalleres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBackGround;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JPanel jPanelExit2;
    private javax.swing.JPanel jPanelSide;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblCodRec;
    private javax.swing.JLabel lblExit2;
    private javax.swing.JLabel lblLogOut;
    // End of variables declaration//GEN-END:variables
}
