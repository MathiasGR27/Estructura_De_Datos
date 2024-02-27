package ejemploarreglos;

import java.util.Scanner;


public class EjemploArreglos {

    public static void main(String[] args) {
        // Declaración e inicialización de un arreglo de enteros llamado 'numeros' con tamaño 5
        int[] numeros = new int[5];

        // Creación de un objeto Scanner para leer la entrada del usuario desde el teclado
        Scanner scanner = new Scanner(System.in);

        // Declaración de la variable 'opc' para almacenar la opción del menú
        int opc;

        // Inicia un bucle do-while que se ejecutará hasta que el usuario seleccione la opción 3 (Salir)
        do {
            // Muestra un menú con tres opciones para que el usuario elija
            System.out.print("\nMenu");
            System.out.print("\n1 Ingresar y Mostrar arreglo en orden de entrada");
            System.out.print("\n2 Mostrar arreglo al revés");
            System.out.print("\n3 Salir");
            System.out.print("\nSeleccione una opción: ");
            
            // Lee la opción ingresada por el usuario
            opc = scanner.nextInt();

            // Inicia una estructura switch basada en la opción seleccionada por el usuario
            switch (opc) {
                case 1:
                    // Opción 1: Ingresar y mostrar arreglo en orden de entrada
                    ingresonum(numeros, scanner);
                    mostrarnum("Numeros ingresados en el orden de entrada:", numeros);
                    break;
                case 2:
                    // Opción 2: Mostrar arreglo al revés
                    mostrarnuminv("Numeros ingresados en el orden de entrada:", numeros);
                    break;
                case 3:
                    // Opción 3: Salir del programa
                    System.out.print("\nSaliendo del programa ");
                    break;
                default:
                    // Opción por defecto: Opción incorrecta
                    System.out.print("\nOpción incorrecta");
                    break;
            }
        } while (opc != 3); // El bucle se ejecuta hasta que la opción es 3 (Salir)

        // Cierra el objeto Scanner para liberar recursos
        scanner.close();
    }

    // Método para ingresar números y guardarlos en un arreglo
    private static void ingresonum(int[] numeros, Scanner scanner) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el número " + (i + 1) + ":");
            numeros[i] = scanner.nextInt();
        }
    }

    // Método para mostrar los números del arreglo en el orden que se ingresaron
    private static void mostrarnum(String mensaje, int[] numeros) {
        System.out.print(mensaje);
        for (int i = 0; i < 5; i++) {
            System.out.println("\n" + numeros[i]);
        }
        System.out.print("---------------------------------------------------");
    }

    // Método para mostrar los números del arreglo en orden inverso
    private static void mostrarnuminv(String mensaje, int[] numeros) {
        System.out.print(mensaje);
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println("\n" + numeros[i]);
        }
        System.out.print("---------------------------------------------------");
    }
}
    