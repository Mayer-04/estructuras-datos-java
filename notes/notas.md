# Mis notas

## Conventional Commits

- **feat:** nueva funcionalidad.
- **fix:** Cuando corriges un error o bug que afectaba al funcionamiento.
- **docs:** Cuando modificas solo documentación (README, comentarios, ejemplos, wiki).
- **style:** Cuando haces cambios de formato o estilo que no alteran la lógica del código.
  (espacios, comas, indentación, orden de imports, nombres de variables más claros).
- **refactor:** Cuando reestructuras o mejoras código existente sin cambiar lo que hace.
  (limpieza, mejor legibilidad, dividir funciones grandes, hacer más eficiente sin cambiar resultados).
- **chore:** Se usa para tareas de mantenimiento (ej.: cambios de dependencias, configuración, infraestructura).
- **test:** Cuando agregas o modificas pruebas (tests).
- **perf:** Cuando haces cambios para mejorar el rendimiento.

## Guía práctica para elegir

- ¿Agregaste algo nuevo? → **feat**
- ¿Corregiste algo roto? → **fix**
- ¿Solo documentación? → **docs**
- ¿Formato o estilo? → **style**
- ¿Reestructuraste código sin cambiar funcionalidad? → **refactor**
- ¿Mantenimiento/configuración? → **chore**
- ¿Agregaste/modificaste tests? → **test**
- ¿Mejoraste rendimiento? → **perf**
- ¿Cambios en pipelines o CI/CD? → **ci**
- ¿Cambios en dependencias/build? → **build**
- ¿Revertiste un commit? → **revert**

```java
            // option lee el número entero pero,
            // no consume el carácter de nueva línea (\n) que queda tras pulsar Enter.
            int option = sc.nextInt();
            // evitar que un posterior nextLine() devuelva una cadena vacía
            sc.nextLine(); // Consumir ese \n y "limpiar el buffer"
```

````java
            String line = sc.nextLine();                 // leemos la línea entera
            int option;
            try {
                option = Integer.parseInt(line.trim()); // parse seguro
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número entre 1 y 5.");
                continue;
            }
````

## Listas

- adicionar

```java
    * @throws IndexOutOfBoundsException Si el índice es negativo o mayor que el
    *                                   tamaño actual de la lista
    * @throws NullPointerException      Si el elemento a insertar es nulo
        Validations.indiceInsercion(indice, contador);
        Validations.elementoNoNulo(elemento);
```

- contiene

```java
 Validations.elementoNoNulo(elemento);
```

- obtener

```java
      Validations.indiceAcceso(indice, contador);
   Validations.elementoNoNulo(elemento);
```

- remover 

```java
IndexOutOfBoundsException

Validations.indiceAcceso(indice, contador);
```

- removerIntervalo
```java
throw new IndexOutOfBoundsException(Constants.INDICE_FUERA_DE_RANGO);
```

- modificar

```java
Validations.indiceAcceso(indice, contador);
        Validations.elementoNoNulo(elemento);
```