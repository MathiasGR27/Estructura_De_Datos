/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo.mergesort;


import java.util.Arrays;
import java.util.Scanner;


public class EjemploMergeSort {

    // Método de combinación utilizado en Merge Sort
    public void merge(int arr[], int left, int middle, int right) {
        // Tamaño de los subarreglos a fusionar
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Vectores temporales para almacenar los subarreglos
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        // 
        for (int i = 0; i < n1; i++) { //copiar cada elemento del subarreglo izquierdo
            // Copia el elemento actual del subarreglo izquierdo al arreglo temporal (leftArray)
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {//copiar cada elemento del subarreglo derecho
            // Copia el elemento actual del subarreglo derecho al arreglo temporal (rightArray)
            rightArray[j] = arr[middle + j + 1];
        }

        // Índices iniciales para los subarreglos y el arreglo principal
        int i = 0, j = 0;
        int k = left;

        // Combinación de los subarreglos ordenados
        while (i < n1 && j < n2) {
        // Comparación: Verifica si 
        if (leftArray[i] <= rightArray[j]) {
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
     // Método principal de ordenamiento usando Merge Sort
    public void sort(int arr[], int left, int right) {
        // Verifica si hay más de un elemento en el subarreglo actual
        if (left < right) {
            // Encuentra el punto medio del subarreglo
            int middle = (left + right) / 2;

            // Divide y ordena la primera mitad
            sort(arr, left, middle);
            // Divide y ordena la segunda mitad
            sort(arr, middle + 1, right);

            // Combina las mitades ordenadas
            merge(arr, left, middle, right);
        }
    }
      // Método para imprimir un arreglo
    public void printArray(int arr[]) {
        // Obtener la longitud del arreglo
        int n = arr.length;
        // Bucle para recorrer cada elemento del arreglo
        for (int i = 0; i < n; ++i) {
        // Imprimir el elemento actual seguido de un espacio en la misma línea
        System.out.print(arr[i] + " ");
        }
        // Imprimir una nueva línea después de mostrar todos los elementos del arreglo
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        //Instaciamos la clase scanner 
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese elementos del arreglo separados por espacios
        System.out.print("Ingresa los elementos del arreglo separados por espacios: ");
        String userInput = scanner.nextLine();

        // Convertir la entrada del usuario en un array de enteros
        int arr[] = Arrays.stream(userInput.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;

        // Crear una instancia de la clase EjemploMergeSort
        EjemploMergeSort mergeSort = new EjemploMergeSort();

        // Imprimir el arreglo original
        System.out.println("Array original:");
        mergeSort.printArray(arr);

        // Ordenar el arreglo usando Merge Sort e imprimir el resultado
        System.out.println("Array ordenado:");
        mergeSort.sort(arr, 0, n - 1);
        mergeSort.printArray(arr);
    }
}