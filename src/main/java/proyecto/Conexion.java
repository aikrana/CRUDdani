/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.Connection;
import java.sql.SQLException;


public class Conexion {
     
    public Connection AbrirConexion() throws Exception{
    
    Connection con; 
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Carga el driver
            String urlOdbc = "jdbc:mysql://localhost/libros";
            con=(java.sql.DriverManager.getConnection(urlOdbc, "root", "root")); // crea una conexion
            //System.out.println("Conexion realizada");
            return con;
        } catch(ClassNotFoundException | SQLException e){//SQLException y ClassNotFoundException
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion"+e.getMessage());
        } 
    
      
    }
    public void CerrarConexion(Connection con) throws Exception
    {
            try {
                if(con!=null ) con.close();
            }catch (Exception e){  throw new Exception("Ha sido imposible establecer la conexion desde DataSource"+e.getMessage());
             }
    }
}
