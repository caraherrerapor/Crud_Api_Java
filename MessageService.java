
package mensajes_app;

import java.util.Scanner;


public class MessageService {
    
    public static void CreateMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Tu nombre");
        String nombre = sc.nextLine();
        
        Messages registro = new Messages();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        MensajeDao.CreateMessageDB(registro);
    }
    public static void listMessage(){
        MensajeDao.ReadMessageDB();
        
    }
    public static  void eraseMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige id a borrar");
        int id_mensaje = sc.nextInt();
        MensajeDao.EraserMessageDB(id_mensaje);
        
    }
    public  static void EditMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("id mensaje a editar");
        int id_mensaje = sc.nextInt();
        
        Messages actualizacion = new Messages();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajeDao.UpdateMessageDB(actualizacion);
        
        
    }
}
