package Servidor;

/**
 *
 * @author Bryan
 */
public class Usuarios {

    private String ip;
    private String nombre;
    private int puerto;
    private Usuarios lista_usuarios[] = new Usuarios[10];

    public Usuarios(String nombre, String ip, int puerto) {
        this.nombre = nombre;
        this.ip = ip;
        this.puerto = puerto;
    }

    public Usuarios() {
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuarios[] getLista_usuarios() {
        return lista_usuarios;
    }

    public void setLista_usuarios(Usuarios[] lista_usuarios) {
        this.lista_usuarios = lista_usuarios;
    }

    public void agregar(int index, Usuarios usuario) {
        //System.out.println(index);
        //System.out.println(usuario);
        lista_usuarios[index] = usuario;
    }

    public Usuarios obtener_usuario(int index) {
        return lista_usuarios[index];
    }

    public String obtener_nombre(int index) {
        return lista_usuarios[index].getNombre();
    }

}
