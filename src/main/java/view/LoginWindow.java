/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
/**
 *
 * @author Cisneros
 */
public class LoginWindow extends javax.swing.JFrame {

    public static String user = ""; //Se declara así para enviar datos entre interfaces    
    /**
     * Creates new form Login
     */
    
    public LoginWindow() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);
        
        LoginController loginCtr = new LoginController(this);
        jButton_Acceder.addActionListener(loginCtr);
        jLabel_Footer.addMouseListener(loginCtr);
        txt_password.addFocusListener(loginCtr);
        txt_user.addFocusListener(loginCtr);
        
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
    
    public String getNickName(){
        return txt_user.getText(); 
    }
    
    public String getPassword(){
        return txt_password.getText();
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
        jLabel_Logo = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo_Blanco.png"))); // NOI18N
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 270, 270));

        txt_user.setBackground(new java.awt.Color(204, 204, 204));
        txt_user.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 210, -1));

        txt_password.setBackground(new java.awt.Color(204, 204, 204));
        txt_password.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 210, -1));

        jButton_Acceder.setBackground(new java.awt.Color(204, 204, 204));
        jButton_Acceder.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton_Acceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ir_1.png"))); // NOI18N
        jButton_Acceder.setBorder(null);
        jButton_Acceder.setBorderPainted(false);
        jButton_Acceder.setContentAreaFilled(false);
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 80, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre de usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jLabel_Footer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setText("Registrate aqui");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo_Trans_1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 340, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField txt_password;
    public javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
