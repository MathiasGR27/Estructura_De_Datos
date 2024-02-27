package u2practica3_ordenar;

import java.util.Scanner;


public class MenuOpciones {
   
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n-------------------------------");
            System.out.println("|     Menu de Opciones        |");
            System.out.println("|1. Arreglo burbuja           |");
            System.out.println("|2. Arreglo Insercion         |");
            System.out.println("|3. Arreglo Seleccion         |");
            System.out.println("|4. Arreglo Shell             |");
            System.out.println("|5. Ordenar burbuja           |");
            System.out.println("|6. Ordenar Seleccion         |");
            System.out.println("|7. Ordenar Insercion         |");
            System.out.println("|8. Ordenar Shell             |");
            System.out.println("|9. Salir                     |");
            System.out.println("|-----------------------------|");
            System.out.println("|Ingrese la opcion deseada:   |");
            System.out.println("-------------------------------");

            opcion = scanner.nextInt();

            switch (opcion) {
                 case 1:
                    System.out.println("Has seleccionado  Arreglo burbuja");
                    // Crear un objeto de la clase ArregloBurbuja
                    ArregloBurbuja arregloBurbuja = new ArregloBurbuja(12);
                    arregloBurbuja.MenuBurbuja();
                    
                    break;
                case 2:
                    System.out.println("Has seleccionado Arreglo Insercion");
                    ArregloInsercion arregloinsercion = new ArregloInsercion(12);
                    arregloinsercion.menuInsercion();
                    break;
                case 3:
                    System.out.println("Has seleccionado Arreglo Seleccion");
                    ArregloSeleccion arregloseleccion = new ArregloSeleccion(12);
                    arregloseleccion.menuSeleccion();
                    break;
                case 4:
                    System.out.println("Has seleccionado Arreglo Shell");
                    ArregloShell arreglosshell = new ArregloShell(12);
                    arreglosshell.menushell();
                    break;
                case 5:
                    System.out.println("Has seleccionado Ordenar burbuja");
                    OrdenarBurbuja.inicio();
                    break;
                case 6:
                    System.out.println("Has seleccionado Ordenar Seleccion");
                    OrdenSeleccion.inicio();
                    break;
                case 7:
                    System.out.println("Has seleccionado Ordenar Insercion");
                    OrdenarInsercion.inicio();
                    break;
                case 8:
                    System.out.println("Has seleccionado Ordenar shell");
                    OrdenacionShellApp.inicio();
                    break;
                case 9:
                    System.out.println("Saliendo del programa");
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (true);
       
    }
    
}


