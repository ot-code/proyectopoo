
package Reto5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    private static List<Maestro> maestros = new ArrayList<>();
    private static List<Alumno> alumnos = new ArrayList<>();
    private static List<Tutor> tutores = new ArrayList<>();
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarObjetos();
        mostrarPerfiles();
        solicitarYGuardarCalificaciones();
        mostrarCalificacionesTutores();
        
        // Crear (Insertar) un nuevo maestro
        insertarMaestro(new Maestro(4, "Carlos", "López", "carloslopez@mail.com"));

        // Leer (Consultar) un maestro por ID y actualizar su nombre
        Maestro maestro = obtenerMaestroPorId(1);
        if (maestro != null) {
            maestro.setNombre("Carlos Alberto");
            actualizarMaestro(maestro);
        } else {
            System.out.println("Maestro no encontrado con el ID proporcionado.");
        }

        // Eliminar un maestro por ID
        eliminarMaestroPorId(4);

        entrada.close();
    }

    private static void inicializarObjetos() {
        maestros.add(new Maestro(1, "Susana", "Vivanco", "susanavivanco@mail.com"));
        maestros.add(new Maestro(2, "Rosa", "Martinez", "rosamtz@mail.com"));
        maestros.add(new Maestro(3, "Eugenia", "Carranza", "eugeniac@mail.com"));

        alumnos.add(new Alumno(1, "Lorena", "Herrera", "lorenaherrerac@mail.com"));
        alumnos.add(new Alumno(2, "David", "Fernandez", "davidfndz@mail.com"));
        alumnos.add(new Alumno(3, "Marta", "Juárez", "martajuarez@mail.com"));

        tutores.add(new Tutor(alumnos.get(0), 1, "Melissa", "Garza", "melissagarza@mail.com"));
        tutores.add(new Tutor(alumnos.get(1), 2, "Alejandra", "Gómez", "alejandrajuarez@mail.com"));
        tutores.add(new Tutor(alumnos.get(2), 3, "Paola", "González", "paolagonzalez@mail.com"));
    }

    // Métodos CRUD
    // Crear (Insertar)
    public static void insertarMaestro(Maestro maestro) {
        maestros.add(maestro);
    }

    // Leer (Consultar)
    public static Maestro obtenerMaestroPorId(int id) {
        return maestros.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    // Actualizar
    public static void actualizarMaestro(Maestro maestro) {
        int index = maestros.indexOf(obtenerMaestroPorId(maestro.getId()));
        if (index != -1) {
            maestros.set(index, maestro);
        }
    }

    // Eliminar
    public static void eliminarMaestroPorId(int id) {
        maestros.removeIf(m -> m.getId() == id);
    }

        // Métodos CRUD para Alumno
        public static void insertarAlumno(Alumno alumno) {
            alumnos.add(alumno);
        }

        public static Alumno obtenerAlumnoPorId(int id) {
            return alumnos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        }

        public static void actualizarAlumno(Alumno alumno) {
            int index = alumnos.indexOf(obtenerAlumnoPorId(alumno.getId()));
            if (index != -1) {
                alumnos.set(index, alumno);
            }
        }

        public static void eliminarAlumnoPorId(int id) {
            alumnos.removeIf(a -> a.getId() == id);
        }

        // Métodos CRUD para Tutor
        public static void insertarTutor(Tutor tutor) {
            tutores.add(tutor);
        }

        public static Tutor obtenerTutorPorId(int id) {
            return tutores.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        }

        public static void actualizarTutor(Tutor tutor) {
            int index = tutores.indexOf(obtenerTutorPorId(tutor.getId()));
            if (index != -1) {
                tutores.set(index, tutor);
            }
        }

        public static void eliminarTutorPorId(int id) {
            tutores.removeIf(t -> t.getId() == id);
        }

    private static void mostrarPerfiles() {
        System.out.println("\nDatos de los maestros:");
        for (Maestro maestro : maestros) {
            maestro.mostrarPerfil();
        }

        System.out.println("\nDatos de los alumnos:");
        for (Alumno alumno : alumnos) {
            alumno.mostrarPerfil();
        }

        System.out.println("\nDatos de los tutores:");
        for (Tutor tutor : tutores) {
            tutor.mostrarPerfil();
        }
    }

    private static void solicitarYGuardarCalificaciones() {
    for (Alumno alumno : alumnos) {
        float calif;
        do {
            System.out.println("Indicame la calificación del alumno " + alumno.getNombre() + " " + alumno.getApellido() + " (debe estar entre 0 y 10):");
            calif = entrada.nextFloat();
            if (calif < 0 || calif > 10) {
                System.out.println("Calificación inválida. Por favor, ingresa un valor entre 0 y 10.");
            }
        } while (calif < 0 || calif > 10);
        alumno.guardarCalificacion(calif);
    }
}


    private static void mostrarCalificacionesTutores() {
        System.out.println("\n****Tutor asignado******");
        for (Tutor tutor : tutores) {
            System.out.println("Nombre del tutor: " + tutor.getNombre() + " " + tutor.getApellido());
            tutor.mostrarCalificacion();
        }
    }
}
