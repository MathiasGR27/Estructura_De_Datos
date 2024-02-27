/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinario_gualpamathias;

/**
 *
 * @author ESPE
 */
public class ArbolBinario_GualpaMathias {

    public static void main(String[] args) {
    Nodo root = new Nodo(1);
    root.left = new Nodo(2);
    root.right = new Nodo(3);

    root.left.left = new Nodo(4);
    root.left.right = new Nodo(5);

    root.right.right = new Nodo(6);

    root.left.left.left = new Nodo(7);

    root.left.right.left = new Nodo(8);

    System.out.print("IN-ORDER TRAVERSAL: ");
    BinaryTreeTraversal.inOrderTraversal(root);
    System.out.println();

    System.out.print("PRE-ORDER TRAVERSAL: ");
    BinaryTreeTraversal.preOrderTraversal(root);
    System.out.println();

    System.out.print("POST-ORDER TRAVERSAL: ");
    BinaryTreeTraversal.postOrderTraversal(root);
    System.out.println();
    
        
    }
    
}
