package Practica7_ColaApp;

import java.util.Scanner;

public class ColaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Pedimos al usuario que ingre el tamaño de la cola
        System.out.print("Ingrese el tamanio de la cola: ");
        int tamanoCola = scanner.nextInt();
        Cola cola = new Cola(tamanoCola);

        //Generamos un menu para el ingreso de cada opcion
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Mostrar todos los elementos Y Elemento a la cabeza");
            System.out.println("3. Quitar elemento"); 
            System.out.println("4. Mostrar si esta vacia , Si esta vacia y Tamanio de la cola");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //Ingreso de elementos
                    System.out.print("Ingrese un elemento ");
                    Object elemento = scanner.next();
                    cola.insertar(elemento);
                    break;
                case 2:
                    //Muestra la cola
                    cola.mostrarCola();
                    
                    System.out.println("---------------------------------------");
                     //Muestra el primer elemento de la cola
                    if (!cola.colavacia()) {
                        System.out.println("Elemento en la cabeza --> " + cola.frentecola());
                    } else {
                        System.out.println("La cola esta vacia ");
                    }
                    break;
                case 3:
                    //Quita elemento desde la cabeza hacia abajo
                    if (!cola.colavacia()) {
                        Object elementoQuitado = cola.quitar();
                        System.out.println("Elemento quitado: " + elementoQuitado);
                    } else {
                        System.out.println("La cola está vacía. No se puede quitar elemento.");
                    }
                    break;
                case 4:
                    //Muestra si la cola esta vacia
                    System.out.println(" La cola esta vacia? -->" + cola.colavacia());
                    
                    System.out.println("---------------------------------------");
                    //Muestra si la cola esta llena
                    System.out.println(" La cola esta llena? -->" + cola.colallena());
                    
                    System.out.println("---------------------------------------");
                    //Muestra el tamaño de la cola
                     System.out.println(" Tamaño de la cola --> " + cola.tamanocola());
                    break;
                case 5:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion !=5);

        scanner.close();
    }
}
    

    

