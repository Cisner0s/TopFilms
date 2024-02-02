/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.Conexion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

import javax.swing.*;
import view.LoginWindow;


/**
 *
 * @author DCM
 */
public class RegisterWindow extends javax.swing.JFrame {
    
    public RegisterWindow() {
        initComponents();
        setResizable(false);
        setTitle("Registro de un nuevo usuario");
        setLocationRelativeTo(null);
        setIconImage(getIconImage());
    
    try {
            BufferedImage wallpaperImage = ImageIO.read(getClass().getResource("/images/Registro.png"));
            ImageIcon wallpaper = new ImageIcon(wallpaperImage.getScaledInstance(
                    jLabel_ImagenRegistro.getWidth(), jLabel_ImagenRegistro.getHeight(), Image.SCALE_DEFAULT));
            jLabel_ImagenRegistro.setIcon(wallpaper);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo adecuado de errores, por ejemplo, loggear el error.
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo.jpg"));
        return retValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_ImagenRegistro = new javax.swing.JLabel();
        jLabel_Username = new javax.swing.JLabel();
        jTextField_Username = new javax.swing.JTextField();
        jLabel_Contraseña = new javax.swing.JLabel();
        jPasswordField_Contraseña = new javax.swing.JPasswordField();
        jLabel_Username2 = new javax.swing.JLabel();
        jTextField_NombreCompleto = new javax.swing.JTextField();
        jLabel_Rol = new javax.swing.JLabel();
        jComboBox_Rol = new javax.swing.JComboBox<>();
        jLabel_ContraseñaRol = new javax.swing.JLabel();
        jPasswordField_ContraseñaRol = new javax.swing.JPasswordField();
        jButton_Registrarme = new javax.swing.JButton();
        jButton_Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 36)); // NOI18N
        jLabel_Titulo.setText("REGISTRO");
        jPanel1.add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 58));
        jPanel1.add(jLabel_ImagenRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 64, 58));

        jLabel_Username.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel_Username.setText("Nombre de Usuario");
        jPanel1.add(jLabel_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jTextField_Username.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_Username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 180, -1));

        jLabel_Contraseña.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Contraseña.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel_Contraseña.setText("Contraseña");
        jPanel1.add(jLabel_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jPasswordField_Contraseña.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField_Contraseña.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jPasswordField_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 180, -1));

        jLabel_Username2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel_Username2.setText("Nombre Completo");
        jPanel1.add(jLabel_Username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jTextField_NombreCompleto.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_NombreCompleto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_NombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 180, -1));

        jLabel_Rol.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel_Rol.setText("Rol");
        jPanel1.add(jLabel_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jComboBox_Rol.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Critico (Especial)", "Administrador (Especial)" }));
        jComboBox_Rol.setBorder(null);
        jComboBox_Rol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_RolActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 180, -1));

        jLabel_ContraseñaRol.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel_ContraseñaRol.setText("Contraseña Rol Especial");
        jLabel_ContraseñaRol.setEnabled(false);
        jPanel1.add(jLabel_ContraseñaRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));

        jPasswordField_ContraseñaRol.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField_ContraseñaRol.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPasswordField_ContraseñaRol.setEnabled(false);
        jPanel1.add(jPasswordField_ContraseñaRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 180, -1));

        jButton_Registrarme.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton_Registrarme.setText("Registrarme");
        jButton_Registrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarmeActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Registrarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 180, -1));

        jButton_Atras.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton_Atras.setText("Atrás");
        jButton_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoRegistro.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 410, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_RolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_RolActionPerformed
        String selectedRole = (String) jComboBox_Rol.getSelectedItem();

                // Habilitar o deshabilitar campos según la opción seleccionada
                if ("Administrador (Especial)".equals(selectedRole) || "Critico (Especial)".equals(selectedRole)) {
                    jPasswordField_ContraseñaRol.setEnabled(true);
                    jLabel_ContraseñaRol.setEnabled(true);

                } else {
                    jPasswordField_ContraseñaRol.setEnabled(false);
                    jLabel_ContraseñaRol.setEnabled(false);
                }
    }//GEN-LAST:event_jComboBox_RolActionPerformed

    private void jButton_RegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarmeActionPerformed
        int role;
        String user, pswd, name, rolePswd, roleString = "";      
        user = jTextField_Username.getText().trim();
        pswd = jPasswordField_Contraseña.getText().trim();
        name = jTextField_NombreCompleto.getText();
        rolePswd = jPasswordField_ContraseñaRol.getText().trim();
        role = jComboBox_Rol.getSelectedIndex();
        
        if (!user.equals("") && !pswd.equals("") && !name.equals("")) {
            switch (role) {
                case 0 -> roleString = "Usuario";
                case 1 -> roleString = "Critico";
                case 2 -> roleString = "Administrador";
                default -> {
                }
            }
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "select NOMBREUSUARIO from usuario where NOMBREUSUARIO ='" + user + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                    cn.close();
                } else {
                    cn.close();
                    if (roleString.equals("Usuario") || roleString.equals("Critico") && rolePswd.equals("Critico") || roleString.equals("Administrador") && rolePswd.equals("Administrador")){
                        try {
                            Connection cn2 = Conexion.conectar();
                            PreparedStatement pst2 = cn2.prepareStatement(
                                "insert into usuario values (?,?,?,?,?,?)");
                            pst2.setInt(1, 0);
                            pst2.setString(2, user);
                            pst2.setString(3, pswd);
                            pst2.setString(4, name);
                            pst2.setString(5, roleString);
                            pst2.setString(6, "Activo");
                            pst2.executeUpdate();
                            cn2.close();
                            JOptionPane.showMessageDialog(null, "Registro exitoso.");
                            this.dispose();
                            new LoginWindow().setVisible(true);
                        } catch (Exception e) {
                            System.err.println("Error al registrar usuario." + e);
                            JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar usuario!!, contacte al administrador.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Introduce correctamente la contraseña de rol.");
                    }
                }
            } catch (Exception e) {
                System.err.println("Error al validar el nombre de usuario." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al comparar usuario!!, contacte al administrador.");
            }
                
        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos.");
        }
    }//GEN-LAST:event_jButton_RegistrarmeActionPerformed

    private void jButton_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtrasActionPerformed
        dispose();
        new LoginWindow().setVisible(true);
    }//GEN-LAST:event_jButton_AtrasActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Atras;
    private javax.swing.JButton jButton_Registrarme;
    private javax.swing.JComboBox<String> jComboBox_Rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Contraseña;
    private javax.swing.JLabel jLabel_ContraseñaRol;
    private javax.swing.JLabel jLabel_ImagenRegistro;
    private javax.swing.JLabel jLabel_Rol;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Username;
    private javax.swing.JLabel jLabel_Username2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_Contraseña;
    private javax.swing.JPasswordField jPasswordField_ContraseñaRol;
    private javax.swing.JTextField jTextField_NombreCompleto;
    private javax.swing.JTextField jTextField_Username;
    // End of variables declaration//GEN-END:variables
}
