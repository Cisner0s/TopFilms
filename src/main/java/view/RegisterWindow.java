/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


/**
 *
 * @author DCM
 */
public class RegisterWindow extends javax.swing.JFrame {

    private JTextField textFieldNombre;
    private JTextField textFieldApellidos;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JComboBox<String> comboBoxRoles;
    private JButton btnRegistrar;
    
    /**
     * Creates new form RegisterWindow
     */
    public RegisterWindow() {
      setTitle("Registro de Usuario");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con diseño de cuadrícula
        JPanel panelPrincipal = new JPanel(new GridLayout(6, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Etiquetas y campos de texto
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblApellidos = new JLabel("Apellidos:");
        JLabel lblUsuario = new JLabel("Usuario:");
        JLabel lblContraseña = new JLabel("Contraseña:");
        JLabel lblRol = new JLabel("Rol:");

        textFieldNombre = new JTextField();
        textFieldApellidos = new JTextField();
        textFieldUsuario = new JTextField();
        passwordField = new JPasswordField();

        // ComboBox para seleccionar el rol
        String[] roles = {"Administrador", "Crítico", "Usuario"};
        comboBoxRoles = new JComboBox<>(roles);
        comboBoxRoles.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Habilitar o deshabilitar la contraseña según el rol seleccionado
                boolean passwordEnabled = comboBoxRoles.getSelectedItem().equals("Administrador") ||
                                          comboBoxRoles.getSelectedItem().equals("Usuario");
                passwordField.setEnabled(passwordEnabled);
            }
        });

        // Botón de registro
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener valores de los campos
                String nombre = textFieldNombre.getText();
                String apellidos = textFieldApellidos.getText();
                String usuario = textFieldUsuario.getText();
                String rol = (String) comboBoxRoles.getSelectedItem();
                char[] contraseña = passwordField.getPassword();

                // Agregar lógica de registro aquí

                // Mostrar un mensaje de éxito
                String mensaje = "¡Usuario registrado!\nNombre: " + nombre +
                                 "\nApellidos: " + apellidos +
                                 "\nUsuario: " + usuario +
                                 "\nRol: " + rol;
                JOptionPane.showMessageDialog(RegisterWindow.this, mensaje);

                // Limpiar campos después del registro (puedes ajustar esto según tus necesidades)
                textFieldNombre.setText("");
                textFieldApellidos.setText("");
                textFieldUsuario.setText("");
                passwordField.setText("");
            }
        });

        // Añadir componentes al panel
        panelPrincipal.add(lblNombre);
        panelPrincipal.add(textFieldNombre);
        panelPrincipal.add(lblApellidos);
        panelPrincipal.add(textFieldApellidos);
        panelPrincipal.add(lblUsuario);
        panelPrincipal.add(textFieldUsuario);
        panelPrincipal.add(lblContraseña);
        panelPrincipal.add(passwordField);
        panelPrincipal.add(lblRol);
        panelPrincipal.add(comboBoxRoles);
        panelPrincipal.add(new JLabel()); // Espaciador
        panelPrincipal.add(btnRegistrar);

        // Configurar colores
        panelPrincipal.setBackground(Color.WHITE);
        lblNombre.setForeground(Color.BLACK);
        lblApellidos.setForeground(Color.BLACK);
        lblUsuario.setForeground(Color.BLACK);
        lblContraseña.setForeground(Color.BLACK);
        lblRol.setForeground(Color.BLACK);
        btnRegistrar.setBackground(Color.GRAY);
        btnRegistrar.setForeground(Color.WHITE);

        // Configurar fuente
        Font font = new Font("Arial", Font.PLAIN, 14);
        lblNombre.setFont(font);
        lblApellidos.setFont(font);
        lblUsuario.setFont(font);
        lblContraseña.setFont(font);
        lblRol.setFont(font);
        textFieldNombre.setFont(font);
        textFieldApellidos.setFont(font);
        textFieldUsuario.setFont(font);
        passwordField.setFont(font);
        comboBoxRoles.setFont(font);
        btnRegistrar.setFont(font);

        // Agregar panel al contenido
        getContentPane().add(panelPrincipal);

        // Hacer visible la ventana
        setVisible(true);
//initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
