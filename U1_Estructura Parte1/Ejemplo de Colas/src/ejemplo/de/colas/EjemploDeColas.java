package ejemplo.de.colas;

// Importar las clases necesarias
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Definir la clase principal
public class EjemploDeColas {

    // Método principal
    public static void main(String[] args) {
        // Crear una cola utilizando la interfaz Queue y LinkedList
        Queue<String> cola = new LinkedList<>();

        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Menú de opciones
        String opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar elemento a la cola");
            System.out.println("2. Eliminar primer elemento de la cola");
            System.out.println("3. Eliminar un elemento especifico de la cola");
            System.out.println("4. Mostrar elementos en la cola");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opcion --> ");
            opcion = scanner.nextLine();

            // Realizar acciones basadas en la opción seleccionada por el usuario
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese un elemento para agregar a la cola --> ");
                    String nuevoElemento = scanner.nextLine();
                    cola.offer(nuevoElemento);
                    System.out.println("Se agrego el elemento a la cola");
                    break;

                case "2":
                    if (!cola.isEmpty()) {
                        String elementoEliminado = cola.poll();
                        System.out.println("Se elimino el elemento de la cola --> " + elementoEliminado);
                    } else {
                        System.out.println("La cola esta vacia");
                    }
                    break;

                case "3":
                    System.out.print("Ingrese el elemento que desea eliminar de la cola --> ");
                    String elementoAEliminar = scanner.nextLine();
                    if (cola.remove(elementoAEliminar)) {
                        System.out.println("Se elimino el elemento de la cola --> " + elementoAEliminar);
                    } else {
                        System.out.println("El elemento no se encontró en la cola");
                    }
                    break;

                case "4":
                    mostrarColaEnColumna(cola);
                    break;

                case "5":
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (!opcion.equals("5"));

        // Cerrar el scanner para evitar fugas de recursos
        scanner.close();
    }

    // Método para mostrar la cola en columna
    private static void mostrarColaEnColumna(Queue<String> cola) {
        if (cola.isEmpty()) {
            System.out.println("La cola esta vacia");
        } else {
            System.out.println("Elementos en la cola (en orden de llegada) --> ");
            for (String elemento : cola) {
                System.out.println(elemento);
            }
        }
    }
}