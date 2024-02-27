package pkg7combinarlistasgrupo4;

public class ListaEnlazada {
   class Nodo { //clase para el nodo de la lista enlazada
    int valor; //definimos varible
    Nodo siguiente;
    //constructor para inicializar un nodo con el valor dado
    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }} Nodo cabeza; //creamos lista vacia
//constructor para inicializar una lista vacia
    public ListaEnlazada() {
        this.cabeza = null;}
    //metodo para insertar un nuevo nodo a la lista enlazada ordenada
    public void insertar(int valor) {
        Nodo nuevoNodo = new Nodo(valor); //instanciamos
        if (cabeza == null || valor > cabeza.valor) { //validamos para ordenar
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null && valor < actual.siguiente.valor) {
                actual = actual.siguiente; }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }}
    //metodo para mostrar los elementos de las lista enlazada
    public void mostrar() {
        Nodo actual = cabeza; //instanciamos y validamos para mostrar los datos ingresados en la lista
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }}
