package u3lab1_gualpamathias;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Grafo {

    private final Map<String, Integer> indiceVertices;
    private final List<List<Arista>> listaAdyacencia;

    // Constructor que inicializa la lista de adyacencia y el mapeo de índices para los vértices.
    public Grafo(List<String> vertices) {
        int cantidadVertices = vertices.size();
        this.listaAdyacencia = new ArrayList<>(cantidadVertices);
        this.indiceVertices = new HashMap<>();

        // Inicializa la lista de adyacencia y asigna un índice a cada vértice.
        for (int i = 0; i < cantidadVertices; i++) {
            this.listaAdyacencia.add(new ArrayList<>());
            this.indiceVertices.put(vertices.get(i), i);
        }
    }

    // Agrega una arista entre dos vértices con un peso dado a la lista de adyacencia.
    public void agregarArista(String origen, String destino, int peso) {
        int indiceOrigen = indiceVertices.get(origen);
        int indiceDestino = indiceVertices.get(destino);
        this.listaAdyacencia.get(indiceOrigen).add(new Arista(indiceDestino, peso));
    }

    // Implementa el algoritmo de Dijkstra para encontrar la ruta más corta desde un nodo de origen hasta un nodo de destino.
    public List<String> dijkstra(String origen, String destino) {
        int indiceOrigen = indiceVertices.get(origen);
        int indiceDestino = indiceVertices.get(destino);

        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(listaAdyacencia.size(), Comparator.comparingInt(a -> a.peso));
        int[] distancias = new int[listaAdyacencia.size()];
        int[] previos = new int[listaAdyacencia.size()];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(previos, -1);

        colaPrioridad.add(new Nodo(indiceOrigen, 0));
        distancias[indiceOrigen] = 0;

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();
            int u = nodoActual.vertice;

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

        List<String> ruta = new ArrayList<>();
        for (int i = indiceDestino; i != -1; i = previos[i]) {
            ruta.add(obtenerVerticePorIndice(i));
        }
        Collections.reverse(ruta);

        return ruta;
    }

    // Calcula la suma de los pesos de las aristas en la ruta proporcionada.
    public int sumaPesosAristas(List<String> ruta) {
        int suma = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            String origen = ruta.get(i);
            String destino = ruta.get(i + 1);
            int peso = obtenerPesoArista(origen, destino);
            suma += peso;
        }
        return suma;
    }

    // Obtiene el peso de la arista entre dos vértices dados.
    private int obtenerPesoArista(String origen, String destino) {
        int indiceOrigen = indiceVertices.get(origen);
        int indiceDestino = indiceVertices.get(destino);

        for (Arista arista : listaAdyacencia.get(indiceOrigen)) {
            if (arista.destino == indiceDestino) {
                return arista.peso;
            }
        }
        return Integer.MAX_VALUE;
    }

    // Muestra la matriz de adyacencia para fines de depuración.
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            for (int j = 0; j < listaAdyacencia.size(); j++) {
                int peso = obtenerPesoArista(obtenerVerticePorIndice(i), obtenerVerticePorIndice(j));
                System.out.print((peso == Integer.MAX_VALUE ? "0" : peso) + " ");
            }
            System.out.println();
        }
    }

    // Muestra los vecinos de cada nodo junto con los pesos de las aristas.
    public void mostrarVecinos() {
        System.out.println("Nodos(Ciudad) Vecinos(Ciudad) y peso(Distancia) ");
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            String nodo = obtenerVerticePorIndice(i);
            System.out.print(nodo + ": ");

            for (Arista arista : listaAdyacencia.get(i)) {
                String vecino = obtenerVerticePorIndice(arista.destino);
                int peso = arista.peso;
                System.out.print("(" + vecino + ", Su peso o distancia es : " + peso + ") ");
            }
            System.out.println();
        }
    }

    // Muestra la tabla dijkstra
    public void mostrarTablaDijkstra(String origen, String destino) {
        int indiceOrigen = indiceVertices.get(origen);
        int indiceDestino = indiceVertices.get(destino);

        System.out.println("Tabla Dijkstra:");
        System.out.printf("%-10s%-15s%-15s%-15s%n", "Nodo", "Temporal", "Final", "Camino");

        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(listaAdyacencia.size(), Comparator.comparingInt(a -> a.peso));
        int[] distancias = new int[listaAdyacencia.size()];
        int[] previos = new int[listaAdyacencia.size()];
        boolean[] finalizados = new boolean[listaAdyacencia.size()];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(previos, -1);

        colaPrioridad.add(new Nodo(indiceOrigen, 0));
        distancias[indiceOrigen] = 0;

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();
            int u = nodoActual.vertice;

            if (!finalizados[u]) {
                finalizados[u] = true;

                for (Arista arista : listaAdyacencia.get(u)) {
                    int v = arista.destino;
                    int peso = arista.peso;
                    if (distancias[u] + peso < distancias[v]) {
                        distancias[v] = distancias[u] + peso;
                        previos[v] = u;
                        colaPrioridad.add(new Nodo(v, distancias[v]));
                    }
                }

                String camino = obtenerCamino(previos, indiceOrigen, u);
                System.out.printf("%-10s%-15s%-15s%-15s%n",
                        obtenerVerticePorIndice(u),
                        distancias[u] == Integer.MAX_VALUE ? "Infinito" : distancias[u],
                        finalizados[u] ? (distancias[u] == Integer.MAX_VALUE ? "Infinito" : distancias[u]) : "No",
                        camino);
            }
        }
    }

    // Obtiene el camino desde el origen hasta el vértice actual.
    private String obtenerCamino(int[] previos, int origen, int destino) {
        List<String> camino = new ArrayList<>();
        for (int i = destino; i != -1; i = previos[i]) {
            camino.add(obtenerVerticePorIndice(i));
        }
        Collections.reverse(camino);
        return String.join(" -> ", camino);
    }

    // Obtiene el vértice correspondiente a un índice dado en el mapeo de índices.
    private String obtenerVerticePorIndice(int indice) {
        for (Map.Entry<String, Integer> entry : indiceVertices.entrySet()) {
            if (entry.getValue() == indice) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Clase interna que representa un nodo 
    private static class Nodo {
        private final int vertice;
        private final int peso;

        public Nodo(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }
    }

    // Clase interna que representa una arista 
    private static class Arista {
        private final int destino;
        private final int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}