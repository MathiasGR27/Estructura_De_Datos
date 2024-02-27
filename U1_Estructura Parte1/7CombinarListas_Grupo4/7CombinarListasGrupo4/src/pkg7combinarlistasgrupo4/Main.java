/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg7combinarlistasgrupo4;
import java.util.Scanner;
import pkg7combinarlistasgrupo4.ListaEnlazada.Nodo;


public class Main {
    public static void main(String[] args) {
        //ingresamos e instamciamos para poder ingresar datos por pantalla
        Scanner scanner = new Scanner(System.in);
        //instanciamos desde la clase creada
        ListaEnlazada lista1 = new ListaEnlazada();
        //pedimos el ingreso de los datos de la lista 1
        System.out.print("Ingrese elementos de la Lista 1 separados por espacios: ");
        String[] elementosLista1 = scanner.nextLine().split(" ");//ingresamos datos dando un espacio
        for (String elemento : elementosLista1) { //ingresamos datos hasta dar enter para ingresar los datos de la lista 2
            lista1.insertar(Integer.parseInt(elemento));
        }
        //instanciamos de la clase creada
        ListaEnlazada lista2 = new ListaEnlazada();
        //pedimos el ingreso de los datos de la lista 2
        System.out.print("Ingrese elementos de la Lista 2 separados por espacios: ");
        String[] elementosLista2 = scanner.nextLine().split(" "); //ingresamos datos dando un espacio para cada dato difernete
        for (String elemento : elementosLista2) { //ingresmaos datos hasta dar enter y mostrara los datos
            lista2.insertar(Integer.parseInt(elemento));
        }
        //mostramos los datos de las listas enlazadas ingresados ordenados
        System.out.println("Lista 1:"); //datos de la lista enlazada 1
        lista1.mostrar();
        System.out.println("Lista 2:");// datos de la lista enlazada 2
        lista2.mostrar();
        //realizamos la combinacion de las datos de las listas enlazadas ordenadas
        ListaEnlazada listaCombinada = combinarListasOrdenadas(lista1, lista2);
        //mostramos los datos de las listas combinadas y ordenadas de mayor a menor
        System.out.println("Lista combinada (ordenada de mayor a menor):");
        listaCombinada.mostrar();
    }
    //metodo que combina dos listas enlazadas y devuelve la lista
   public static ListaEnlazada combinarListasOrdenadas(ListaEnlazada lista1, ListaEnlazada lista2) {
        ListaEnlazada listaCombinada = new ListaEnlazada();//instanciamos desde la clase
        ListaEnlazada listaCombinadaInvertida = new ListaEnlazada();//instanciamos
        //creamos las listas para ingresar datos
        Nodo nodoLista1 = lista1.cabeza;
        Nodo nodoLista2 = lista2.cabeza;
        //validamos para que se ordenen los datos que ingresamos
        while (nodoLista1 != null || nodoLista2 != null) {
            if (nodoLista1 != null && (nodoLista2 == null || nodoLista1.valor >= nodoLista2.valor)) {
                listaCombinada.insertar(nodoLista1.valor);
                nodoLista1 = nodoLista1.siguiente;
            } else {
                listaCombinada.insertar(nodoLista2.valor);
                nodoLista2 = nodoLista2.siguiente;
            }
        }
        //validamos para que los datos que ingresamos se ordenen
         while (nodoLista1 != null || nodoLista2 != null) {
            if (nodoLista1 != null && (nodoLista2 == null || nodoLista1.valor <= nodoLista2.valor)) {
                listaCombinadaInvertida.insertar(nodoLista1.valor);
                nodoLista1 = nodoLista1.siguiente;
            } else {
                listaCombinadaInvertida.insertar(nodoLista2.valor);
                nodoLista2 = nodoLista2.siguiente;
            }
        }
        return listaCombinada;
    }
 
}
