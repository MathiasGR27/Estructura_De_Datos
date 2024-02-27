/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafobusquedadijkstradinamico;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author ESPE
 */
public class GrafoBusquedaDijkstraDinamico {

    public static void main(String[] args) {
        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de vértices/nodos en el grafo
        System.out.print("Ingrese la cantidad de Vértices/Nodos : ");
        int cantidadVertices = scanner.nextInt();

        // Crear un objeto Grafo con la cantidad de vértices proporcionada
        Grafo grafo = new Grafo(cantidadVertices);

        // Solicitar al usuario ingresar las aristas del grafo (origen destino peso)
        System.out.println("Ingrese las aristas (origen destino peso), escriba 'fin' para terminar:");
        while (true) {
            // Leer la entrada del usuario
            String entrada = scanner.next();
            // Salir del bucle si el usuario escribe 'fin'
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            // Convertir las entradas a valores numéricos y agregar la arista al grafo
            int origen = Integer.parseInt(entrada);
            int destino = scanner.nextInt();
            int peso = scanner.nextInt();
            grafo.agregarArista(origen, destino, peso);
        }

        // Solicitar al usuario ingresar el vértice de origen para el algoritmo de Dijkstra
        System.out.println("Ingrese el origen para Dijkstra: ");
        int origenDijkstra = scanner.nextInt();

        // Solicitar al usuario ingresar el vértice de destino para el algoritmo de Dijkstra
        System.out.println("Ingrese el destino para Dijkstra: ");
        int destinoDijkstra = scanner.nextInt();

        // Aplicar el algoritmo de Dijkstra y obtener el resultado
        List<Integer> dijkstraResult = grafo.dijkstra(origenDijkstra, destinoDijkstra);
        

        // Imprimir el recorrido resultante del algoritmo de Dijkstra
        System.out.println("El recorrido es " + dijkstraResult.stream().map(Object::toString).collect(Collectors.joining(" -> ")));
        
        //grafo.mostrarTablaDijkstra(origenDijkstra, destinoDijkstra);

        // Imprimir la suma total de los pesos de las aristas en el recorrido
        System.out.println("La suma total del peso es " + grafo.sumaPesosAristas(dijkstraResult));
        System.out.println("-------------------------");
        // Mostrar la matriz de adyacencia del grafo (para fines de depuración)
        grafo.mostrarMatrizAdyacencia();
        System.out.println("-------------------------");
    }
}