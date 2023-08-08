package VISTAS;

import CONTROLADOR.ctrlAsignacionRecluso;
import CONTROLADOR.ctrlReclusos;
import MODELO.ConnectionBD;
import MODELO.Inscripcion;
import MODELO.Recluso;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class frmInscripcionReclusos extends javax.swing.JFrame {
    
    private DefaultTableModel modeloTabla;
    private static String usuario = ""; 
    private static String contrasena ="";
    ctrlReclusos controlador = new ctrlReclusos();
    private ConnectionBD connectionBD;
    public static String nombreR = "";
    public static String apellidosR = "";
    public static String correo = "";
    public static String idRecluso = "";
    ctrlAsignacionRecluso ctrc = new ctrlAsignacionRecluso();
    
    public frmInscripcionReclusos(String usuario, String contrasena) throws ClassNotFoundException {
        initComponents();
        connectionBD = new ConnectionBD();
        lblHandle.setText("@" + usuario);
        this.usuario = usuario; 
        this.contrasena = contrasena;
        ctrlReclusos controlador = new ctrlReclusos();
        modeloTabla = new DefaultTableModel();
        jTable1.setModel(modeloTabla);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        String[] nombresColumnas = {"ID Taller", "Nombre de taller", "Grupo","Tiempo de Reducción", "Fecha de inicio", "Fecha de finalización", "Cupos", "Inscribirse"};
        modeloTabla.setColumnIdentifiers(nombresColumnas);

        controlador.cargarDatosTalleresG(modeloTabla);
        TableColumn tc = jTable1.getColumnModel().getColumn(7); 
        tc.setCellEditor(jTable1.getDefaultEditor(Boolean.class)); 
        tc.setCellRenderer(jTable1.getDefaultRenderer(Boolean.class));
        
        
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
        btnTalleres = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInscripciones = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblHandle = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanelBackGround.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBackGround.setMinimumSize(new java.awt.Dimension(1337, 640));
        jPanelBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSide.setBackground(new java.awt.Color(54, 33, 89));
        jPanelSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTalleres.setBackground(new java.awt.Color(85, 65, 118));
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

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("TALLERES");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/Taller.png"))); // NOI18N

        javax.swing.GroupLayout btnTalleresLayout = new javax.swing.GroupLayout(btnTalleres);
        btnTalleres.setLayout(btnTalleresLayout);
        btnTalleresLayout.setHorizontalGroup(
            btnTalleresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTalleresLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        btnTalleresLayout.setVerticalGroup(
            btnTalleresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTalleresLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTalleresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(14, 14, 14))
        );

        jPanelSide.add(btnTalleres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 300, 50));

        btnInscripciones.setBackground(new java.awt.Color(64, 43, 100));
        btnInscripciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInscripciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInscripcionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInscripcionesMouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("INSCRIPCIONES");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/Inscripcion.png"))); // NOI18N

        javax.swing.GroupLayout btnInscripcionesLayout = new javax.swing.GroupLayout(btnInscripciones);
        btnInscripciones.setLayout(btnInscripcionesLayout);
        btnInscripcionesLayout.setHorizontalGroup(
            btnInscripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInscripcionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4))
        );
        btnInscripcionesLayout.setVerticalGroup(
            btnInscripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInscripcionesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInscripcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(14, 14, 14))
        );

        jPanelSide.add(btnInscripciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 300, 50));

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

        jPanelSide.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 50));

        lblHandle.setBackground(new java.awt.Color(204, 204, 204));
        lblHandle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHandle.setForeground(new java.awt.Color(204, 204, 204));
        lblHandle.setText("USER");
        jPanelSide.add(lblHandle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

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
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BtnOpcion5Layout = new javax.swing.GroupLayout(BtnOpcion5);
        BtnOpcion5.setLayout(BtnOpcion5Layout);
        BtnOpcion5Layout.setHorizontalGroup(
            BtnOpcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnOpcion5Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(31, 31, 31))
        );
        BtnOpcion5Layout.setVerticalGroup(
            BtnOpcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(BtnOpcion5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSide.add(BtnOpcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 300, 50));

        jLabel1.setBackground(new java.awt.Color(54, 33, 89));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanelBackGround.add(jPanelSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 640));

        jPanelBanner.setBackground(new java.awt.Color(122, 72, 221));
        jPanelBanner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("SISTEMA CARCELARIO \"CARCEQUIL\" - TALLERES");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExit2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelBanner.add(jPanelExit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, -1, -1));

        jPanelBackGround.add(jPanelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 0, 1090, -1));

        jPanel1.setBackground(new java.awt.Color(230, 240, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imagenes_Alcaide/TrabajoForzado1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setText("Inscripción de talleres ");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("Elija los talleres que desea realizar. Como máximo puede elegir");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("3 talleres. Tenga en cuenta el tiempo de reducción de condena.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel17))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBackGround.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 810, 160));

        btnEnviar.setBackground(new java.awt.Color(65, 39, 111));
        btnEnviar.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Inscribirse");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanelBackGround.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 600, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Taller", "Nombre del taller", "Grupo:", "Tiempo de Reducción", "Fecha de inicio", "Fecha de finalización", "Cupos", "Inscribirse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        TableColumn tc = jTable1.getColumnModel().getColumn(6); 
        tc.setCellEditor(jTable1.getDefaultEditor(Boolean.class)); 
        tc.setCellRenderer(jTable1.getDefaultRenderer(Boolean.class));
        jScrollPane1.setViewportView(jTable1);

        jPanelBackGround.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 1070, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackGround, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnTalleresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseEntered
        setColor(btnTalleres);
        resetColor(btnInscripciones);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnTalleresMouseEntered

    private void btnTalleresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseExited
        resetColor(btnTalleres);
        resetColor(btnInscripciones);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnTalleresMouseExited

    private void btnInscripcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInscripcionesMouseEntered
        setColor(btnInscripciones);
        resetColor(btnTalleres);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnInscripcionesMouseEntered

    private void btnInscripcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInscripcionesMouseExited
        resetColor(btnTalleres);
        resetColor(btnInscripciones);
        resetColor(btnPerfil);
    }//GEN-LAST:event_btnInscripcionesMouseExited

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
        setColor(btnPerfil);
        resetColor(btnInscripciones);
        resetColor(btnTalleres);
    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseExited
        resetColor(btnTalleres);
        resetColor(btnInscripciones);
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

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        frmPerfil perfil = null;
        try {
            perfil = new frmPerfil(usuario, contrasena);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        perfil.setVisible(true);
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnTalleresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTalleresMouseClicked
        frmTalleres noti = null;
        try {
            noti = new frmTalleres(usuario, contrasena);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        noti.setVisible(true);
    }//GEN-LAST:event_btnTalleresMouseClicked
    
    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
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
    }//GEN-LAST:event_jLabel14MouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
    int maxPostulaciones = 3;
    int seleccionadas = 0;
    String IdRecluso = "";
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        Boolean b = (Boolean) jTable1.getModel().getValueAt(i, 7);
        
        if (b != null && b) {        
            seleccionadas++;
            
            try {
                IdRecluso = ctrc.ObtenerIdRecluso(usuario,contrasena);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if(!controlador.InscripcionesAlcanzadas(IdRecluso)){
                    String idTaller = (String) jTable1.getModel().getValueAt(i, 0);
                    String nombreTaller = (String) jTable1.getModel().getValueAt(i, 1);
                    String nombreGrupo = (String) jTable1.getModel().getValueAt(i, 2);
                    int reduccion = (int) jTable1.getModel().getValueAt(i, 3);
                    Date fechaCreacion = (Date) jTable1.getModel().getValueAt(i, 4);
                    Date fechaVencimiento = (Date) jTable1.getModel().getValueAt(i, 5);       
                    int cupos = (int) jTable1.getModel().getValueAt(i, 6);
                    Inscripcion inscripcion = new Inscripcion(nombreR, apellidosR, correo, idRecluso, nombreGrupo, cupos, idTaller, nombreTaller, 0, cupos, fechaCreacion, fechaVencimiento, reduccion);
                    controlador.cargarIdGrupo(idTaller);
                    controlador.guardarTaller(inscripcion);                        
                } else{ 
                    JOptionPane.showMessageDialog(null, "Alcanzaste el máximo de inscripciones");

                }         
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        if (seleccionadas > maxPostulaciones) {
            JOptionPane.showMessageDialog(null, "Seleccione " + maxPostulaciones + " talleres como máximo");
            return;
        }
    }
    if (seleccionadas == 0) {
        JOptionPane.showMessageDialog(null, "Seleccione al menos una postulación");
    } else {       
        JOptionPane.showMessageDialog(null, "Inscripciones enviadas con éxito");
        try {
            controlador.MisTalleres(IdRecluso);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


    }//GEN-LAST:event_btnEnviarActionPerformed
    
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
            java.util.logging.Logger.getLogger(frmTalleres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTalleres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTalleres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTalleres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmInscripcionReclusos(usuario, contrasena).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmInscripcionReclusos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnOpcion5;
    private javax.swing.JLabel LlbIconUser;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JPanel btnInscripciones;
    private javax.swing.JPanel btnPerfil;
    private javax.swing.JPanel btnTalleres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBackGround;
    private javax.swing.JPanel jPanelBanner;
    private javax.swing.JPanel jPanelExit2;
    private javax.swing.JPanel jPanelSide;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblExit2;
    private javax.swing.JLabel lblHandle;
    // End of variables declaration//GEN-END:variables

    
}
