/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package u2lab1_gualpamathias;



public class U2Lab1_GualpaMathias {

    public static void main(String[] args) {
         // Crear una instancia de la clase ArbolGenealogico
        ArbolGenealogico arbol = new ArbolGenealogico();

        // Insertar personas en el árbol con su nombre y género
        arbol.insertar("Fer", "Masculino");
        arbol.insertar("Gilma", "Femenino");

        arbol.insertar("Franklin", "Masculino");
        arbol.insertar("Tatiana", "Femenino");

        arbol.insertar("Mathias", "Masculino");
        arbol.insertar("Derik", "Masculino");
        arbol.insertar("Daniela", "Femenino");

        // Establecer relaciones familiares entre las personas
        arbol.establecerRelaciones();

        // Imprimir el árbol genealógico
        System.out.println("Árbol Genealógico:");
        arbol.imprimirArbolGenealogico(arbol.getRaiz(), "");
    }
}