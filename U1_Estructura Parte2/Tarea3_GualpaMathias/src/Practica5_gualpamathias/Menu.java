/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica5_gualpamathias;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private Competencia comp;

    public Menu() {
        comp = new Competencia();
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setTitle("Competencia de Atletas");

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton buttonRegistrar = new JButton("Registrar Atleta");
        buttonRegistrar.setBounds(10, 20, 200, 25);
        buttonRegistrar.setBackground(new Color(0, 0, 255)); 
        buttonRegistrar.setForeground(Color.WHITE);
        panel.add(buttonRegistrar);

        JButton buttonMostrarGanador = new JButton("Datos del campeón");
        buttonMostrarGanador.setBounds(10, 50, 200, 25);
        buttonMostrarGanador.setBackground(new Color(0, 0, 255)); 
        buttonMostrarGanador.setForeground(Color.WHITE);
        panel.add(buttonMostrarGanador);

        JButton buttonMostrarPorPais = new JButton("Atletas por país");
        buttonMostrarPorPais.setBounds(10, 80, 200, 25);
        buttonMostrarPorPais.setBackground(new Color(0, 0, 255)); 
        buttonMostrarPorPais.setForeground(Color.WHITE);
        panel.add(buttonMostrarPorPais);

        JButton buttonPromedioTiempo = new JButton("Promedio de tiempos");
        buttonPromedioTiempo.setBounds(10, 110, 200, 25);
        buttonPromedioTiempo.setBackground(new Color(0, 0, 255)); 
        buttonPromedioTiempo.setForeground(Color.WHITE);
        panel.add(buttonPromedioTiempo);

        JButton buttonEliminarAtleta = new JButton("Eliminar Atleta");
        buttonEliminarAtleta.setBounds(10, 140, 200, 25);
        buttonEliminarAtleta.setBackground(new Color(0, 0, 255)); 
        buttonEliminarAtleta.setForeground(Color.WHITE);
        panel.add(buttonEliminarAtleta);

        JButton buttonMostrarTodosAtletas = new JButton("Mostrar Todos los Atletas");
        buttonMostrarTodosAtletas.setBounds(10, 170, 200, 25);
        buttonMostrarTodosAtletas.setBackground(new Color(0, 0, 255)); 
        buttonMostrarTodosAtletas.setForeground(Color.WHITE);
        panel.add(buttonMostrarTodosAtletas);


        JButton buttonSalir = new JButton("Salir");
        buttonSalir.setBounds(10, 200, 200, 25);
        buttonSalir.setBackground(new Color(0, 0, 255)); 
        buttonSalir.setForeground(Color.WHITE);
        panel.add(buttonSalir);
        
        panel.setBackground(new Color(255, 255, 224)); // Color de fondo amarillo claro

        // Agregar ActionListener a cada botón
        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAtleta();
            }
        });

        buttonMostrarGanador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosGanador();
            }
        });

        buttonMostrarPorPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAtletasPorPais();
            }
        });

        buttonPromedioTiempo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPromedioTiempo();
            }
        });

        buttonEliminarAtleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarAtleta();
            }
        });

        buttonMostrarTodosAtletas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodosAtletas();
            }
        });

        buttonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void registrarAtleta() {
        double tiempo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tiempo del atleta (En segundos)"));
        String nombr_atleta = JOptionPane.showInputDialog("Ingrese el nombre del atleta");
        String pais = JOptionPane.showInputDialog("Ingrese la nacionalidad del atleta");
        comp.registro(tiempo, nombr_atleta, pais);
    }

    private void mostrarDatosGanador() {
        String resultado = comp.obtenerDatosGanador();
        JOptionPane.showMessageDialog(null, resultado);
    }

    private void mostrarAtletasPorPais() {
        String pais = JOptionPane.showInputDialog("Ingrese el nombre del país");
        String resultado = comp.obtenerAtletasPorPais(pais);
        JOptionPane.showMessageDialog(null, resultado);
    }

    private void calcularPromedioTiempo() {
        String resultado = comp.obtenerPromedioTiempo();
        JOptionPane.showMessageDialog(null, resultado);
    }

    private void eliminarAtleta() {
        String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del atleta a eliminar");
        String resultado = comp.eliminarAtleta(nombreEliminar);
        JOptionPane.showMessageDialog(null, resultado);
    }

    private void mostrarTodosAtletas() {
        String resultado = comp.obtenerDatosAtletas();
        JOptionPane.showMessageDialog(null, resultado);
    }
}