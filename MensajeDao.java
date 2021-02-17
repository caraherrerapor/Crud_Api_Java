package mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDao {

    // este es el corazon del crud
    public static void CreateMessageDB(Messages mensaje) {
        Conexion db_connect = new Conexion();

        /*
         El  objeto db_connect usa el metodo get_connection
         de la clase conexion
         */
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje,autor_mensaje) VALUES(?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void ReadMessageDB() {

        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = db_connect.get_connection()) {

            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID" + rs.getInt("id_mensaje"));
                System.out.println("Mensaje" + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");

            }

        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar mensajes");
            System.out.println(e);
        }
    }

    public static void EraserMessageDB(int id_mensaje) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM  mensajes WHERE id_mensaje = ?";
                ps= conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje fue borrdo");
                
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo borrar mensajes");
                

            }

        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    public static void UpdateMessageDB(Messages mensaje) {
        /*
        instancio un objeto db_connect de la clase Conexion
        que conecta la db
        */
        Conexion db_connect = new Conexion();
         PreparedStatement ps = null;
        try(Connection conexion = db_connect.get_connection()){
           
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje =?";
                ps= conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se actualizo correctamente");
                
                
                
            }catch(SQLException ex){
                
                System.out.println(ex);
                System.out.println("No se puedo actualizar el mensaje");
            }
            
            
            
        }catch(SQLException e) {
            System.out.println(e);
            
        }
        
        

    }

}
