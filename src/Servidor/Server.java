package Servidor;

import Servidor.Hilo_Server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryan
 */
public class Server {

    public static void main(String[] args) {
        final int PUERTO = 6666;
        ServerSocket socket_server = null; //server
        //socket
        Usuarios lista_usuarios = new Usuarios();
        int con = 0;
        Paquete_enviar paquete_recibido;

        try {
            socket_server = new ServerSocket(PUERTO);
            System.out.println("Server Connected");

            while (true) {
                Socket client_socket = socket_server.accept();

                ObjectInputStream in_paquete = new ObjectInputStream(client_socket.getInputStream());
                paquete_recibido = (Paquete_enviar) in_paquete.readObject();

                System.out.println("paquete recibido");

                System.out.println("ip : " + paquete_recibido.getIp() + " puerto : " + paquete_recibido.getPuerto()
                        + " nombre : " + paquete_recibido.getNombre() + " menaje : " + paquete_recibido.getMensaje());

                Usuarios usuario = new Usuarios(paquete_recibido.getNombre(),
                        paquete_recibido.getIp(), paquete_recibido.getPuerto());

                lista_usuarios.agregar(con, usuario);
                System.out.println("usuario agregado a la lista");

                Hilo_Server hilo = new Hilo_Server(client_socket, lista_usuarios, in_paquete); //,lista_usuarios
                hilo.start();
                con++;
            }

        } catch (Exception e) {
            System.out.println("Erro de server " + e);
        }

    }

}
