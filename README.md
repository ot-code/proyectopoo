<h1 align="center">Proyecto de POO</h1>💱

Este proyecto se relaciona con un sistema escolar para la *Escuela de Informática Río Grande*, desarrollado en **Java** y donde utilicé el entorno **NetBeans**. La aplicación aplica los principios de la programación orientada a objetos (POO) para gestionar tres tipos de usuarios: **Maestro**, **Alumno** y **Tutor**.

---

## Características

- **Diseño orientado a objetos:**
  Utiliza una clase abstracta `Usuario` que define atributos básicos (ID, nombre, apellido y correo) y una interfaz `Perfil` que obliga a implementar el método `mostrarPerfil()`.
- **Roles y funcionalidades:**
  - **Alumno:** Permite asignar y validar calificaciones (rango de 0 a 10) y muestra su perfil junto con la calificación.
  - **Maestro:** Hereda de `Usuario` y cuenta con funcionalidades básicas, como la actualización de datos y operaciones CRUD simuladas.
  - **Tutor:** Además de heredar de `Usuario`, se asocia a un objeto `Alumno` para mostrar el perfil tanto del tutor como del alumno asignado, facilitando el seguimiento académico.
- **Simulación de base de datos:**
  La clase `Principal` actúa como punto de entrada, donde se inicializan listas en memoria para maestros, alumnos y tutores. Se implementan operaciones CRUD (crear, leer, actualizar y eliminar) para simular la interacción con una base de datos real.
- **Interacción dinámica:**
  Mediante la consola, la aplicación solicita calificaciones para cada alumno, valida la entrada y muestra los perfiles y resultados, ofreciendo una experiencia de usuario clara y amigable.

---

## Tecnologías

- **Lenguaje:** Java
- **IDE:** NetBeans
- **Conceptos POO:** Herencia, encapsulamiento, abstracción, polimorfismo e implementación de interfaces.
