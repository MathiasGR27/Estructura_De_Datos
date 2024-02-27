package u2practica3_ordenar;

import java.util.Scanner;

public class ArregloShell {
    
       public void menushell(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
         // Define el tamaño del arreglo al crear una instancia de ArregloShell
        ArregloShell arreglo = new ArregloShell(10);
        boolean regresarMenuPrincipal = false;

        while (!regresarMenuPrincipal) {
            System.out.println("\n---------------------------------------");
            System.out.println("|          Menú Arreglo Shell           |");
            System.out.println("|1. Insertar elemento                   |");
            System.out.println("|2. Eliminar elemento                   |");
            System.out.println("|3. Buscar elemento                     |");
            System.out.println("|4. Mostrar elementos                   |");
            System.out.println("|5. Ordenar elementos (Shell Sort)      |");
            System.out.println("|6. Mostrar elementos en orden inverso  |");
            System.out.println("|7. Salir                               |");
            System.out.println("|---------------------------------------|");
            System.out.println("|Ingrese la opción deseada:             |");
            System.out.println("|---------------------------------------|");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a insertar: ");
                    long elementoInsertar = scanner.nextLong();
                    arreglo.insertar(elementoInsertar);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a eliminar: ");
                    long elementoEliminar = scanner.nextLong();
                    boolean eliminado = arreglo.eliminar(elementoEliminar);
                    if (eliminado) {
                        System.out.println("Elemento eliminado exitosamente.");
                    } else {
                        System.out.println("Elemento no encontrado en el arreglo.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el elemento a buscar: ");
                    long elementoBuscar = scanner.nextLong();
                    boolean encontrado = arreglo.buscar(elementoBuscar);
                    if (encontrado) {
                        System.out.println("Elemento encontrado en el arreglo.");
                    } else {
                        System.out.println("Elemento no encontrado en el arreglo.");
                    }
                    break;
                case 4:
                    System.out.println("Elementos en el arreglo:");
                    arreglo.mostrarElementos();
                    break;
                case 5:
                    System.out.println("Arreglo ordenado (Shell Sort):");
                    arreglo.ordenacionShell();
                    arreglo.mostrarElementos();
                    break;
                case 6:
                    System.out.println("Elementos en orden inverso:");
                    arreglo.mostrarElementosOrdenInverso();
                    break;
                case 7:
                    System.out.println("Regresando al Menu Principal");
                    regresarMenuPrincipal = true;
                    break;
 
 
            }
        } 
    }

    
    private long[] arr;	// referencia a arreglo con elementos tipo long
	private int numElems;// numero actual de elementos en arreglo
	// constructor
	public ArregloShell(int tam) {
		arr = new long[tam];// crea arreglo
		numElems = 0;	// arreglo inicia con 0 elementos
	}
	// metodo que busca un valor especifico en arreglo
	// el argumento dato especifica el valor del elemento a borrar
	public boolean buscar(long dato) {
		int j;
		for(j=0;j<numElems;j++) {
			if(arr[j]==dato) {// se encontro item
				break;
			}
		}
		
		if(j==numElems) {// llego al final del arreglo
			return false;// no se encontro elemento, retona false
		} else {
			return true;// se encontro elemento retorna true
		}
	}
	// inserta un nuevo elemento en el arreglo
	public void insertar(long dato) {
		arr[numElems] = dato;// inserta dato en arreglo
		numElems++;// incrementa en uno numero de elementos de arreglo
	}
	// borra elemento del arreglo que sea igual al valor del argumento dato desplazando los valores del
	// arreglo una celda hacia abajo
	public boolean eliminar(long dato) {
		int j;
		
		for(j=0;j<numElems;j++) {// busca elemento en arreglo
			if(arr[j]==dato) {// se encontro el valor buscado
				break;
			}
		}
		if(j==numElems) {// no se encontro el valor buscado
			return false;
		} else {// valor encontrado en arreglo
			for(int k=j;k<numElems;k++) {// desplaza elementos superiores al indice j
				arr[k]=arr[k+1];
			}
			numElems--;
			return true;
		}
	}
	public void mostrarElementos() {
		for(int j=0;j<numElems;j++) {// recorre todos los elementos del arreglo
			System.out.print(arr[j] + " ");	// imprime cada elemento del arreglo en consola
		}
		
		System.out.println("");// imprime linea en blanco
	}
	// muestra el valor del elemento en la posicion i del arreglo
	public long valorElemento(int i) {
		return arr[i];// retorna el valor del elemento en la posicion i del arreglo
	}
	// ordenacion Shell (Shell Sort)
	public void ordenacionShell() {
		int h=1;// incremento (determina espaciamiento entre elementos para el ordenamiento)
		long temp;// guarda temporalmente elemento del arreglo
		int i;// indice del arreglo
		int j;// indice del arreglo
		// bucle encuentra el valor inicial de h
		while(h<numElems) {// mientras h sea menor a la cantidad de elementos del arreglo
			h=h*3+1;// formula del intervalo de Knuth (genera la serie 1,4,13,40,121,364)
		}
		while(h>0) {// iteramos hasta que h sea igual a 1
			for(i=h;i<numElems;i++) {// desplazamos el indice i de acuerdo a los valores que va tomando h
				temp=arr[i];// guardamos temporalmente el valor del elemento apuntaodo por el indice i
				j=i;// indice j comienza en la posicion del indice i
				// ordenamos subarreglo
				while(j-h>=0) {	// itera si existen mas elementos en subarreglo anteriores al elemento en temp
					if(arr[j-h]<temp)// elemento a una distancia h de temp es menor que temp
						break;	// terminamos el bucle while (nos movemos al siguiente valor de j)
					arr[j]=arr[j-h];// movemos elemento en la posicion j-h a la posicion j
					j=j-h;// movemos el indice j hacia la izquierda del arreglo h posiciones
				}
				arr[j]=temp;// colocamos el valor de temp en la posicion del indice j del arreglo				
			}			
			h=(h-1)/3;// decrementamos el valor de h usando la inversa de la formula de Knuth
		}		
	}
	public void mostrarElementosOrdenInverso() {
		for(int j=numElems-1;j>=0;j--)	// recorre todos los elementos del arreglo en orden inverso
			System.out.print(arr[j] + " ");	// imprime valor en el indice j
		System.out.println("");	// dejamos linea en blanco
        }
}

