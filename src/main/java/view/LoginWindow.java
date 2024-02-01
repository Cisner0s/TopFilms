/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JOptionPane;
import dao.Conexion;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
/**
 *
 * @author Cisneros
 */
public class LoginWindow extends javax.swing.JFrame {

    public static String user = ""; //Se declara así para enviar datos entre interfaces
    String pass = "";
    int intentos = 3;
    
    /**
     * Creates new form Login
     */
    
    public LoginWindow() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);
        
        try {
            BufferedImage wallpaperImage = ImageIO.read(getClass().getResource("/images/wallpaperPrincipal.jpg"));
            ImageIcon wallpaper = new ImageIcon(wallpaperImage.getScaledInstance(
                    jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
            jLabel_Wallpaper.setIcon(wallpaper);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo adecuado de errores, por ejemplo, loggear el error.
        }

        try {
            BufferedImage logoImage = ImageIO.read(getClass().getResource("/images/logo.jpg"));;
            ImageIcon logo = new ImageIcon(logoImage.getScaledInstance(
                    jLabel_Logo.getWidth(), jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
            jLabel_Logo.setIcon(logo);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo adecuado de errores, por ejemplo, loggear el error.
        }

        txt_user.setText("Nombre de usuario");
        txt_user.setForeground(Color.gray);
        txt_password.setText("Contraseña");
	txt_password.setForeground(Color.gray);
	txt_password.setEchoChar((char) 0);
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

        jLabel_Logo = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 270, 270));

        txt_user.setBackground(new java.awt.Color(204, 204, 204));
        txt_user.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_userFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_userFocusLost(evt);
            }
        });
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        txt_password.setBackground(new java.awt.Color(204, 204, 204));
        txt_password.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passwordFocusLost(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, -1));

        jButton_Acceder.setBackground(new java.awt.Color(204, 204, 204));
        jButton_Acceder.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.setBorder(null);
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 35));

        jLabel_Footer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Footer.setText("Registrate aqui");
        jLabel_Footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_FooterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_FooterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_FooterMouseExited(evt);
            }
        });
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed

        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();
        if (!user.equals("") || !pass.equals("")) {

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select ROL, ESTATUS from usuario where NOMBREUSUARIO = '" + user
                        + "' and CONTRASEÑA = '" + pass + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    String tipo_nivel = rs.getString("ROL");
                    String estatus = rs.getString("ESTATUS");

                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        //dispose(); Hace que el JFrame sea destruido y limpiado por el sistema operativo.
                        dispose();
                        new AdminWindow().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Critico") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new CriticoWindow().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Usuario") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new UserWindow().setVisible(true);
                    }

                } else {
                    intentos -= 1;
                    txt_user.setText("Nombre de usuario");
                    txt_user.setForeground(Color.gray);
                    txt_password.setText("Contraseña");
                    txt_password.setForeground(Color.gray);
                    txt_password.setEchoChar((char) 0);
                    if (intentos == 0){
                        JOptionPane.showMessageDialog(null, "No le quedan más intentos, vuelva más tarde.");
                        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                        jButton_Acceder.setEnabled(false);
                        scheduler.schedule(() -> jButton_Acceder.setEnabled(true), 10, TimeUnit.MINUTES);
                        intentos = 3;
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos. Le quedan " + intentos + " intento(s).");
                    }
                }

            } catch (SQLException e) {
                System.err.println("Error en el botón Acceder." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al iniciar!!, contacte al administrador.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_jButton_AccederActionPerformed

    private void jLabel_FooterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_FooterMouseClicked
        dispose();
        new RegisterWindow().setVisible(true);
    }//GEN-LAST:event_jLabel_FooterMouseClicked

    private void jLabel_FooterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_FooterMouseEntered
        jLabel_Footer.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel_FooterMouseEntered

    private void jLabel_FooterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_FooterMouseExited
       jLabel_Footer.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel_FooterMouseExited
    
    private void txt_userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_userFocusGained
        if (txt_user.getText().equals("Nombre de usuario") && txt_user.getForeground().equals(Color.gray)) {
            txt_user.setText("");
            txt_user.setForeground(Color.black);
	}
    }//GEN-LAST:event_txt_userFocusGained

    private void txt_userFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_userFocusLost
        if (txt_user.getText().equals("")) {
            txt_user.setText("Nombre de usuario");
            txt_user.setForeground(Color.gray);
	}
    }//GEN-LAST:event_txt_userFocusLost

    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained
        String pw = new String(txt_password.getPassword());
        if (pw.equals("Contraseña") && txt_password.getForeground().equals(Color.gray)) {
            txt_password.setText("");
            txt_password.setForeground(Color.black);
            txt_password.setEchoChar('*');
	}
    }//GEN-LAST:event_txt_passwordFocusGained

    private void txt_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusLost
        String pw = new String(txt_password.getPassword());
	if (pw.equals("")) {
            txt_password.setEchoChar((char) 0);
            txt_password.setText("Contraseña");
            txt_password.setForeground(Color.gray);
	}
    }//GEN-LAST:event_txt_passwordFocusLost
   
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
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
