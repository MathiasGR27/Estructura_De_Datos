/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;
import arboles.Nodo;
import org.junit.jupiter.api.Test;
public class ArbolBinario {
    
    @Test
    public void test(){
        System.out.println("PRINCIPAL");
    String[] args = null;
    Arboles.main(args);
    // TODO revisar el código de prueba generado y quitar la llamada a fail por defecto.
    //fail("El caso de prueba es un prototipo.");
    // El código debajo de esta línea ahora se ejecutará.
    Nodo root = new Nodo(1);
        root.left = new Nodo(2);
        root.right = new Nodo(3);
        root.left.left = new Nodo(4);
        root.left.right = new Nodo(5);
        root.right.right = new Nodo(6);
        root.left.left.left = new Nodo(7);
        root.left.right.left = new Nodo(8);
        System.out.print("IN-ORDER TRAVERSAL: ");
        BinaryTreeTraversals.inOrderTraversal(root);
        System.out.println();
        System.out.print("PRE-ORDER TRAVERSAL: ");
        BinaryTreeTraversals.preOrderTraversal(root);
        System.out.println();
        System.out.print("POST-ORDER TRAVERSAL: ");
        BinaryTreeTraversals.postOrderTraversal(root);
        System.out.println();
        
    }
    
}
