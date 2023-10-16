package org.example.datos;

import java.sql.*;

public class Conexion {
    private static final String JDVC_URL="jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDVC_USER="root";
    private static final String JDVC_PASSWORD=null;

    public static Connection getconexion() throws SQLException {
        return DriverManager.getConnection(JDVC_URL,JDVC_USER,JDVC_PASSWORD);
    }
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
