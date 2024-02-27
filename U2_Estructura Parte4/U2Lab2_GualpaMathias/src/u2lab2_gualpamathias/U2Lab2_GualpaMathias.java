/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package u2lab2_gualpamathias;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class U2Lab2_GualpaMathias {


    public static void main(String[] args) {
        CrearArbolGenalogico arbol = new CrearArbolGenalogico();

        Persona abuelo = new Persona("Angel", "01/01/1950", "Masculino");
        Persona abuela = new Persona("Elvira", "01/01/1952", "Femenino");
        Persona padre = new Persona("Franklin", "01/01/1975", "Masculino");
        Persona madre = new Persona("Tatiana", "01/01/1980", "Femenino");
        Persona hijo = new Persona("Mathias", "01/01/2000", "Masculino");

        arbol.agregarPersona(abuelo);
        arbol.agregarPersona(abuela);
        arbol.agregarPersona(padre);
        arbol.agregarPersona(madre);
        arbol.agregarPersona(hijo);
        arbol.agregarPadres(padre, abuelo, abuela);
        arbol.agregarHijo(padre, madre, hijo);
        arbol.imprimirArbol();

        String nombreABuscar = "Mathias";
        arbol.BuscarArbol(nombreABuscar, false);

        nombreABuscar = "Angel";
        arbol.BuscarArbol(nombreABuscar, false);

        nombreABuscar = "Elian";
        arbol.BuscarArbol(nombreABuscar, false);
    }
}