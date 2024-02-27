package Practica7_ColaApp;

public class Cola {
    private Object[] colaArr;
    private int tamanoMax;
    private int frente;
    private int fin;
    private int numElems;

    //Constructor para el tamaño de la cola
    public Cola(int tamano) {
        tamanoMax = tamano;
        colaArr = new Object[tamanoMax];
        fin = -1;
        frente = 0;
        numElems = 0;
    }
    
    //Metodo para insertar elementos a la cola
    public void insertar(Object elemento) {
        if (numElems == tamanoMax) {
            System.out.println("La cola está llena");
        } else {
            if (fin == tamanoMax - 1) {
                fin = -1;
            }
            fin++;
            colaArr[fin] = elemento;
            numElems++;
            System.out.println("Elemento insertado: " + elemento);
        }
    }
    //Metodo para mostrar la cola
     public void mostrarCola() {
        if (colavacia()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Elementos de la cola:");
            int indice = frente;
            for (int i = 0; i < numElems; i++) {
                System.out.println(colaArr[indice]);
                indice = (indice + 1) % tamanoMax;
            }
        }
    }
     
    //Metodo para quitar elemento de la cola
    public Object quitar() {
        Object temp = colaArr[frente];
        frente += 1;
        if (frente == tamanoMax) {
            frente = 0;
        }
        numElems--;
        return temp;
    }

    public Object frentecola() {
        return colaArr[frente]; 
    }

    public boolean colavacia() {
        return (numElems == 0);
    }

    public boolean colallena() {
        return (numElems == tamanoMax);
    }

    public int tamanocola() {
        return numElems;
    }
}