/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package u2exam_gualpamathias;

import java.util.Scanner;

/**
 *
 * @author ESPE
 */
public class U2Exam_GualpaMathias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    Scanner scanner = new Scanner(System.in);
    int opc;
    Directorio raiz = new Directorio("Raíz");

    // Generamos un menú
    do {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar directorio");
        System.out.println("2. Agregar archivo a un directorio existente");
        System.out.println("3. Agregar subdirectorio a un directorio existente");
        System.out.println("4. Eliminar archivo");
        System.out.println("5. Eliminar directorio ");
        System.out.println("6. Mostrar estructura del árbol de directorios");
        System.out.println("7. Buscar archivo");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
        opc = scanner.nextInt();

        switch (opc) {
            case 1:
                //Vamos a agregar un directorio 
                System.out.print("Ingrese el nombre del nuevo directorio: ");
                String nombreDirectorio = scanner.next(); 
                Directorio nuevoDirectorio = new Directorio(nombreDirectorio); 
                raiz.agregarDirectorio(nuevoDirectorio);
                System.out.println("Directorio '" + nombreDirectorio + "' agregado con éxito.");
                break;
            case 2:
                //Vamos a agregar un archivo al directorio
                System.out.print("Ingrese el nombre del directorio al que desea agregar el archivo: ");
                String nombreDirArchivo = scanner.next();
                System.out.print("Ingrese el nombre del archivo: ");
                String nombreArchivo = scanner.next();
                for (Directorio directorio : raiz.subdirectorios) {
                    if (directorio.nombre.equals(nombreDirArchivo)) {
                        directorio.agregarArchivo(nombreArchivo);
                        System.out.println("Archivo '" + nombreArchivo + "' agregado al directorio '" + nombreDirArchivo + "' con éxito.");
                        break;
                    }
                }
                break;
            case 3:
                //Vamos a agregar un subdirectorio al directorio
                System.out.print("Ingrese el nombre del directorio al que desea agregar el subdirectorio: ");
                String nombreDirSubdirectorio = scanner.next();
                for (Directorio directorio : raiz.subdirectorios) {
                    if (directorio.nombre.equals(nombreDirSubdirectorio)) {
                        System.out.print("Ingrese el nombre del subdirectorio: ");
                        String nombreSubdirectorio = scanner.next();
                        directorio.agregarSubdirectorio(nombreSubdirectorio);
                        System.out.println("Subdirectorio '" + nombreSubdirectorio + "' agregado al directorio '" + nombreDirSubdirectorio + "' con éxito.");
                        break;
                    }
                }
                break;
            case 4:
                //vamos a eliminar un archivo
                System.out.print("Ingrese el nombre del archivo que desea eliminar: ");
                String archivoEliminar = scanner.next();
                if (raiz.eliminarArchivo(archivoEliminar)) {
                    System.out.println("Archivo '" + archivoEliminar + "' eliminado con éxito.");
                } else {
                    System.out.println("El archivo '" + archivoEliminar + "' no se encontró.");
                }
                break;
            case 5:
                //vamos a eliminar un directorio
                System.out.print("Ingrese el nombre del directorio que desea eliminar: ");
                    String directorioEliminar = scanner.next();
                    for (Directorio directorio : raiz.subdirectorios) {
                        if (directorio.nombre.equals(directorioEliminar)) {
                            if (raiz.eliminarDirectorio(directorio)) {
                                System.out.println("Directorio '" + directorioEliminar + "' eliminado con éxito.");
                            } else {
                                System.out.println("Error al eliminar el directorio '" + directorioEliminar + "'.");
                            }
                            break;
                        }
                    }
                break;
            case 6:
                //Mostramos
                raiz.mostrarArbol();
                break;
            case 7:
                //Buscamos un archivo
                System.out.print("Ingrese el nombre del archivo que desea buscar: ");
                    String archivoBuscar = scanner.next();
                    if (raiz.buscarArchivo(archivoBuscar)) {
                        System.out.println("El archivo '" + archivoBuscar + "' se encontró.");
                    } else {
                        System.out.println("El archivo '" + archivoBuscar + "' no se encontró.");
                    }
                break;
            case 8:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }

    } while (opc != 8);
   }
}