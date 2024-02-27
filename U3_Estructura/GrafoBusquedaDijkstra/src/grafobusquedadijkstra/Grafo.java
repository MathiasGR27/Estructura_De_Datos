package grafobusquedadijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Grafo {
    
    private final int cantidadVertices;
    private final List<List<Arista>> listaAdyacencia;;

    public Grafo(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        this.listaAdyacencia = new ArrayList<>(cantidadVertices);
        for (int i = 0; i < cantidadVertices; i++) {
            this.listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        this.listaAdyacencia.get(origen).add(new Arista(destino, peso));
    }

    public List<Integer> dijkstra(int origen, int destino) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(cantidadVertices, Comparator.comparingInt(a -> a.peso));
        int[] distancias = new int[cantidadVertices];
        int[] previos = new int[cantidadVertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(previos, -1);

        colaPrioridad.add(new Nodo(origen, 0));
        distancias[origen] = 0;

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
        List<Integer> ruta = new ArrayList<>();
        for (int i = destino; i != -1; i = previos[i]) {
            ruta.add(i);
        }
        Collections.reverse(ruta);

        return ruta;
    }
    public int sumaPesosAristas(List<Integer> ruta) {
        int suma = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            int origen = ruta.get(i);
            int destino = ruta.get(i + 1);
            int peso = obtenerPesoArista(origen, destino);
            suma += peso;
        }
        return suma;
    }
    
    private int obtenerPesoArista(int origen, int destino) {
        for (Arista arista : listaAdyacencia.get(origen)) {
            if (arista.destino == destino) {
                return arista.peso;
            }
        }
        return Integer.MAX_VALUE;
    }
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                int peso = obtenerPesoArista(i, j);
                System.out.print((peso == Integer.MAX_VALUE ? "0" : peso) + " ");
            }
            System.out.println();
        }
    }
   
    private static class Nodo {
        private final int vertice;
        private final int peso;

        public Nodo(int vertice, int peso) {
            this.vertice = vertice;
            this.peso = peso;
        }
    }
    private static class Arista {
        private final int destino;
        private final int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}
