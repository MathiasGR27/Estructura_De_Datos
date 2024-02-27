package u2practica3_ordenar;

import java.util.Scanner;


public class OrdenarBurbuja {
    public static void inicio(){
        Scanner entrada=new Scanner(System.in);
        // problema: calcular el maximo y el minimo valor de un conjunto de N datos
        // variable que guarda los valores ingresados por el teclado
        long dato;
        // declaramos instancia de la clase Scanner para ingresar datos por la consola
        
        // ingresamos cantidad de datos a procesar
        System.out.print("Ingrese la cantidad de datos a analizar: ");
        int tamano=entrada.nextInt();
        
        // creamos una instancia de la clase ArregloBurbuja (pasamos la variable tamaño al constructor)
        ArregloBurbuja arr = new ArregloBurbuja(tamano);
        // ingresamos conjunto de datos
        System.out.println("Ingrese los " + tamano + " datos ");
        
        // leemos los datos numericos ingresados por teclado
        for(int i=0;i<tamano;i++) {
            System.out.print("Dato " + (i + 1) + ": ");
            dato = entrada.nextLong();
            arr.insertar(dato);
        }
        
        // imprimimos datos ingresados
        System.out.println("Datos antes de estar ordenados:");
        arr.mostrarElementos();
        // ordenamos los datos usando la ordenacion por burbuja
        arr.ordenacionBurbuja();
        // imprimimos datos ordenados
        System.out.println("Datos ordenados:");
        arr.mostrarElementos();
        // imprimimos elemento menor y mayor
        System.out.println("El menor valor es: " + arr.valorElemento(0));
        System.out.println("El mayor valor es: " + arr.valorElemento(tamano-1));
}
    
}
