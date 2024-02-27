package ejemplopila;


public class Pila {
    int tamaño; // Tamaño de la pila 
    Nodo tope;  // Para el tope de la pila

    // Constructor de la clase Pila
    public Pila() {
        this.tamaño = 0; // Inicializa el tamaño de la pila en 0
        this.tope = null; // Inicializa el tope de la pila como nulo
    }

    // Método para agregar un nuevo elemento a la pila (push)
    public void push(int valor) {
        Nodo nodo = new Nodo(valor); // Crea un nuevo nodo con el valor proporcionado
        nodo.siguiente = tope; // Establece el siguiente del nuevo nodo como el tope actual
        tope = nodo; // Actualiza el tope de la pila al nuevo nodo
        tamaño++; // Incrementa el tamaño de la pila
    }

    // Método para quitar y devolver el elemento en la cima de la pila (pop)
    public int pop() {
        if (tamaño > 0) {
            int returnValue = tope.valor; // Obtiene el valor del tope de la pila
            tope = tope.siguiente; // Actualiza el tope de la pila al siguiente nodo
            tamaño--; // Decrementa el tamaño de la pila
            return returnValue; // Devuelve el valor obtenido del tope de la pila
        } else {
            return -1; // Si la pila está vacía, devuelve -1 
        }
    }

    // Método para mostrar todos los elementos de la pila
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
        } else {
            System.out.println("Elementos de la pila:");
            Nodo actual = tope;
            while (actual != null) {
                System.out.println(actual.valor);
                actual = actual.siguiente;
            }
        }
    }

    // Método para obtener el valor en la cima de la pila sin quitarlo
    public int verTope() {
        if (isEmpty()) {
            System.out.println("La pila está vacía. No hay elementos en la cima.");
            return -1; // Otra opción es lanzar una excepción en lugar de devolver -1
        } else {
            return tope.valor;
        }
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return tamaño == 0;
    }
}
