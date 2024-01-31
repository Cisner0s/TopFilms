package dao;

import java.sql.*;

public class Conexion {
    // Conexión Local
    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://db-inso-do-user-15730192-0.c.db.ondigitalocean.com:25060/topfilms";
            String usuario = "doadmin";
            String contraseña = "AVNS_UVPIJd_Aw8gJZd-Bxed";
            
            Connection cn = DriverManager.getConnection(url, usuario, contraseña);
            return cn;
            
        } catch (SQLException e) {
            System.out.println("Error en conexión remota " + e);
        }
        return (null);
    }
}
