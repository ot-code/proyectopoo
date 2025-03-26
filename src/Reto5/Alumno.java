package Reto5;

public class Alumno extends Usuario {
    
    private float calificacion;
            
    public Alumno(int id, String nombre, String apellido, String correo) {
        super(id, nombre, apellido, correo);
    }
    
    public void guardarCalificacion(float calificacion){
        if(calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        } else {
            System.out.println("La calificación debe estar en el rango de 0 a 10.");
        }
    }
    
    public float getCalificacion() {
        return calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    @Override
    public void mostrarPerfil() {
        System.out.println("ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCorreo electrónico: " + correo + "\n");
    }

    public void mostrarCalificacion() {
        System.out.println("Calificacion: " + calificacion + "\n");
    }
}
