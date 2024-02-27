package ejemplopila;

import java.util.Scanner;

public class EjemploPila {

    public static void main(String[] args) {
      Pila mipila = new Pila();//Instanciamos 
      Scanner scanner = new Scanner(System.in);	
	int opc;
		
	do {
		System.out.print("\nMenu");
		System.out.print("\n1 Ingresar datos de pila");
                System.out.print("\n2 Mosrar el datos que esta al tope");
                System.out.print("\n3 Mosrar datos de pila");
		System.out.print("\n4 Quitar datos de pila");
		System.out.print("\n5 Mostrar si la pila esta llena o Vacia");
		System.out.print("\n6 Salir");
		System.out.print("\nSeleccione una opcion : ");
		opc=scanner.nextInt();
		switch(opc) {
		case 1:
                    System.out.println("Ingrese el valor a agregar ");
                    int valorPush = scanner.nextInt();
                    mipila.push(valorPush);
		break;
                case 2:
                   int valorTope = mipila.verTope();
                   if (valorTope != -1) {
                       System.out.println("El primer dato en la cima de la pila es: " + valorTope);
                   }
		break;
                case 3:
                    mipila.mostrar();
		break;
		case 4:
                    int poppedValue =mipila.pop();
                    if(poppedValue !=1 ){
                        System.out.println("Elemento removido " + poppedValue);
                    }else{
                         System.out.println("La pila esta vacia");
                    }	
		break;
		case 5:
			if(mipila.isEmpty()){
                            System.out.println("La pila esta vacia");
                        }else{
                            System.out.println("La pila esta llena");
                        }
		break;
		case 6:
			System.out.print("\nFIN ");
		break;
		default:
			System.out.print("\nOpcion incorrecta");
		break;	
	     }
	}while(opc !=6);
    }
}
