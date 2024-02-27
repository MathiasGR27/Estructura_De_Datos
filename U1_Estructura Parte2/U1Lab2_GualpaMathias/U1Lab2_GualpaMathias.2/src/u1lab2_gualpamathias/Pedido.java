package u1lab2_gualpamathias;

import java.util.LinkedList;
import java.util.Queue;

public class Pedido implements Comparable<Pedido> { 
    //Atributos 
    int numPedido;
    String nomCliente;
    Queue<Producto> productos = new LinkedList<>();

    //Constructor
    public Pedido(int numPedido, String nomCliente) {
      //  this.numPedido = numPedido;
        this.nomCliente = nomCliente;
    }
    
    //Metodo de agregar producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    @Override
    public int compareTo(Pedido otroPedido) {
        return Integer.compare(this.numPedido, otroPedido.numPedido);
    }
}