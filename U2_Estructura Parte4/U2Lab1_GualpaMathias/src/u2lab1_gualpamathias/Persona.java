package u2lab1_gualpamathias;

import java.util.ArrayList;

public class Persona {
    String nombre;
    String fechaNacimiento;
    String genero;
    ArrayList<Persona> hijos;
    Persona padre;
    Persona madre;

    public Persona(String nombre, String fechaNacimiento, String genero) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.hijos = new ArrayList<>();
        this.padre = null;
        this.madre = null;
    }
     public void agregarHijo(Persona hijo) {
        hijos.add(hijo);
        hijo.agregarPadre(this);  // Llamada directa a agregarPadre en lugar de agregarHijo
    }

    public void agregarPadre(Persona padre) {
        if (this.genero.equals("Masculino")) {
            this.padre = padre;
        } else {
            this.madre = padre;
        }
        padre.hijos.add(this);  // Agregar el hijo directamente a la lista de hijos del padre
    }
    public void agregarMadre(Persona madre) {
        this.madre = madre;
        madre.agregarHijo(this);
    }

    public ArrayList<Persona> getHijos() {
        return hijos;
    }

    public Persona getPadre() {
        return padre;
    }

    public Persona getMadre() {
        return madre;
    }

    public static void imprimirArbolGenealogico(Persona persona, String espacio, String lado) {
        System.out.println(espacio + lado + " " + persona.nombre + " (" + persona.fechaNacimiento + ", " + persona.genero + ")");
        for (Persona hijo : persona.getHijos()) {
            imprimirArbolGenealogico(hijo, espacio + "   ", "Hijos de " + persona.nombre);
        }
    }
}
