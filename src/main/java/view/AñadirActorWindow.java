/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author DCM
 */
public class AñadirActorWindow extends javax.swing.JFrame {

    /**
     * Creates new form AñadirActorWindow
     */
    public AñadirActorWindow() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setText("Titulo");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));
        jPanel1.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel46.setText("Fecha Estreno");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jLabel47.setText("Numero de Episodios");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));
        jPanel1.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jLabel48.setText("Duracion media por Episodio");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));
        jPanel1.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jLabel49.setText("Numero de Temporadas");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));
        jPanel1.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jLabel51.setText("Presupuesto");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, -1));
        jPanel1.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jLabel52.setText("Ganancias");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));
        jPanel1.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        jLabel50.setText("Imagen");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, -1));
        jPanel1.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, -1, -1));

        jLabel53.setText("Nombre Director");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, -1, -1));
        jPanel1.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, -1, -1));

        jLabel54.setText("Nombre Estudio");
        jPanel1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, -1, -1));
        jPanel1.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, -1, -1));

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
            java.util.logging.Logger.getLogger(AñadirActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirActorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirActorWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField21;
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
