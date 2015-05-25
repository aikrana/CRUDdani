package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumnomati
 */
public class DAO {

    public static void InsertarLibro(Libro libro) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO libros values(0,?,?,?,?)");
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getEditorial());
            stmt.setString(4, libro.getIsbn());
            stmt.executeUpdate();
            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            System.out.println("ERROR de SQL o clase en DAO.InsertarLibro");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
    }

    public static void BorrarLibro(int id) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;
            stmt = con.prepareStatement("delete from libros where id = ?");
            stmt.setInt(1, id);

            int num = stmt.executeUpdate();
            /*if (num == 0) {
             System.out.println("No se encontró el contacto\n");
             } else if (num == 1) {
             System.out.println("Contacto eliminado correctamente\n");
             }*/
            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            System.out.println("ERROR de SQL o clase en DAO.BorrarLibro");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL en DAO.BorrarLibro");
        }
    }

    public static List<Libro> ListarLibros() {

        final List<Libro> libros = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            stmt = con.prepareStatement("select * from libros");
            rs = stmt.executeQuery();

            if (rs.first()) {

                rs.beforeFirst();
                while (rs.next()) {
                    libros.add(new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                }
            } else {
//                System.out.println("\nNo hay libros a mostrar");
            }

            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR de SQL o clase en DAO.ListarLibros");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL en DAO.ListarLibros");
        }
        return libros;
    }

}
