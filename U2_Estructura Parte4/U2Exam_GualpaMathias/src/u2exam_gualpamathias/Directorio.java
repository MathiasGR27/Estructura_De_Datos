package u2exam_gualpamathias;

import java.util.LinkedList;
import java.util.Queue;

public class Directorio {
    String nombre;
    LinkedList<Directorio> subdirectorios;
    LinkedList<String> archivos;

    public Directorio(String nombre) {
        this.nombre = nombre;
        subdirectorios = new LinkedList<>();
        archivos = new LinkedList<>();
    }
    
    //Metodo para agregar un nuevo directorio 
    public void agregarDirectorio(Directorio nuevoDirectorio) {
        subdirectorios.add(nuevoDirectorio);
    }
    // Método para agregar un nuevo subdirectorio
    public void agregarSubdirectorio(String nombreSubdirectorio) {
        Directorio nuevoSubdirectorio = new Directorio(nombreSubdirectorio);
        subdirectorios.add(nuevoSubdirectorio);
    }

    // Método para agregar archivo a un directorio
    public void agregarArchivo(String archivo) {
        archivos.add(archivo);
    }

    // Método para eliminar archivo de un directorio
    public boolean eliminarArchivo(String archivo) {
        return archivos.remove(archivo);
    }

    // Método para eliminar un Directorio
    public boolean eliminarDirectorio(Directorio directorio) {
        return subdirectorios.remove(directorio);
    }

    // Método para mostrar la estructura realizada
    public void mostrarArbol() {
        
        Queue<Directorio> cola = new LinkedList<>();
        cola.add(this);

        while (!cola.isEmpty()) {
        Directorio actual = cola.poll();
        System.out.println("-----------------------------");
        System.out.println("Directorio: " + actual.nombre);
        System.out.println("Archivos: " + actual.archivos);
        // Mostrar subdirectorios como una lista enlazada
       if (!actual.subdirectorios.isEmpty()) {
           System.out.print("Subdirectorios: ");
           for (Directorio subdirectorio : actual.subdirectorios) {
               System.out.print(subdirectorio.nombre + " ");
               cola.add(subdirectorio);  // Agregar subdirectorios a la cola para procesarlos en la próxima iteración
           }
           System.out.println();
        System.out.println("-----------------------------");   
       }
    }
}
    
    //Metodo para buscar un archivo
    public boolean buscarArchivo(String nombreArchivo) {
        if (archivos.contains(nombreArchivo))
            return true;
        for (Directorio subdirectorio : subdirectorios) {
            if (subdirectorio.buscarArchivo(nombreArchivo))
                return true;
        }
        return false;
    }
}


    
    

