package Reto5;

public class Tutor extends Usuario {
    
    private Alumno alumno;

    public Tutor(Alumno alumno, int id, String nombre, String apellido, String correo) {
        super(id, nombre, apellido, correo);
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    public String getNombre() {
        return super.nombre;
    }

    public String getApellido() {
        return super.apellido;
    }
    
    public void mostrarCalificacion() {
        System.out.println("Nombre del estudiante: " + alumno.getNombre() + " " + alumno.getApellido() + "\nCalificacion: " + alumno.getCalificacion() + "\n");
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCorreo electrónico: " + correo + "\n");
        System.out.println("Datos del alumno asignado:");
        alumno.mostrarPerfil();
    }
}
