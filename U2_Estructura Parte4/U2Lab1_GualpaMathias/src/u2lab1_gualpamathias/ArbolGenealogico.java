/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2lab1_gualpamathias;


public class ArbolGenealogico {
    private Nodo raiz;

    // Constructor de la clase, inicializa la raíz como null
    public ArbolGenealogico() {
        this.raiz = null;
    }

    // Método para insertar una persona en el árbol con nombre y género
    public void insertar(String nombre, String genero) {
        raiz = insertarRec(raiz, nombre, genero);
    }

    // Método recursivo para insertar una persona en el árbol
    private Nodo insertarRec(Nodo raiz, String nombre, String genero) {
        if (raiz == null) {
            raiz = new Nodo(nombre, genero);
            return raiz;
        }
        if (nombre.compareTo(raiz.nombre) < 0) {
            raiz.izquierda = insertarRec(raiz.izquierda, nombre, genero);
        } else if (nombre.compareTo(raiz.nombre) > 0) {
            raiz.derecha = insertarRec(raiz.derecha, nombre, genero);
        }
        return raiz;
    }

    // Método para obtener la raíz del árbol
    public Nodo getRaiz() {
        return raiz;
    }

    // Método para establecer relaciones familiares manualmente
    public void establecerRelaciones() {
        Nodo padre = buscarNodo("Padre", raiz);
        Nodo madre = buscarNodo("Madre", raiz);
        Nodo hijo1 = buscarNodo("Hijo1", raiz);
        Nodo hijo2 = buscarNodo("Hijo2", raiz);

        if (padre != null) {
            padre.izquierda = hijo1;
        }

        if (madre != null) {
            madre.izquierda = hijo2;
        }
    }

    // Método recursivo para buscar un nodo por nombre en el árbol
    private Nodo buscarNodo(String nombre, Nodo raiz) {
        if (raiz == null || nombre.equals(raiz.nombre)) {
            return raiz;
        }
        if (nombre.compareTo(raiz.nombre) < 0) {
            return buscarNodo(nombre, raiz.izquierda);
        } else {
            return buscarNodo(nombre, raiz.derecha);
        }
    }

    // Método para imprimir el árbol genealógico de manera recursiva
    public void imprimirArbolGenealogico(Nodo persona, String espacio) {
        System.out.println(espacio + "|- " + persona.nombre + " (" + persona.genero + ")");
        if (persona.izquierda != null) {
            imprimirArbolGenealogico(persona.izquierda, espacio + "   ");
        }
        if (persona.derecha != null) {
            imprimirArbolGenealogico(persona.derecha, espacio + "   ");
        }
    }
}
