package u2practica3_ordenar;

import java.util.Scanner;

public class ArregloSeleccion {
    
    public void menuSeleccion(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        // Define el tamaño del arreglo al crear una instancia de ArregloSeleccion
        ArregloSeleccion arreglo = new ArregloSeleccion(10);
        boolean regresarMenuPrincipal = false;

        while (!regresarMenuPrincipal) {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("|                 Menu Arreglo Seleccion                  |");
            System.out.println("|1. Insertar elemento                                     |");
            System.out.println("|2. Eliminar elemento                                     |");
            System.out.println("|3. Buscar elemento                                       |");
            System.out.println("|4. Mostrar elementos                                     |");
            System.out.println("|5. Ordenar elementos                                     |");
            System.out.println("|6. Eliminar elementos repetidos                          |");
            System.out.println("|7. Mostrar pares ordenados con diferencia de dos unidades|");
            System.out.println("|8. Salir                                                 |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|Ingrese la opcion deseada:                               |");
            System.out.println("|---------------------------------------------------------|");

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
                    System.out.println("Arreglo ordenado:");
                    arreglo.ordenacionSeleccion();
                    arreglo.mostrarElementos();
                    break;
                case 6:
                    System.out.println("Eliminando elementos repetidos...");
                    arreglo.eliminarElementosRepetidos();
                    System.out.println("Elementos sin repetir:");
                    arreglo.mostrarElementos();
                    break;
                case 7:
                    System.out.println("Pares ordenados con diferencia de dos unidades:");
                    arreglo.mostrarParesOrdenados();
                    break;
                case 8:
                    System.out.println("Regresando al Menu Principal");
                    regresarMenuPrincipal = true;
                    break;
 
            }
        } 
    }
  
    private long[] arr;	// referencia a arreglo con elementos tipo long
	private int numElems;// numero actual de elementos en arreglo

	// constructor
	public ArregloSeleccion(int tam) {
		arr = new long[tam];// crea arreglo
		numElems = 0;// arreglo inicia con 0 elementos
	}

	// metodo que busca un valor especifico en arreglo
	// el argumento dato especifica el valor del elemento a buscar
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
		
		System.out.println("");	// imprime linea en blanco
	}
	
	// muestra el valor del elemento en la posicion i del arreglo
	public long valorElemento(int i) {
		return arr[i];// retorna el valor del elemento en la posicion i del arreglo
	}
	
	// metodo que ordena un arreglo ascendentemente usando la ordenacion por seleccion
	public void ordenacionSeleccion() {
	  int minimo; // guarda valor minimo
	  long temp;// variable temporal que ayudara en el intercambio de elementos del arreglo
	    
	  for(int i=0;i<numElems-1;i++) {// el valor de i establece el comienzo de cada recorrido (bucle externo)
	    minimo=i; // al inicio de cada recorrido el valor de minimo se inicializa apuntando al primer elemento
	    for(int j=i+1;j<numElems;j++) {// recorremos cada uno de los elementos del arreglo a partir del indice i+1 (bucle interno)
	      if(arr[j]<arr[minimo]) { // comparamos elemento en el indice j con el actual valor minimo
	        minimo=j;// el elemento en la posicion j es menor que el actual valor minimo; elemento en la posicion j
	        // es el nuevo minimo
	      }
	    } 
	    // intercambiamos elementos del arreglo en los indices apuntados por i y minimo
	    temp=arr[i];
	    arr[i]=arr[minimo];
	    arr[minimo]=temp;
	  }   
	} 

	// metodo que elimina los elementos repetidos del arreglo
	public void eliminarElementosRepetidos() {
	  long[] temp=new long[numElems];// arreglo que guarda temporalmente elementos sin repeticiones
	  int j;// nos ayudara a recorrer arreglo temporal temp
	  int numElemsTemp=0;// numero de elementos del arreglo temporal temp
		
	  for(int i=0;i<numElems;i++) {	// recorremos todos los elementos del arreglo arr
		 for(j=0;j<numElemsTemp;j++) // recorremos arreglo temporal buscando el elemento en la posicion i del arreglo arr
			 if(arr[i]==temp[j]) // si el elemento en la posicion i del arreglo arr se encuentra en el arreglo temporal temp
				 break;// no seguimos recorriendo arreglo temporal porque se encontro elemento 
			
		 if(j==numElemsTemp) {// si el indice j llega hasta el final del arreglo temporal el elemento no esta repetido
			 temp[numElemsTemp]=arr[i];// guardamos elemento del arreglo arr en la posicion i en arreglo temporal (en la posicion k)
			 numElemsTemp++;// aumenta en uno el numero de elementos en el arreglo temporal
		 }
	  }
		
	  // copiamos elementos no repetidos del arreglo temporal temp al arreglo arr
	  numElems=0;// borramos (reseteamos) todos los elementos del arreglo arr
	  for(int p=0;p<numElemsTemp;p++) {// recorremos todo el arreglo temp
		arr[p]=temp[p];	// copiamos cada elemento de temp a arr
		numElems++;// aumentamos en uno el numero de elementos de arr para elemento copiado
	  }
	}
	// metodo que muestra los elementos del arreglo que tengan una diferencia de dos unidades en pares
	public void mostrarParesOrdenados	() {
	  String elemPares="";// guarda los pares de elementos con diferencia de dos
	  int j=0;// apunta al indice del primer elemento del arreglo arr
	  int i=1;// apunta al indice del segundo elemento del arreglo arr
	  long diferencia;// diferencia entre elementos del arreglo arr

	  eliminarElementosRepetidos();	// eliminamos elementos repetidos en el arreglo arr
	  ordenacionSeleccion();// ordenamos elementos del arreglo arr de manera ascendente
	  while(i<numElems) {// mientras no lleguemos al final del arreglo arr
		diferencia=arr[i]-arr[j];// calculamos diferencia entre elemento en la posicion i de arr y el minimoValor
		if(diferencia<2) {// diferencia es diferente a dos
			  i++;// nos movemos al siguiente elemento del arreglo arr
			  continue;// saltamos a la siguiente iteracion del bucle while
		}
		if(diferencia==2)// diferencia es igual a dos
			elemPares+="(" + arr[j] + "," + arr[i] + ") ";// guardamos elementos pares con diferencia igual a dos
		j++;
		i=j+1;	// movemos el indice del segundo elemento del arreglo
	 }		  
	 System.out.print(elemPares);
	} 
}

