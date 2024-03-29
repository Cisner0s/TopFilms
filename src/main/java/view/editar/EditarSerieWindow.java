/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.editar;

import controller.editar.EditarSerieController;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author DCM
 */
public class EditarSerieWindow extends javax.swing.JFrame {

    /**
     * Creates new form EditarSerieWindow
     */
    public EditarSerieWindow() {
        initComponents();
        setResizable(false);
        setTitle("Editar Serie.");
        setLocationRelativeTo(null); 
        setIconImage(getIconImage());
        
        EditarSerieController ctrl = new EditarSerieController(this);
        jButton_Buscar.addActionListener(ctrl);
        jButton_Editar.addActionListener(ctrl);
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
        jTextField_Titulo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField_NumEpisodios = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField_DuracionMedia = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField_NumTemp = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField_Presupuesto = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jTextField_Ganancias = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField_Imagen = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField_DirectorID = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField_EstudioID = new javax.swing.JTextField();
        jDateChooser_FechaEstreno = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton_Buscar = new javax.swing.JButton();
        jTextField_BuscarID = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jButton_Editar = new javax.swing.JButton();
        jTextField_Genero = new javax.swing.JTextField();
        jLabel_Genero = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Titulo");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jTextField_Titulo.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Titulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 180, -1));

        jLabel46.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Fecha Estreno");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabel47.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Numero de Episodios");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        jTextField_NumEpisodios.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_NumEpisodios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_NumEpisodios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 180, -1));

        jLabel48.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Duracion media por Episodio");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        jTextField_DuracionMedia.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_DuracionMedia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_DuracionMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 180, -1));

        jLabel49.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Numero de Temporadas");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        jTextField_NumTemp.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_NumTemp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_NumTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 180, -1));

        jLabel51.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Presupuesto");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));

        jTextField_Presupuesto.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Presupuesto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Presupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 180, -1));

        jLabel52.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Ganancias");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        jTextField_Ganancias.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Ganancias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Ganancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 180, -1));

        jLabel50.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Imagen");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, -1, -1));

        jTextField_Imagen.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Imagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 180, -1));

        jLabel53.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Director ID");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, -1, -1));

        jTextField_DirectorID.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_DirectorID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_DirectorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, 180, -1));

        jLabel54.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Estudio ID");
        jPanel1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, -1, -1));

        jTextField_EstudioID.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_EstudioID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_EstudioID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 180, -1));

        jDateChooser_FechaEstreno.setBackground(new java.awt.Color(204, 153, 255));
        jDateChooser_FechaEstreno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jDateChooser_FechaEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 180, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar Serie");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jButton_Buscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ir_1.png"))); // NOI18N
        jButton_Buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Buscar.setBorderPainted(false);
        jButton_Buscar.setContentAreaFilled(false);
        jPanel1.add(jButton_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 180, 70));

        jTextField_BuscarID.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_BuscarID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_BuscarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 180, -1));

        jLabel55.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Serie_ID");
        jPanel1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jButton_Editar.setBackground(new java.awt.Color(255, 153, 0));
        jButton_Editar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Editar.setText("EDITAR");
        jButton_Editar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, 180, -1));

        jTextField_Genero.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Genero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 180, -1));

        jLabel_Genero.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel_Genero.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Genero.setText("Genero");
        jPanel1.add(jLabel_Genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Negro_Trans_2.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 490, 650));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 600, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(EditarSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarSerieWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Buscar;
    public javax.swing.JButton jButton_Editar;
    public com.toedter.calendar.JDateChooser jDateChooser_FechaEstreno;
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
    private javax.swing.JLabel jLabel_Genero;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField_BuscarID;
    public javax.swing.JTextField jTextField_DirectorID;
    public javax.swing.JTextField jTextField_DuracionMedia;
    public javax.swing.JTextField jTextField_EstudioID;
    public javax.swing.JTextField jTextField_Ganancias;
    public javax.swing.JTextField jTextField_Genero;
    public javax.swing.JTextField jTextField_Imagen;
    public javax.swing.JTextField jTextField_NumEpisodios;
    public javax.swing.JTextField jTextField_NumTemp;
    public javax.swing.JTextField jTextField_Presupuesto;
    public javax.swing.JTextField jTextField_Titulo;
    // End of variables declaration//GEN-END:variables
}
