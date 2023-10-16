package org.example.datos;

import org.example.domain.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.datos.Conexion.close;
import static org.example.datos.Conexion.getconexion;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private static final String SQL_ACTUALIZAR = "UPDATE prueba.persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE (idpersona = ?)";
    private static final String SQL_ELIMINAR = "DELETE from persona WHERE idpersona = ?";

    public List<Persona> select() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        try {
            con = getconexion();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idpersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idpersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException, RuntimeException {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = getconexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(con);
        }
        return registros;
    }

    public void update(Persona persona) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = Conexion.getconexion();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdpersona());
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
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }
}
