/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.details;

import controller.details.ActorDetailsController;
import view.menu.*;
import controller.menus.ActorMenuController;
import controller.menus.SerieMenuController;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author DCM
 */
public class DirectorDetailsWindow extends javax.swing.JFrame {

    /**
     * Creates new form ShowWindow
     */
    public DirectorDetailsWindow() {
        initComponents();
        setResizable(false);
        setTitle("Menu Series");
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
        jLabel_sexo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_nombre = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_nacionalidad = new javax.swing.JLabel();
        jLabel_lugarNac = new javax.swing.JLabel();
        jLabel_fechaNac = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_nominaciones = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_peliculas = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_premios = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_sexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 160, 20));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel7.setText("Nombre: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 120, 20));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel4.setText("Sexo: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 50, 20));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel5.setText("Fecha de nacimiento: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 170, 20));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel6.setText("Lugar de nacimiento: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 170, 20));

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel15.setText("Nacionalidad:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 110, 20));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel8.setText("Nominaciones: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 210, 20));

        jLabel_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 160, 20));

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel9.setText("Películas que ha dirigido: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 300, 20));

        jLabel_nacionalidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel_nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 160, 20));

        jLabel_lugarNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel_lugarNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 160, 20));

        jLabel_fechaNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jLabel_fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 160, 20));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea_nominaciones.setEditable(false);
        jTextArea_nominaciones.setColumns(20);
        jTextArea_nominaciones.setRows(5);
        jScrollPane4.setViewportView(jTextArea_nominaciones);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 270, 130));

        jScrollPane1.setViewportView(jList_peliculas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 270, 130));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea_premios.setEditable(false);
        jTextArea_premios.setColumns(20);
        jTextArea_premios.setRows(5);
        jScrollPane3.setViewportView(jTextArea_premios);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 250, 160));

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel10.setText("Premios: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 70, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoDegradadoVerdeVioleta.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(DirectorDetailsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DirectorDetailsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DirectorDetailsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DirectorDetailsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DirectorDetailsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabel_fechaNac;
    public javax.swing.JLabel jLabel_lugarNac;
    public javax.swing.JLabel jLabel_nacionalidad;
    public javax.swing.JLabel jLabel_nombre;
    public javax.swing.JLabel jLabel_sexo;
    public javax.swing.JList<String> jList_peliculas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTextArea jTextArea_nominaciones;
    public javax.swing.JTextArea jTextArea_premios;
    // End of variables declaration//GEN-END:variables
}
