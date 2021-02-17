/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.*;

/**
 *
 * @author lagra
 */
public class Conexion {
    public Connection get_connection() /*throws ClassNotFoundException{*/{
        Connection connection = null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","toor");
            /*
            if (connection != null) {
                System.out.println("conexion exitosa");
                
            }
            
            */
            
            
        }catch(SQLException e){
            System.out.println(e);
            
        }
        return connection;
        
    }
    
}
