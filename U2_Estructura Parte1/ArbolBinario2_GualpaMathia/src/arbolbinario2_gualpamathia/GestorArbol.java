/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinario2_gualpamathia;

import java.util.Scanner;

/**
 *
 * @author ESPE
 */
public class GestorArbol {
    private NodoArbol arbol = null;
    
    public void ejecutarMenuArbol() {
 int opcion;
 do {
 System.out.println("\n\nGestor de Árbol:");
 System.out.println("1 - Mostrar árbol.");
 System.out.println("2 - Agregar nodo.");
 System.out.println("3 - Buscar nodo.");
 System.out.println("4 - Crear árbol predeterminado.");
 System.out.println("5 - Eliminar nodo.");
 System.out.println("6 - Salir.");
 System.out.print("Ingrese la opción: ");
 Scanner scanner = new Scanner(System.in);
 opcion = scanner.nextInt();
 } while (opcion < 1 || opcion > 6);
 switch (opcion) {
 case 1:
 mostrarArbol();
 break;
 case 2:
 agregarNodo();
 break;
 case 3:
 buscarNodo();
 break;
 case 4:
 crearArbolPredeterminado();
 break;
 case 5:
 eliminarNodo();
 break;
 case 6:
 break;
 }
 }
 private void insertarNodoArbol(int numero) {

     NodoArbol nodo = new NodoArbol(numero);
     if (arbol == null) {
         arbol = nodo;
     } else {
         NodoArbol aux = arbol;
         NodoArbol prev = aux;
         while (aux != null) {
             prev = aux;
             if (numero < aux.numero) {
                 aux = aux.izquierda;
             } else {
                 aux = aux.derecha;
             }
         }
         if (numero < prev.numero) {
             prev.izquierda = nodo;
         } else {
             prev.derecha = nodo;
         }
     }
 }
 private void agregarNodo() {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Ingrese un número: ");
 int numero = scanner.nextInt();
 insertarNodoArbol(numero);
 ejecutarMenuArbol();
 }
 private void mostrarArbolInorden(NodoArbol aux) {
 if (aux != null) {
 mostrarArbolInorden(aux.izquierda);
 System.out.print(aux.numero + " ");
 mostrarArbolInorden(aux.derecha);
 }
 }
 private void mostrarArbol() {
 System.out.println("\n\nÁRBOL MOSTRADO INORDEN");
 mostrarArbolInorden(arbol);
 System.out.println("\n\n");
 ejecutarMenuArbol();
 }
 private void buscarNodoArbol(int numero, boolean eliminar) {
 int rondas = 0;
 NodoArbol buscando = arbol;
 NodoArbol previo = null;
 while (buscando != null) {
 rondas++;
 if (numero == buscando.numero) break;
 else previo = buscando;
 if (numero < buscando.numero) buscando = buscando.izquierda;
 else buscando = buscando.derecha;
 }
 if (buscando == null) System.out.println("\nNodo " + numero + " no encontrado");
 else {
 if (!eliminar) System.out.println("\nNodo " + numero + " encontrado después de " + 
rondas + " rondas");
 else eliminarNodoArbol(buscando, previo);
 }
 ejecutarMenuArbol();
 }
 private void buscarNodo() {
 Scanner scanner = new Scanner(System.in);
 System.out.print("¿Qué número desea buscar?: ");
 int numero = scanner.nextInt();
 buscarNodoArbol(numero, false);
 }
 private void eliminarNodoArbol(NodoArbol aux, NodoArbol prev) {
 if (aux != null) {
 eliminarNodoArbol(aux.izquierda, aux);
 eliminarNodoArbol(aux.derecha, aux);
 System.out.println("\nNodo Eliminado: " + aux.numero);
 if (prev != null) {
 if (aux.numero < prev.numero) prev.izquierda = null;
 else prev.derecha = null;
 }
 if (aux == arbol) arbol = null;
 // Borrar nodo.
 aux = null;
 }
 }
 private void eliminarNodo() {
 Scanner scanner = new Scanner(System.in);
 System.out.print("¿Qué número desea eliminar?: ");
 int numero = scanner.nextInt();
 buscarNodoArbol(numero, true);
 }
 private void crearArbolPredeterminado() {
     insertarNodoArbol(5);
     insertarNodoArbol(4);
     insertarNodoArbol(9);
     insertarNodoArbol(-2);
     insertarNodoArbol(8);
     insertarNodoArbol(0);
     insertarNodoArbol(3);
     insertarNodoArbol(6);
     System.out.println("\n\nÁrbol predeterminado creado exitosamente.\n");
 }
}

