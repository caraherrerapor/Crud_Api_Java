package mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // se crea el menu del usuario
        int option = 0;

        do { 
            System.out.println("--------------------");
            System.out.println("Aplicacion de mensaje");
            System.out.println("1° Crear mensaje");
            System.out.println("2° Listar mensaje");
            System.out.println("3° Borrar mensaje");
            System.out.println("4° Editar mensaje");
            System.out.println("5° Salir");
            
            // lee la opcion del usarion
            
            option = sc.nextInt();
            
            switch(option){
                
                /*
                en cada uno de los casos se crea
                instancias de la clase MessageService
                
                */
                case 1:
                    MessageService.CreateMessage();
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.eraseMessage();
                    break;
                case 4:
                    MessageService.EditMessage();
                    break;
                default:
                    break;
            }

        } while (option != 5);

        

        /*
        Conexion conexion = new Conexion();
        try (Connection cnx = conexion.get_connection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
        
        */

    }

}
