package dao;

import java.sql.*;

public class Conexion {
    // Conexión Local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection(
                    "jdbc:db-inso-do-user-15730192-0.c.db.ondigitalocean.com:25060/topfilms", "doadmin",
                    "AVNS_UVPIJd_Aw8gJZd-Bxed");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión local " + e);
        }
        return (null);
    }
}
