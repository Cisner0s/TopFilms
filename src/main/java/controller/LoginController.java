package controller;

import dao.Conexion;
import dao.DAOException;
import dao.UsuarioDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.EstatusUsuarios;
import model.RolUsuarios;
import model.Usuario;
import view.AdminWindow;
import view.LoginWindow;
import view.RegisterWindow;
import view.UserWindow;

public class LoginController implements ActionListener, FocusListener, MouseListener {

    private final LoginWindow loginWindow;
    private final UsuarioDAO dao;
    boolean blockDuplicateWindow = false;
    boolean blockDuplicateRegister = false;

    public LoginController(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        this.dao = new UsuarioDAO(Conexion.conectar());
        loginWindow.jButton_Acceder.addActionListener(this);
        loginWindow.jLabel_Footer.addMouseListener(this);
        loginWindow.txt_user.addFocusListener(this);
        loginWindow.txt_password.addFocusListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (!blockDuplicateWindow) { // Verifica si no existe una instancia de AdminWindow
                loginAction();
            } 
        } catch (DAOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loginAction() throws DAOException {
        String nickName = loginWindow.getNickName();
        String password = loginWindow.getPassword();

        if (!"Nombre de usuario".equals(nickName) && !"Contraseña".equals(password)) {
            if (dao.login(nickName, password)) {
                Usuario user = dao.get(nickName);
                if (user.getEstatus() != EstatusUsuarios.INACTIVO) {
                    if (RolUsuarios.CRITICO == user.getRol() || RolUsuarios.USUARIO == user.getRol()) {
                        loginWindow.dispose();
                        new UserWindow(user).setVisible(true);
                        blockDuplicateWindow = true;
                    } else if (user.getRol() == RolUsuarios.ADMIN) {
                        loginWindow.dispose();
                        new AdminWindow().setVisible(true);
                        blockDuplicateWindow = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Su cuenta de usuario"
                            + " ha sido marcada como inactiva. Le recomendamos "
                            + "que se ponga en contacto con los administradores "
                            + "del sistema para solicitar que su cuenta sea reactivada.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == loginWindow.txt_user) {
            if (loginWindow.txt_user.getText().equals("Nombre de usuario") && loginWindow.txt_user.getForeground().equals(Color.gray)) {
                loginWindow.txt_user.setText("");
                loginWindow.txt_user.setForeground(Color.black);
            }
        } else if (e.getSource() == loginWindow.txt_password) {
            String pw = new String(loginWindow.txt_password.getPassword());
            if (pw.equals("Contraseña") && loginWindow.txt_password.getForeground().equals(Color.gray)) {
                loginWindow.txt_password.setText("");
                loginWindow.txt_password.setForeground(Color.black);
                loginWindow.txt_password.setEchoChar('*');
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == loginWindow.txt_user) {
            if (loginWindow.txt_user.getText().equals("")) {
                loginWindow.txt_user.setText("Nombre de usuario");
                loginWindow.txt_user.setForeground(Color.gray);
            }
        } else if (e.getSource() == loginWindow.txt_password) {
            String pw = new String(loginWindow.txt_password.getPassword());
            if (pw.equals("")) {
                loginWindow.txt_password.setEchoChar((char) 0);
                loginWindow.txt_password.setText("Contraseña");
                loginWindow.txt_password.setForeground(Color.gray);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!blockDuplicateRegister) {
            loginWindow.dispose();
            new RegisterWindow().setVisible(true);
            blockDuplicateRegister = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        loginWindow.jLabel_Footer.setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        loginWindow.jLabel_Footer.setForeground(Color.BLACK);
    }
}
