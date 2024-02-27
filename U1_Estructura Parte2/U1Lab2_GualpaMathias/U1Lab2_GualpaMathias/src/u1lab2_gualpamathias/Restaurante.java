package u1lab2_gualpamathias;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Restaurante {
    Stack<Pedido> pedidosPend; // Pila de pedidos pendientes
    Queue<Pedido> pedidosPrep; // Cola de pedidos en preparación
    int numProductos, numeroPedido, cantidadProducto;
    double precioProducto;
    Scanner scanner = new Scanner(System.in);

    // Constructor de la clase Restaurante
    public Restaurante() {
        this.pedidosPend = new Stack<>();
        this.pedidosPrep = new LinkedList<>();
    }
    private static boolean esSoloLetras(String nombreCliente) {
        return nombreCliente.matches("[a-zA-Z]+");}
    private static boolean esSoloLetra(String nombreProducto) {
        return nombreProducto.matches("[a-zA-Z]+");
    }

    // Método para ingresar un nuevo pedido
    public void cantidapedidos() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        if (esSoloLetras(nombreCliente)) {
            System.out.println(" ");
        } else {
            System.out.println("Error ingrese solo letras");  
            System.out.print("ingrese nombre del cliente: ");
            nombreCliente = scanner.nextLine();
        }
        Pedido nuevoPedido = new Pedido(numeroPedido, nombreCliente);

        // Validar que la cantidad de productos sea un número positivo
        do {
            System.out.print("Ingrese cuantos productos desea adquirir: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error ingrese un numero valido");
                System.out.print("Ingrese cuantos productos desea adquirir: ");
                scanner.next(); // Consumir la entrada incorrecta
            }
            numProductos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
        } while (numProductos <= 0);

        // Loop para ingresar detalles de cada producto en el pedido
        for (int i = 0; i < numProductos; i++) {
            System.out.println("Ingrese los datos del producto " + (i + 1) + ":");
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            if (esSoloLetra(nombreProducto)) {
                System.out.println(" ");
            } else {
                System.out.println("Error ingrese solo letras");  
                System.out.print("Ingrese el nombre del producto: ");
                nombreProducto = scanner.nextLine();
            }

            // Validar que el precio sea un número positivo
            do {
                System.out.print("Ingrese el precio del producto: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Error ingrese un numero valido");
                    System.out.print("Ingrese el precio del producto: ");
                    scanner.next(); // Consumir la entrada incorrecta
                }
                precioProducto = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
            } while (precioProducto <= 0);

            // Validar que la cantidad sea un número positivo
            do {
                System.out.print("Ingrese la cantidad que desea: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Error ingrese un numero valido");
                    System.out.print("Ingrese la cantidad que desea: ");
                    scanner.next(); // Consumir la entrada incorrecta
                }
                cantidadProducto = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
            } while (cantidadProducto <= 0);

            Producto producto = new Producto(nombreProducto, precioProducto, cantidadProducto);
            nuevoPedido.agregarProducto(producto);
        }
        agregarPedido(nuevoPedido); // Llama al método de agregar pedido
    }

    // Método para agregar un pedido a la pila de pedidos pendientes
    public void agregarPedido(Pedido pedido) {
        pedidosPend.push(pedido);
        System.out.println("Se agrego un pedido");
    }

    // Método estático para mostrar los pedidos ingresados en el restaurante
    public static void mostrarPedidos(Restaurante restaurante) {
        System.out.println("\nPedidos ingresados: ");
        Stack<Pedido> pedidosPend = new Stack<>();
        pedidosPend.addAll(restaurante.pedidosPend);
        // Muestra los detalles de cada pedido en la pila de pedidos pendientes
        while (!pedidosPend.isEmpty()) {
            Pedido pedido = pedidosPend.pop();
            System.out.println("-------------------------------");
            System.out.println("Nombre del Cliente: " + pedido.nomCliente);
            System.out.println("Productos agregados:");
            for (Producto producto : pedido.productos) {
                System.out.println(" Nombre  : " + producto.nombre);
                System.out.println(" Cantidad: " + producto.cantidad);
                System.out.println(" Precio  : " + producto.precio);
            }
        }
    }

    // Método para preparar un pedido
    public void prepararPedido() {
        if (!pedidosPend.isEmpty()) {
            Pedido pedidoAct = pedidosPend.remove(0);
            System.out.println("Pedido a preparar para " + pedidoAct.nomCliente);
            mostrarDetallesPedido(pedidoAct);
            pedidosPrep.add(pedidoAct);
            System.out.println("Su pedido esta listo ya puede retirarlo");
        } else {
            System.out.println("No hay pedidos para preparar.");
        }
    }

    // Método privado para mostrar los detalles de un pedido
    private void mostrarDetallesPedido(Pedido pedido) {
        System.out.println("Detalles del pedido:");
        for (Producto producto : pedido.productos) {
            System.out.println("Nombre del producto: " + producto.nombre);
            System.out.println("Cantidad: " + producto.cantidad);
            System.out.println("Precio: " + producto.precio);
            System.out.println("-------------------------------");
        }
    }

    // Método para entregar un pedido
    public void entregarPedido() {
        if (!pedidosPrep.isEmpty()) {
            Pedido pedidoEntregado = pedidosPrep.poll();
            System.out.println("Entregando pedido a " + pedidoEntregado.nomCliente);
            mostrarDetallesPedido(pedidoEntregado);
            System.out.println("El pedido ha sido entregado");
        } else {
            System.out.println("No hay pedidos para entregar");
        }
    }
}

