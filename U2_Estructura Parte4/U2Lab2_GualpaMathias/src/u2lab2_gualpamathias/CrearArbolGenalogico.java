/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2lab2_gualpamathias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrearArbolGenalogico {
    private Map<Persona, List<Persona>> relaciones;

    public CrearArbolGenalogico() {
        this.relaciones = new HashMap<>();
    }

    public void agregarPersona(Persona persona) {
        relaciones.put(persona, new ArrayList<>());
    }

    public void agregarPadres(Persona hijo, Persona padre, Persona madre) {
        if (relaciones.containsKey(hijo)) {
            relaciones.get(hijo).add(padre);
            relaciones.get(hijo).add(madre);
        }
    }

    public void agregarHijo(Persona padre, Persona madre, Persona hijo) {
        if (relaciones.containsKey(padre) && relaciones.containsKey(madre)) {
            relaciones.get(padre).add(hijo);
            relaciones.get(madre).add(hijo);
        }
    }

    public void imprimirArbol() {
        for (Map.Entry<Persona, List<Persona>> entry : relaciones.entrySet()) {
            Persona persona = entry.getKey();
            List<Persona> familiares = entry.getValue();
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Fecha de Nacimiento: " + persona.getFechaNacimiento());
            System.out.println("Género: " + persona.getGenero());
            System.out.println("Familiares:");
            for (Persona familiar : familiares) {
                System.out.println(" - " + familiar.getNombre());
            }
            System.out.println("\n");
        }
    }

    // In-orden
    public void BuscarArbol(String nombre, boolean eliminar) {
        boolean encontrado = false;

        for (Map.Entry<Persona, List<Persona>> entry : relaciones.entrySet()) {
            Persona persona = entry.getKey();

            if (nombre.equals(persona.getNombre())) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("\nPersona " + nombre + " encontrada");
        } else {
            System.out.println("\nPersona " + nombre + " no encontrada");
        }
    }
}