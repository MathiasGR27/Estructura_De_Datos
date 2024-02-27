/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinario2_gualpamathia;

/**
 *
 * @author ESPE
 */
public class NodoArbol {
    public int numero;
    public NodoArbol izquierda;
    public NodoArbol derecha;
 
    public NodoArbol(int numero) {
        this.numero = numero;
        izquierda = null;
        derecha = null;
 }
}
