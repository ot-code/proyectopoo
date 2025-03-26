
package Reto5;

public class Maestro extends Usuario{
    
    public Maestro(int id, String nombre, String apellido, String correo) {
        super(id, nombre, apellido, correo);
    }
    
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
}
