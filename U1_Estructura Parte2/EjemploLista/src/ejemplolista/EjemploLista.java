package ejemplolista;

import java.util.ArrayList;
import java.util.Scanner;

public class EjemploLista {

    public static void main(String[] args) {
        // Crear una lista para almacenar las cadenas de texto
        ArrayList<String> listaCadenas = new ArrayList<>();

        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario ingresar cadenas de texto hasta que escriba "fin"
        String entradaUsuario;
        do {
            System.out.print("Ingrese una cadena de texto (o escriba 'fin' para terminar): ");
            entradaUsuario = scanner.nextLine();

            // Agregar la cadena a la lista si no es "fin"
            if (!entradaUsuario.equalsIgnoreCase("fin")) {
                listaCadenas.add(entradaUsuario);
            }

        } while (!entradaUsuario.equalsIgnoreCase("fin"));

        // Mostrar el contenido de la lista
        System.out.println("\nContenido de la lista:");
        for (String cadena : listaCadenas) {
            System.out.println(cadena);
        }

        // Cerrar el objeto Scanner
        scanner.close();
    }
 }
    

