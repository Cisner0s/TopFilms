/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.editar;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author DCM
 */
public class EditarActorWindow extends javax.swing.JFrame {

    /**
     * Creates new form EditarActorWindow
     */
    public EditarActorWindow() {
        initComponents();
        setResizable(false);
        setTitle("Editar Actor.");
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
        jLabel45 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel55 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(400, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Titulo");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jTextField21.setBackground(new java.awt.Color(204, 153, 255));
        jTextField21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 180, -1));

        jLabel46.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Fecha Estreno");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel47.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Numero de Episodios");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jTextField34.setBackground(new java.awt.Color(204, 153, 255));
        jTextField34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 180, -1));

        jLabel48.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Duracion media por Episodio");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jTextField35.setBackground(new java.awt.Color(204, 153, 255));
        jTextField35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 180, -1));

        jLabel49.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Numero de Temporadas");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        jTextField36.setBackground(new java.awt.Color(204, 153, 255));
        jTextField36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 180, -1));

        jLabel51.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Presupuesto");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));

        jTextField38.setBackground(new java.awt.Color(204, 153, 255));
        jTextField38.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 180, -1));

        jLabel52.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Ganancias");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        jTextField39.setBackground(new java.awt.Color(204, 153, 255));
        jTextField39.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 180, -1));

        jLabel50.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Imagen");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, -1, -1));

        jTextField37.setBackground(new java.awt.Color(204, 153, 255));
        jTextField37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 180, -1));

        jLabel53.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Nombre Director");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, -1, -1));

        jTextField40.setBackground(new java.awt.Color(204, 153, 255));
        jTextField40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, 180, -1));

        jLabel54.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Nombre Estudio");
        jPanel1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, -1, -1));

        jTextField41.setBackground(new java.awt.Color(204, 153, 255));
        jTextField41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 180, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar Actor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jDateChooser1.setBackground(new java.awt.Color(204, 153, 255));
        jDateChooser1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 180, -1));

        jLabel55.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Actor_ID");
        jPanel1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jTextField22.setBackground(new java.awt.Color(204, 153, 255));
        jTextField22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 180, -1));

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setText("EDITAR");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 630, 180, -1));

        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ir_1.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 110, 90));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Negro_Trans_2.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 520, 670));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-99, 0, 700, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(EditarActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarActorWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    // End of variables declaration//GEN-END:variables
}
