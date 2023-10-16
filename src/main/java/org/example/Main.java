package org.example;

import org.example.datos.UsuarioDAO;
import org.example.domain.Usuario;

import java.sql.*;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        Usuario usuario1 = new Usuario(5,"DEV", "LACLAVELOCA");
        Usuario usuario2 = new Usuario("alpaca", "12354123");
//        int nuevainsersion = usuarioDao.insertar(usuario1);
//        int nuevainsersion1 = usuarioDao.insertar(usuario2);
//        usuarioDao.eliminar(2);
//        usuarioDao.eliminar(4);
        usuarioDao.update(usuario1);
        List<Usuario> usuarios = usuarioDao.select();
        for (Usuario usuario : usuarios) {
            System.out.println("usuario = " + usuario);
        }
//        Usuario usuario = new Usuario("Carlos", "12345");
//        Usuario usuario1 = new Usuario("Luis", "12341");
//        Usuario usuario2 = new Usuario("Jose", "541234");
//        Usuario usuario3 = new Usuario("Pedro", "asdf");
//        Usuario usuario4 = new Usuario("Mario", "ghasdga");
//        int var1 = usuarioDao.insertar(usuario);
//        int var2 = usuarioDao.insertar(usuario1);
//        int var3 = usuarioDao.insertar(usuario2);
//        int var4 = usuarioDao.insertar(usuario3);
//        int var5 = usuarioDao.insertar(usuario4);
//
//        System.out.println("var5 = " + var5);
//        PersonaDAO personaDAO = new PersonaDAO();
////        Persona nuevapersona = new Persona(1,"123", "12314", "1231231@.com", "12313");
//        personaDAO.eliminar(2);
//        List<Persona> personas = personaDAO.select();
//        for (Persona persona : personas) {
//            System.out.println("persona = " + persona);
//        }
//        String url = "jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//        try {
//            //apps webs
//            //Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conexion = DriverManager.getConnection(url,"root",null);
//            Statement intruccion = conexion.createStatement();
//            var sql = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
//            ResultSet resultado =  intruccion.executeQuery(sql);
//            while(resultado.next()){
//                System.out.print("id persona : " + resultado.getInt("idpersona"));
//                System.out.print(" nombre : " + resultado.getString("nombre"));
//                System.out.print(" apellido : " + resultado.getString("apellido"));
//                System.out.print(" email: " + resultado.getString("email"));
//                System.out.print(" telefono : " + resultado.getString("telefono"));
//                System.out.println("");
//            }
//            resultado.close();
//            intruccion.close();
//            conexion.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}