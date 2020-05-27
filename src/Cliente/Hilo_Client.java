package Cliente;

import com.sun.source.doctree.SerialDataTree;
import com.sun.source.tree.Scope;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class Hilo_Client extends Thread {

    private ServerSocket servidor_cliente = null;
    //private Socket socket_cliente;
    private final Client ventana_cliente;
    private DataInputStream in;
    private String mensaje, nombre;
    private final int PUERTO = 6666;

    public Hilo_Client(Client ventana_cliente) {
        this.ventana_cliente = ventana_cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            System.out.println("Hilo cliente inicializado");
            servidor_cliente = new ServerSocket(PUERTO);
            Socket socket_cliente;

            while (true) {
                socket_cliente = servidor_cliente.accept();

                in = new DataInputStream(socket_cliente.getInputStream());
                nombre = in.readUTF();
                mensaje = in.readUTF();
                System.out.println("mensajes recibidos de hilo cliente");

                if (mensaje.equals("#")) {
                    break;
                }

                System.out.println(nombre + " >> " + mensaje);
                ventana_cliente.mostrar_mensaje(nombre, mensaje);
            }

            socket_cliente.close();

        } catch (IOException e) {
            System.out.println("Error en hilo ciente " + e);
        }

    }

}
