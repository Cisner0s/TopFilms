/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.anadir;

import controller.anadir.AnadirSerieController;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author DCM
 */
public class AnadirSerieWindow extends javax.swing.JFrame {

    /**
     * Creates new form AñadirSerieWindow
     */
    public AnadirSerieWindow() {
        initComponents();
        setResizable(false);
        setTitle("Añadir Serie");
        setLocationRelativeTo(null);
        setIconImage(getIconImage());
        
        AnadirSerieController ctr = new AnadirSerieController(this);
        jButton_AñadirSerie.addActionListener(ctr);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jTextField_Titulo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField_NumEpisodios = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField_DuracionMedia = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField_NumTemporadas = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField_Presupuesto = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jTextField_Ganancias = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField_Genero = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField_NombreDirector = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField_NombreEstudio = new javax.swing.JTextField();
        jDateChooser_FechaEstreno = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton_AñadirSerie = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("OK");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Titulo");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jTextField_Titulo.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Titulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, -1));

        jLabel46.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Fecha Estreno");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel47.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Numero de Episodios");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jTextField_NumEpisodios.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_NumEpisodios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_NumEpisodios, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 180, -1));

        jLabel48.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Duracion media por Episodio");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jTextField_DuracionMedia.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_DuracionMedia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_DuracionMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 180, -1));

        jLabel49.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Numero de Temporadas");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jTextField_NumTemporadas.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_NumTemporadas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_NumTemporadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 180, -1));

        jLabel51.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Presupuesto");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));

        jTextField_Presupuesto.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Presupuesto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Presupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 180, -1));

        jLabel52.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Ganancias");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, -1));

        jTextField_Ganancias.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Ganancias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Ganancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 180, -1));

        jLabel50.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Género");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, -1, -1));

        jTextField_Genero.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_Genero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_Genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 180, -1));

        jLabel53.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Director ID");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, -1, -1));

        jTextField_NombreDirector.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_NombreDirector.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_NombreDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 180, -1));

        jLabel54.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Estudio ID");
        jPanel1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, -1, -1));

        jTextField_NombreEstudio.setBackground(new java.awt.Color(204, 153, 255));
        jTextField_NombreEstudio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField_NombreEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 180, -1));

        jDateChooser_FechaEstreno.setBackground(new java.awt.Color(204, 153, 255));
        jDateChooser_FechaEstreno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jDateChooser_FechaEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 180, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Añadir Serie");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jButton_AñadirSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_AñadirSerie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ir_1.png"))); // NOI18N
        jButton_AñadirSerie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_AñadirSerie.setBorderPainted(false);
        jButton_AñadirSerie.setContentAreaFilled(false);
        jPanel1.add(jButton_AñadirSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 180, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Negro_Trans_2.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 300, 690));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 400, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(AnadirSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirSerieWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirSerieWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton_AñadirSerie;
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
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField_DuracionMedia;
    public javax.swing.JTextField jTextField_Ganancias;
    public javax.swing.JTextField jTextField_Genero;
    public javax.swing.JTextField jTextField_NombreDirector;
    public javax.swing.JTextField jTextField_NombreEstudio;
    public javax.swing.JTextField jTextField_NumEpisodios;
    public javax.swing.JTextField jTextField_NumTemporadas;
    public javax.swing.JTextField jTextField_Presupuesto;
    public javax.swing.JTextField jTextField_Titulo;
    // End of variables declaration//GEN-END:variables
}
