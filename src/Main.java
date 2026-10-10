import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        int opcion;

        do {
            System.out.println("\n===== TIENDA DE INSTRUMENTOS MUSICALES =====");
            System.out.println("1. Agregar instrumento");
            System.out.println("2. Eliminar instrumento");
            System.out.println("3. Mostrar instrumentos");
            System.out.println("4. Actualizar cantidad (stock)");
            System.out.println("5. Calcular valor total del inventario");
            System.out.println("6. Salir");
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1:
                    agregarInstrumento(lista);
                    break;
                case 2:
                    eliminarInstrumento(lista);
                    break;
                case 3:
                    System.out.println("\n--- Inventario (" + lista.getTamano() + " instrumentos) ---");
                    lista.mostrar();
                    break;
                case 4:
                    actualizarCantidad(lista);
                    break;
                case 5:
                    System.out.println("Valor total del inventario: $" + lista.calcularValorInventario());
                    break;
                case 6:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida, intenta de nuevo.");
            }
        } while (opcion != 6);
    }

    public static void agregarInstrumento(ListaLigada lista) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        double precio = leerDouble("Precio: ");
        int cantidad = leerEntero("Cantidad: ");

        Instrumento nuevo = new Instrumento(nombre, marca, precio, cantidad);
        lista.agregar(nuevo);
        System.out.println("Instrumento agregado.");
    }

    public static void eliminarInstrumento(ListaLigada lista) {
        System.out.print("Nombre del instrumento a eliminar: ");
        String nombre = sc.nextLine();

        if (lista.eliminar(nombre)) {
            System.out.println("Instrumento eliminado.");
        } else {
            System.out.println("No se encontro ese instrumento.");
        }
    }

    public static void actualizarCantidad(ListaLigada lista) {
        System.out.print("Nombre del instrumento: ");
        String nombre = sc.nextLine();

        Instrumento inst = lista.obtener(nombre);
        if (inst == null) {
            System.out.println("No se encontro ese instrumento.");
        } else {
            int nueva = leerEntero("Nueva cantidad: ");
            inst.setCantidad(nueva);
            System.out.println("Cantidad actualizada.");
        }
    }

    // Estos dos metodos repiten la pregunta hasta que el usuario escriba un numero valido
    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 0) {
                    return n;
                }
                System.out.println("No puede ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println("Escribe un numero entero valido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (n >= 0) {
                    return n;
                }
                System.out.println("No puede ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println("Escribe un numero valido.");
            }
        }
    }
}