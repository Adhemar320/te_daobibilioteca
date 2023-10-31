
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionBD {
    static public String driver ="com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    static public String usuario ="root";
    static public String password ="mysql";
    
    protected Connection conn= null;

    public ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver"+ ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al realizar la conexion "+ ex.getMessage());
        }
    }
    public Connection conectar(){
        return conn ;
    }
     public Connection desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerra la conexion"+ ex.getMessage());
        }
        return null;
        
     }
    
}

