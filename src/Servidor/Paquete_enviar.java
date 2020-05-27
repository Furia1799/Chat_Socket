/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.Serializable;

/**
 *
 * @author Bryan
 */
public class Paquete_enviar implements Serializable{
    
    private String ip;
    private int puerto;
    private String nombre;
    private String mensaje;

    public Paquete_enviar(String ip, int puerto, String nombre, String mensaje) {
        this.ip = ip;
        this.puerto = puerto;
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    public Paquete_enviar() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
