package u1lab2_gualpamathias;

import java.util.Scanner;

public class U1Lab2_GualpaMathias {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();//Instanciamos la clase Restaurante
        Scanner scanner = new Scanner(System.in);	
	int opc;
	//Generamos un menu
	do {
                System.out.print("\n|-------------------------------------------------|");
		System.out.print("\n|                 Menu Restaurante                |");
		System.out.print("\n|1. Agregar un nuevo pedido                       |");
                System.out.print("\n|2. Mostrar pdidos                                |");
                System.out.print("\n|3. Preparar el pedido actual                     |");
                System.out.print("\n|4. Entregar el pedido preparado actual al cliente|");
		System.out.print("\n|5. Salir                                         |");
                System.out.print("\n|-------------------------------------------------|");
                System.out.print("\nSeleccione una opcion :");
		opc=scanner.nextInt();
		switch(opc) {
		 case 1:
                     // Agregar un nuevo pedido
                    restaurante.cantidapedidos();
                    
                    break;
                    
                 case 2:
                    // Muestra los pedidos
                    restaurante.mostrarPedidos(restaurante);
                    break;

                case 3:
                    // Preparar el pedido actual
                    restaurante.prepararPedido();
                    break;

                case 4:
                    // Entregar el pedido preparado
                    restaurante.entregarPedido();
                    break;

                case 5:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opc != 5);
    }
}

