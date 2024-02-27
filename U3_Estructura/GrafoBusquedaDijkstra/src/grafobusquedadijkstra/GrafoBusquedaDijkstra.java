/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafobusquedadijkstra;

public class GrafoBusquedaDijkstra {

    public static void main(String[] args) {
        
        Grafo grafo = new Grafo(6);
        
        grafo.agregarArista(0, 1, 7);
        grafo.agregarArista(0, 2, 1);
        grafo.agregarArista(0, 3, 6);
        grafo.agregarArista(1, 3, 2);
        grafo.agregarArista(1, 5, 2);
        grafo.agregarArista(2, 3, 2);
        grafo.agregarArista(2, 4, 5);
        grafo.agregarArista(3, 4, 3);
        grafo.agregarArista(3, 5, 4);
        grafo.agregarArista(4, 5, 2);

        System.out.println("El recorrido es " + grafo.dijkstra(0, 5));
        System.out.println("La suma total del peso es " + grafo.sumaPesosAristas(grafo.dijkstra(0, 5)));
        System.out.println("-------------------------");
        grafo.mostrarMatrizAdyacencia();
        System.out.println("-------------------------");
    }
    
}
