/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicagrafo_gualpamathias;

import java.util.Scanner;


public class PracticaGrafo_GualpaMathias {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un grafo
        Grafo grafo = new Grafo();

        // Pedir al usuario que ingrese nodos y aristas hasta que desee detenerse
        System.out.println("Ingrese nodos y aristas del grafo (ingrese 'fin' para detenerse):");
        while (true) {
            System.out.print("Ingrese el nodo (Ingrese 'fin en minusculas' para detenerse): ");
            String inicio = scanner.next();
            if (inicio.equals("fin")) {
                break;
            }

            System.out.print("Ingrese el vecino: ");
            String fin = scanner.next();

            grafo.agregarArista(inicio, fin);
        }

        // Mostrar el grafo ingresado por el usuario
        grafo.mostrarGrafo();

        // Pedir al usuario el nodo objetivo para la búsqueda en profundidad
        System.out.print("Ingrese el nodo objetivo para la búsqueda en profundidad: ");
        String objetivoProfundidad = scanner.next();
        boolean encontradoProfundidad = BusquedaEnProfundidad.BusquedaEnProfundidad(grafo, objetivoProfundidad);

        if (encontradoProfundidad) {
            System.out.println("El nodo " + objetivoProfundidad + " fue encontrado utilizando búsqueda en profundidad.");
        } else {
            System.out.println("El nodo " + objetivoProfundidad + " no fue encontrado utilizando búsqueda en profundidad.");
        }

        // Reiniciar los estados de los nodos para la búsqueda en amplitud
        reiniciarEstados(grafo);

        // Pedir al usuario el nodo objetivo para la búsqueda en amplitud
        System.out.print("Ingrese el nodo objetivo para la búsqueda en amplitud: ");
        String objetivoAmplitud = scanner.next();
        boolean encontradoAmplitud = BusquedaEnAmplitud.BusquedaEnAmplitud(grafo, objetivoAmplitud);

        if (encontradoAmplitud) {
            System.out.println("El nodo " + objetivoAmplitud + " fue encontrado utilizando búsqueda en amplitud.");
        } else {
            System.out.println("El nodo " + objetivoAmplitud + " no fue encontrado utilizando búsqueda en amplitud.");
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Método para reiniciar los estados de los nodos en el grafo
    private static void reiniciarEstados(Grafo grafo) {
        for (NodoGrafo nodo : grafo.nodos.values()) {
            nodo.estado = EstadoNodoGrafo.NoVisitado;
        }
    }
}