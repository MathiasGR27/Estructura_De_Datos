package Practica5_gualpamathias;

import java.util.Scanner;//Importamos la librerias
import java.util.ArrayList;//Importamos la libreria
import javax.swing.SwingUtilities;

public class Practica5_GualpaMathias {
        
      public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
    }
}