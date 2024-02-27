/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2lab1_gualpamathias;

/**
 *
 * @author ESPE
 */
public class Nodo {
    String nombre;
    String genero;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
        this.izquierda = null;
        this.derecha = null;
    }
}
