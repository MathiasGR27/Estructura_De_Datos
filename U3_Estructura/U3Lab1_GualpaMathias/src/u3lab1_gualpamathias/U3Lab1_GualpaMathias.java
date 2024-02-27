package u3lab1_gualpamathias;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class U3Lab1_GualpaMathias {

    public static void main(String[] args) {
        
        //Instanciamos la clase Scanneer para obteener entrada del usuario 
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de vértices/nodos en el grafo
        System.out.print("Ingrese la cantidad de Vertices/Nodos: ");
        int cantidadVertices = scanner.nextInt();

        // Crear un objeto Grafo con la cantidad de vértices proporcionada
        List<String> vertices = new ArrayList<>();
        for (int i = 0; i < cantidadVertices; i++) {
            System.out.print("Ingrese el vertice " + (i + 1) + ": ");
            vertices.add(scanner.next());
        }
        Grafo grafo = new Grafo(vertices);

        // Solicitar al usuario ingresar las aristas del grafo (origen destino peso)
        System.out.println("Ingrese las aristas (origen destino peso), escriba 'fin' para terminar:");
        while (true) {
            // Leer la entrada del usuario
            String origen = scanner.next();
            // Salir del bucle si el usuario escribe 'fin'
            if (origen.equalsIgnoreCase("fin")) {
                break;
            }
            // Convertir las entradas a valores numéricos y agregar la arista al grafo
            String destino = scanner.next();
            int peso = scanner.nextInt();
            grafo.agregarArista(origen, destino, peso);
        }

        // Solicitar al usuario ingresar el vértice de origen para el algoritmo de Dijkstra
        System.out.println("Ingrese el origen para Dijkstra: ");
        String origenDijkstra = scanner.next();

        // Solicitar al usuario ingresar el vértice de destino para el algoritmo de Dijkstra
        System.out.println("Ingrese el destino para Dijkstra: ");
        String destinoDijkstra = scanner.next();

        // Aplicar el algoritmo de Dijkstra y obtener el resultado
        List<String> dijkstraResult = grafo.dijkstra(origenDijkstra, destinoDijkstra);

        // Imprimir el recorrido resultante del algoritmo de Dijkstra
        System.out.println("-------------------------");
        System.out.println("El recorrido es " + dijkstraResult.stream().collect(Collectors.joining(" -> ")));
        System.out.println("-------------------------");

        // Imprimir la suma total de los pesos de las aristas en el recorrido
        System.out.println("La suma total del peso es " + grafo.sumaPesosAristas(dijkstraResult));
        System.out.println("-------------------------");

        // Mostrar la matriz de adyacencia del grafo
        grafo.mostrarMatrizAdyacencia();
        System.out.println("-------------------------");
        //Mostrar nodos con sus vecinos y su peso
        grafo.mostrarVecinos();
         System.out.println("-------------------------");
        grafo.mostrarTablaDijkstra(origenDijkstra, destinoDijkstra);
    }
}
