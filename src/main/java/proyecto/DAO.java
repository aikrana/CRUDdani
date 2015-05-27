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

            stmt.executeUpdate();

            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            System.out.println("ERROR de SQL o clase en DAO.BorrarLibro");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL en DAO.BorrarLibro");
        }
    }

    public static ArrayList<Libro> ListarLibros() {

        final ArrayList<Libro> libros = new ArrayList<>();
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
            }

            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR de SQL o clase en DAO.ListarLibros");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL en DAO.ListarLibros");
        }
        return libros;
    }

    public static ArrayList<ArrayList<Libro>> ListarLibros(int filas) {

        final ArrayList<ArrayList<Libro>> paginas  = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            stmt = con.prepareStatement("select * from libros order by titulo");
            rs = stmt.executeQuery();
            
            
            
            if (rs.first()) {
                rs.beforeFirst();
                for (int p=0; !rs.isLast(); p++){
                    paginas.add(new ArrayList<Libro>());
                    int f = 0;
                    
                    while(f < filas && !rs.isLast()) {                        
                        rs.next();
                        paginas.get(p).add(new Libro(
                                rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5)
                        ));
                        f++;
                    }
                    
                }
            }

            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR de SQL o clase en DAO.ListarLibros");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL en DAO.ListarLibros");
        }
        return paginas;
    }

    public static Libro BuscarLibro(int id) {
        Libro libro = null;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;
            ResultSet rs = null;

            stmt = con.prepareStatement("select * from libros where id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.first()) {
                libro = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            conexion.CerrarConexion(con);

        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            System.out.println("ERROR de SQL o clase en DAO.BuscarLibro");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL en DAO.BuscarLibro");
        }
        return libro;

    }

    public static void ActualizarLibro(Libro libro) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;
            stmt = con.prepareStatement("update libros set titulo = ?, autor = ?, editorial = ?, isbn = ? where id = ?");
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getEditorial());
            stmt.setString(4, libro.getIsbn());
            stmt.setInt(5, libro.getId());
            stmt.executeUpdate();
            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            System.out.println("ERROR de SQL o clase en DAO.ActualizarLibro");
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL en DAO.ActualizarLibro");
        }
    }
}
