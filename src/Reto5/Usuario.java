package Reto5;

public abstract class Usuario implements Perfil {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String correo;

    public Usuario(int id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
    
    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarPerfil() {
        System.out.println("ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCorreo electrónico: " + correo + "\n");
    }
}