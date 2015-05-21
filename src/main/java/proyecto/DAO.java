package proyecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidad.Contacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumnomati
 */
public class DAO {

    public static void InsertarContacto(Contacto contacto) throws Exception {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO contactos values(?,?,?,?,?,?)");
            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getTelefono());
            stmt.setString(3, contacto.getDireccion());
            stmt.setString(4, contacto.getPoblacion());
            stmt.setString(5, contacto.getProvincia());
            stmt.setString(6, contacto.getFechaCumple());

            stmt.executeUpdate();
            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
    }

    public static void InsertarContactos(List<Contacto> contactos) throws Exception {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            PreparedStatement stmt;

            for (Contacto contacto : contactos) {

                stmt = con.prepareStatement("INSERT INTO contactos values(?,?,?,?,?,?)");
                //, Statement.RETURN_GENERATED_KEYS);

                stmt.setString(1, contacto.getNombre());
                stmt.setString(2, contacto.getTelefono());
                stmt.setString(3, contacto.getDireccion());
                stmt.setString(4, contacto.getPoblacion());
                stmt.setString(5, contacto.getProvincia());
                stmt.setString(6, contacto.getFechaCumple());

                stmt.executeUpdate();
            }
            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {//SQLException y ClassNotFoundException
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        } catch (Exception ex) {
            System.err.println("Excepcion ->++++++" + ex.getMessage());

        }
    }

    public static void BorrarContacto(String nom) {
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

    public static void ListarContactos() throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            stmt = con.prepareStatement("select * from contactos order by nombre");
            rs = stmt.executeQuery();

            ListarResult(rs);

            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
    }

    public static void Buscar(String campo, String valor) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.AbrirConexion();
            stmt = con.prepareStatement("select * from contactos where " + campo + " like '%" + valor + "%' order by " + campo);
            rs = stmt.executeQuery();

            ListarResult(rs);

            conexion.CerrarConexion(con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
            } catch (Exception ex) {
            }
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
    }

    public static void ListarResult(ResultSet rs) throws Exception {
        try {
            if (rs.first()) {
                rs.beforeFirst();
                System.out.println("\n\n");
                System.out.println("Nombre" + tabula("Nombre", 20) + "Telefono" + tabula("Telefono", 15) + "Direccion" + tabula("Direccion", 25) + "Poblacion" + tabula("Poblacion", 15) + "Provincia" + tabula("Provincia", 15) + "Cumpleaños");
                System.out.println("======" + tabula("======", 20) + "========" + tabula("========", 15) + "=========" + tabula("Direccion", 25) + "=========" + tabula("Poblacion", 15) + "=========" + tabula("Provincia", 15) + "==========");

                while (rs.next()) {
                    System.out.println(rs.getString(1) + tabula(rs.getString(1), 20) + rs.getString(2) + tabula(rs.getString(2), 15) + rs.getString(3) + tabula(rs.getString(3), 25) + rs.getString(4) + tabula(rs.getString(4), 15) + rs.getString(5) + tabula(rs.getString(5), 15) + rs.getString(6));
                }

                System.out.println("\n");

            } else {
                System.out.println("\nNo hay contactos a mostrar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL");
        }
    }

    //TABULADORES
    static String tabula(String cadena, int numesp) {
        String espacios = "";
        numesp -= cadena.length();

        for (int i = 0; i < numesp; i++) {
            espacios += " ";
        }
        return espacios;
    }

    static String tabula(int numesp) {
        String espacios = "";

        for (int i = 0; i < numesp; i++) {
            espacios += " ";
        }
        return espacios;
    }

}
