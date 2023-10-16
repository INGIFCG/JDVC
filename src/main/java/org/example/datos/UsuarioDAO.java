package org.example.datos;

import org.example.domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.datos.Conexion.close;
import static org.example.datos.Conexion.getconexion;

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT idusuario, name ,password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(name,password) VALUES(?,?)";
    private static final String SQL_ACTUALIZAR = "UPDATE prueba.usuario SET name = ?, password = ? WHERE (idusuario = ?)";
    private static final String SQL_ELIMINAR = "DELETE from usuario WHERE idusuario= ?";

    public List<Usuario> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> users = new ArrayList<>();
        try {
            con = getconexion();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idusuario = rs.getInt("idusuario");
                String name = rs.getString("name");
                String password = rs.getString("password");
                usuario = new Usuario(idusuario, name, password);
                users.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(stmt);
            close(con);
        }
        return users;
    }

    public int insertar(Usuario usuario) throws SQLException, RuntimeException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = getconexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getName());
            stmt.setString(2, usuario.getPassword());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(con);
        }
        return registros;
    }

    public void update(Usuario usuario) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexion.getconexion();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, usuario.getName());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIduser());
            stmt.executeUpdate();

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("e = " + e);
            e.getMessage();
        }

    }

    public void eliminar(int id) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = getconexion();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(con);
        }
    }
}
