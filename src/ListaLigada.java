public class ListaLigada {
    private Nodo cabeza;
    private int tamano;

    public ListaLigada() {
        cabeza = null;
        tamano = 0;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    // Agrega un instrumento al final de la lista
    public void agregar(Instrumento instrumento) {
        Nodo nuevo = new Nodo(instrumento);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamano++;
    }

    // Elimina el primer instrumento que tenga ese nombre
    // Regresa true si lo encontro y false si no
    public boolean eliminar(String nombre) {
        if (cabeza == null) {
            return false;
        }

        // Caso 1: es el primer nodo
        if (cabeza.dato.getNombre().equalsIgnoreCase(nombre)) {
            cabeza = cabeza.siguiente;
            tamano--;
            return true;
        }

        // Caso 2: esta en medio o al final
        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        while (actual != null) {
            if (actual.dato.getNombre().equalsIgnoreCase(nombre)) {
                anterior.siguiente = actual.siguiente;
                tamano--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        Nodo actual = cabeza;
        int numero = 1;
        while (actual != null) {
            System.out.print(numero + ". ");
            actual.dato.mostrar();
            actual = actual.siguiente;
            numero++;
        }
    }

    // Regresa el instrumento con ese nombre, o null si no existe
    public Instrumento obtener(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.getNombre().equalsIgnoreCase(nombre)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Operacion extra: suma precio * cantidad de todos los instrumentos
    public double calcularValorInventario() {
        double total = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            total += actual.dato.getSubtotal();
            actual = actual.siguiente;
        }
        return total;
    }
}