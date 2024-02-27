package com.mycompany.grupo4_proyecto;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RegistroTest {
    
    public RegistroTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class Registro.
     */
    @Test
    public void testMain() {
        // Mensaje que se mostrará en la consola al ejecutar esta prueba
        System.out.println("main");

        // Creamos un CountDownLatch con un recuento de 1
        CountDownLatch latch = new CountDownLatch(1);

        // Usamos SwingUtilities.invokeLater para ejecutar la interfaz gráfica en un hilo separado
        SwingUtilities.invokeLater(() -> {
            // Crear una instancia de la clase Registro
            Registro regis = new Registro();
            // Hacer visible la interfaz gráfica
            regis.setVisible(true);

            // Agregamos un WindowAdapter para detectar cuando la interfaz se cierra
            regis.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    // La interfaz se ha cerrado, reducimos el recuento del latch
                    latch.countDown();
                }
            });
        });

        try {
            // Esperamos hasta que el usuario cierre la interfaz manualmente
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
