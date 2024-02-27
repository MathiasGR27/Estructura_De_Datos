/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinario_gualpamathias;


public class BinaryTreeTraversal {
      //viista la rama izaquier sigue nodo y rama derecha
    public static void inOrderTraversal(Nodo node) {
    if (node != null) {//po que incicia del ultimo nivel
      inOrderTraversal(node.left);//rama izquierda
      System.out.print(node.value + " ");//imprime valor
      inOrderTraversal(node.right);//el ndoo right no sea null
    }
  }

  public static void preOrderTraversal(Nodo node) {
    if (node != null) {//visita primero nodo actual
      System.out.print(node.value + " ");
      preOrderTraversal(node.left);//rama izquieda
      preOrderTraversal(node.right);//rama derecha
    }
  }

  public static void postOrderTraversal(Nodo node) {
    if (node != null) {
      postOrderTraversal(node.left);//recorre rama izquerde
      postOrderTraversal(node.right);//rama derecha
      System.out.print(node.value + " ");//visita nodo
    }
  }
}