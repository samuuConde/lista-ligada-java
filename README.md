# Tienda de Instrumentos Musicales (Lista Ligada en Java)

Proyecto del segundo parcial. Es un sistema por consola para administrar el inventario de una tienda de instrumentos musicales, usando una **lista ligada implementada desde cero** (sin usar `LinkedList` ni `ArrayList`).

## Descripcion

Cada instrumento es un objeto de la clase `Instrumento` con estos atributos:

- nombre
- marca
- precio
- cantidad (stock)

Los instrumentos se guardan en una lista ligada propia formada por la clase `Nodo` y la clase `ListaLigada`.

## Funciones del menu

1. **Agregar instrumento**: pide los datos por consola y lo agrega al final de la lista.
2. **Eliminar instrumento**: lo busca por nombre y lo elimina de la lista.
3. **Mostrar instrumentos**: muestra todos los instrumentos guardados.
4. **Actualizar cantidad**: cambia el stock de un instrumento (operacion extra).
5. **Calcular valor total del inventario**: suma precio x cantidad de todos los instrumentos (operacion extra).
6. **Salir**

## Estructura del proyecto

| Archivo | Descripcion |
|---|---|
| `Instrumento.java` | Clase que representa cada instrumento |
| `Nodo.java` | Nodo de la lista (guarda un instrumento y apunta al siguiente) |
| `ListaLigada.java` | Lista ligada con los metodos agregar, eliminar, mostrar, etc. |
| `Main.java` | Programa principal con el menu de consola |

## Como ejecutarlo

Necesitas tener instalado el JDK de Java.

1. Clona el repositorio o descarga los archivos.
2. Abre una terminal en la carpeta del proyecto.
3. Entra a la carpeta src:
   cd src
4. Compila:
   javac *.java
5. Ejecuta:
   java Main

## Autor

Samuel - UMAD