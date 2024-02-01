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
public class GestionContenidoWindow extends javax.swing.JFrame {

    /**
     * Creates new form AñadirContenidoWindow
     */
    public GestionContenidoWindow() {
        initComponents();
        setResizable(false);
        setTitle("Gestion de Contenido");
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

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox_Editar = new javax.swing.JCheckBox();
        jCheckBox_Anadir = new javax.swing.JCheckBox();
        jCheckBox_Borrar = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Pelicula", "Serie", "Actor", "Director", "Estudio" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 290, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione el tipo de contenido");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jCheckBox_Editar.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jCheckBox_Editar.setText("Editar");
        jCheckBox_Editar.setEnabled(false);
        jCheckBox_Editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_EditarMouseClicked(evt);
            }
        });
        jPanel2.add(jCheckBox_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        jCheckBox_Anadir.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jCheckBox_Anadir.setText("Añadir");
        jCheckBox_Anadir.setEnabled(false);
        jCheckBox_Anadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_AnadirMouseClicked(evt);
            }
        });
        jPanel2.add(jCheckBox_Anadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, 20));

        jCheckBox_Borrar.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jCheckBox_Borrar.setText("Borrar");
        jCheckBox_Borrar.setEnabled(false);
        jCheckBox_Borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_BorrarMouseClicked(evt);
            }
        });
        jPanel2.add(jCheckBox_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jButton1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        jButton1.setText("OK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 150, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photo-1557683311-eac922347aa1.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 520, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedAction = (String) jComboBox1.getSelectedItem();
        if(null != selectedAction)switch (selectedAction) {
            case "..." -> {
                jCheckBox_Anadir.setEnabled(false);
                jCheckBox_Editar.setEnabled(false);
                jCheckBox_Borrar.setEnabled(false);
            }
            case "Pelicula" -> {
                jCheckBox_Anadir.setEnabled(true);
                jCheckBox_Editar.setEnabled(true);
                jCheckBox_Borrar.setEnabled(true);
            }
            case "Serie" -> {
                jCheckBox_Anadir.setEnabled(true);
                jCheckBox_Editar.setEnabled(true);
                jCheckBox_Borrar.setEnabled(true);
            }
            case "Actor" -> {
                jCheckBox_Anadir.setEnabled(true);
                jCheckBox_Editar.setEnabled(true);
                jCheckBox_Borrar.setEnabled(true);
            }
            case "Director" -> {
                jCheckBox_Anadir.setEnabled(true);
                jCheckBox_Editar.setEnabled(true);
                jCheckBox_Borrar.setEnabled(true);
            }
            case "Estudio" -> {
                jCheckBox_Anadir.setEnabled(true);
                jCheckBox_Editar.setEnabled(true);
                jCheckBox_Borrar.setEnabled(true);
            }
            default -> {
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBox_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_EditarMouseClicked
        if(!jCheckBox_Editar.isEnabled()){
            
        } else if(jCheckBox_Editar.isSelected() && jCheckBox_Editar.isEnabled()){
            jCheckBox_Anadir.setEnabled(false);
            jCheckBox_Borrar.setEnabled(false);
        } else if(!jCheckBox_Editar.isSelected()){
            jCheckBox_Anadir.setEnabled(true);
            jCheckBox_Borrar.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox_EditarMouseClicked

    private void jCheckBox_AnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_AnadirMouseClicked
        if(!jCheckBox_Anadir.isEnabled()){
            
        } else if(jCheckBox_Anadir.isSelected() && jCheckBox_Anadir.isEnabled()){
            jCheckBox_Editar.setEnabled(false);
            jCheckBox_Borrar.setEnabled(false);
        } else if(!jCheckBox_Anadir.isSelected()){
            jCheckBox_Editar.setEnabled(true);
            jCheckBox_Borrar.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox_AnadirMouseClicked

    private void jCheckBox_BorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_BorrarMouseClicked
        if(!jCheckBox_Borrar.isEnabled()){
            
        } else if(jCheckBox_Borrar.isSelected() && jCheckBox_Borrar.isEnabled()){
            jCheckBox_Editar.setEnabled(false);
            jCheckBox_Anadir.setEnabled(false);
        } else if(!jCheckBox_Borrar.isSelected()){
            jCheckBox_Editar.setEnabled(true);
            jCheckBox_Anadir.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox_BorrarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String selectedAction = (String) jComboBox1.getSelectedItem();
        int accion; // 0 = Añadir | 1 = Editar | 2 = Borrar | 3 = No seleccionado
        
        if(jCheckBox_Anadir.isEnabled()){
            accion = 0;
        } else if(jCheckBox_Editar.isEnabled()){
            accion = 1;
        } else if(jCheckBox_Borrar.isEnabled()){
            accion = 2;
        } else {
            accion = 3;
        }
        
        if(null != selectedAction)switch (selectedAction) {
            case "..." -> {
                
            }
            case "Pelicula" -> {
                if(accion == 0){
                    dispose();
                    new AnadirPeliculaWindow().setVisible(true);
                } else if (accion == 1){
                    dispose();
                    new EditarPeliculaWindow().setVisible(true);
                } else if (accion == 2){
                    dispose();
                    new BorrarPeliculaWindow().setVisible(true);
                }
            }
            case "Serie" -> {
                if(accion == 0){
                    dispose();
                    new AnadirSerieWindow().setVisible(true);
                } else if (accion == 1){
                    dispose();
                    new EditarSerieWindow().setVisible(true);
                } else if (accion == 2){
                    dispose();
                    new BorrarSerieWindow().setVisible(true);
                }
            }
            case "Actor" -> {
                if(accion == 0){
                    dispose();
                    new AnadirActorWindow().setVisible(true);
                } else if (accion == 1){
                    dispose();
                    new EditarActorWindow().setVisible(true);
                } else if (accion == 2){
                    dispose();
                    new BorrarActorWindow().setVisible(true);
                }
            }
            case "Director" -> {
                if(accion == 0){
                    dispose();
                    new AnadirDirectorWindow().setVisible(true);
                } else if (accion == 1){
                    dispose();
                    new EditarDirectorWindow().setVisible(true);
                } else if (accion == 2){
                    dispose();
                    new BorrarDirectorWindow().setVisible(true);
                }
            }
            case "Estudio" -> {
                if(accion == 0){
                    dispose();
                    new AnadirEstudioWindow().setVisible(true);
                } else if (accion == 1){
                    dispose();
                    new EditarEstudioWindow().setVisible(true);
                } else if (accion == 2){
                    dispose();
                    new BorrarEstudioWindow().setVisible(true);
                }
            }
            default -> {
            }}
        
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(GestionContenidoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionContenidoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionContenidoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionContenidoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionContenidoWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox_Anadir;
    private javax.swing.JCheckBox jCheckBox_Borrar;
    private javax.swing.JCheckBox jCheckBox_Editar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
