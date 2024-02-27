/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallergrupo4;

/**
 *
 * @author ESPE
 */
public class Nodo {
    // Variable para almacenar el dato del nodo 
    int dato;
    // Referencia al siguiente nodo en la lista
    Nodo siguiente;
    
    // Constructor de la clase Nodo que recibe un dato como parámetro
    public Nodo(int dato) {
        // Inicializa la variable de instancia "dato" con el valor proporcionado
        this.dato = dato;

        // Inicializa la referencia al siguiente nodo como nula (ya que aún no se ha enlazado con otro nodo)
        this.siguiente = null;
    }
}