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
public class AnadirPeliculaWindow extends javax.swing.JFrame {

    /**
     * Creates new form AñadirPeliculaWindow
     */
    public AnadirPeliculaWindow() {
        initComponents();
        setResizable(false);
        setTitle("Añadir Pelicula");
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
        jLabel36 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel38 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel36.setText("Titulo");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jTextField33.setBackground(new java.awt.Color(204, 255, 255));
        jTextField33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, -1));

        jLabel37.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel37.setText("Sinopsis");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jTextArea5.setBackground(new java.awt.Color(204, 255, 255));
        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane5.setViewportView(jTextArea5);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel38.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel38.setText("Genero");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jTextField27.setBackground(new java.awt.Color(204, 255, 255));
        jTextField27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 180, -1));

        jLabel39.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel39.setText("Fecha Estreno");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jLabel40.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel40.setText("Presupuesto");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));

        jTextField28.setBackground(new java.awt.Color(204, 255, 255));
        jTextField28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 180, -1));

        jLabel41.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel41.setText("Ganancias");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, -1));

        jTextField29.setBackground(new java.awt.Color(204, 255, 255));
        jTextField29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 180, -1));

        jLabel42.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel42.setText("Imagen");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, -1, -1));

        jTextField30.setBackground(new java.awt.Color(204, 255, 255));
        jTextField30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 180, -1));

        jLabel43.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel43.setText("Nombre Director");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, -1, -1));

        jTextField31.setBackground(new java.awt.Color(204, 255, 255));
        jTextField31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 180, -1));

        jLabel44.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel44.setText("Nombre Estudio");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, -1, -1));

        jTextField32.setBackground(new java.awt.Color(204, 255, 255));
        jTextField32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 180, -1));

        jDateChooser1.setBackground(new java.awt.Color(204, 255, 255));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 180, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setText("Añadir Pelicula");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 650, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photo-1557683311-eac922347aa1.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 400, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(AnadirPeliculaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirPeliculaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirPeliculaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirPeliculaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirPeliculaWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    // End of variables declaration//GEN-END:variables
}