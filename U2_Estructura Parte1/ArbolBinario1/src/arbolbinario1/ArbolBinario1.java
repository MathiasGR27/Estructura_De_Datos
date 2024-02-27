/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinario1;

/**
 *
 * @author gisse
 */
public class ArbolBinario1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ArbolBinarioB arbol = new ArbolBinarioB();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
 
        System.out.println("Recorrido In-Orden:");
        arbol.inOrden(); 
        int valorABuscar = 40;
        System.out.println("\nEl valor " + valorABuscar + " esta en el arbol? " + 
                arbol.buscar(valorABuscar));
    }
}