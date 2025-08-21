# Conceptos básicos de Java

## Operadores

### instanceof

Es un operador que dice: Es este objeto una instancia (es creado a partir de una clase) de este tipo (o de una subclase
de ese tipo).

**Ejemplo:**

```java
// Comprueba si element es un String (o subclase).
// Si lo es, crea una nueva variable 's' con el valor de element convertido a String.
// En pocas palabras verifica + castea.
if(element instanceof
String s){

        }
```

### operador condicional (ternario)

Es una forma más compacta de escribir `if-else` que devuelva un valor.

```md
<!-- Sintaxis -->

resultado = (condición) ? valorSiTrue : valorSiFalse;
```

```java
String status = active ? "ON" : "OFF";
var message = (edad >= 18) ? "Mayor" : "Menor";
```

### Comentarios multilínea

```java
/**
 * Soy
 * un
 * comentario
 * multilínea
 */
```

### text block (multiline string)

- strings multilínea sin concatenar `\n`
- Los `text blocks` llegaron en forma final a Java SE 15.
- Conservan los saltos de línea tal cual.

```java
String menu = """
        Hello
        World
        !
        """;
```

## Variables con `var` y tipos inferidos

Se utiliza cuando queremos que Java `infiera` el tipo. Lo va a inferir dependiendo del tipo que se encuentre a la
derecha del igual.

```java
var name = "Mayer";
var age = 25;
```

### Clases y constructores

`final` en una **clase** significa que **no puede ser heredada**.

- Se usa para clases de utilidades o helper.

```java
public final class Validations {
    // code
}

// Esto daría error:
public class MisValidaciones extends Validations {
} // ❌ no permitido
```

### constructor `privado` en una clase

Significa que **nadie fuera de la clase puede crear instancias** de esa clase.

Esto se usa para clases que:

- Solo tienen **métodos estáticos**.
- Se usan como `utilidades/helper`.
- No tienen sentido como “objeto” (no guardan estado).

## ¿Qué es args[] en public static void main(String[] args)?

En Java, **args** es una variable local que apunta a un arreglo de cadenas _(String[])_.
Este arreglo contiene los **argumentos** que el usuario pasa al programa desde la terminal cuando lo ejecuta.

**Importante:**

- Cada elemento de **args** es un String (incluso si parece un número).
- Si no pasas argumentos, args es un arreglo vacío (args.length == 0), pero nunca es null.
- El nombre **args** es solo una convención; podrías llamarlo parametros, argv, etc., y funcionaría igual.

**Importante método `main`:**

1. El método `main` es el punto de entrada de un programa Java ejecutable.
2. Cuando ejecutas `java NombreDeClase`, la JVM busca el **método main** con exactamente esta firma:

```java
public static void main(String[] args)
```

- **public:** accesible desde la JVM.
- **static:** se puede ejecutar sin crear una instancia de la clase.
- **void:** no devuelve nada.
- **String[] args:** recibe los argumentos de la terminal.

3. En Java puedes tener varias clases con su propio main, y cada main puede ser un punto de entrada independiente.

```java
// Archivo: ClaseA.java
public class ClaseA {
    public static void main(String[] args) {
        System.out.println("Hola desde ClaseA");
    }
}

// Archivo: ClaseB.java
public class ClaseB {
    public static void main(String[] args) {
        System.out.println("Hola desde ClaseB");
    }
}
```

## ¿Qué es un archivo .class?

En Java, un archivo `.class` es el resultado de compilar un archivo `.java` (el código fuente).

- Contiene **bytecode**, que es un conjunto de instrucciones que entiende la **Java Virtual Machine (JVM)**.
- No es código que tu computadora pueda ejecutar directamente como un programa nativo; necesita la JVM para
  interpretarlo o compilarlo a código máquina en tiempo de ejecución (Just-In-Time, JIT).
- **Permiten portabilidad:** un `.class` se puede ejecutar en cualquier sistema que tenga **JVM**, sin recompilar.
- Cualquier clase válida en Java se puede compilar, aunque no tenga un **main**.

**Flujo de ejecución:**

```md
Main.java --> javac Main.java --> Main.class --> java Main (JVM ejecuta)
```

## Arrays.stream(array)

Es un método **estático** de la **clase Arrays**.

- Toma un array y lo convierte en un `Stream`, que es parte de la API de Streams de Java 8+.
- Esto te permite usar operaciones funcionales como `filter`, `map`, `forEach`, etc., sobre los elementos del array.

### Stream

En Java, un `Stream` es una secuencia de elementos sobre la que se pueden realizar operaciones funcionales (como
filtrar, mapear, reducir) de manera declarativa.

- No almacena elementos; solo **provee operaciones** sobre los datos que ya existen en un array, colección o generador.
- Arrays.stream(array) crea un **objeto IntStream** que conecta el array con operaciones de stream.
- Cada operación intermedia _(filter)_ se encadena y se almacena internamente, pero no recorre los elementos.
- Cuando llega la operación terminal _(forEach)_, se recorren los elementos uno por uno, aplicando todas las operaciones
  encadenadas.
- `Arrays.stream(array)` es para arrays, `.stream()` es para colecciones.

```css
Array / Colección  -->  Stream (intermedio) --> Stream (intermedio) ... --> Operación terminal
         |                      |                          |
         v                      v                          v
     Arrays.stream()      filter(), map()            forEach(), collect()
```

```java
// Los :: dicen “toma este método y pásalo como función”.
Arrays.stream(numeros).

forEach(System.out::println);
```

## ¿Qué es una excepción?

En Java, una `excepción` es un evento que ocurre durante la ejecución de un programa y que interrumpe el flujo normal
del mismo. Por ejemplo, intentar dividir por cero o acceder a un archivo que no existe.

Java tiene un sistema de manejo de excepciones muy robusto basado en clases. Todas las excepciones heredan de la clase
base:

```java
java.lang.Throwable
```

- Throwable → clase base

    - Error → problemas graves del sistema (p. ej., OutOfMemoryError) → no se deben capturar normalmente
    - Exception → problemas que el programa puede manejar → sí se capturan
        - Checked Exception → deben declararse o manejarse (p. ej., IOException)
        - Unchecked Exception → no necesitan declararse (p. ej., NullPointerException)

- **try:** bloque donde colocamos el código que puede lanzar excepciones.
- **catch:** bloque que captura la excepción y permite manejarla.
- **finally:** bloque opcional que se ejecuta siempre, ocurra o no excepción (ideal para cerrar recursos).

## Leer datos con `Scanner`

```java
int option = sc.nextInt(); // lee el número, PERO no consume el salto de línea (\n)
sc.

nextLine();             // tienes que "limpiar" el buffer
```

- `nextInt()` solo lee el número (ej: 3), pero deja en el buffer el `\n` que se genera al pulsar **Enter**.
- Si luego usas `nextLine()` para leer un string, lo primero que devuelve es ese `\n` pendiente → da la sensación de que "
salta" la entrada.