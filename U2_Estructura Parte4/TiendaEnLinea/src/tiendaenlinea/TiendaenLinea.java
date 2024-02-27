package tiendaenlinea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TiendaenLinea {
    
    public static void main(String[] args) {
        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Crear una lista para almacenar los productos en el inventario
        List<Producto> inventario = new ArrayList<>();

        // Variable para almacenar la opción del menú seleccionada por el usuario
        int opcion;

        // Bucle principal del programa
        do {
            // Mostrar el menú al usuario
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ingresar un nuevo producto");
            System.out.println("2. Mostrar el inventario desordenado");
            System.out.println("3. Ordenar el inventario por precio (Mergesort)");
            System.out.println("4. Busqueda secuencial por nombre");
            System.out.println("5. Busqueda binaria por precio (requiere inventario ordenado)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            // Realizar acciones según la opción seleccionada
            switch (opcion) {
                case 1:
                    // Opción 1: Ingresar un nuevo producto al inventario
                    ingresarNuevoProducto(scanner, inventario);
                    break;
                case 2:
                    // Opción 2: Mostrar el inventario desordenado
                    System.out.println("\nInventario desordenado:");
                    imprimirInventario(inventario);
                    break;
                case 3:
                    // Opción 3: Ordenar el inventario por precio utilizando Mergesort
                    mergeSortInventario(inventario);
                    System.out.println("\nInventario ordenado por precio (Mergesort):");
                    imprimirInventario(inventario);
                    break;
                case 4:
                    // Opción 4: Realizar una búsqueda secuencial por nombre
                    buscarPorNombre(scanner, inventario);
                    break;
                case 5:
                    // Opción 5: Realizar una búsqueda binaria por precio (requiere inventario ordenado)
                    // Asegurarse de que el inventario esté ordenado antes de realizar la búsqueda binaria
                    if (inventario.isEmpty()) {
                        System.out.println("El inventario está vacío o no ha sido ordenado. Ordénelo primero.");
                    } else {
                        buscarBinaria(scanner, inventario);
                    }
                    break;
                case 6:
                    // Opción 6: Salir del programa
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opcion no valida ");
            }

        } while (opcion != 6);  // Continuar el bucle mientras la opción no sea salir (6)
    }

    // Método para ingresar un nuevo producto al inventario
    private static void ingresarNuevoProducto(Scanner scanner, List<Producto> inventario) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea

        // Crear un nuevo objeto Producto y agregarlo al inventario
        Producto producto = new Producto(nombre, precio);
        inventario.add(producto);
        System.out.println("Producto agregado correctamente al inventario.");
    }

    // Método para realizar una búsqueda secuencial por nombre en el inventario
    private static void buscarPorNombre(Scanner scanner, List<Producto> inventario) {
        // Solicita al usuario ingresar el nombre del producto a buscar
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreBusqueda = scanner.nextLine();
        // Inicializa la variable 'posicion' con -1 para indicar que el producto no ha sido encontrado
        int posicion = -1;
        // Bucle para buscar el producto en el inventario
        for (int i = 0; i < inventario.size(); i++) {
            // Obtiene el producto actual del inventario en la posición 'i'
            Producto producto = inventario.get(i);
            // Compara el nombre del producto (ignorando mayúsculas y minúsculas) con el nombre de búsqueda
            if (producto.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                // Si se encuentra el producto, muestra la información y almacena la posición
                System.out.println("Producto encontrado en la posicion " + i + ": " + producto);
                posicion = i;
                // Sale del bucle, ya que se encontró el producto
                break;  
            }
        }
        // Verifica si el producto no fue encontrado y muestra un mensaje adecuado
        if (posicion == -1) {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

   // Método para realizar una búsqueda binaria por precio en el inventario (requiere inventario ordenado)
    private static void buscarBinaria(Scanner scanner, List<Producto> inventario) {
    // Solicita al usuario ingresar el precio del producto a buscar
    System.out.print("Ingrese el precio del producto a buscar: ");
    double precioBusqueda = scanner.nextDouble();

    // Llama a la función de búsqueda binaria y obtiene el índice del producto encontrado
    int indice = busquedaBinaria(inventario.toArray(new Producto[0]), precioBusqueda);

    // Muestra el resultado de la búsqueda binaria
    if (indice != -1) {
        // Si el producto se encuentra, muestra su información
        System.out.println("Producto encontrado en la posición " + indice + ": " + inventario.get(indice));
    } else {
        // Si el producto no se encuentra, muestra un mensaje indicando que no está en el inventario
        System.out.println("Producto no encontrado en el inventario.");
    }
}
    // Función de búsqueda binaria
    private static int busquedaBinaria(Producto arr[], double precioBusqueda) {
    // Inicialización de variables para los límites del rango de búsqueda
    int izquierda = 0;
    int derecha = arr.length - 1;

    // Bucle de búsqueda binaria
    while (izquierda <= derecha) {
        // Calcular el índice medio del arreglo
        int medio = izquierda + (derecha - izquierda) / 2;

        // Comprobar si el elemento en el índice medio tiene el precio buscado
        if (arr[medio].getPrecio() == precioBusqueda) {
            return medio;  // Elemento encontrado, devuelve el índice
        }

        // Si el precio en el índice medio es menor que el precio buscado, buscar en la mitad derecha
        if (arr[medio].getPrecio() < precioBusqueda) {
            izquierda = medio + 1;
        } else { // Si el precio en el índice medio es mayor, buscar en la mitad izquierda
            derecha = medio - 1;
        }
    }

    // Elemento no encontrado, devuelve -1
    return -1;
}
    // Método para ordenar el inventario por precio utilizando Mergesort
    private static void mergeSortInventario(List<Producto> inventario) {
        // Convertir la lista de productos a un array para usar Mergesort
        Producto[] arrayProductos = inventario.toArray(new Producto[0]);

        // Llamar a la función de Mergesort
        mergeSort(arrayProductos, 0, arrayProductos.length - 1);

        // Limpiar el inventario y agregar los productos ordenados
        inventario.clear();
        inventario.addAll(Arrays.asList(arrayProductos));
    }

    // Función de Mergesort
        private static void mergeSort(Producto arr[], int left, int right) {
    // Verifica si hay más de un elemento en el arreglo
        if (left < right) {
        // Calcula el índice medio del arreglo
        int middle = left + (right - left) / 2;
        // Llama recursivamente a mergeSort para la mitad izquierda del arreglo
        mergeSort(arr, left, middle);

        // Llama recursivamente a mergeSort para la mitad derecha del arreglo
        mergeSort(arr, middle + 1, right);

        // Combina las mitades ordenadas utilizando la función merge
        merge(arr, left, middle, right);
    }
}

    // Función para fusionar dos sub-arrays en Mergesort
    private static void merge(Producto arr[], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Producto leftArray[] = new Producto[n1];
        Producto rightArray[] = new Producto[n2];

        // Copiar datos a arrays temporales
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

        // Índices iniciales de los sub-arrays izquierdo y derecho
        int i = 0, j = 0;
        int k = left;

        // Ordenamiento
        while (i < n1 && j < n2) {
        if (leftArray[i].compareTo(rightArray[j]) <= 0) {
        // Si es verdadero, asigna el elemento del subarreglo izquierdo al arreglo principal
        arr[k] = leftArray[i];
        // Incrementa el índice del subarreglo izquierdo para pasar al siguiente elemento
        i++;
        } else {
        // Si es falso, asigna el elemento del subarreglo derecho al arreglo principal
        arr[k] = rightArray[j];
        // Incrementa el índice del subarreglo derecho para pasar al siguiente elemento
        j++;
        }
        // Incrementa el índice del arreglo principal para apuntar a la siguiente posición
        k++;
        }


        // Copia los elementos restantes de leftArray[]
        while (i < n1) {
        // Asigna el elemento actual del subarreglo izquierdo al arreglo principal
        arr[k] = leftArray[i];
        // Incrementa el índice del subarreglo izquierdo para pasar al siguiente elemento
        i++;
        // Incrementa el índice del arreglo principal para apuntar a la siguiente posición
        k++;
        }

        // Copia los elementos restantes de rightArray[]
        while (j < n2) {
        // Asigna el elemento actual del subarreglo derecho al arreglo principal   
        arr[k] = rightArray[j];
        // Incrementa el índice del subarreglo derecho para pasar al siguiente elemento   
        j++;
        // Incrementa el índice del arreglo principal para apuntar a la siguiente posición
        k++;
        }
    }

       // Método para imprimir el inventario
        private static void imprimirInventario(List<Producto> inventario) {
        // Itera a través de cada producto en el inventario
        for (Producto producto : inventario) {
        // Imprime la representación en cadena del producto (se asume que la clase Producto tiene un método toString implementado)
        System.out.println(producto);
  
        }
    }
}