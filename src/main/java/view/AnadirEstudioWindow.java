/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author DCM
 */
public class AnadirEstudioWindow extends javax.swing.JFrame {

    /**
     * Creates new form AñadirEstudioWindow
     */
    public AnadirEstudioWindow() {
        initComponents();
        setResizable(false);
        setTitle("Añadir Estudio");
        setLocationRelativeTo(null);
        setIconImage(getIconImage());
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
        jLabel69 = new javax.swing.JLabel();
        jTextField49 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel69.setText("Nombre");
        jPanel1.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, 20));

        jTextField49.setBackground(new java.awt.Color(204, 255, 255));
        jTextField49.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 180, 20));

        jLabel70.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel70.setText("Propietario");
        jPanel1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, 20));

        jTextField50.setBackground(new java.awt.Color(204, 255, 255));
        jTextField50.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 180, 20));

        jLabel71.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel71.setText("Fecha de fundacion");
        jPanel1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, 20));

        jTextField51.setBackground(new java.awt.Color(204, 255, 255));
        jTextField51.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 180, 20));

        jLabel72.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel72.setText("Patrimonio");
        jPanel1.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, 20));

        jTextField52.setBackground(new java.awt.Color(204, 255, 255));
        jTextField52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField52, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 180, 20));

        jLabel73.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel73.setText("Sedes");
        jPanel1.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, 20));

        jTextField53.setBackground(new java.awt.Color(204, 255, 255));
        jTextField53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 180, 20));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel2.setText("Añadir Estudio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 180, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photo-1557683311-eac922347aa1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 400, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AnadirEstudioWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirEstudioWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirEstudioWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirEstudioWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirEstudioWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    // End of variables declaration//GEN-END:variables
}