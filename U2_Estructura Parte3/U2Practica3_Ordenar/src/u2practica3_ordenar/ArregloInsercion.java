package u2practica3_ordenar;

import java.util.Scanner;

public class ArregloInsercion {
    
    public void menuInsercion(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        // Define el tamaño del arreglo al crear una instancia de ArregloInsercion
        ArregloInsercion arreglo = new ArregloInsercion(10);
        boolean regresarMenuPrincipal = false;

        while (!regresarMenuPrincipal) {
            System.out.println("\n----------------------------------------");
            System.out.println("|      Menu Arreglo Insercion            |");
            System.out.println("|1. Insertar elemento                    |");
            System.out.println("|2. Eliminar elemento                    |");
            System.out.println("|3. Buscar elemento                      |");
            System.out.println("|4. Mostrar elementos                    |");
            System.out.println("|5. Ordenar elementos                    |");
            System.out.println("|6. Mostrar elementos menores a un valor |");
            System.out.println("|7. Regresar al menu                     |");
            System.out.println("|----------------------------------------|");
            System.out.println("|Ingrese la opción deseada:              |");
            System.out.println("|----------------------------------------|");
            
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
                    arreglo.ordenacionInsercion();
                    arreglo.mostrarElementos();
                    break;
                case 6:
                    System.out.print("Ingrese el valor limite: ");
                    int valorLimite = scanner.nextInt();
                    System.out.println("Elementos menores a " + valorLimite + ":");
                    arreglo.mostrarElementosMenoresA(valorLimite);
                    break;
                case 7:
                    System.out.println("Regresando al Menu Principal");
                    regresarMenuPrincipal = true;
                    break;
            }
        } 
    }
   
	private long[] arr;// referencia a arreglo con elementos tipo long
	private int numElems;// numero actual de elementos en arreglo
	//---------------------------------------------------------------------------------------------------
	// constructor
	public ArregloInsercion(int tam) {
		arr = new long[tam];// crea arreglo
		numElems = 0;// arreglo inicia con 0 elementos
	}	//---------------------------------------------------------------------------------------------------
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
			return false;	// no se encontro elemento, retona false
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
	// metodo que ordena arreglo usando el metodo de ordenacion por insercion
	public void ordenacionInsercion() {
		int i;	// indice i recorre cada elemento del arreglo
		int j;	// indice j recorre elementos a comparar con el valor en i
		
		for(i=0;i<numElems;i++) {// bucle externo (itera por todo el arreglo)
			long temp=arr[i];// temp guarda temporalmente elemento removido en la posicion i
			j=i;// j comienza en la posicion i del arreglo
			
			while(j>0 && arr[j-1]>=temp) {	// itera hasta encontrar el primer elemento menor al valor de temp o cuando se llega a 0
				arr[j]=arr[j-1];// movemos el elemento en la posicion j-1 a la posicion j
				--j;// movemos j a la siguiente posicion a la izquierda
			}
			arr[j]=temp;// insertamos el valor de temp en la posicion j
		}
	}
	// metodo que imprime los valores menores al valor ingresado como parametro
	public void mostrarElementosMenoresA(int valor) {
		int i=0;// indice para recorrer arreglo
		ordenacionInsercion();	// ordenamos arreglo ascendentemente
		while(arr[i]<valor) {	// mientras parametro valor sea menor al elemento en el indice i del arreglo
			System.out.print(arr[i]+" ");// imprime elemento en el indice i del arreglo por ser menor al parametro valor
			i++;// nos movemos al siguiente elemento del arreglo
		}
		System.out.println("");	// dejamos una linea en blanco
	}       
}

