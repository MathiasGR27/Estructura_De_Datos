package grafobusquedadijkstradinamico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Grafo {

     // Número de vértices en el grafo
    private final int cantidadVertices;
    // Lista de adyacencia para representar el grafo
    private final List<List<Arista>> listaAdyacencia;

    // Constructor que inicializa el grafo con la cantidad de vértices dada
    public Grafo(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        // Inicialización de la lista de adyacencia
        this.listaAdyacencia = new ArrayList<>(cantidadVertices);
        for (int i = 0; i < cantidadVertices; i++) {
            this.listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Método para agregar una arista entre dos vértices con un peso dado
    public void agregarArista(int origen, int destino, int peso) {
        this.listaAdyacencia.get(origen).add(new Arista(destino, peso));
    }

    // Implementación del algoritmo de Dijkstra para encontrar el camino más corto desde el origen hasta el destino
    public List<Integer> dijkstra(int origen, int destino) {
        // Cola de prioridad para manejar los nodos de manera eficiente
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(cantidadVertices, Comparator.comparingInt(a -> a.peso));
        // Arreglos para almacenar distancias y nodos previos
        int[] distancias = new int[cantidadVertices];
        int[] previos = new int[cantidadVertices];
        // Inicialización de los arreglos con valores predeterminados
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(previos, -1);

        // Agregar el nodo de origen a la cola de prioridad
        colaPrioridad.add(new Nodo(origen, 0));
        distancias[origen] = 0;

        // Bucle principal del algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            // Extraer el nodo con la menor distancia de la cola de prioridad
            Nodo nodoActual = colaPrioridad.poll();
            int u = nodoActual.vertice;

            // Iterar sobre las aristas adyacentes al nodo actual
            for (Arista arista : listaAdyacencia.get(u)) {
                int v = arista.destino;
                int peso = arista.peso;
                // Comprobar si se encuentra un camino más corto hacia v desde u
                if (distancias[u] + peso < distancias[v]) {
                    // Actualizar la distancia y el nodo previo
                    distancias[v] = distancias[u] + peso;
                    previos[v] = u;
                    // Agregar el nodo actualizado a la cola de prioridad
                    colaPrioridad.add(new Nodo(v, distancias[v]));
                }
            }
        }

        // Reconstruir y devolver la ruta desde el destino hasta el origen
        List<Integer> ruta = new ArrayList<>();
        for (int i = destino; i != -1; i = previos[i]) {
            ruta.add(i);
        }
        Collections.reverse(ruta);

        return ruta;
    }

    // Método para calcular la suma de los pesos de las aristas en una ruta dada
    public int sumaPesosAristas(List<Integer> ruta) {
        int suma = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            int origen = ruta.get(i);
            int destino = ruta.get(i + 1);
            // Obtener el peso de la arista entre los vértices origen y destino
            int peso = obtenerPesoArista(origen, destino);
            suma += peso;
        }
        return suma;
    }

    // Método privado para obtener el peso de una arista entre dos vértices
    private int obtenerPesoArista(int origen, int destino) {
        for (Arista arista : listaAdyacencia.get(origen)) {
            if (arista.destino == destino) {
                return arista.peso;
            }
        }
        return Integer.MAX_VALUE; // Si no hay arista, se devuelve el valor máximo posible
    }

    // Método para imprimir la matriz de adyacencia del grafo (para fines de depuración)
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                int peso = obtenerPesoArista(i, j);
                // Mostrar el peso de la arista o "0" si no hay conexión
                System.out.print((peso == Integer.MAX_VALUE ? "0" : peso) + " ");
            }
            System.out.println();
        }
    }
    /*public void mostrarTablaDijkstra(int origen, int destino) {
    PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(cantidadVertices, Comparator.comparingInt(a -> a.peso));
    int[] distancias = new int[cantidadVertices];
    int[] previos = new int[cantidadVertices];
    Arrays.fill(distancias, 1, cantidadVertices, Integer.MAX_VALUE);
    Arrays.fill(previos, -1);

    colaPrioridad.add(new Nodo(origen, 0));
    distancias[origen] = 0;

    System.out.println("Tabla de Búsqueda de Dijkstra:");
    System.out.println("-------------------------------");
    System.out.println("Vertice | Final | Temporal");
    System.out.println("-------------------------------");

    while (!colaPrioridad.isEmpty()) {
        Nodo nodoActual = colaPrioridad.poll();
        int u = nodoActual.vertice;

        // Verificar si el nodo ya está en la cola con una distancia menor
        if (nodoActual.peso > distancias[u]) {
            continue;
        }

        // Imprimir la información del nodo actual en la tabla
        System.out.printf("   %-5d |   %-8d |   %-10s%n", u, distancias[u], (previos[u] == -1 ? "-" : previos[u]));

        for (Arista arista : listaAdyacencia.get(u)) {
            int v = arista.destino;
            int peso = arista.peso;

            if (distancias[u] + peso < distancias[v]) {
                distancias[v] = distancias[u] + peso;
                previos[v] = u;
                colaPrioridad.add(new Nodo(v, distancias[v]));
            }
        }
    }
    System.out.println("-------------------------------");

    // Ordenar e imprimir los vértices según sus distancias
    System.out.println("Vértices ordenados por distancia:");
    System.out.println(Arrays.toString(distancias));
}*/

    // Clase interna que representa un nodo con un vértice y un peso asociado
    private static class Nodo {
        private final int vertice;
        private final int peso;

        public Nodo(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }
    }

    // Clase interna que representa una arista con un destino y un peso asociado
    private static class Arista {
        private final int destino;
        private final int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}
