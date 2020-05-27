package Servidor;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
public class Hilo_Server extends Thread {

    private Socket socket_cliente;
    private Usuarios usuario = null;
    ObjectInputStream in_paquete;

    public Hilo_Server(Socket cliente, Usuarios usuario, ObjectInputStream in_paquete) { //Usuarios usuario
        this.socket_cliente = cliente;
        this.usuario = usuario;
        this.in_paquete = in_paquete;

    }

    @Override
    public void run() {
        System.out.println("Hilo comenzo servidor");

        try {

            ObjectOutputStream out_paquete;
            Paquete_enviar datos_recibidos;

            while (true) {

                datos_recibidos = (Paquete_enviar) in_paquete.readObject();

                String direcion = datos_recibidos.getIp();
                System.out.println("direccion" + direcion);

                System.out.println("paquete recibido del hilo servidor");
                System.out.println(datos_recibidos.getNombre() + " >>> " + datos_recibidos.getMensaje());

                if (datos_recibidos.getMensaje().equals("#")) {
                    break;
                }

                for (int i = 0; i < usuario.getLista_usuarios().length; i++) {

                    if (usuario.obtener_usuario(i) == null) {
                        break;
                    }
                    Socket enviar_destino = new Socket(usuario.obtener_usuario(i).getIp(), 
                            usuario.obtener_usuario(i).getPuerto());
                    out_paquete = new ObjectOutputStream(enviar_destino.getOutputStream());

                    out_paquete.writeObject(datos_recibidos);

                    System.out.println("menajes enviados a " + usuario.obtener_usuario(i).getNombre());
                    enviar_destino.close();

                }

                System.out.println("------------------------------------");
            }
            in_paquete.close();
            socket_cliente.close();

        } catch (Exception e) {
            System.out.println("perdio conexion con cliente " + e.toString());
        }
        System.out.println("Se a desconectado el cliente");

    }

}
