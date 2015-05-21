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

    public static void InsertarLibro(Libro libro) throws Exception {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO contactos values(?,?,?,?,?,?)");
            /*            stmt.setString(1, contacto.getNombre());
             stmt.setString(2, contacto.getTelefono());
             stmt.setString(3, contacto.getDireccion());
             stmt.setString(4, contacto.getPoblacion());
             stmt.setString(5, contacto.getProvincia());
             stmt.setString(6, contacto.getFechaCumple());*/
            stmt.executeUpdate();
            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
    }

    public static void BorrarLibro(String nom) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;
            stmt = con.prepareStatement("delete from contactos where nombre = ?");
            stmt.setString(1, nom);

            int num = stmt.executeUpdate();

            if (num == 0) {
                System.out.println("No se encontró el contacto\n");
            } else if (num == 1) {
                System.out.println("Contacto eliminado correctamente\n");
            } else if (num > 1) {
                System.out.println(num + " contactos eliminados\n");
            }

            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            e.printStackTrace();
            try {
                throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
            } catch (Exception ex) {
            }
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
    }

    public static List<Libro> ListarLibros() throws Exception {

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
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
        return libros;
    }

}
