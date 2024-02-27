/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallergrupo4;


public class ListaEnlazada {
    // Referencia al primer nodo de la lista
    Nodo cabeza;

    // Constructor de la clase ListaEnlazada, que inicializa la cabeza como nula 
    public ListaEnlazada() {
        this.cabeza = null;
    }

    // Método para agregar un nuevo elemento al principio de la lista
    public void agregarElemento(int dato) {
        // Crear un nuevo nodo con el dato proporcionado
        Nodo nuevoNodo = new Nodo(dato);

        // Enlazar el nuevo nodo al anterior primer nodo (cabeza)
        nuevoNodo.siguiente = cabeza;

        // Actualizar la cabeza para que apunte al nuevo nodo (que ahora es el primer nodo)
        cabeza = nuevoNodo;
    }

    // Método para realizar una búsqueda ingenua en la lista
    public boolean busquedamenoseficiente(int objetivo) {
        // Inicializar un nodo actual con la cabeza de la lista
        Nodo actual = cabeza;

        // Iterar a través de la lista mientras el nodo actual no sea nulo
        while (actual != null) {
            // Verificar si el dato del nodo actual es igual al objetivo de búsqueda
            if (actual.dato == objetivo) {
                // Si se encuentra, retornar true
                return true;
            }

            // Mover al siguiente nodo en la lista
            actual = actual.siguiente;
        }

        // Si se llega al final de la lista sin encontrar el objetivo, retornar false
        return false;
    }

    // Método para realizar una búsqueda optimizada en la lista
    public boolean busquedamaseficiente(int objetivo) {
        // Inicializar un nodo actual con la cabeza de la lista
        Nodo actual = cabeza;

        // Iterar a través de la lista mientras el nodo actual no sea nulo y el dato no sea igual al objetivo
        while (actual != null && actual.dato != objetivo) {
            // Mover al siguiente nodo en la lista
            actual = actual.siguiente;
        }

        // Si se encontró el objetivo (o se llegó al final de la lista), retornar true; de lo contrario, false
        return actual != null;
    }
}
