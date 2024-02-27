/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallergrupo4;

import java.text.DecimalFormat;

/**
 *
 * @author ESPE
 */
public class TallerGrupo4 {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        // Agregar 10 millones de elementos
        for (int i = 0; i < 10000000; i++) {
            lista.agregarElemento(i);
        }
        // Agregar el elemento buscado al final de la lista
        lista.agregarElemento(150);

        // Búsqueda Ingenua
        medirTiempo("Búsqueda menos eficiente", () -> lista.busquedamenoseficiente(150));

        // Búsqueda Optimizada
        medirTiempo("Búsqueda mas eficiente", () -> lista.busquedamaseficiente(150));
    }

    // Método para medir el tiempo de ejecución de una función
    private static void medirTiempo(String nombre, Runnable funcion) {
        // Obtener el tiempo de inicio
        long inicio = System.nanoTime();

        // Ejecutar la función proporcionada
        funcion.run();

        // Obtener el tiempo de finalización
        long fin = System.nanoTime();

        // Calcular el tiempo total en segundos
        double tiempoMilisegundos = (fin - inicio) / 1e6;
        
         // Formatear el tiempo con dos decimales y mostrar en milisegundos
        DecimalFormat formato = new DecimalFormat("#0.00");

        // Mostrar el tiempo de ejecución
        System.out.println("Tiempo de ejecución (" + nombre + "): " + tiempoMilisegundos + " segundos");
    }
}
