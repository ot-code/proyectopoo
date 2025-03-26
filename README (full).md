# Proyecto de paradigma POO

Este proyecto, desarrollado en **Java** utilizando el entorno **NetBeans**, es una simulación de un sistema escolar para la *Escuela de Informática Río Grande*. La aplicación está diseñada aplicando los principios del paradigma de programación orientada a objetos (POO) y se centra en el manejo de tres tipos de usuarios: **Maestro**, **Alumno** y **Tutor**. Cada uno de estos roles cuenta con características y funcionalidades específicas, permitiendo practicar conceptos fundamentales como herencia, encapsulamiento, clases abstractas, interfaces y métodos.

---

### Componentes y estructura

- **Clases y jerarquía de usuarios**
  - **Usuario (Clase abstracta):**
    Define los atributos básicos comunes a todos los usuarios, como *id*, *nombre*, *apellido* y *correo electrónico*. También implementa un método para imprimir el perfil de usuario.
  - **Perfil (Interfaz):**
    Especifica el método `mostrarPerfil()`, que es implementado por las clases derivadas para mostrar la información básica del usuario.
  - **Alumno:**
    Extiende de `Usuario` y agrega la funcionalidad de gestionar una *calificación*. Incluye métodos para guardar y mostrar la calificación, validando que ésta se encuentre entre 0 y 10.
  - **Maestro:**
    También extiende de `Usuario` y, aunque inicialmente posee funcionalidades básicas, se muestra la capacidad de actualizar información (por ejemplo, el nombre) y realizar operaciones CRUD simuladas.
  - **Tutor:**
    Además de extender de `Usuario`, la clase `Tutor` se asocia a un objeto `Alumno`. Su función principal es imprimir su perfil junto con el perfil del alumno asignado y mostrar la calificación del alumno.
- **Clase principal y simulación de base de datos**
  La clase `Principal` es el punto de entrada de la aplicación y se encarga de:
  - Inicializar instancias de cada tipo de usuario.
  - Simular operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para **Maestros**, **Alumnos** y **Tutores**.
  - Solicitar y guardar calificaciones para los alumnos a través de la entrada por consola.
  - Mostrar los perfiles y calificaciones, simulando así la interacción con una base de datos, pero mediante impresión en la consola.

---

### Herramientas y tecnologías

- **Lenguaje de programación:** Java
  Se aprovechan características avanzadas de Java, como clases abstractas, interfaces y manejo de excepciones.
- **Entorno de desarrollo:** NetBeans
  Este IDE facilitó la organización del proyecto y la simulación de operaciones de base de datos mediante colecciones en memoria.
- **Conceptos de Programación Orientada a Objetos:**
  - **Herencia:** Uso de clases derivadas (`Alumno`, `Maestro`, `Tutor`) que extienden de la clase abstracta `Usuario`.
  - **Encapsulamiento:** Manejo de atributos privados y métodos públicos para garantizar la integridad de los datos.
  - **Abstracción y polimorfismo:** A través de la clase abstracta `Usuario` y la interfaz `Perfil`, se implementa un diseño modular y flexible.
  - **CRUD simulado:** Se realizan operaciones de inserción, consulta, actualización y eliminación sobre listas, emulando la interacción con una base de datos.

---

### Función esperada

La aplicación está pensada para mejorar la eficiencia del sistema escolar, ofreciendo:

- **Gestión de usuarios:** Permite la creación y mantenimiento de perfiles de maestros, alumnos y tutores.
- **Interacción dinámica:** A través de la consola, se solicita la calificación de cada alumno, asegurando que se cumpla con la validación necesaria.
- **Operaciones CRUD:** Se simulan acciones comunes de bases de datos, como insertar nuevos registros, consultar usuarios por su ID, actualizar información y eliminar registros.
- **Impresión de perfiles y calificaciones:** Cada usuario puede ver sus datos básicos y, en el caso de alumnos y tutores, se muestra la calificación asociada al alumno.
- **Experiencia de usuario amigable:** La aplicación utiliza mensajes claros y estructurados, brindando una experiencia interactiva y comprensible incluso para quienes no están familiarizados con el código.

---

<h2 align="center">Análisis del código</h2>

## Clase Alumno

```java
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
```

### 1. **Herencia y ubicación**

- **Herencia de `Usuario`:**
  La clase `Alumno` extiende de la clase abstracta `Usuario`, lo que significa que hereda atributos y métodos comunes a todos los usuarios (como `id`, `nombre`, `apellido` y `correo`). Esto permite reutilizar el código y mantener un diseño modular y organizado.
  _Ejemplo: Al crear un alumno, se inicializan sus datos básicos a través del constructor de `Usuario`._
- **Paquete:**
  El código se encuentra en el paquete `Reto5`, lo cual organiza el proyecto y facilita la gestión de clases relacionadas.

### 2. **Atributos**

- **`private float calificacion;`**
  Este atributo almacena la calificación del alumno. Se declara como `private` para asegurar el principio de encapsulamiento, es decir, que solo pueda modificarse a través de métodos específicos.

### 3. **Constructor**

- **`public Alumno(int id, String nombre, String apellido, String correo)`**
  El constructor inicializa un objeto `Alumno` usando los parámetros proporcionados.
  - **`super(...)`:** Llama al constructor de la clase `Usuario` para asignar los valores básicos.
  - **Objetivo:** Garantizar que cada objeto alumno tenga una identidad única (ID), nombre, apellido y correo electrónico desde el inicio.

### 4. **Métodos para gestión de la calificación**

- **`public void guardarCalificacion(float calificacion)`**
  - **Funcionalidad:** Permite asignar una calificación al alumno.
  - **Validación:** Se verifica que la calificación esté dentro del rango de 0 a 10. Si la calificación es válida, se guarda; de lo contrario, se muestra un mensaje de error.
  - **Importancia:** Garantiza la integridad de los datos, asegurándose que los valores fuera de rango no sean asignados.
- **`public float getCalificacion()`**
  - **Funcionalidad:** Retorna el valor de la calificación almacenada.
  - **Uso:** Permite acceder a la calificación sin modificarla, siguiendo el principio de encapsulamiento.

### 5. **Métodos para acceso a atributos heredados**

- **`public String getNombre()` y `public String getApellido()`**
  - **Propósito:** Facilitan el acceso a los atributos `nombre` y `apellido` heredados de `Usuario`.
  - **Ventaja:** Estos métodos permiten obtener la información personal del alumno de forma controlada.

### 6. **Método de visualización de información**

- **`@Override public void mostrarPerfil()`**
  - **Funcionalidad:** Imprime en consola los datos básicos del alumno: ID, nombre, apellido y correo electrónico.
  - **Sobreescritura:** Al estar anotado con `@Override`, se indica que este método modifica o complementa la implementación de `mostrarPerfil()` definida en la clase padre o en la interfaz `Perfil`.
  - **Objetivo:** Ofrecer una forma rápida y legible de revisar la información del alumno.
- **`public void mostrarCalificacion()`**
  - **Funcionalidad:** Muestra la calificación del alumno en la consola.
  - **Importancia:** Permite verificar visualmente el rendimiento académico del alumno en la aplicación.

---

### Datos adicionales

- **Encapsulamiento y seguridad de datos:**
  La declaración de atributos como `calificacion` en modo `private` y el uso de métodos `get` y `set` garantizan que la información se manipule de manera controlada, lo cual es una práctica esencial en la programación orientada a objetos.
- **Validaciones:**
  La validación dentro del método `guardarCalificacion` es fundamental para evitar la entrada de datos erróneos o fuera de los límites permitidos. Esto es crucial en sistemas reales donde la integridad de la información afecta el rendimiento del sistema.
- **Herencia y reutilización de código:**
  Al extender de la clase `Usuario`, la clase `Alumno` no necesita redefinir atributos y comportamientos comunes, lo que reduce la redundancia y facilita el mantenimiento del código.
- **Interfaz y polimorfismo:**
  Al implementar el método `mostrarPerfil()` de la interfaz `Perfil`, se asegura que cada clase derivada (como `Alumno`) presente la información de forma consistente, permitiendo el polimorfismo en el manejo de diferentes tipos de usuarios.
- **Estilo de programación y legibilidad:**
  El código está escrito de manera clara y estructurada, lo que facilita la comprensión y el mantenimiento, incluso para usuarios generales o desarrolladores que se acerquen al proyecto por primera vez. Además, se puede complementar con emojis o comentarios adicionales para hacerlo más amigable en el portafolio.

---

## Clase Maestro

```java
package Reto5;

public class Maestro extends Usuario{

    public Maestro(int id, String nombre, String apellido, String correo) {
        super(id, nombre, apellido, correo);
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
}

```

### 1. **Herencia y ubicación**

- **Herencia de `Usuario`:**
  La clase `Maestro` extiende de la clase abstracta `Usuario`, lo que significa que hereda atributos comunes como *id*, *nombre*, *apellido* y *correo*. Esto permite reutilizar el código y mantener un diseño coherente en el sistema, ya que todos los tipos de usuarios comparten ciertas características básicas.
- **Paquete:**
  El código se encuentra en el paquete `Reto5`, lo que ayuda a organizar las clases relacionadas con el reto y facilita la gestión del proyecto.

### 2. **Constructor**

- **`public Maestro(int id, String nombre, String apellido, String correo)`**
  - **Función:**
    El constructor se encarga de inicializar un objeto `Maestro` con los datos básicos del usuario, utilizando el constructor de la clase `Usuario` mediante la llamada a `super(...)`.
  - **Ventaja:**
    Garantiza que cada maestro cuente con un identificador único y la información necesaria para ser reconocido dentro del sistema.

### 3. **Método para actualización de datos**

- **`public void setNombre(String nombre)`**
  - **Funcionalidad:**
    Este método permite modificar el nombre del maestro. Se utiliza la implementación del método `setNombre`definido en la clase `Usuario` para actualizar este atributo.
  - **Propósito:**
    Facilita la actualización de la información del maestro en caso de que se requiera un cambio, manteniendo el principio de encapsulamiento y reutilización de código.

### 4. **Buenas prácticas**

- **Simplicidad:**
  La clase `Maestro` está diseñada de forma simple, delegando gran parte de la funcionalidad a la clase padre `Usuario`. Esto no solo reduce la redundancia del código, sino que también permite que futuras mejoras o modificaciones en la estructura de usuario se reflejen automáticamente en todas las clases derivadas.
- **Encapsulamiento:**
  Aunque en este caso el método `setNombre` solo actúa como una interfaz para la modificación del nombre, se mantiene el control sobre cómo y cuándo se realizan estos cambios, asegurando que los datos sean actualizados de manera controlada.

---

## Clase Perfil

### Interfaz Perfil

```java
package Reto5;

public interface Perfil {
    void mostrarPerfil();
}
```

### 1. **Concepto de interfaz**

- **Definición:**
  Una interfaz en Java define un contrato que las clases deben cumplir, especificando métodos que deben implementarse. No contiene implementación de métodos (salvo que se usen métodos por defecto), lo que permite garantizar que diferentes clases ofrezcan una funcionalidad común.

### 2. **Método**

- **`void mostrarPerfil();`**
  - **Propósito:**
    Este método obliga a cualquier clase que implemente la interfaz `Perfil` a definir su propio comportamiento para mostrar la información del perfil.
  - **Uso en el sistema:**
    Al implementar `mostrarPerfil()`, las clases como `Alumno`, `Maestro` y `Tutor` aseguran que puedan presentar de manera consistente los datos básicos de un usuario, aunque cada uno pueda tener detalles adicionales propios.

### 3. **Beneficios**

- **Polimorfismo:**
  La interfaz permite tratar a diferentes tipos de usuarios de manera uniforme. Por ejemplo, en el método `mostrarPerfiles()` de la clase `Principal`, se puede invocar `mostrarPerfil()` en cada objeto sin preocuparse por la clase concreta, ya que todas implementan la misma interfaz.
- **Flexibilidad:**
  Al definir un contrato claro, la interfaz facilita futuras expansiones del sistema. Nuevas clases de usuarios o roles solo deben implementar `mostrarPerfil()` para integrarse con el resto del sistema, promoviendo un diseño modular y extensible.
- **Conceptos:**
  La interfaz ayuda a separar la definición de la funcionalidad (qué se espera que haga) de su implementación (cómo se hace), lo que mejora la claridad y organización del código.

## Clase Principal

### 1. **Organización y variables globales**

- **Listas de Objetos:**
  Se crean listas estáticas para almacenar instancias de **Maestro**, **Alumno** y **Tutor**. Estas listas actúan como una "base de datos" en memoria para simular operaciones CRUD.
  - `private static List<Maestro> maestros`
  - `private static List<Alumno> alumnos`
  - `private static List<Tutor> tutores`
- **Scanner para entrada de datos:**
  Se utiliza un objeto `Scanner` (definido como `static final`) para leer datos desde la consola, lo que permite la interacción del usuario.
  - `private static final Scanner entrada = new Scanner(System.in);`
    _Esto permite la entrada dinámica de calificaciones por parte del usuario._

### 2. **Método main**

- **Secuencia de ejecución:**
  El método `main` es el punto de entrada de la aplicación y ejecuta el programa:
  - **Inicialización:** Llama a `inicializarObjetos()` para poblar las listas con instancias predeterminadas de maestros, alumnos y tutores.
  - **Visualización:** Llama a `mostrarPerfiles()` para imprimir en consola la información de cada usuario.
  - **Interacción:** Ejecuta `solicitarYGuardarCalificaciones()` para pedir al usuario calificaciones para cada alumno y, posteriormente, `mostrarCalificacionesTutores()` para visualizar las calificaciones asociadas a cada tutor.
  - **Operaciones CRUD:**
    - **Insertar:** Se añade un nuevo maestro.
    - **Consultar y Actualizar:** Se busca un maestro por su ID y se actualiza su nombre.
    - **Eliminar:** Se elimina un maestro específico por su ID.
  - **Cierre del Scanner:** Finalmente, se cierra el objeto `Scanner` para liberar recursos.

### 3. **Inicialización de objetos**

- **Método `inicializarObjetos()`:**
  - Se crean instancias predeterminadas para cada tipo de usuario y se añaden a sus respectivas listas.
  - **Ejemplo:**
    ```java
    maestros.add(new Maestro(1, "Susana", "Vivanco", "susanavivanco@mail.com"));
    ```
  - Permite simular un entorno con datos ya existentes, facilitando la demostración de las funcionalidades del sistema.

### 4. **Operaciones CRUD (Crear, Leer, Actualizar, Eliminar)**

- **Maestro, Alumno y Tutor:**
  La clase implementa métodos específicos para cada tipo de usuario, permitiendo:
  - **Insertar:** Añadir nuevos objetos a las listas.
  - **Obtener por ID:** Buscar un objeto dentro de la lista usando una expresión lambda con streams.
  - **Actualizar:** Modificar el objeto encontrado en la lista.
  - **Eliminar:** Remover un objeto de la lista según su ID.
  Estas operaciones demuestran la capacidad de la aplicación para gestionar dinámicamente los datos, simulando interacciones con una base de datos real.

### 5. **Visualización de perfiles**

- **Método `mostrarPerfiles()`:**
  - Imprime la información de los maestros, alumnos y tutores.
  - Cada usuario utiliza el método `mostrarPerfil()` (definido en la clase `Usuario` o implementado por cada subclase), lo que garantiza consistencia en la salida de datos.
  - _Esta funcionalidad es crucial para validar la correcta inicialización y manipulación de los objetos._

### 6. **Interacción y validación de calificaciones**

- **Método `solicitarYGuardarCalificaciones()`:**
  - Recorre la lista de alumnos solicitando una calificación para cada uno.
  - Implementa un bucle `do-while` que se asegura de que la calificación ingresada se encuentre en el rango permitido (0 a 10).
  - Si la entrada es inválida, se solicita nuevamente el dato, reforzando la integridad de la información.
- **Método `mostrarCalificacionesTutores()`:**
  - Para cada tutor, se muestra el nombre y la calificación del alumno asociado, facilitando la verificación visual del proceso de asignación de calificaciones.

### 7. **Buenas prácticas**

- **Modularidad y reutilización:** Cada funcionalidad se encapsula en métodos bien definidos, lo que permite una fácil extensión y mantenimiento del código.
- **Uso de streams:** La utilización de streams para filtrar y buscar objetos en las listas es una práctica en Java, que hace el código más limpio.
- **Simulación de base de datos:** Aunque la aplicación utiliza colecciones en memoria, la estructura de los métodos CRUD es similar a la que se emplearía con una base de datos real, lo que facilita la escalabilidad del proyecto.
- **Interacción usuario-programa:** La lectura desde consola y la validación de datos aseguran que la aplicación es interactiva y robusta ante entradas erróneas.

---

En síntesis

- El método `main` coordina la inicialización, visualización, interacción y manipulación de datos.
- Se utilizan listas para almacenar y gestionar maestros, alumnos y tutores, simulando un entorno de base de datos.
- Se implementan métodos para insertar, consultar, actualizar y eliminar datos, demostrando la aplicabilidad del patrón CRUD en POO.
- La aplicación solicita calificaciones a través de la consola, valida la información y muestra los resultados, garantizando una experiencia de usuario interactiva.

## Clase Tutor

### 1. **Herencia y ubicación**

- **Extensión de `Usuario`:**
  La clase `Tutor` hereda de la clase abstracta `Usuario`, lo que le proporciona atributos comunes (id, nombre, apellido, correo) y la obligación de implementar el método `mostrarPerfil()` de la interfaz `Perfil`.
  _Esto garantiza uniformidad en la presentación de datos entre los distintos tipos de usuarios._

### 2. **Atributos**

- **`private Alumno alumno;`**
  - **Función:**
    Este atributo establece una relación de asociación entre el tutor y un alumno. Es decir, cada tutor está vinculado a un objeto `Alumno`, lo cual permite acceder a la información y calificación de dicho alumno.
  - **Ventaja:**
    Facilita la gestión y seguimiento académico, permitiendo que el tutor pueda revisar y mostrar la calificación del alumno asignado.

### 3. **Constructor**

- **`public Tutor(Alumno alumno, int id, String nombre, String apellido, String correo)`**
  - **Objetivo:**
    Inicializa un objeto `Tutor` asignándole tanto los datos heredados de `Usuario` como el alumno que supervisa.
  - **Uso de `super`:**
    Llama al constructor de la clase padre (`Usuario`) para establecer los atributos básicos y, a continuación, asigna el alumno a su atributo local.

### 4. **Métodos de acceso**

- **Getters y Setters para `alumno`:**
  - **`public Alumno getAlumno()` y `public void setAlumno(Alumno alumno)`**
    Permiten obtener y modificar el alumno asociado al tutor, siguiendo el principio de encapsulamiento.
- **Getters para `nombre` y `apellido`:**
  - **`public String getNombre()` y `public String getApellido()`**
    Aunque ya se heredan de `Usuario`, se proporcionan para acceder directamente a estos atributos desde el contexto de un tutor.
    _Nota: La implementación accede directamente a `super.nombre` y `super.apellido`, aprovechando la herencia._

### 5. **Visualización de información**

- **`mostrarCalificacion()`**
  - **Función:**
    Este método imprime en consola el nombre del estudiante y su calificación, obteniendo los datos a través de los métodos del objeto `Alumno`.
  - **Importancia:**
    Permite que el tutor muestre de manera clara y rápida el rendimiento académico del alumno asignado, lo que es vital para el seguimiento y asesoramiento educativo.
- **`mostrarPerfil()`**
  - **Sobrescritura del método:**
    Al estar anotado con `@Override`, este método redefine la forma en la que se muestra el perfil del tutor.
  - **Contenido:**
    Imprime la información del tutor (ID, nombre, apellido, correo) y, adicionalmente, llama al método `mostrarPerfil()` del alumno asociado para mostrar sus datos.
  - **Ventaja:**
    Proporciona una vista completa y relacionada de la información, integrando datos del tutor y del alumno bajo su supervisión.

---

En síntesis

- La clase `Tutor` combina la herencia de `Usuario` con una asociación directa a un objeto `Alumno`, facilitando el seguimiento académico.
- El constructor establece de manera clara la relación entre tutor y alumno, mientras que los getters y setters aseguran un acceso controlado a los datos.
- **Los métodos de visualización:**
  - **`mostrarCalificacion()`:** Se enfoca en detallar la información académica del alumno.
  - **`mostrarPerfil()`:** Ofrece una vista integral del perfil del tutor junto con los datos del alumno asignado.

## Clase Usuario

### **Rol de la clase**

- **Clase Abstracta:**
  `Usuario` es una clase abstracta, lo que significa que no puede ser instanciada directamente. Se utiliza como base para que otras clases (como **Alumno**, **Maestro** y **Tutor**) hereden atributos y comportamientos comunes.
  - **Ventaja:** Facilita la reutilización de código y garantiza consistencia en la representación de los datos básicos de cualquier usuario en el sistema.
- **Implementación de la interfaz `Perfil`:**
  Al implementar la interfaz `Perfil`, la clase se compromete a definir el método `mostrarPerfil()`, lo cual asegura que todas las clases derivadas tendrán una manera estándar de mostrar la información del usuario.

### 2. **Atributos Protegidos**

- **`protected int id;`**
- **`protected String nombre;`**
- **`protected String apellido;`**
- **`protected String correo;`**
  Estos atributos representan la información básica que comparten todos los usuarios:
  - **`id`:** Identificador único para cada usuario.
  - **`nombre` y `apellido`:** Datos personales que permiten identificar al usuario.
  - **`correo`:** Información de contacto.
  Se declaran como **protected** para permitir que las clases derivadas puedan acceder directamente a ellos, manteniendo al mismo tiempo el principio de encapsulamiento al no ser públicos.

### 3. **Constructor**

- **`public Usuario(int id, String nombre, String apellido, String correo)`**
  - **Función:** Inicializa los atributos básicos del usuario con los valores proporcionados.
  - **Uso:** Al ser invocado desde las clases hijas, garantiza que cada objeto derivado tenga correctamente inicializados sus datos fundamentales.

### 4. **Métodos de acceso**

- **`public int getId()`**
  - **Propósito:** Devuelve el identificador del usuario.
  - **Importancia:** Permite la consulta del ID sin exponer directamente el atributo.
- **`public void setNombre(String nombre)`**
  - **Función:** Permite actualizar el nombre del usuario.
  - **Beneficio:** Facilita la modificación de datos de forma controlada, asegurando que cambios en el nombre se realicen de manera segura.

### 5. **Método de visualización**

- **`public void mostrarPerfil()`**
  - **Funcionalidad:** Imprime en consola la información básica del usuario, incluyendo el ID, nombre, apellido y correo electrónico.
  - **Implementación:** Al no ser un método abstracto en esta clase, proporciona una implementación por defecto que puede ser sobrescrita en las clases derivadas si se requiere personalizar la presentación de la información.
  - **Beneficio:** Permite una visualización homogénea y estandarizada del perfil de cualquier usuario, lo que es útil para depuración, informes o demostraciones.

---

En síntesis:

- La clase `Usuario` actúa como el cimiento para todas las demás clases de usuario en el sistema. Al centralizar la información básica y las funciones comunes, se promueve un diseño limpio y modular.
- Con atributos protegidos y métodos públicos, se asegura que las clases hijas puedan heredar y extender la funcionalidad sin duplicar código, facilitando el mantenimiento y la escalabilidad del proyecto.
- La implementación del método `mostrarPerfil()` establece un formato uniforme para la presentación de los datos, lo que se vuelve esencial al integrar y visualizar información de diferentes tipos de usuarios.

Esta clase es fundamental para el proyecto, ya que define la estructura básica y el comportamiento que comparten todos los usuarios, garantizando un diseño coherente y fácil de mantener en el contexto de la programación orientada a objetos.
